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
            <%
        Mushkiambar mush = (Mushkiambar) request.getAttribute("mushk");
        if (mush != null) {
    %>
        <div> <p>Nomi : <%= mush.getName() %>
          :   : Gram narhi : <%= mush.getGramNarhi() %></p>
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
