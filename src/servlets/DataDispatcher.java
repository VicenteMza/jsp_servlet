package servlets;

import model.ListUsuarios;
import model.Usuario;
import model.Profesion;

import java.io.IOException;
import java.io.Serial;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (description = "Carga los datos que va a mostar el jsp", urlPatterns = "/showDataUser")
public class DataDispatcher extends HttpServlet {
	
	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 2319314504958811913L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			   throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			   throws ServletException, IOException {
		ListUsuarios listaUsuarios = new ListUsuarios();

		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher("/showDataUser.jsp");
		request.setAttribute("infoData", listaUsuarios.obtenerTodosLosUsuarios());
		dispatcher.forward(request, response);
	}
	
}
