package com.bison.common.core.utils;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageUtils {

    /**
     * 按照比例进行缩放
     *
     * @param filePath 图片路径
     * @param toFilePath 新图片路径
     * @param scale 压缩比例
     */
    public static void scale(String filePath, String toFilePath, float scale) throws IOException {
        Thumbnails.of(filePath).scale(scale).toFile(toFilePath);
    }

    /**
     * 指定大小进行缩放
     *
     * @param filePath 图片路径
     * @param toFilePath 新图片路径
     * @param width 宽
     * @param height 高
     */
    public static void scale(String filePath, String toFilePath, int width, int height) throws IOException {
        // keepAspectRatio(false) 默认是按照比例缩放的
        Thumbnails.of(filePath).size(width,height).keepAspectRatio(Boolean.FALSE).toFile(toFilePath);
    }

    /**
     * 添加水印
     *
     * @param filePath 图片路径
     * @param toFilePath 新图片路径
     * @param watermarkFilePath 水印图片路径
     */
    public static void addWatermark(String filePath, String toFilePath, String watermarkFilePath) throws IOException {
        Thumbnails.of(filePath)
                .scale(1f)
                .watermark(Positions.CENTER, ImageIO.read(new File(watermarkFilePath)), 0.5f)
                .outputQuality(0.8f)
                .toFile(toFilePath);
    }
}
