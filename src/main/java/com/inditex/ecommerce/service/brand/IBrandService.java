package com.inditex.ecommerce.service.brand;

import java.util.Optional;

import com.inditex.ecommerce.entity.Brand;

public interface IBrandService {

    Optional<Brand> findById(final Long id);
}
