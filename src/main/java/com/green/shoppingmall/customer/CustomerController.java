package com.green.shoppingmall.customer;

import com.green.shoppingmall.customer.model.CustomerGetVo;
import com.green.shoppingmall.customer.model.CustomerInsDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    /customer 고객
    (post) 회원가입

 */
@RestController
@RequestMapping("/customer")

public class CustomerController {
    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Integer> postCustomer(@RequestBody CustomerInsDto dto){
        int result = service.insCustomer(dto);
        return ResponseEntity.ok(result);
        //위 내용이 200 코드로 리절트값 넘기는 방식임
    }

    @GetMapping
    private ResponseEntity<List<CustomerGetVo>> getCustomer() {
        return ResponseEntity.ok(service.selCustomer());
    }


}
