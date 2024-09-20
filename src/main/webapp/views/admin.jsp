<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 9/5/24
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../views/css.css">
</head>
<body>
<div style="margin-top: 20px">
    <table>
        <tr>
            <th>name</th>
            <th>rangi</th>
            <th>turi</th>
            <th>stoykasi</th>
            <th>jamiGrami</th>
            <th>gramNarhi</th>
            <th>gender</th>
            <th>edit</th>
            <th>dalet</th>
        </tr>

        <c:forEach var="t" items="${mushks}">
            <tr>
                <td>${t.getName()}</td>
                <td>${t.getRangi()}</td>
                <td>${t.getTuri()}</td>
                <td>${t.getStoykasi()}</td>
                <td>${t.getJamiGrami()}</td>
                <td>${t.getGramNarhi()}</td>
                <td>${t.getGender()}</td>
                <td><a href="/edit?id=${t.getId()}">edit</a></td>
                <td><a href="/delete?id=${t.getId()}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<form style="margin-top: 40px" action="/admin" method="post">
    <div>
        <input type="text" name="name" placeholder="enter mushk name">
    </div>
    <div>
        <input type="text" name="rangi" placeholder="enter mushk rangi">
    </div>
    <div>
        <input type="text" name="turi" placeholder="enter mushk turi">
    </div>
    <div>
        <input type="text" name="stoykasi" placeholder="enter mushk stoykasi">
    </div>
    <div>
        <input type="number" name="jamiGrami" placeholder="enter jami grami">
    </div>
    <div>
        <input type="number" name="gramNarhi" placeholder="enter gram Narhi">
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
