package com.dynamicpricing.strategy;

import com.dynamicpricing.entity.PricingRule;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class SurgePricingStrategy implements PricingStrategy {

	@Override
	public String getType() {
		return "SURGE";
	}
	
	@Override
	public BigDecimal apply (BigDecimal currentPrice, PricingRule pricingRule) {
		
		BigDecimal percentage = pricingRule.getValue().divide(BigDecimal.valueOf(100),4, RoundingMode.HALF_UP);
		BigDecimal increaseAmount = currentPrice.multiply(percentage);
		return currentPrice.add(increaseAmount);
	}
}
