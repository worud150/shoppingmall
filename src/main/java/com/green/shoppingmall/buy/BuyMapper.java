package com.green.shoppingmall.buy;

import com.green.shoppingmall.buy.model.BuyInsDto;
import com.green.shoppingmall.buy.model.BuySelDetailDto;
import com.green.shoppingmall.buy.model.BuySelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuyMapper {
    int insBuy(BuyInsDto dto);
    List<BuySelVo> selBuyProduct(BuySelDetailDto dto);
}
