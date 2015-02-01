<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="../common/common.jsp" %>
<r:base/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>login.jsp</title>

</head>
<body>
  <form action="/user/login" method="post">
    User Name
    <input type="text" name="name"/>
    <br>
    Password
    <input type="password" name="password"/>
    <br>
    <input type="submit" value="OK"/>
  </form>
</body>
</html>