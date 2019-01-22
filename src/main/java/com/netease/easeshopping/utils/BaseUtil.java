package com.netease.easeshopping.utils;

/**
 * 用于判断和存储本地上传的文件
 */
public class BaseUtil {
    public static String IMAGE_DIR = "D:/upload/";
    public static String[] IMAGE_FILE_EXTD = new String[] {"png", "bmp", "jpg", "jpeg"};

    public static boolean isFileAllowed(String fileName) {
        for (String ext : IMAGE_FILE_EXTD) {
            if (ext.equals(fileName)) {
                return true;
            }
        }
        return false;
    }
}
