# Api Documentation - Dynamic pricing Engine

 # 1. Create Product

  Method: POST  
  URL: `/api/products`

   # Request

   ```json
  {
  "name": "Laptop",
  "basePrice": 50000
  }

  # Response

  {
  "id": 1,
  "name": "Laptop",
  "basePrice": 50000.00
  }

# 2. Get All Products

Method: GET
URL: /api/product

Response


  {
    "id": 1,
    "name": "Laptop",
    "basePrice": 50000.00
  }
]


# 3. Create Pricing Rule

  Method: POST
  URL: /api/pricing-rules
  
  ---Request---
  {
  "type": "SURGE",
  "value": 20,
  "conditionText": "DEMAND_HIGH"
  }
  
  ----Response---
  {
  "id": 1,
  "type": "SURGE",
  "value": 20.00,
  "conditionText": "DEMAND_HIGH"
  }
  
  
# 4. Get All Pricing Rules

  Method: GET
  URL: /api/pricing-rules
  
  -----Response------
  [
  {
    "id": 1,
    "type": "SURGE",
    "value": 20.00,
    "conditionText": "DEMAND_HIGH"
  },
  {
    "id": 2,
    "type": "TIME",
    "value": 10.00,
    "conditionText": "PEAK_HOUR"
  },
  {
    "id": 3,
    "type": "INVENTORY",
    "value": 15.00,
    "conditionText": "LOW_STOCK"
  }
]


# 5. Calculate Dynamic Price

  Method: GET
  URL: /api/prices/product/{productId}
  
  Example : /api/prices/product/1
  
  {
  "productId": 1,
  "productName": "Laptop",
  "basePrice": 50000.00,
  "finalPrice": 75900.00,
  "timestamp": "2026-07-08T13:19:29.974584"
  }

----------Calculation Example-----------

      Base price = 50000
      SURGE 20% = 60000
      TIME 10% = 66000
      INVENTORY 15% = 75900

## Delete Pricing Rule

Method: DELETE
URL: /api/pricing-rules/{id}

Example:
DELETE /api/pricing-rules/4

Response:
Pricing rule deleted successfully













