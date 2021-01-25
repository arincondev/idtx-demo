package com.inditex.ecommerce.service.product;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inditex.ecommerce.dao.IProductDao;
import com.inditex.ecommerce.entity.Product;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    private final IProductDao productDao;

    @Override
    public Optional<Product> findByProductId(final Integer id) {
        return productDao.findByProductId(id);
    }
}
