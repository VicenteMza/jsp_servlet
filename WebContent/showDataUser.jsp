<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@page import="model.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Usuarios</title>
</head>
<body>
<h1>Lista de Usuarios</h1>
    <table style="border: 1px solid black; border-collapse: collapse; margin: 20px;">
        <tr>
            <th style="border: 1px solid black; padding: 10px;">Nombre</th>
            <th style="border: 1px solid black; padding: 10px;">Dni</th>
            <th style="border: 1px solid black; padding: 10px;">Fecha de Nacimiento</th>
            <th style="border: 1px solid black; padding: 10px;">Profesión</th>
            <th style="border: 1px solid black; padding: 10px;">Acciones</th>
        </tr>
        <c:forEach items="${infoData}" var="usuario">
            <tr>
                <td style="border: 1px solid black; padding: 10px;">${usuario.nombre} ${usuario.apellido}</td>
                <td style="border: 1px solid black; padding: 10px;">${usuario.dni}</td>
                <td style="border: 1px solid black; padding: 10px;">${usuario.fechaNacimiento}</td>
                <td style="border: 1px solid black; padding: 10px;">${usuario.profesion.description}</td>
                <td style="border: 1px solid black; padding: 10px;">
                    <form action="eliminarUsuarioServlet" method="post">
                        <input type="hidden" name="dni" value="${usuario.dni}">
                        <input type="submit" value="Borrar">
                    </form>
                    <form action="ModificarUsuarioServlet" method="get">
                        <input type="hidden" name="dni" value="${usuario.dni}">
                        <input type="submit" value="Modificar">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form action="CrearUsuarioServlet" method="get">
        <input type="submit" value="Crear Usuario">
    </form>
</body>
</html>
