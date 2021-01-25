package com.inditex.ecommerce.service.price;

import java.text.ParseException;

import com.inditex.ecommerce.entity.Price;

public interface IPriceService {

    Price findByBrandAndProduct(final Long brandId, final Integer productId, final String applicationDate) throws ParseException;
}
