package com.green.shoppingmall.review.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ReviewInsDto {
    private Long ibuy;
    private String ctnt;
    private int star;
    private List<MultipartFile> pics;
}
