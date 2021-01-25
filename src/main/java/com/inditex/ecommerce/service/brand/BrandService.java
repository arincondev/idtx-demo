package com.inditex.ecommerce.service.brand;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inditex.ecommerce.dao.IBrandDao;
import com.inditex.ecommerce.entity.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandService implements IBrandService {

    private final IBrandDao brandDao;

    @Override public Optional<Brand> findById(final Long id) {
        return brandDao.findById(id);
    }
}
