package com.freturn.tech.support.constant;

/**
 *
 * 博客类型
 *
 * @author yangtao.lyt
 * @version $Id: BlogType, v 0.1 2016-05-02 12:44 yangtao.lyt Exp $
 */
public enum BlogType {


    STANDARD("STANDARD", "通用"),

    GALLERY("GALLERY", "图集"),

    LINK("LINK", "外部链接"),

    QUOTE("QUOTE", "引用")

    ;

    private String code;

    private String label;

    BlogType(String code, String label){

        this.code = code;
        this.label = label;
    }


    public BlogType getTypeByCode(String code){

        for(BlogType type : values()){
            if(code.equals(type.code)){
                return type;
            }
        }

        throw new IllegalArgumentException("code值无效: code=" + code);
    }


    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}
