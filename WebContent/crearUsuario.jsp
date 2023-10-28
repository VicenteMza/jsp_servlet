<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@page import="java.util.List" %>
        <%@page import="model.Usuario" %>
            <%@page import="model.Profesion" %>
                <html>

                <head>
                    <meta charset="UTF-8">
                    <title>Cargar Usuario</title>
                </head>

                <body>
                    <h1> Cargar Usuario Nuevo </h1>
                    <form action="CrearUsuarioServlet" method="post">
                        Nombre: <input type="text" name="nombre" required pattern="[A-Za-z\s]+"
                            title="Ingresa solo letras"><br>
                        Apellido: <input type="text" name="apellido" required pattern="[A-Za-z\s]+"
                            title="Ingresa solo letras"><br>
                        Dni: <input type="text" name="dni" required pattern="[0-9]{8}"
                            title="Ingresa 8 dígitos numéricos"><br>

                        Fecha de Nacimiento: <input type="date" name="fechaNacimiento" required><br>
                        Profesión: <select name="profesion">
                            <% for (Profesion profesion : Profesion.values()) { %>
                                <option value="<%= profesion.name() %>">
                                    <%= profesion.getDescription() %>
                                </option>
                                <% } %>
                        </select><br>
                        <input type="submit" value="Guardar">
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