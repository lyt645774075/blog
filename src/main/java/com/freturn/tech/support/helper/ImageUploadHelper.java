package com.freturn.tech.support.helper;

import com.aliyun.oss.OSSClient;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author yangtao.lyt
 * @version $Id: ImageUploadUtil, v 0.1 2016-05-11 23:36 yangtao.lyt Exp $
 */
@Component
public class ImageUploadHelper {


    private final static String BUCKET_NAME = "freturn";

    private final static String USER_FILE_FOLDER = "upload/img/user/";

    /** 上传图片最大宽度 */
    private final static Float MAX_WIDTH = 1200f;

    /** 图片地址前缀 */
    private final static String IMAGE_URL_PRE = "http://freturn.oss-cn-hangzhou.aliyuncs.com/";

    @Autowired
    private OSSClient ossClient;


    public String doUpload(MultipartFile file) throws IOException {

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

        return IMAGE_URL_PRE + fileName;

    }



}
