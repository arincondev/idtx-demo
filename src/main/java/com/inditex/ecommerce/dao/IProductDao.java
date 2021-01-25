package com.inditex.ecommerce.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inditex.ecommerce.entity.Product;

public interface IProductDao extends JpaRepository<Product, Long> {

    Optional<Product> findByProductId(final Integer id);
}
