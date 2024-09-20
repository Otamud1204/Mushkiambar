<%@ page import="uz.entity.Mushkiambar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Haridlar Ro'yxati</title>
    <link rel="stylesheet" href="../views/css.css">
</head>
<body>
<div style="margin-top: 20px">
    <table>
        <tr>
            <th>Mushkiambar</th>
            <th>Olish Grami</th>
            <th>Jami Summa</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="t" items="${haridlaris}">
            <tr>
                <td>${t.mushkiambar.name}</td>
                <td>${t.olishGrami}</td>
                <td>${t.jamiSumma}</td>
                <td><a href="/delett?id=${t.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <div style="margin-top: 20px">
        <a href="/user" class="button">Orqaga</a>
        <a href="/chek" class="button">Harid qilish</a>
    </div>
</div>
</body>
</html>
