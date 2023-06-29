package com.green.shoppingmall.buy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class BuySelVo {
    private int icustomer;
    private int iproduct;
    private int ibuy;
    private String productNm;
    private String customerNm;
    private int quantity;
    private String productMainPic;
    private int productPrice;
    private String buyAt;
}


