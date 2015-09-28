package org.practice.webapp.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.practice.webapp.dto.Database;
import org.practice.webapp.dto.User;
import org.practice.webapp.dto.UserDetails;

/**
 * Servlet implementation class ValidatorServlet
 */
@WebServlet("/Validator")
public class ValidatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean fetch = false;
		if(request.getParameterMap().containsKey("visitorName"))
			fetch = true;
		String file = fetch ? "fetch.jsp":"update.jsp";

		String visitorName = request.getParameter("visitorName");
		if(fetch) {
			if(visitorName == null || visitorName.trim().equals("")) {
				request.getRequestDispatcher(file).forward(request, response);
				//response.sendRedirect(file);
				return;
			}
		}
		String userId = request.getParameter("userId");
		if(userId == null || userId.trim().equals("")) {
			request.getRequestDispatcher(file).forward(request, response);
			//response.sendRedirect(file);
			return;
		}
		UserDetails details = Database.getUserDetails(userId);
		User user = Database.getUser(userId);
		if(user == null || details == null) {
			request.getRequestDispatcher(file).forward(request, response);
			return;
		}
		if(!fetch) {
			String userName = request.getParameter("userName");
			String yearVal = request.getParameter("year");
			if(userName == null || userName.trim().equals("") ||
					yearVal == null || yearVal.trim().equals("")) {
				request.getRequestDispatcher(file).forward(request, response);
				//response.sendRedirect(file);
				return;
			}
			int year = 0;
			try {
				year = Integer.parseInt(yearVal);
			} catch (NumberFormatException ex) {
				request.getRequestDispatcher(file).forward(request, response);
				//response.sendRedirect(file);
				return;
			}
			if(!user.getUserName().equalsIgnoreCase(userName) || user.getYear()!=year) {
				request.getRequestDispatcher(file).forward(request, response);
				//response.sendRedirect(file);
				return;
			}
		}
		if(!fetch) {
			request.getRequestDispatcher("updateForm.jsp").forward(request, response);
		} else {
			request.setAttribute("details", details);
			request.setAttribute("userName", user.getUserName());
			request.setAttribute("year", user.getYear());
			request.getRequestDispatcher("fetchedForm.jsp").forward(request, response);
		}
	}	

}
