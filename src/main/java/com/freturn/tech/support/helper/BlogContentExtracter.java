package com.freturn.tech.support.helper;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yangtao.lyt
 * @version $Id: BlogContentExtracter, v 0.1 2016-05-12 13:58 yangtao.lyt Exp $
 */
public class BlogContentExtracter {

    private static final String  regEx_img  = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
    private static final String  regEx_src  = "src\\s*=\\s*\"?(.*?)(\"|>|\\s+)";

    private static final Pattern ImgPattern = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
    private static final Pattern SrcPattern = Pattern.compile(regEx_src, Pattern.CASE_INSENSITIVE);

    /**
     * 抽取图片url地址
     * @param content
     * @return
     */
    public static final List<String> extractImageUrl(String content) {

        Matcher imgMatcher = ImgPattern.matcher(content);

        List<String> srcList = Lists.newArrayList();

        while (imgMatcher.find()) {

            String img = imgMatcher.group();
            System.out.println(img);
            Matcher m = SrcPattern.matcher(img);
            while (m.find()) {
                srcList.add(m.group(1));
            }
        }
        return srcList;
    }

    public static void main(String[] args) throws IOException, WriterException {

        String text = "http://www.baidu.com";
        int width = 100;
        int height = 100;
        String format = "png";
        HashMap hints= Maps.newHashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height,hints);
        OutputStream outputStream = new FileOutputStream("2.png");

        MatrixToImageWriter.writeToStream(bitMatrix, format, outputStream);// 输出图像
        System.out.println("输出成功.");

    }

}
