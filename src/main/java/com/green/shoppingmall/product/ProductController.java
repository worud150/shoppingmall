package com.green.shoppingmall.product;

import com.green.shoppingmall.product.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }


    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public int insProduct(@RequestPart MultipartFile img
                        , @RequestPart ProductInsDto dto) {
        return service.insProduct(img, dto);
    }


    @PostMapping(value = "/{iproduct}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Long insProductPics(@PathVariable Long iproduct
                            , @RequestPart List<MultipartFile> pics) throws Exception {
        return service.insProductPics(iproduct, pics);
    }

    @GetMapping("/{iproduct}")
    public ProductDetailResponse getProductById(@PathVariable Long iproduct) {
        ProductGetDetailDto dto = new ProductGetDetailDto(iproduct);
        return service.selProductById(dto);
    }



    @GetMapping
    public List<ProductVo> getProduct() {
        return service.selProduct();
    }



    //연습한거
    @PostMapping(value="/file", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public int singSangSong(@RequestPart MultipartFile file
                         , @RequestPart SingSangSongDto data) {

        System.out.println(data);
        System.out.println(file.getOriginalFilename());

        return 0;
    }


}
