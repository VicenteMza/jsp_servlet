package servlets;

import model.ListUsuarios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/eliminarUsuarioServlet")
public class EliminarUsuarioServlet extends HttpServlet {
    ListUsuarios listUsuarios = new ListUsuarios();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws  ServletException, IOException{
        String dnistr = request.getParameter("dni");

        try {
            int dni = Integer.parseInt(dnistr);

            if (listUsuarios.existeDNI(dni)){
                listUsuarios.deleteUserByDni(dni);
            }
            response.sendRedirect("showDataUser");
        } catch (NumberFormatException e){
            response.sendRedirect("showDataUser");
        }
    }
}
