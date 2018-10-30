<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="Bean.*,java.util.*"%>
<jsp:useBean id="user_db" scope="session" class="Servlest.LoginUserBean" />


<%
List<Bean> list=(List<Bean>)request.getAttribute("list");
%>

<%
List<Bean6> list2 =(List<Bean6>)request.getAttribute("list2");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/css2.css">


<div class="right"><jsp:getProperty property="name" name="user_db"/><td>さん</td>
<a href="/Example/LogoutServletDB"><font color="red">ログアウト</font></a></div>
<div class="center"><font size="10">ユーザ一覧</font></div>
<div class="right"><a href="/Example/Create">新規登録</a></div>
<title>ユーザ一覧</title>
</head>
<body>
<form action="/Example/Retrieval" method="post">
<div>ログインID:<input type="text" name="login_id"></div>
<div>ユーザ名:<input type="text" name="name"></div>
<div>生年月日:<input type="date" name="birth_date1">
～  <input type="date" name="birth_date2"></div>
<div class="right"><input class="common_button" type="submit" name="submit" value="検索"/></div>
</form>
<%
String login_id = (user_db.getName());
%>
<hr>
<table border="1" bgcolor= "#d3d3d3" width="75%" style="table-layout: fixed;">
           <tr>
            <th>ログインID</th>
            <th>ユーザ名</th>
            <th>生年月日</th>
            <th>　　　　</th>
          </tr>
</table>

<%if(login_id.equals("管理者")){ %>

<%if(list != null && list.size() > 0){ %>
<table border="1" width="75%" style="table-layout: fixed;">




<%for(Bean C:list){ %>
<tr>
<td><%=C.getLogin_id() %></td>
<td><%=C.getName() %></td>


<td><%=C.getbirth_date() %></td>

<td>
<a class="button1" href="/Example/Reference?id=<%=C.getId()%>"><font color="#ffffff">詳細</font></a>
<a class="button2"href="/Example/Update?id=<%=C.getId()%>"><font color="#ffffff">更新</font></a>
<a class="button3"href="/Example/Delete?id=<%=C.getId()%>" ><font color="#ffffff">削除</font></a></td>

</tr>

<%} %>
</table>

<%} %>


<%if(list2 != null && list2.size() > 0){ %>

<table border="1" width="75%" style="table-layout: fixed;">


<%for(Bean6 C:list2){ %>

<tr>



<td><%=C.getName() %></td>
<td><%=C.getLogin_id() %></td>


<td><%=C.getBirth_date() %></td>

<td>
<a class="button1"href="/Example/Reference?id=<%=C.getId()%>"><font color="#ffffff">詳細</font></a>
<a class="button2"href="/Example/Update?id=<%=C.getId()%>"><font color="#ffffff">更新</font></a>
<a class="button3"href="/Example/Delete?id=<%=C.getId()%>" ><font color="#ffffff">削除</font></a></td>

</tr>

<%} %>
</table>

<%} %>

<%}else{%>
<%	if(list != null && list.size() > 0){ %>

<table border="1" width="75%" style="table-layout: fixed;">


<%for(Bean C:list){ %>

<tr>



<td><%=C.getLogin_id() %></td>
<td><%=C.getName() %></td>


<td><%=C.getBirth_date() %></td>

<td><a class="button1"href="/Example/Reference?id=<%=C.getId()%>"><font color="#ffffff">詳細</font></a>

<%if(login_id.equals(C.getName())){ %>
<a class="button2"href="/Example/Update?id=<%=C.getId()%>"><font color="#ffffff">更新</font></a>
<%} %>
</td>
</tr>
<%} %>
</table>
<%} %>

<%if(list2 != null && list2.size() > 0){ %>

<table border="1" width="75%" style="table-layout: fixed;">


<%for(Bean6 C:list2){ %>

<tr>




<td><%=C.getName() %></td>
<td><%=C.getLogin_id() %></td>

<td><%=C.getBirth_date() %></td>

<td><a class="button1"href="/Example/Reference?id=<%=C.getId()%>"><font color="#ffffff">詳細</font></a>
<%if(login_id.equals(C.getName())){ %>
<a class="button2"href="/Example/Update?id=<%=C.getId()%>"><font color="#ffffff">更新</font></a>
<%} %>
</td>
</tr>

<%} %>
</table>

<%} %>
<%} %>


</body>
</html>