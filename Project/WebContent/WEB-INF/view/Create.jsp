<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
    <jsp:useBean id="user_db" scope="session" class="Servlest.LoginUserBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/css2.css">
<div class="right"><jsp:getProperty property="name" name="user_db"/><td>さん</td>
<a href="/Example/LogoutServletDB"><font color="red">ログアウト</font></a></div>
<div class="center"><font size="10">ユーザ新規登録</font></div>

<title>新規登録</title>
</head>
<body>

<form action="/Example//Create" method="post">
<div>ログインID:<input type="text" name="login_id"></div>
<div>パスワード<input type="password" name="password"></div>
<div>パスワード確認<input type="password" name="passwordConf"></div>
<div>ユーザ名:<input type="text" name="name"></div>
<div>生年月日:<input type="date" name="birth_date"></div>

 <input class="common_button" type="submit" name="submit"  value="登録"/>
 <input class="common_button" type="submit" name="submit"  value="戻る"/>
</form>

</body>
</html>