package com.inditex.ecommerce.service.rate;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.inditex.ecommerce.dao.IRateDao;
import com.inditex.ecommerce.entity.Rate;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RateService implements IRateService {

    private final IRateDao rateDao;

    @Override public List<Rate> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(final Date applicationDate) {
        return rateDao.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(applicationDate, applicationDate);
    }
}
