<%@ page import="uz.entity.Cheka" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="uz.entity.Harid" %>
<%@ page import="uz.controller.ChekSkidka" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Chek</title>
    <link rel="stylesheet" href="../views/css.css">
</head>
<body>
<div style="margin-top: 20px">
    <%
        Double jammi = 0.0;
        Double skidka = ChekSkidka.skidkasi();
        Cheka cheka = (Cheka) request.getAttribute("chek");
        ArrayList<Harid> arr = (ArrayList<Harid>) cheka.getHarids();

        for (Harid harid : arr) {
            jammi += harid.getJamiSumma();
        }
        skidka = jammi - (jammi * skidka / 100);
    %>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Hajmi</th>
            <th>Sumasi</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="t" items="${cheka.harids}">
            <tr>
                <td>${t.mushkabar.name}</td>
                <td>${t.olishGrami}</td>
                <td>${t.jamiSumma}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <p>Jammi summasi: <%= jammi %></p>
        <p>Skidka: <%= skidka %></p>
        <p>To'lov Kartasi: 860011290266</p>
    </div>
    <form action="/chek" method="post">
        <div>
            <a href="/user" class="button">Orqaga</a>
        </div>
    </form>
</div>
</body>
</html>
