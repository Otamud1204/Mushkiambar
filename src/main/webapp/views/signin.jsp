
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Title </title>
  <link rel="stylesheet" href="../views/css.css">
</head>
<body>
<div>
  <form action = "/signin" method="post">
    <div>
      <label for= "username"> enter username </label>
      <input id= "username" type="text" name= "username" placeholder="enter username">
    </div>
    <div>
      <label for= "password" > enter password </label>
      <input id= "password" type= "text" name = "password" placeholder= "enter password" >
    </div>
    <div>
      <button type= "submit" >Submit</button>
      <a href="/signup"> sign up ga o'tish</a>
    </div>
  </form>
</div>
</body>
</html>
