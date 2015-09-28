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
import org.practice.webapp.dto.UserDetails.Fun;
import org.practice.webapp.dto.UserDetails.Geek;
import org.practice.webapp.dto.UserDetails.Sports;

/**
 * Servlet implementation class UpdatorServlet
 */
@WebServlet("/Updator")
public class UpdatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = (String)request.getSession().getAttribute("userId");
		if(userId == null || userId.trim().equals(""))
			return;
		UserDetails details = Database.getUserDetails(userId);
		
		Geek geek = Geek.getGeek(Integer.parseInt(request.getParameter("geek")));
		details.setGeek(geek);
		Fun fun = Fun.getFun(Integer.parseInt(request.getParameter("fun")));
		details.setFun(fun);
		Sports sports = Sports.getSports(Integer.parseInt(request.getParameter("sports")));
		details.setSports(sports);
		String description = request.getParameter("description");
		String updateVal = request.getParameter("updateMessage");
		boolean update = !(updateVal == null || !updateVal.equals("on"));
		if(update || details.getDescription()==null)
			details.setDescription(description);
		else
			details.setDescription(details.getDescription()+" "+description);
		Database.store(details);
		
		User user = Database.getUser(userId);
		request.setAttribute("userName", user.getUserName());
		request.setAttribute("year", user.getYear());
		request.setAttribute("details", details);
		
		request.getRequestDispatcher("updateComplete.jsp").forward(request, response);
	}

}
