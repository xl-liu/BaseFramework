package com.RFramework.systemManagement.dao;

import com.RFramework.pojo.UserBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangronghua on 15/1/19.
 */
public interface UserDao {

    public List<UserBean> getAll();

    public UserBean getById(@Param(value="userId")long userId);

    public UserBean getByName(@Param(value="userName") String userName);
}
