<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Mushklar Ro'yxati</title>
    <link rel="stylesheet" href="../views/css.css">
</head>
<body>
<form style="margin-top: 40px" action="/mushk" method="post">
    <div style="margin-top: 20px">
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Rangi</th>
                <th>Turi</th>
                <th>Stoykasi</th>
                <th>Jami Grami</th>
                <th>Gram Narhi</th>
                <th>Gender</th>
                <th>Harid</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="t" items="${mushks}">
                <tr>
                    <td>${t.getName()}</td>
                    <td>${t.getRangi()}</td>
                    <td>${t.getTuri()}</td>
                    <td>${t.getStoykasi()}</td>
                    <td>${t.getJamiGrami()}</td>
                    <td>${t.getGramNarhi()}</td>
                    <td>${t.getGender()}</td>
                    <td><a href="/harid?id=${t.getId()}">Harid</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="/" class="button">Bosh menu</a>
    </div>
</form>
</body>
</html>
