<%@ page import="uz.entity.Harid" %>
<%@ page import="uz.entity.Mushkiambar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Harid Ro'yxati</title>
    <link rel="stylesheet" href="../views/css.css">
</head>
<body>
<div style="margin-top: 20px">
    <table>
        <tr>
            <th>Mushkiambar</th>
            <th>Olish Grami</th>
            <th>Jami Summa</th>
            <th>Dalet</th>
        </tr>
        <!-- Loop through each item in 'harids' and display its properties -->
        <c:forEach var="t" items="${harids}">
            <tr>
                <td>${t.getMushkiambar().getName()}</td>
                <td>${t.getOlishGrami()}</td>
                <td>${t.getJamiSumma()}</td>
                <td><a href="/delett?id=${t.getId()}">Dalet</a></td>
            </tr>
        </c:forEach>
            <%
        Mushkiambar mush = (Mushkiambar) request.getAttribute("mushk");
        if (mush != null) {
    %>
        <div> <p>Nomi : <%= mush.getName() %>
          : Gram narhi : <%= mush.getGramNarhi() %></p>
            <%
            } else {
            %>
        <p>User ma'lumotlari topilmadi.</p>
        <%
            }
        %></div>
        <form action="/harid" method="post">

            <div>
                <input id="olishGrami" type="number" name="olishGrami" placeholder="olishGrami kirting" required>
            </div>
        </form>
    </table>
    <!-- Form for adding a new 'harid' -->

        <div>
            <a href="/user" class="button">Orqaga</a>
        </div>
   <!-- Correctly closing the form tag here -->
</div>
</body>
</html>
