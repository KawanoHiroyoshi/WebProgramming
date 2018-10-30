<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Bean.*"%>
    <jsp:useBean id="user_db" scope="session" class="Servlest.LoginUserBean" />
<%
Bean4 Bean=(Bean4)request.getAttribute("Bean");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/css2.css">
<title>削除画面</title>
<div class="right"><jsp:getProperty property="name" name="user_db"/><td>さん</td>
<a href="/Example/LogoutServletDB"><font color="red">ログアウト</font></a></div>
<div class="center"><font size="10">ユーザ削除確認</font></div>

</head>
<body>
<form action="/Example/Delete" method="post">
<div>ログインID:<%=Bean.getLogin_id() %></div>
<div><input type="hidden" name="id" value="<%=Bean.getId() %>"></div>
<div>を本当に削除してもよろしいでしょうか</div>
 <input class="common_button" type="submit" name="submit"  value="キャンセル"/>
 <input class="common_button" type="submit" name="submit"  value="OK"/>
</form>
</body>
</html>