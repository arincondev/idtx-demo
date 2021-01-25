package com.inditex.ecommerce.service.rate;

import java.util.Date;
import java.util.List;

import com.inditex.ecommerce.entity.Rate;

public interface IRateService {

    List<Rate> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(final Date applicationDate);
}
