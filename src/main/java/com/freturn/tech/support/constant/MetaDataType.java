package com.freturn.tech.support.constant;

/**
 * @author yangtao.lyt
 * @version $Id: MetaDataType, v 0.1 2016-04-27 15:18 yangtao.lyt Exp $
 */
public enum MetaDataType {


    CATEGORY("CATEGORY", "文章分类"),

    LABEL("LABEL", "标签"),

    ;

    private String code;

    private String label;

    MetaDataType(String code, String label){

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
