<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 9/5/24
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="../views/css.css">

</head>
<body>

<form style="margin-top: 40px" action="/edit" method="post">

  <input type="hidden" value="${mushk.getId()}" name="id">
  <div>
    <input type="text" value="${mushk.getName()}" name="name" placeholder="enter mushk name">
  </div>
  <div>
    <input type="text" value="${mushk.getRangi()}" name="rangi" placeholder="enter mushk rangi">
  </div>
 <div>
    <input type="text" value="${mushk.getTuri()}" name="turi" placeholder="enter mushk turi">
  </div>
 <div>
    <input type="text" value="${mushk.getStoykasi()}" name="stoykasi" placeholder="enter mushk stoykasi">
  </div>
  <div>
    <input type="number" value="${mushk.getJamiGrami()}" name="jamiGrami" placeholder="enter mushk jamiGrami">
  </div>
  <div>
    <input type="number" value="${mushk.getGramNarhi()}" name="gramNarhi" placeholder="enter mushk gramNarhi">
  </div>
    <div>
        <label for="gender"> Gender </label>
        <select id="gender" name = "gender" required>
            <option value="">  Gender </option>
            <option value= "Ayol" >  Ayol </option>
            <option value= "Erkak" > Erkak </option>
            <option value= "Yunit" > Yunit </option>
        </select>
    </div>
  <div>
    <button type="submit">submit</button>
  </div>

</form>
</body>
</html>
