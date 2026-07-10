package com.dynamicpricing.controller;

import com.dynamicpricing.entity.PricingRule;
import com.dynamicpricing.service.PricingRuleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pricing-rules")
public class PricingRuleController {

	private final PricingRuleService pricingRuleService;
	
	public PricingRuleController(PricingRuleService pricingRuleService) {
		this.pricingRuleService = pricingRuleService;
	}
	
	@PostMapping
	public PricingRule createRule(@Valid @RequestBody PricingRule pricingRule) {
		return pricingRuleService.createRule(pricingRule);
	}
	
	@GetMapping
	public List<PricingRule> getRules() {
		return pricingRuleService.getAllRules();
	}
	
	@DeleteMapping("/{id}")
	public String deleteRule(@PathVariable Long id) {
		pricingRuleService.deleteRule(id);
		return "Pricing rule deleted successfully";
	}
}
