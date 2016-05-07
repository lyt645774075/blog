package com.freturn.tech.support.constant;

/**
 *
 * 设备枚举
 *
 * @author yangtao.lyt
 * @version $Id: Device, v 0.1 2016-05-06 14:31 yangtao.lyt Exp $
 */
public enum Device {

    PC(1, "PC端"),

    APP(2, "移动端")

    ;


    private Integer code;

    private String label;

    Device(Integer code, String label){

        this.code = code;
        this.label = label;
    }


    public static Device getTypeByCode(Integer code){

        for(Device type : values()){
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
