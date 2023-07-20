package com.NisRids.ecommerce.dto;

import lombok.Data;


@Data
public class AddToCartDto {
    private Long id;
    private Long productId;
    private int quantity;


}
