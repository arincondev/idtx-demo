package com.inditex.ecommerce.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.inditex.ecommerce.entity.Brand;
import com.inditex.ecommerce.entity.Price;
import com.inditex.ecommerce.entity.Product;
import com.inditex.ecommerce.entity.Rate;
import com.inditex.ecommerce.model.EBrand;
import com.inditex.ecommerce.model.EProduct;
import com.inditex.ecommerce.service.price.IPriceService;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;

public class ProductControllerTest {

    @Tested
    private ProductController sut;

    @Injectable
    private IPriceService priceService;

    @Test
    public void getProductTest() throws ParseException {


        final EBrand mockBrand = EBrand.ZARA;
        final EProduct mockProduct = EProduct.JEANS;
        final SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date date = temp.parse("2020-06-16 21:00:00");

        final Price mockPrice = Price.builder()
            .id(1L)
            .product(Product.builder()
                .id(1L)
                .productId(mockProduct.getId())
                .name(mockProduct.getName())
                .build())
            .rate(Rate.builder()
                .id(1L)
                .startDate(date)
                .endDate(date)
                .price((float) 30.5)
                .name("XMAS")
                .priority(999)
                .currency("EUR")
                .build())
            .brand(Brand.builder()
                .id(mockBrand.getId())
                .name(mockBrand.name())
                .build())
            .build();

        new Expectations() {
            {
                priceService.findByBrandAndProduct(mockBrand.getId(), mockProduct.getId(), "2020-06-16 21:00:00");
                times = 1;
                result = mockPrice;
            }
        };

        final Price actual = sut.getProduct(mockBrand, mockProduct, "2020-06-16 21:00:00");

        assertNotNull(actual);
        assertEquals(mockPrice.getId(), actual.getId());
        assertEquals(mockPrice.getBrand().getId(), actual.getBrand().getId());
        assertEquals(mockPrice.getProduct().getProductId(), actual.getProduct().getProductId());
        assertEquals(mockPrice.getRate().getId(), actual.getRate().getId());
    }
}
