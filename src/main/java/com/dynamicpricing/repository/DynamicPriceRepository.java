package com.dynamicpricing.repository;

import com.dynamicpricing.entity.DynamicPrice;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DynamicPriceRepository extends JpaRepository<DynamicPrice, Long> {

}
