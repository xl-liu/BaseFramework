package com.RFramework.systemManagement.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;

import com.RFramework.common.app.AppConstants;
import com.RFramework.pojo.PageItemBean;
import com.RFramework.systemManagement.service.PageItemService;
import com.opensymphony.xwork2.ActionSupport;

public class PageItemSubmitAction extends ActionSupport{

  /**
   * 
   */
  private static final long serialVersionUID = 6558391877434992570L;

  private PageItemService pageItemService;
  
  public String save(){
    PageItemBean item = getBean();
    pageItemService.save(item);
    if(uid == null) {
      this.uid = item.getUid();
    }
    return SUCCESS;
  }
  
  private PageItemBean getBean() {
    PageItemBean item;
    if(uid != null) {
      item = pageItemService.getPageItemById(uid);
      BeanUtils.copyProperties(this, item);
    } else {
      item = new PageItemBean();
      item.setName(name);
      item.setUrl(url);
      item.setDescription(description);
    }
    return item;
  }
  
  private Long uid;
  private String name;
  private String description;
  //private String parentId;
  private String url;
  private String result = "success";
  private String resultType = "json";
  public Long getUid() {
    return uid;
  }
  public void setUid(Long uid) {
    this.uid = uid;
  }
  public String getName() {
    return name;
  }
  public String getDescription() {
    return description;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public PageItemService getPageItemService() {
    return pageItemService;
  }
  public void setPageItemService(PageItemService pageItemService) {
    this.pageItemService = pageItemService;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getResultType() {
    return resultType;
  }

  public void setResultType(String resultType) {
    this.resultType = resultType;
  }
}
