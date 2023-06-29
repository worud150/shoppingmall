package com.green.shoppingmall.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.UUID;

public class FileUtils {
    // 파일의 확장자 리턴하는 메소드
    public static String getExt(String fileNm) {
        int dotIdx = fileNm.lastIndexOf(".");
        String ext = fileNm.substring(dotIdx);
        return ext;
    }

    public static String getFile (String fileNm) {
        int dotIdx = fileNm.lastIndexOf(".");
        String ext = fileNm.substring(0, dotIdx);
        return ext;
    }
    public static String makeRandomFileNm (String fileNm) {
        String uuid = UUID.randomUUID().toString();
        String saveNm = uuid + getExt(fileNm);
        return saveNm;
    }

    public static String getAbsolutePath(String path) {
        Path p = Paths.get(path);
        return p.toFile().getAbsolutePath();
    }
}
