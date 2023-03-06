package controller;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Owners;

/**
 * Servlet implementation class AddOwnerServlet
 */
@WebServlet("/addOwnerServlet")
public class AddOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOwnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		OwnersHelper oh = new OwnersHelper();
		
		String name = request.getParameter("name");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		LocalDate birthday;
		
		try {
			birthday = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {  
			birthday = LocalDate.now();
		} catch (DateTimeException e) {  
			birthday = LocalDate.now();
		}

		Owners owner = new Owners(name, birthday);
		oh.insertOwners(owner);
		 
		getServletContext().getRequestDispatcher("/add-owner.html").forward(request,response);
	}

}