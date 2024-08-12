<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 수정</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 0;
        }

        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }

        form {
            max-width: 600px;
            margin: 0 auto;
            background-color: #f2f2f2;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input[type="text"],
        textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 16px;
        }

        textarea {
            resize: vertical;
            height: 200px;
        }

        .submit-button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            text-align: center;
            display: block;
            width: 100%;
        }

        .submit-button:hover {
            background-color: #45a049;
        }

        .back-button {
            background-color: #3093f5;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            text-align: center;
            display: block;
            width: 100%;
            margin-top: 10px;
            text-decoration: none;
        }

        .back-button:hover {
            background-color: #3561e5;
        }

    </style>
</head>
<body>
<h1>게시글 수정</h1>

<form action="/post/v1/update" method="post">
    <input type="hidden" name="id" value="${post.id}">

    <label for="title">제목</label>
    <input type="text" id="title" name="title" value="${post.title}" required>

    <label for="content">내용</label>
    <textarea id="content" name="content" required>${post.content}</textarea>

    <input type="submit" value="수정" class="submit-button">
    <a href="/post/v1/show" class="back-button">목록으로 돌아가기</a>
</form>
</body>
</html>
