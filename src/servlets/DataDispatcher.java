package servlets;

import model.ListUsuarios;
import java.io.IOException;
import java.io.Serial;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (description = "Carga los datos que va a mostar el jsp", urlPatterns = "/showDataUser")
public class DataDispatcher extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			   throws ServletException, IOException {

		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			   throws ServletException, IOException {
		ListUsuarios listaUsuarios = new ListUsuarios();

		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher("/showDataUser.jsp");
		request.setAttribute("infoData", listaUsuarios.obtenerTodosLosUsuarios());
		dispatcher.forward(request, response);
	}
	
}
