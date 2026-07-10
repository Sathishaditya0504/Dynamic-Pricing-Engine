package com.dynamicpricing.service;

import com.dynamicpricing.dto.PriceResponse; 
import com.dynamicpricing.entity.DynamicPrice;
import com.dynamicpricing.entity.PricingRule;
import com.dynamicpricing.entity.Product;
import com.dynamicpricing.repository.DynamicPriceRepository;
import com.dynamicpricing.repository.PricingRuleRepository;
import com.dynamicpricing.repository.ProductRepository;
import com.dynamicpricing.strategy.PricingStrategy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class PricingEngineService {
	
	private final ProductRepository productRepository;
	private final PricingRuleService pricingRuleService;
	private final DynamicPriceRepository dynamicPriceRepository;
	private final Map<String, PricingStrategy> strategyMap;
	
	public PricingEngineService (ProductRepository productRepository, PricingRuleService pricingRuleService, 
			      DynamicPriceRepository dynamicPriceRepository, List<PricingStrategy> pricingStrategies, PricingRuleRepository pricingRuleRepository) {
		
		this.productRepository = productRepository;
		this.pricingRuleService= pricingRuleService;
		this.dynamicPriceRepository = dynamicPriceRepository;
		this.strategyMap = pricingStrategies.stream().collect(Collectors.toMap(PricingStrategy::getType, Function.identity()));
	}
	
	@Transactional
	public PriceResponse calculatePrice(Long productId) {
		Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found with id: "+ productId));
		
		BigDecimal finalPrice = product.getBasePrice();
		List <PricingRule> rules = pricingRuleService.getAllRules();
		
		
		for(PricingRule rule : rules) {
			PricingStrategy strategy = strategyMap.get(rule.getType());
			
			if(strategy != null) {
				finalPrice = strategy.apply(finalPrice, rule);
			}
		}
		
		DynamicPrice dynamicPrice = new DynamicPrice();
		dynamicPrice.setProduct(product);
		dynamicPrice.setFinalPrice(finalPrice);
		dynamicPrice.setTimestamp(LocalDateTime.now());
		
		DynamicPrice savedPrice = dynamicPriceRepository.save(dynamicPrice);
		
		return new PriceResponse(
				product.getId(),
				product.getName(),
				product.getBasePrice(),
				savedPrice.getFinalPrice(),
				savedPrice.getTimestamp() );
	}	
}
