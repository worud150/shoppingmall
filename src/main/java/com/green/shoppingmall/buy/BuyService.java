package com.green.shoppingmall.buy;

import com.green.shoppingmall.buy.model.BuyInsDto;
import com.green.shoppingmall.buy.model.BuySelDetailDto;
import com.green.shoppingmall.buy.model.BuySelVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BuyService {
    private final BuyMapper mapper;

    public int insBuy(BuyInsDto dto) {
        return mapper.insBuy(dto);
    }

    public List<BuySelVo> getBuyId(BuySelDetailDto dto) {
        return mapper.selBuyProduct(dto);
    }

}
