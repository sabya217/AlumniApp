package org.practice.webapp.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.practice.webapp.config.AlumniConfig;
import org.practice.webapp.dto.Database;
import org.practice.webapp.dto.User;
import org.practice.webapp.service.ResgistrationService;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/Office")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResgistrationService service = new ResgistrationService();
		service.process(request.getParameterMap());
		if(!service.status()) {
			request.setAttribute("message", service.getMessage());
			request.setAttribute("return", true);
			request.getRequestDispatcher("loginReturn.jsp").forward(request, response);
			return;
		}
		User user = service.getUser();
		Database.store(user);
		request.setAttribute("details", Database.getUserDetails(user));
		request.setAttribute("status", "success");
		request.getRequestDispatcher("success.jsp").forward(request, response);
	}
	
	
}
