<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TODO 목록</title>
</head>
<body>
    <h1>TODO 목록 V2</h1>
    <ul>
        <li><b>할 일</b></li>
        <c:forEach var="todo" items="${todoList}">
            <li>${todo.todo}</li>
        </c:forEach>
    </ul>
</body>
</html>
