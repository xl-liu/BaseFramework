package com.RFramework.systemManagement.service.impl;

import com.RFramework.pojo.UserBean;
import com.RFramework.systemManagement.dao.UserDao;
import com.RFramework.systemManagement.service.UserService;
import com.RFramework.utils.EncryptUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService{

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserBean getUserById(long uid) {
        return userDao.getById(uid);
    }

    @Override
    public UserBean getUserByName(String userName) {
        return userDao.getByName(userName);
    }

    @Override
    public List<UserBean> query(Map paraMap) {
        return null;
    }

    @Override
    public List<UserBean> queryByRole(long roleId) {
        return null;
    }

    @Override
    public void insert(UserBean user) {

    }

    @Override
    public void update(UserBean user) {

    }

    @Override
    public void delete(long uid) {

    }

    @Override
    public boolean authenticate(UserBean userBean) {
        if(null != userBean
            && StringUtils.isNotEmpty(userBean.getName())
            && StringUtils.isNotEmpty(userBean.getPassword())) {

            UserBean user = this.getUserByName(userBean.getName());
            if(null != user && user.getPassword().equals(EncryptUtils.md5(userBean.getPassword()))) {
                try {
                    BeanUtils.copyProperties(userBean, user);
                } catch (IllegalAccessException|InvocationTargetException e) {
                    logger.error("Exception happened while fill UserBean after verification", e);
                    return false;
                }
                return true;
            }
        }
        return false;
    }

}
