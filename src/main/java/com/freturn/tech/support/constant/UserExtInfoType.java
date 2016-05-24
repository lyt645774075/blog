package com.freturn.tech.support.constant;

/**
 * @author yangtao.lyt
 * @version $Id: UserExtInfoType, v 0.1 2016-04-27 15:18 yangtao.lyt Exp $
 */
public enum UserExtInfoType {


    CATEGORY("CATEGORY", "文章分类"),

    LINK("LINK", "链接"),

    CONTACT("CONTACT", "联系方式")

    ;

    private String code;

    private String label;

    UserExtInfoType(String code, String label){

        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}
