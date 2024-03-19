<%--
  Created by IntelliJ IDEA.
  User: hyrki
  Date: 3/14/24
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%-- WEB-INF아래에 있는 파일들은 직접 경로를 쳐서 못들어옴 WAS에서 이미 설정되어있는부분이다 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<!-- 상대경로 사용, [현재 URL이 속한 계층 경로 + /save] -->
<form action="save" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>