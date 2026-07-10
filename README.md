# Dynamic Pricing Engine

Spring Boot backend assignment for calculating product prices dynamically using configurable pricing rules.

## Features

  # Product base price configuration
  # Dynamic price calculations
  # Surge pricing support
  # Time based pricing support
  # Inventory based pricing support
  # Admin APIs for rule configuration
  # Strategy Pattern
  # Spring Data JPA
  # Validation
  # Spring Cache
  # Transaction Manangement
  
## Technologies Used

 - Java 17
 - Spring Boot
 - Spring Web
 - Spring Data JPA
 - H2 Database
 - Maven
 
 
## Project Structure

 # src/main/java/com/dynamicpricing
 
    - controller
   ProductController.java
   PricingRuleController.java
   PriceController.java
   
     - dto
   PriceResponse.java
   
     - entity
  
   Product.java
   PricingRule.java
   DynamicPrice.java
   
     - repository
   
   ProductRepository.java
   PricingRuleRepository.java
   DynamicPriceRepository.java
   
     - service
     
  ProductService.java
  PricingRuleService.java
  PricingEngineService.java
  
     - strategy
  
  PricingStrategy.java
  SurgePricingStrategy.java
  TimeBasedPricingStrategy.java
  InventoryPricingStrategy.java
  
  
## Database Tables

  - product
  - pricing_rule
  - dynamic_price
   
##  API's

  - POST /api/product
  - GET /api/product
  - GET /api/product/{id}
  - POST /api/pricing-rules
  - GET /api/peicing-rules
  - GET /api/prices/product/{productId}
  
## Sample Calculation

  Base price = 50000
  SURGE 20%  = 60000
  TIME  10%  = 66000
  INVENTORY 15 = 75900

## Run

  `bash
mvn spring-boot:run
```

## H2 Console

  `text
http://localhost:8080/h2-console


JDBC URL:

   `text
   
jdbc:h2:mem:pricingdb
















```
