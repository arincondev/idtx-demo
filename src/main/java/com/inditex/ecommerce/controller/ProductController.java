package com.inditex.ecommerce.controller;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.ecommerce.entity.Price;
import com.inditex.ecommerce.entity.Product;
import com.inditex.ecommerce.exception.model.ErrorDTO;
import com.inditex.ecommerce.model.EBrand;
import com.inditex.ecommerce.model.EProduct;
import com.inditex.ecommerce.service.price.IPriceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "productList")
@AllArgsConstructor
public class ProductController {

    private final IPriceService priceService;

    @ApiOperation(
        nickname = "getProduct",
        value = "This operation returns a product"
    )
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK, successful operation", response = Product.class),
        @ApiResponse(code = 404, message = "Price not found", response = ErrorDTO.class),
        @ApiResponse(code = 422, message = "Mandatory fields missing / validation error", response = ErrorDTO.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorDTO.class),
        @ApiResponse(code = 503, message = "Service unavailable", response = ErrorDTO.class)
    })
    @GetMapping(value = "products", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public Price getProduct(
        @RequestParam("brand") final EBrand brand, @RequestParam("product") final EProduct product,
        @RequestParam("applicationDate") @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") @Valid final String applicationDate) throws ParseException {
        return priceService.findByBrandAndProduct(brand.getId(), product.getId(), applicationDate);
    }
}
