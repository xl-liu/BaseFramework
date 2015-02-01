package com.RFramework.pojo;

import com.RFramework.common.annotations.Id;
import com.RFramework.common.annotations.Indexed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Date;

public class Bean implements Cloneable, Serializable {
    /**
     * logger
     */
    protected final static Logger LOG = LoggerFactory.getLogger(Bean.class);
    @Id
    Long uid;
    @Indexed
    String name;
    @Indexed
    Date createTime = null;
    @Indexed
    Date modifyTime = null;

    Boolean isDeleted = false;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the modifytime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime the modifytime to set
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * Clone (create a deep copy of) this instance.
     *
     * @return A clone of this instance.
     */
    public Object clone() {
        // It's necessary to provide a default clone() method in this base class
        // in
        // order to allow public access to it, because Object.clone() is
        // protected.
        try {
            return super.clone();
        } catch (CloneNotSupportedException cnse) {
            LOG.error("Exception happens while cloning Beans:{}", cnse);
            throw new RuntimeException("Error cloning in Bean", cnse);
        }
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }


}
