package com.green.shoppingmall.review;

import com.green.shoppingmall.review.model.ReviewEntity;
import com.green.shoppingmall.review.model.ReviewInsDto;
import com.green.shoppingmall.review.model.ReviewInsPicsEntity;
import com.green.shoppingmall.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewMapper MAPPER;

    @Value("${file.dir}")
    private String fileDir;

    public int insReview(ReviewInsDto dto) {
        ReviewEntity entity = new ReviewEntity();
        entity.setIbuy(dto.getIbuy());
        entity.setCtnt(dto.getCtnt());
        entity.setStar(dto.getStar());

        int reviewResult = MAPPER.insReview(entity);
        if(reviewResult == 0) { return 0; }

        String dicPath = String.format("%s/review/%d", fileDir, entity.getIreview());
        File dicFile = new File(dicPath);
        if(!dicFile.exists()) {
            dicFile.mkdirs();
        }


        //List<ReviewPicInsDto> picDtoList = new ArrayList<>();
        ReviewInsPicsEntity picDto = new ReviewInsPicsEntity();
        picDto.setIreview(entity.getIreview());
        List<String> pics = new ArrayList<>();
        picDto.setPics(pics);

        for(MultipartFile file : dto.getPics()) {
            String saveFileNm = FileUtils.makeRandomFileNm(file.getOriginalFilename());
            String savePath = String.format("%s/%s", FileUtils.getAbsolutePath(dicPath), saveFileNm);

            File saveFile = new File(savePath);
            try {
                file.transferTo(saveFile);
                pics.add(saveFileNm);
//                ReviewPicInsDto picDto = new ReviewPicInsDto();
//                picDto.setIreview(entity.getIreview());
//                picDto.setPic(saveFileNm);
//                picDtoList.add(picDto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /*
        if(picDtoList.size() > 0) {
            int reviewPicResult = mapper.insReviewPics(picDtoList);
        }

         */

        int reviewPicResult = MAPPER.insReviewPics(picDto);
        return 1;
    }
}
