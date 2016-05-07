package com.freturn.tech.support.constant;

/**
 *
 * 可查看人群范围
 *
 * @author yangtao.lyt
 * @version $Id: SeeScope, v 0.1 2016-05-06 14:15 yangtao.lyt Exp $
 */
public enum SeeScope {


    PRIVATE(1 , "私密的,只能自己看见"),

    FRIEND(10, "好友可见"),

    PUBLIC(20, "公开的,所有人可见")


    ;

    private Integer code;

    private String desc;


    SeeScope(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static SeeScope getEnumByCode(Integer code){

        for(SeeScope type : values()){
            if(code.equals(type.code)){
                return type;
            }
        }

        throw new IllegalArgumentException("code值无效: code=" + code);
    }

}
