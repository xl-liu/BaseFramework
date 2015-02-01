package com.RFramework.pojo;

import com.RFramework.pojo.Bean;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Indexed;

@Entity("role")
public class RoleBean extends Bean {
    @Indexed
    private String code;
    private String description;
    private short systemReserved;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getSystemReserved() {
        return systemReserved;
    }

    public void setSystemReserved(short systemReserved) {
        this.systemReserved = systemReserved;
    }
}
