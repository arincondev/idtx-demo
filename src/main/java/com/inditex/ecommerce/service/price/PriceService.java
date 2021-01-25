package com.inditex.ecommerce.service.price;


import static com.inditex.ecommerce.utils.DateUtils.convertToDate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inditex.ecommerce.dao.IPriceDao;
import com.inditex.ecommerce.entity.Brand;
import com.inditex.ecommerce.entity.Price;
import com.inditex.ecommerce.entity.Product;
import com.inditex.ecommerce.entity.Rate;
import com.inditex.ecommerce.exception.ServiceException;
import com.inditex.ecommerce.exception.template.CommonErrorTemplate;
import com.inditex.ecommerce.exception.template.ErrorParameters;
import com.inditex.ecommerce.service.brand.IBrandService;
import com.inditex.ecommerce.service.product.IProductService;
import com.inditex.ecommerce.service.rate.IRateService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PriceService implements IPriceService {

    private final IBrandService brandService;
    private final IProductService productService;
    private final IRateService rateService;
    private final IPriceDao priceDao;

    @Override
    public Price findByBrandAndProduct(final Long brandId, final Integer productId, final String applicationDate) {
        final Optional<Brand> brand = brandService.findById(brandId);
        final Optional<Product> product = productService.findByProductId(productId);
        final Rate rate = rateService.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(convertToDate(applicationDate));
        final Optional<Price> price = priceDao.findByBrandAndProductAndRate(brand, product, rate);

        return buildResponse(price, brandId, productId, applicationDate);
    }

    private Price buildResponse(final Optional<Price> price, final Long brandId, final Integer productId, final String applicationDate) {
        Price ret;

        if (price.isPresent()) {
            ret = getPrice(price.get());
        } else {
            final Map<String, String> parameters = new HashMap<>();
            parameters.put("applicationDate", applicationDate);
            parameters.put("brandId", brandId.toString());
            parameters.put("productId", productId.toString());

            throw new ServiceException(null, CommonErrorTemplate.PRICE_NOT_FOUND, ErrorParameters.builder()
                .parameters(parameters)
                .build());
        }

        return ret;
    }

    private Price getPrice(final Price price) {
        return Price.builder()
            .product(
                Product.builder().productId(price.getProduct().getProductId()).build()
            )
            .brand(Brand.builder()
                .id(price.getBrand().getId())
                .name(price.getBrand().getName())
                .build())
            .rate(Rate.builder()
                .name(price.getRate().getName())
                .price(price.getRate().getPrice())
                .startDate(price.getRate().getStartDate())
                .endDate(price.getRate().getEndDate())
                .build())
            .build();
    }


}
