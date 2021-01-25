package com.inditex.ecommerce.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inditex.ecommerce.entity.Rate;

public interface IRateDao extends JpaRepository<Rate, Long> {

    List<Rate> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(final Date from, final Date to);
}
