package com.inditex.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EProduct {
    JEANS(35455, "Jeans", "Blue jeans"),
    SHIRT(35453, "Shirt", "White jeans"),
    SHOES(354551, "Shoes", "Black shoes");

    protected Integer id;
    protected String name;
    protected String description;
}
