<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Bean.*"%>
     <jsp:useBean id="user_db" scope="session" class="Servlest.LoginUserBean" />
<%
Bean3 create=(Bean3)request.getAttribute("Bean");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/css2.css">
<div class="right"><jsp:getProperty property="name" name="user_db"/><td>さん</td>
<a href="/Example/LogoutServletDB"><font color="red">ログアウト</font></a></div>
<div class="center"><font size="10">ユーザ情報更新</font></div>
<title>更新画面</title>
</head>
<body>
<form action="/Example/Update" method="post">
<div>ログインID:<%=create.getLogin_id() %></div>
<input type="hidden" name="login_id" value="<%=create.getLogin_id() %>">
<div>パスワード:<input type="password" name="password"></div>
<div>パスワード確認:<input type="password" name="passwordConf"></div>
<div>ユーザ名:<input type="text" name="name" value="<%=create.getName() %>"></div>
<div>生年月日:<input type="date" name="birth_date" value="<%=create.getBirth_date() %>"></div>
<div><input type="hidden" name="id" value="<%=create.getId() %>"></div>
<input class="common_button" type="submit" name="submit"  value="更新"/>
<input class="common_button" type="submit" name="submit"  value="戻る"/>
</form>
</body>
</html>