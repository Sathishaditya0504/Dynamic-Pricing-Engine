package com.dynamicpricing.repository;

import com.dynamicpricing.entity.PricingRule;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PricingRuleRepository extends JpaRepository<PricingRule, Long>{
	

}
