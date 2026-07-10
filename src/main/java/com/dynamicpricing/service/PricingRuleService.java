package com.dynamicpricing.service;

import com.dynamicpricing.entity.PricingRule;
import com.dynamicpricing.repository.PricingRuleRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingRuleService {
  
	private final PricingRuleRepository pricingRuleRepository;
	
	public PricingRuleService(PricingRuleRepository pricingRuleRepository) {
		this.pricingRuleRepository = pricingRuleRepository;
	}
	
	@CacheEvict(value = "pricingRules", allEntries = true)
	public PricingRule createRule(PricingRule pricingRule) {
		return pricingRuleRepository.save(pricingRule);
	}
	
	@Cacheable("pricingRules")
	public List<PricingRule> getAllRules() {
		return pricingRuleRepository.findAll();
	}
	
	@CacheEvict(value = "pricingRules", allEntries = true)
	public void deleteRule(Long id) {
		if (!pricingRuleRepository.existsById(id)) {
			throw new RuntimeException("Pricing rule not found with id: " + id);
		}
		pricingRuleRepository.deleteById(id);
	}
}
