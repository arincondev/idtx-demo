package com.inditex.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EBrand {

    ZARA(1L),
    OYSHO(2L),
    STRADIVARIUS(3L);

    protected Long id;
}
