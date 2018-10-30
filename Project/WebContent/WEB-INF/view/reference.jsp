<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Bean.*"%>
    <jsp:useBean id="user_db" scope="session" class="Servlest.LoginUserBean" />
<%
Bean4 Bean =(Bean4)request.getAttribute("Bean");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/css2.css">
<div class="right"><jsp:getProperty property="name" name="user_db"/><td>さん</td>
 <a href="/Example/LogoutServletDB"><font color="red">ログアウト</font></a></div>
<div class="center"><font size="10">ユーザ更新画面</font></div>
<title>更新画面</title>
</head>
<body>
<form action="/Example/Reference" method="post">
<div>ログインID:<%=Bean.getLogin_id() %></div>
<div>ユーザ名:<%=Bean.getName() %></div>
<div>生年月日:<%=Bean.getBirth_date() %></div>
<div>登録日時:<%=Bean.getCreate_date() %></div>
<div>更新日時:<%=Bean.getUpdate_date() %></div>
<div><input type="hidden" name="id" value="<%=Bean.getId() %>"></div>
<input class="common_button" type="submit" name="submit" value="戻る"/>
</form>
</body>
</html>