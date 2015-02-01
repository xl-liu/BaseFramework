package com.RFramework.pojo;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Transient;

/**
 * Created by qiaolei on 14-8-18.
 */
@Entity("user_role")
public class UserRoleBean extends Bean {

    @Indexed
    private String userId;

    @Indexed
    private String roleId;

    @Transient
    private com.RFramework.pojo.RoleBean role;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}
