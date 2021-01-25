package com.inditex.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inditex.ecommerce.entity.Brand;

public interface IBrandDao extends JpaRepository<Brand, Long> {

    Brand findById(final Integer id);
}
