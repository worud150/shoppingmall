package com.green.shoppingmall.buy;

import com.green.shoppingmall.buy.model.BuyInsDto;
import com.green.shoppingmall.buy.model.BuySelDetailDto;
import com.green.shoppingmall.buy.model.BuySelVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/buy")
@RequiredArgsConstructor
public class BuyController {
    private final BuyService service;

    @PostMapping
    public ResponseEntity<Integer> insBuy(@RequestBody BuyInsDto dto) {
        return ResponseEntity.ok(service.insBuy(dto));
    }

    @GetMapping("/{icustomer}")
    public List<BuySelVo> getBuyId (@PathVariable int icustomer) {
        BuySelDetailDto dto = new BuySelDetailDto();
        dto.setIcustomer(icustomer);
        return service.getBuyId(dto);
    }

}
