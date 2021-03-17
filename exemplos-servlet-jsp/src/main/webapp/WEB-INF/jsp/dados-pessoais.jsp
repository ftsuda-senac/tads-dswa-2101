<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${dp.nome}</h1>
        <h2>Experiências profissionais</h2>
        <ul>
            <c:forEach items="${dp.experienciasProfissionais}" var="ep">
                <li>
                    <p>Cargo: ${ep.cargo}</p>
                    <p>Empresa: ${ep.empresa}</p>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
