package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pets;

/**
 * Servlet implementation class PetNavigationServlet
 */
@WebServlet("/petNavigationServlet")
public class PetNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetNavigationServlet() {
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
		// add helpers
		PetsHelper ph = new PetsHelper();
		OwnersHelper oh = new OwnersHelper();
		
		// read inputs
		String act = request.getParameter("doThisToPets");
		
		// determine next steps
		String path = "/viewAllPetsServlet";
		if(act.equals("Add")) {
			path = "/add-pet.html";
		} else if (act.equals("Delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("petId"));
				Pets petToDelete = ph.searchPetByID(tempId);
				ph.deletePet(petToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select Pet");
			}
		} else if (act.equals("Edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("petId"));
				Pets petToEdit = ph.searchPetByID(tempId);
				request.setAttribute("petToEdit", petToEdit);
				request.setAttribute("month", petToEdit.getBirthday().getMonthValue());
				request.setAttribute("date", petToEdit.getBirthday().getDayOfMonth());
				request.setAttribute("year", petToEdit.getBirthday().getYear());
				request.setAttribute("allOwners", oh.showAllOwners());
				if(oh.showAllOwners().isEmpty()) {
					request.setAttribute("allOwners", " ");
				}
				path = "/edit-pet.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select Pet");
			}
		}
		
		// directs traffic
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
