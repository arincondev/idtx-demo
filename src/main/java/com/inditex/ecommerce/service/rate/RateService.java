package com.inditex.ecommerce.service.rate;

import java.util.Comparator;
import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inditex.ecommerce.dao.IRateDao;
import com.inditex.ecommerce.entity.Rate;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RateService implements IRateService {

    private static final Comparator<Rate> PRIORITY_COMPARATOR = Comparator.comparing(Rate::getPriority);
    private final IRateDao rateDao;

    @Override
    public Rate findByStartDateLessThanEqualAndEndDateGreaterThanEqual(final Date applicationDate) {
        return getRate(applicationDate);
    }

    private Rate getRate(final Date applicationDate) {
        Rate ret = null;
        final Optional<Rate> rate = rateDao.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(applicationDate, applicationDate)
            .stream()
            .max(PRIORITY_COMPARATOR);

        if (rate.isPresent()) {
            ret = rate.get();
        }
        return ret;
    }
}
