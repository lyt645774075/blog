package com.freturn.tech.controller.ajax;

import com.aliyun.oss.OSSClient;
import com.google.common.collect.Maps;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * 图片上传控制器
 *
 * @author yangtao.lyt
 * @version $Id: ImageUploadController, v 0.1 2016-01-25 23:54 yangtao.lyt Exp $
 */
@Controller
public class ImageUploadController {

    private final static String BUCKET_NAME = "freturn";

    private final static String USER_FILE_FOLDER = "upload/img/user/";

    /** 上传图片最大宽度 */
    private final static Float MAX_WIDTH = 1200f;

    /** 图片地址前缀 */
    private final static String IMAGE_URL_PRE = "http://freturn.oss-cn-hangzhou.aliyuncs.com/";

    @Autowired
    private OSSClient ossClient;


    @RequestMapping(value = "/upload/user/image", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,String> imageUpload(@RequestParam("file") MultipartFile file) {

        Map<String, String> dataMap = Maps.newHashMap();

        try {
            /*
             * 使用图片md5作为文件名
             */
            String fileName = USER_FILE_FOLDER + DigestUtils.md5Hex(file.getInputStream()) + ".jpg";
            /*
             * 先判断文件是否已经存在,去重
             */
            boolean exist = ossClient.doesObjectExist(BUCKET_NAME, fileName);

            if(!exist){
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                BufferedImage image = ImageIO.read(file.getInputStream());
                Float scale = MAX_WIDTH / image.getWidth() > 1f ? 1f : MAX_WIDTH / image.getWidth();

                Thumbnails.of(file.getInputStream()).scale(scale).outputQuality(0.9f).outputFormat("jpg").toOutputStream(outputStream);

                ossClient.putObject(BUCKET_NAME, fileName, new ByteArrayInputStream(outputStream.toByteArray()));
            }

            dataMap.put("url", IMAGE_URL_PRE + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataMap;
    }





}
