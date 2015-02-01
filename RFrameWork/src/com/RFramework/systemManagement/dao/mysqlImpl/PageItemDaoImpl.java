package com.RFramework.systemManagement.dao.mysqlImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.RFramework.common.dao.BaseDao;
import com.RFramework.pojo.PageItemBean;
import com.RFramework.systemManagement.dao.PageItemDao;

public class PageItemDaoImpl extends BaseDao implements PageItemDao {

  @Override
  public void insert(PageItemBean item) {
    StringBuilder sql = new StringBuilder("insert into sys_pageitem (uid, name, url, description) values (");
    sql.append(item.getUid()).append(",'")
        .append(item.getName()).append("','")
        .append(item.getUrl()).append("','")
        .append(item.getDescription()).append("')");
    super.jdbcTemplate.execute(sql.toString());
  }

  @Override
  public void update(PageItemBean item) {
    PageItemBean origBean = this.getPageItemById(item.getUid());
    StringBuilder sql = new StringBuilder("update sys_pageitem set ");
    sql.append(" name = '").append(item.getName()).append("' ");
    
    if(!origBean.getDescription().equals(item.getDescription())) {
        sql.append(", description = '").append(item.getDescription()).append("' ");
    }
    if(!origBean.getUrl().equals(item.getUrl())) {
        sql.append(", url = '").append(item.getUrl()).append("' ");
    }
    sql.append(" where uid = ").append(item.getUid());
    super.jdbcTemplate.execute(sql.toString());
  }

  @Override
  public void delete(long uid) {
    StringBuilder sql = new StringBuilder("delete from sys_pageitem where uid = ").append(uid);
    super.jdbcTemplate.execute(sql.toString());
  }

  public List<PageItemBean> queryForList(Map params) {
    List<PageItemBean> result = null ;
    if(null != params) {
      StringBuilder sql = new StringBuilder("select * from sys_pageitem where 1=1 order by sequence asc");

      result = super.jdbcTemplate.query(sql.toString(), new PageItemRowMapper());
    }
    if(null == result) result = new ArrayList<PageItemBean>();
    return result;
  }

  @Override
  public PageItemBean getPageItemById(long uid) {
    String sql = "select * from sys_pageitem where uid=" + uid;
    PageItemBean result = (PageItemBean)super.jdbcTemplate.queryForObject(sql, new PageItemRowMapper());
    return result;
  }
  
  class PageItemRowMapper implements RowMapper{

    @Override
    public PageItemBean mapRow(ResultSet rs, int arg1) throws SQLException {
      PageItemBean item = new PageItemBean();
      item.setUid(rs.getLong("uid"));
      item.setName(rs.getString("name"));
      item.setUrl(rs.getString("url"));
      item.setType(rs.getInt("type"));
      item.setParentId(rs.getLong("parentId"));
      item.setSequence(rs.getInt("sequence"));
      item.setDescription(rs.getString("description"));
      return item;
    }
  }
}
