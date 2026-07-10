package com.dynamicpricing.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PriceResponse {
	
	private Long productId;
	private String productName;
	private BigDecimal basePrice;
	private BigDecimal finalPrice;
	private LocalDateTime timestamp;
	
	public PriceResponse() {
		
	}
	
	public PriceResponse (Long productId, String productName, BigDecimal basePrice, BigDecimal finalPrice, LocalDateTime timestamp) {
		
		this.productId = productId;
		this.productName = productName;
		this.basePrice = basePrice;
		this.finalPrice = finalPrice;
		this.timestamp = timestamp;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public BigDecimal getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
