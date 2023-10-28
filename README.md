# CRUD de Usuarios con Servlet y JSP
Este proyecto es un CRUD de usuario desarrollado en java utilizando Servlets y JSP. Permite administrar información de usuarios (nombre, apellido, dni, fecha de nacimiento y profesión).
## Caracteristicas
1. **Listar Usuarios:** En la url http://localhost:8080/jsp_servlet/showDataUser, se muestra una lista de usuarios. Cada fila incluye un boton para "Borrar" y "Modificar" usuarios existentes.
2. **Crear Usuario:** Se permite la creacion de usuarios a travez del boton "Crear". Los usuarios se identifican por su número de DNI, el cual debe ser único.
3. **Editar Usuario:** Es posible modificar la informacíon de una usuario existente.
4. **Eliminar Usuario:** Los usuarios pueden ser eliminados de la lista.
5. **Almacenamiento de datos:** los datos se guardan en una List temporalmente, existen datos precargados de muestra.
