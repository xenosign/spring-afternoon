<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>TODO 추가</title>
</head>
<body>
<%@ include file="../header.jsp"%>
<h1>TODO 추가 V3</h1>
<form method="post" action="/todo/v3/form/save">
    <label for="todo">할 일 :</label>
    <input type="text" id="todo" name="todo" required>
    <br>
    <button type="submit">할 일 추가</button>
</form>
</body>
</html>