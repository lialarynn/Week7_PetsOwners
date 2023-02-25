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
 * Servlet implementation class AddPetServlet
 */
@WebServlet("/addPetServlet")
public class AddPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// add helpers
		PetsHelper ph = new PetsHelper();
		
		// read inputs
		String name = request.getParameter("name");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String species = request.getParameter("species");
		String breed = request.getParameter("breed");
		
		LocalDate birthday;
		// edit inputs
		try {	//convert three fields to a valid date
			birthday = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {  //in case dates entered is not valid dates, put in today's for now
			birthday = LocalDate.now();
		} catch (DateTimeException e) {  
			birthday = LocalDate.now();
		}
		
		// create pet and insert into database
		Pets pet = new Pets(name, birthday, species, breed);
		ph.insertPets(pet);
		 
		//go back to the add page
		getServletContext().getRequestDispatcher("/add-pet.html").forward(request,response);
	}

}
