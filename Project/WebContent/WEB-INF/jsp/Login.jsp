<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="user_db" scope="session" class="Servlest.LoginUserBean"/>

<%-- ログイン機能 --%>
<!DOCTYPE html>
<html>
 <head>
 
    <meta charset="utf-8">
        <title>ログイン画面</title>
      <link rel="stylesheet" href="/css/css2.css">
    </head>
    <body>
        <div class="login_pane">
           <div style="text-align:center;"> <font size="10">ログイン画面</font></div>
            <form action="./LoginServletDB" method="post">
             <br>
             <br>
                 <div style="text-align:center;"> <label>ログインID</label><input type="text" name="id"/> </div>
                  <br>
             		<br>
                 <div style="text-align:center;"> <label>パスワード</label><input type="password" name="pass"/></div>
                   <br>
             		<br>
                 <div style="text-align:center;"> <input class="common_button" type="submit" name="submit"  value="ログイン"/></div>
            </form>
        </div>
    </body>
</html>
