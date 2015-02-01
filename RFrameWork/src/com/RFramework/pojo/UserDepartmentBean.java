package com.RFramework.pojo;

import org.mongodb.morphia.annotations.Entity;

/**
 * Created by qiaolei on 14-8-21.
 */
@Entity("user_department")
public class UserDepartmentBean extends Bean {

    private String userId;

    private String departmentId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
