package com.dynamicpricing.controller;

import com.dynamicpricing.service.PricingEngineService;
import org.springframework.web.bind.annotation.*;
import com.dynamicpricing.dto.PriceResponse;



@RestController
@RequestMapping("/api/prices")
public class PriceController {
	
	private final PricingEngineService pricingEngineService;
	
	public PriceController(PricingEngineService pricingEngineService) {
		
		this.pricingEngineService = pricingEngineService;
	}
	
	@GetMapping("/product/{productId}")
	public PriceResponse calculatePrice(@PathVariable Long productId) {
		return pricingEngineService.calculatePrice(productId);
	}

}
