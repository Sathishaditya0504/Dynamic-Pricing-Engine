package com.dynamicpricing.strategy;

import com.dynamicpricing.entity.PricingRule;

import java.math.BigDecimal;

public interface PricingStrategy {
    
	String getType();
	
	BigDecimal apply(BigDecimal currentPrice, PricingRule pricingRule);
}
