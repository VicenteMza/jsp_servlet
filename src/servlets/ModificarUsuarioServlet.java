package servlets;

import model.ListUsuarios;
import model.Profesion;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@WebServlet("/ModificarUsuarioServlet")
public class ModificarUsuarioServlet extends HttpServlet {
    ListUsuarios listUsuarios = new ListUsuarios();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dniStr = request.getParameter("dni");

        if (dniStr == null || dniStr.isEmpty()){
            response.sendRedirect("showDataUser");
        }
        System.out.println(dniStr);
        try {
            int dni = Integer.parseInt(dniStr);
            Usuario usuario = listUsuarios.findByDni(dni);
            System.out.println(usuario);
            if (usuario == null){
                response.sendRedirect("showDataUser");
            } else {
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("editarUsuario.jsp").forward(request,response);
            }
        }catch (NumberFormatException e){
            response.sendRedirect("showDataUser");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dniStr = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String fechaNacimientoStr = request.getParameter("fechaNacimiento");
        String profesionValue = request.getParameter("profesion");

        try {
            int dni= Integer.parseInt(dniStr);
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
            Profesion profesion = Profesion.valueOf(profesionValue);

            Usuario usuario = listUsuarios.findByDni(dni);

            if (usuario != null){
                usuario.setApellido(apellido);
                usuario.setNombre(nombre);
                usuario.setProfesion(profesion);
                usuario.setFechaNacimiento(fechaNacimiento);
            }

            response.sendRedirect("showDataUser");
        } catch (NumberFormatException |DateTimeParseException e){
            response.sendRedirect("showDataUser");
        }
    }
}
