package com.freturn.tech.security.role;

import com.google.common.base.Preconditions;

/**
 *
 * 用户角色
 *
 * @author yangtao.lyt
 * @version $Id: UserRole, v 0.1 2016-01-28 13:31 yangtao.lyt Exp $
 */
public enum UserRole {


    OWNER("owner", "所有者", 0),

    ADMIN("admin", "管理员", 10),

    MEMBER("member", "成员", 20),

    VISITOR("visitor", "游客", 30)
    ;

    private String code;

    private String desc;

    private Integer order;


    UserRole(String code, String desc, Integer order){
        this.code = code;
        this.desc = desc;
        this.order = order;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public static UserRole getUserRoleByCode(String code){
        Preconditions.checkNotNull(code);

        for (UserRole userRole : UserRole.values()){
            if(code.equals(userRole.getCode())){
                return userRole;
            }
        }

        throw new IllegalArgumentException("用户角色code非法, code=" + code);
    }



}
