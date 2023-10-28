package servlets;

import model.ListUsuarios;
import model.Profesion;
import model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ModificarUsuarioServlet")
public class ModificarUsuarioServlet extends HttpServlet {
    ListUsuarios listUsuarios = new ListUsuarios();
    List<String> errores = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dniStr = request.getParameter("dni");

        if (dniStr == null || dniStr.isEmpty()){
            response.sendRedirect("showDataUser");
        }

        try {
            int dni = Integer.parseInt(dniStr);
            Usuario usuario = listUsuarios.findByDni(dni);

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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        errores.clear();// Limpiar la lista de errores

        String dniStr = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String fechaNacimientoStr = request.getParameter("fechaNacimiento");
        String profesionValue = request.getParameter("profesion");

        validarNombre(nombre);
        validarApellido(apellido);
        validarDNI(dniStr);

        try {
            int dni= Integer.parseInt(dniStr);
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
            validarEdad(fechaNacimiento);

            Profesion profesion = Profesion.valueOf(profesionValue);

            Usuario usuario = listUsuarios.findByDni(dni);

            if (!errores.isEmpty()) {
                request.setAttribute("errores", errores);
                request.setAttribute("usuario", usuario);

                RequestDispatcher dispatcher = request.getRequestDispatcher("editarUsuario.jsp");
                dispatcher.forward(request, response);
            } else {
                if (usuario != null) {
                    usuario.setApellido(apellido);
                    usuario.setNombre(nombre);
                    usuario.setProfesion(profesion);
                    usuario.setFechaNacimiento(fechaNacimiento);
                }
                response.sendRedirect("showDataUser");
            }
        } catch (NumberFormatException |DateTimeParseException e){
            response.sendRedirect("showDataUser");
        }
    }
    private void validarEdad(LocalDate fechaNacimiento) {
        Period edadDiferencia = Period.between(fechaNacimiento, LocalDate.now());
        if (edadDiferencia.getYears() > 130) {
            errores.add("La edad ingresada supera el límite de 130 años, por favor, verifique la fecha de nacimiento.");
        }
    }

    private void validarDNI(String dniStr) {
        if (!dniStr.matches("[0-9]{8}")) {
            errores.add("El DNI debe contener exactamente 8 dígitos numéricos.");
        }
    }

    private void validarNombre(String nombre) {
        boolean nombreValido = nombre.matches("[A-Za-z\\s]+");
        if (!nombreValido)
            errores.add("El nombre solo puede contener letras.");
    }
    private void validarApellido(String apellido) {
        if (!apellido.matches("[A-Za-z\\s]+")) {
            errores.add("El apellido solo puede contener letras.");
        }
    }
}
