package com.RFramework.pojo;

import org.mongodb.morphia.annotations.*;

/**
 * Created by qiaolei on 14-8-18.
 */
@Entity("role_permission")
public class RolePermissionBean extends Bean {

    @Indexed
    private String permissionId;

    @Indexed
    private String roleId;

    @Transient
    private PermissionBean permission;


    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
//
//    public PermissionBean getPermission() {
//        if (this.permission == null) {
//            this.permission = this.getParentBean(PermissionBean.class, this.getPermissionId());
//        }
//        return permission;
//    }
}
