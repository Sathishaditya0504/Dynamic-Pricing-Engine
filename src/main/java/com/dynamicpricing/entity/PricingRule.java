package com.dynamicpricing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Entity
public class PricingRule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message = "Rule type is required")
	private String type;
	
	@NotNull(message = "Rule value is required")
	@Positive (message = "Rule value must be greater than zero")
	@Column(name = "rule_value")
	private BigDecimal value;
	
	@NotBlank(message = "Rule condition is required")
	private String conditionText;
	
	public PricingRule() {
		
	}
	
	public PricingRule(Long id, String type, BigDecimal value, String conditionText) {
		this.id=id;
		this.type=type;
		this.value=value;
		this.conditionText=conditionText;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getConditionText() {
		return conditionText;
	}

	public void setConditionText(String conditionText) {
		this.conditionText = conditionText;
	}
	
}
