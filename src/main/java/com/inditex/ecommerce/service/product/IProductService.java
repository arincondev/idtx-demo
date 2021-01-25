package com.inditex.ecommerce.service.product;

import java.util.Optional;

import com.inditex.ecommerce.entity.Product;

public interface IProductService {

    Optional<Product> findByProductId(final Integer id);
}
