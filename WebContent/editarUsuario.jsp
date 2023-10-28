<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List" %>
<%@ page import="model.Usuario" %>
<%@ page import="model.Profesion" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>Editar Usuario</title>
</head>

<body>
    <h1>Editar Usuario</h1>
    <form action="ModificarUsuarioServlet" method="post">
        <c:if test="${usuario != null}">
            <input type="hidden" name="dni" value="${usuario.dni}">
            Nombre: <input type="text" name="nombre" required pattern="[A-Za-z\s]+" title="Ingresa solo letras" value="${usuario.nombre}"><br>
            Apellido: <input type="text" name="apellido" required pattern="[A-Za-z\s]+" title="Ingresa solo letras" value="${usuario.apellido}"><br>
            DNI: <input type="text" name="dni" required pattern="[0-9]{8}" title="Ingresa 8 dígitos numéricos" value="${usuario.dni}" readonly><br>
            Fecha de Nacimiento: <input type="date" name="fechaNacimiento" required value="${usuario.fechaNacimiento}"><br>
            Profesión: <select name="profesion">
                <c:forEach var="profesion" items="${Profesion.values()}">
                    <option value="${profesion.name()}" <c:if test="${profesion.name() eq usuario.profesion.name()}">selected</c:if>>
                        ${profesion.getDescription()}
                    </option>
                </c:forEach>
            </select><br>
            <input type="submit" value="Guardar">
        </c:if>
        <a href="showDataUser"><button type="button">Volver</button></a>
    </form>

    <!-- Verificar si hay un mensaje de error-->
                        <% List<String> errores = (List<String>) request.getAttribute("errores");
                                if (errores != null && !errores.isEmpty()) {
                                %>
                                <script>
                                    var mensajeError = "Errores:\n";
                                    <c:forEach var="error" items="${errores}">
                                        mensajeError += "<c:out value='${error}' />\n";
                                    </c:forEach>
                                    alert(mensajeError);
                                </script>
                                <% } %>
</body>

</html>
