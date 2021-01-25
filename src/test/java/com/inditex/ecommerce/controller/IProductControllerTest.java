package com.inditex.ecommerce.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.inditex.ecommerce.EcommerceApplication;
import com.inditex.ecommerce.configuration.H2TestProfileJPAConfig;
import com.inditex.ecommerce.entity.Brand;
import com.inditex.ecommerce.entity.Price;
import com.inditex.ecommerce.entity.Product;
import com.inditex.ecommerce.model.EBrand;
import com.inditex.ecommerce.model.EProduct;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
    EcommerceApplication.class,
    H2TestProfileJPAConfig.class
})
@ActiveProfiles("test")
public class IProductControllerTest {

    @Autowired
    private ProductController sut;

    @Test
    public void case1() throws ParseException {

        final SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date first = temp.parse("2020-06-14 10:00:00");
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(first);

        final Price mockPrice = Price.builder()
            .brand(Brand.builder()
                .id(1L)
                .name("ZARA")
                .build())
            .product(Product.builder()
                .productId(35455)
                .build())
            .build();

        final Price ret = sut.getProduct(EBrand.ZARA, EProduct.JEANS, "2020-06-14 10:00:00");

        assertNotNull(ret);
        assertEquals("Product ID", mockPrice.getProduct().getProductId(), ret.getProduct().getProductId());
        assertEquals("Brand ID", mockPrice.getBrand().getId(), ret.getBrand().getId());
        assertEquals("Brand Name", mockPrice.getBrand().getName(), ret.getBrand().getName());

        System.out.println("Test 1: petición a las " + calendar.get(Calendar.HOUR_OF_DAY) + " del día " + calendar.get(Calendar.DAY_OF_MONTH) +
            " del producto " + ret.getProduct().getProductId() + " para la marca " + ret.getBrand().getId() + "(" + ret.getBrand().getName() + ")");
    }

    @Test
    public void case2() throws ParseException {

        final SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date first = temp.parse("2020-06-14 16:00:00");
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(first);

        final Price mockPrice = Price.builder()
            .brand(Brand.builder()
                .id(1L)
                .name("ZARA")
                .build())
            .product(Product.builder()
                .productId(35455)
                .build())
            .build();

        final Price ret = sut.getProduct(EBrand.ZARA, EProduct.JEANS, "2020-06-14 16:00:00");

        assertNotNull(ret);
        assertEquals("Product ID", mockPrice.getProduct().getProductId(), ret.getProduct().getProductId());
        assertEquals("Brand ID", mockPrice.getBrand().getId(), ret.getBrand().getId());
        assertEquals("Brand Name", mockPrice.getBrand().getName(), ret.getBrand().getName());

        System.out.println("Test 2: petición a las " + calendar.get(Calendar.HOUR_OF_DAY) + " del día " + calendar.get(Calendar.DAY_OF_MONTH) +
            " del producto " + ret.getProduct().getProductId() + " para la marca " + ret.getBrand().getId() + "(" + ret.getBrand().getName() + ")");
    }

    @Test
    public void case3() throws ParseException {

        final SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date first = temp.parse("2020-06-14 21:00:00");
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(first);

        final Price mockPrice = Price.builder()
            .brand(Brand.builder()
                .id(1L)
                .name("ZARA")
                .build())
            .product(Product.builder()
                .productId(35455)
                .build())
            .build();

        final Price ret = sut.getProduct(EBrand.ZARA, EProduct.JEANS, "2020-06-14 21:00:00");

        assertNotNull(ret);
        assertEquals("Product ID", mockPrice.getProduct().getProductId(), ret.getProduct().getProductId());
        assertEquals("Brand ID", mockPrice.getBrand().getId(), ret.getBrand().getId());
        assertEquals("Brand Name", mockPrice.getBrand().getName(), ret.getBrand().getName());

        System.out.println("Test 3: petición a las " + calendar.get(Calendar.HOUR_OF_DAY) + " del día " + calendar.get(Calendar.DAY_OF_MONTH) +
            " del producto " + ret.getProduct().getProductId() + " para la marca " + ret.getBrand().getId() + "(" + ret.getBrand().getName() + ")");
    }

    @Test
    public void case4() throws ParseException {

        final SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date first = temp.parse("2020-06-15 10:00:00");
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(first);

        final Price mockPrice = Price.builder()
            .brand(Brand.builder()
                .id(1L)
                .name("ZARA")
                .build())
            .product(Product.builder()
                .productId(35455)
                .build())
            .build();

        final Price ret = sut.getProduct(EBrand.ZARA, EProduct.JEANS, "2020-06-15 10:00:00");

        assertNotNull(ret);
        assertEquals("Product ID", mockPrice.getProduct().getProductId(), ret.getProduct().getProductId());
        assertEquals("Brand ID", mockPrice.getBrand().getId(), ret.getBrand().getId());
        assertEquals("Brand Name", mockPrice.getBrand().getName(), ret.getBrand().getName());

        System.out.println("Test 4: petición a las " + calendar.get(Calendar.HOUR_OF_DAY) + " del día " + calendar.get(Calendar.DAY_OF_MONTH) +
            " del producto " + ret.getProduct().getProductId() + " para la marca " + ret.getBrand().getId() + "(" + ret.getBrand().getName() + ")");
    }

    @Test
    public void case5() throws ParseException {

        final SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date first = temp.parse("2020-06-16 21:00:00");
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(first);

        final Price mockPrice = Price.builder()
            .brand(Brand.builder()
                .id(1L)
                .name("ZARA")
                .build())
            .product(Product.builder()
                .productId(35455)
                .build())
            .build();

        final Price ret = sut.getProduct(EBrand.ZARA, EProduct.JEANS, "2020-06-16 21:00:00");

        assertNotNull(ret);
        assertEquals("Product ID", mockPrice.getProduct().getProductId(), ret.getProduct().getProductId());
        assertEquals("Brand ID", mockPrice.getBrand().getId(), ret.getBrand().getId());
        assertEquals("Brand Name", mockPrice.getBrand().getName(), ret.getBrand().getName());

        System.out.println("Test 5: petición a las " + calendar.get(Calendar.HOUR_OF_DAY) + " del día " + calendar.get(Calendar.DAY_OF_MONTH) +
            " del producto " + ret.getProduct().getProductId() + " para la marca " + ret.getBrand().getId() + "(" + ret.getBrand().getName() + ")");
    }
}
