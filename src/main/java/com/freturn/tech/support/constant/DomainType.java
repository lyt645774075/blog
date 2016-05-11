package com.freturn.tech.support.constant;

/**
 *
 * 领域对象类型
 *
 * @author yangtao.lyt
 * @version $Id: DomainType, v 0.1 2016-05-09 10:31 yangtao.lyt Exp $
 */
public enum DomainType {

    BLOG(1, "博客"),

    USER(2, "用户")

    ;

    private Integer code;

    private String label;

    DomainType(Integer code, String label){

        this.code = code;
        this.label = label;
    }


    public static DomainType getTypeByCode(Integer code){

        for(DomainType type : values()){
            if(code.equals(type.code)){
                return type;
            }
        }

        throw new IllegalArgumentException("code值无效: code=" + code);
    }

    public Integer getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }





}
