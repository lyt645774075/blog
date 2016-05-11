package com.freturn.tech.support.constant;

/**
 *
 * 评论类型
 *
 * @author yangtao.lyt
 * @version $Id: CommentType, v 0.1 2016-05-09 10:33 yangtao.lyt Exp $
 */
public enum  CommentType {


    COMMON(1, "普通评论"),

    PROFESSIONAL(2, "专业评论")

    ;

    private Integer code;

    private String label;

    CommentType(Integer code, String label){

        this.code = code;
        this.label = label;
    }


    public static CommentType getTypeByCode(Integer code){

        for(CommentType type : values()){
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
