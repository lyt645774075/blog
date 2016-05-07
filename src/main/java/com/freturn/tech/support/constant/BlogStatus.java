package com.freturn.tech.support.constant;

/**
 * @author yangtao.lyt
 * @version $Id: BlogStatus, v 0.1 2016-05-06 14:20 yangtao.lyt Exp $
 */
public enum BlogStatus {


    FINISH("FINISH", "已完成")
    ;


    private String code;

    private String label;

    BlogStatus(String code, String label){

        this.code = code;
        this.label = label;
    }


    public static BlogStatus getStatusByCode(String code){

        for(BlogStatus type : values()){
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
