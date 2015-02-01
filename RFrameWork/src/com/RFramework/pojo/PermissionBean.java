package com.RFramework.pojo;

import com.RFramework.common.pojo.NameValueEnum;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Transient;

/**
 * Created by qiaolei on 14-8-18.
 */
@Entity("permission")
public class PermissionBean extends Bean {
    @Indexed
    private String code;
    private short type;
    private String path;
    private Integer sequence;
    private String description;
    @Indexed
    private String parentId;

    @Transient
    private String parentName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public static enum PermissionType implements NameValueEnum {
        MENU(0, "菜单"),
        PAGE(1, "页面"),
        ACTION(2, "操作");

        private Integer value;
        private String name;

        PermissionType(Integer value, String name) {
            this.value = value;
            this.name = name;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


    }
}
