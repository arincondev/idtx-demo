package com.inditex.ecommerce.service.price;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inditex.ecommerce.dao.IPriceDao;
import com.inditex.ecommerce.entity.Brand;
import com.inditex.ecommerce.entity.Price;
import com.inditex.ecommerce.entity.Product;
import com.inditex.ecommerce.entity.Rate;
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
    public Price findByBrandAndProduct(final Long brandId, final Integer productId, final String applicationDate) throws ParseException {
        final Optional<Brand> brand = brandService.findById(brandId);
        final Optional<Product> product = productService.findByProductId(productId);
        final Comparator<Rate> comparator = Comparator.comparing(Rate::getPriority);

        final Rate rate = rateService.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(convertToDate(applicationDate))
            .stream()
            .max(comparator)
            .get();

        final Optional<Price> price = priceDao.findByBrandAndProductAndRate(brand, product, rate);

        return buildResponse(price);
    }

    private Price buildResponse(final Optional<Price> price) {
        return Price.builder()
            .product(
                Product.builder().productId(price.get().getProduct().getProductId()).build()
            )
            .brand(Brand.builder()
                .id(price.get().getBrand().getId())
                .name(price.get().getBrand().getName())
                .build())
            .rate(Rate.builder()
                .name(price.get().getRate().getName())
                .price(price.get().getRate().getPrice())
                .startDate(price.get().getRate().getStartDate())
                .endDate(price.get().getRate().getEndDate())
                .build())
            .build();
    }

    private Date convertToDate(final String date) throws ParseException {
        final SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date convertedDate = temp.parse(date);

        return convertedDate;
    }
}
