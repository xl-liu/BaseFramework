package com.RFramework.common.dao;

import com.RFramework.pojo.Bean;
import org.springframework.jdbc.core.JdbcTemplate;


public class BaseDao<T extends Bean> {

    protected JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public T getById(String uid) {

        return null;
    }

    public void save() {

    }

    public void update() {

    }

    public void insert() {

    }

    public void delete() {

    }

    public void query() {

    }

}
