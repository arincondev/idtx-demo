package com.inditex.ecommerce.service.rate;

import java.util.Date;

import com.inditex.ecommerce.entity.Rate;

public interface IRateService {

    Rate findByStartDateLessThanEqualAndEndDateGreaterThanEqual(final Date applicationDate);
}
