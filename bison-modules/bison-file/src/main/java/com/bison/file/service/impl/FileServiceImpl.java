package com.bison.file.service.impl;

import com.bison.file.service.FileService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.concurrent.CompletableFuture;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @description:
 * @author: Changhai.liu
 * @date: 2020/9/20 23:42
 */
public class FileServiceImpl implements FileService {

    //要压缩的图片文件所在所存放位置
    public static String JPG_FILE_PATH = "/Users/hupengfei/Pictures/pap.er/OqtafYT5kTw.jpg";

    //zip压缩包所存放的位置
    public static String ZIP_FILE = "/Users/hupengfei/Downloads/hu.zip";

    //所要压缩的文件
    public static File JPG_FILE = null;

    //文件大小
    public static long FILE_SIZE = 0;

    //文件名
    public static String FILE_NAME = "";

    //文件后缀名
    public static String SUFFIX_FILE = "";

    static {

        File file = new File(JPG_FILE_PATH);

        JPG_FILE = file;

        FILE_NAME = file.getName();

        FILE_SIZE = file.length();

        SUFFIX_FILE = file.getName().substring(file.getName().indexOf('.'));
    }

    /**
     * 文件压缩 使用Pip
     */
    @Override
    public void zipFile() {
        long beginTime = System.currentTimeMillis();
        try(WritableByteChannel out = Channels.newChannel(new FileOutputStream(ZIP_FILE))) {
            Pipe pipe = Pipe.open();
            //异步任务
            CompletableFuture.runAsync(()->runTask(pipe));

            //获取读通道
            ReadableByteChannel readableByteChannel = pipe.source();
            ByteBuffer buffer = ByteBuffer.allocate(((int) FILE_SIZE)*10);
            while (readableByteChannel.read(buffer)>= 0) {
                buffer.flip();
                out.write(buffer);
                buffer.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        printInfo(beginTime);
    }

    //异步任务
    public static void runTask(Pipe pipe) {

        try(ZipOutputStream zos = new ZipOutputStream(Channels.newOutputStream(pipe.sink()));
            WritableByteChannel out = Channels.newChannel(zos)) {
            System.out.println("Begin");
            for (int i = 0; i < 10; i++) {
                zos.putNextEntry(new ZipEntry(i+SUFFIX_FILE));

                FileChannel jpgChannel = new FileInputStream(new File(JPG_FILE_PATH)).getChannel();

                jpgChannel.transferTo(0, FILE_SIZE, out);

                jpgChannel.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 计算耗时
     * @param beginTime
     */
    private static void printInfo(long beginTime) {
        //耗时
        long timeConsum = (System.currentTimeMillis() - beginTime);

        System.out.println("fileSize:" + FILE_SIZE / 1024 / 1024 * 10 + "M");
        System.out.println("consum time:" + timeConsum);
    }
}
