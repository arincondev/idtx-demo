package com.inditex.ecommerce.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inditex.ecommerce.entity.Brand;
import com.inditex.ecommerce.entity.Price;
import com.inditex.ecommerce.entity.Product;
import com.inditex.ecommerce.entity.Rate;

public interface IPriceDao extends JpaRepository<Price, Long> {

    Optional<Price> findByBrandAndProductAndRate(final Optional<Brand> brand, final Optional<Product> product, final Rate rate);
}
