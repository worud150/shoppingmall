package com.green.shoppingmall.product.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ProductDetailResponse {
    private ProductDetailVo data;
    private List<String> pics;

}
