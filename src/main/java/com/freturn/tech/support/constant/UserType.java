package com.freturn.tech.support.constant;

/**
 *
 * 用户类型
 *
 * @author yangtao.lyt
 * @version $Id: UserType, v 0.1 2016-05-07 12:13 yangtao.lyt Exp $
 */
public enum UserType {

    PERSON(1, "个人"),

    ORGANIZATION(2, "组织")

    ;

    private Integer code;

    private String label;


    UserType(Integer code, String label){
        this.code = code;
        this.label = label;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return label;
    }

    public static UserType getEnumByCode(Integer code){

        for(UserType type : values()){
            if(code.equals(type.code)){
                return type;
            }
        }

        throw new IllegalArgumentException("code值无效: code=" + code);
    }



}
