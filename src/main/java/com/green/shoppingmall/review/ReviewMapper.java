package com.green.shoppingmall.review;

import com.green.shoppingmall.review.model.ReviewEntity;
import com.green.shoppingmall.review.model.ReviewInsDto;
import com.green.shoppingmall.review.model.ReviewInsPicsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    int insReview(ReviewEntity entity);
    int insReviewPics(ReviewInsPicsEntity entity);
}
