package org.jin;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("欢迎使用本软件，请确保本软件所在的文件夹放到需要压缩的图片文件夹");
        System.out.println("请输入扩展名，如：jpg,png,默认为jpg ：");
        Scanner scanner = new Scanner(System.in);
        String format = scanner.nextLine();
        System.out.println("请输入压缩比，压缩比为0-1之间的小数(压缩比越小，图片占用体积越小，图片质量也会相应变差)：");
        Double scale = scanner.nextDouble();
        File f = new File("../");
        File[] files = f.listFiles(f1 -> f1.isFile() && f1.getName().endsWith(format));
        File des = new File("../compressed");
        if (!des.exists()) {
            des.mkdirs();
        }
        Thumbnails.of(files)
                .scale(scale)
                .outputFormat(format)
                .toFiles(des, Rename.NO_CHANGE);
        System.out.println("压缩" + files.length + "张图片完成，输出路径为：" + des.getAbsolutePath() + ",程序运行已结束，请关闭当前窗口");
        scanner.next();
    }
}
