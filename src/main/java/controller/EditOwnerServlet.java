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
 * Servlet implementation class EditOwnerServlet
 */
@WebServlet("/editOwnerServlet")
public class EditOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOwnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		OwnersHelper oh = new OwnersHelper();
				
		Integer ownerId = Integer.parseInt(request.getParameter("ownerId"));
		String name = request.getParameter("name");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		// edit date
		LocalDate newLd;
		try {
			newLd = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException e) {
			newLd = LocalDate.now();
		} catch (DateTimeException e) {  
			newLd = LocalDate.now();
		}

		Owners ownerToUpdate = oh.searchOwnerByID(ownerId);
		ownerToUpdate.setName(name);
		ownerToUpdate.setBirthday(newLd);
		oh.updateOwner(ownerToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllOwnersServlet").forward(request, response);
	}

}