<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 9/5/24
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../views/css.css">
</head>
<body>
<div>
    <form action="/signup" method="post">
        <div>
            <label for="name"></label>
            <input id="name" type="text" name="name" placeholder="enter name">
        </div>
        <div>
            <label for="age"></label>
            <input id="age" type="number" name="age" placeholder="enter age">
        </div>
        <div>
            <label for="username"></label>
            <input id="username" type="text" name="username" placeholder="enter username">
        </div>
        <div>
            <label for="password"></label>
            <input id="password" type="text" name="password" placeholder="enter password">
        </div>

        <div>
            <button type="submit">Submit</button>
            go to<a href="/signin"> sign in ga o'tish</a>

        </div>
    </form>
</div>
</body>
</html>
