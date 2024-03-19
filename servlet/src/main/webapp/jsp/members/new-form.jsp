<%--
  Created by IntelliJ IDEA.
  User: hyrki
  Date: 3/13/24
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%--jsp 파일입니다. 라는 뜻--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/jsp/members/save.jsp" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>
