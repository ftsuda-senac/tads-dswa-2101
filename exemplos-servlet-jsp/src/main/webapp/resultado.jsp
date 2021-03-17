<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body onload="alert('Mensagem javascript')">
        <h1>Texto digitado: <%= request.getParameter("texto") %></h1>
        <a href="formulario.jsp">Voltar</a>
    </body>
</html>
