package com.freturn.tech.support.helper;

import com.google.common.collect.Lists;
import com.google.zxing.WriterException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yangtao.lyt
 * @version $Id: BlogContentExtracter, v 0.1 2016-05-12 13:58 yangtao.lyt Exp $
 */

@Component
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
            Matcher m = SrcPattern.matcher(img);
            while (m.find()) {
                srcList.add(m.group(1));
            }
        }
        return srcList;
    }

    public static String getAbstract(String content, Integer maxWordCount, String replaceStr) {

        Document doc = Jsoup.parseBodyFragment(content);
        Element article = doc.body();

        if(article.text().length() < maxWordCount){
            return article.text();
        } else {
            return article.text().substring(0, maxWordCount) + replaceStr;
        }


    }

    public static String getAbstract(String content, Integer maxWordCount) {
        return getAbstract(content, maxWordCount, "");
    }

    public static void main(String[] args) throws IOException, WriterException {

        String line="<p>hi,all</p><p>这是第一篇博客文章，欢迎大家关注我</p><p><img src=\"http://freturn.oss-cn-hangzhou.aliyuncs.com/upload/img/user/013db9200f2cc647c82346a09b4f62f2.jpg\" data-filename=\"上传图片\" style=\"width: 740px;\"><br></p><p>中国中国中国,第一篇博客文章，欢迎大家,第一篇博客文章，欢迎大家</p>";

        System.out.println(getAbstract(line, 1000));
    }

}
