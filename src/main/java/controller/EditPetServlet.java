package controller;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pets;



/**
 * Servlet implementation class EditPetServlet
 */
@WebServlet("/editPetServlet")
public class EditPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPetServlet() {
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
				
		// read inputs
		Integer petId = Integer.parseInt(request.getParameter("petId"));
		String name = request.getParameter("name");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		Integer weight = Integer.parseInt(request.getParameter("weight"));
		String gender = request.getParameter("gender");
		
		// edit date
		LocalDate newLd;
		try {
			newLd = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException e) {
			newLd = LocalDate.now();
		} catch (DateTimeException e) {  //in case dates entered is not valid dates, put in today's for now
			newLd = LocalDate.now();
		}
		
		// correct object and update record
		Pets petToUpdate = ph.searchPetByID(petId);
		petToUpdate.setName(name);
		petToUpdate.setBirthday(newLd);
		petToUpdate.setWeight(weight);
		petToUpdate.setGender(gender);
		ph.updatePet(petToUpdate);
		
		// direct traffic
		getServletContext().getRequestDispatcher("/viewAllPetsServlet").forward(request, response);
	}

}
