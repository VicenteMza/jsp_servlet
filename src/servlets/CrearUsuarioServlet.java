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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CrearUsuarioServlet")
public class CrearUsuarioServlet extends HttpServlet {
    ListUsuarios listUsuarios = new ListUsuarios();
    List<String> errores = new ArrayList<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si se realiza una solicitud GET a este servlet, simplemente redirige a la página de inicio
        response.sendRedirect("crearUsuario.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        errores.clear();// Limpiar la lista de errores

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dniStr = request.getParameter("dni");
        LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimiento"));
        String profesionValue = request.getParameter("profesion");
        Profesion profesion = Profesion.valueOf(profesionValue);

        validarNombre(nombre);
        validarApellido(apellido);
        validarDNI(dniStr);
        validarEdad(fechaNacimiento);
        if (!errores.isEmpty()) {
            request.setAttribute("errores", errores);
            RequestDispatcher dispatcher = request.getRequestDispatcher("crearUsuario.jsp");
            dispatcher.forward(request, response);
        } else {
            int dni = Integer.parseInt(dniStr);
            Usuario nuevoUsuario = new Usuario(nombre, apellido, dni, fechaNacimiento, profesion);
            listUsuarios.agregarUsuario(nuevoUsuario);

            // Redirigir a la página showDataUser
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
        } else {
            int dni = Integer.parseInt(dniStr);
            if (listUsuarios.existeDNI(dni)) {
                errores.add("El DNI ingresado ya está en uso.");
            }
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