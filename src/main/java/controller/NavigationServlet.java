package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pets;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		String act = request.getParameter("doThisToPets");
		
		// determine next steps
		String path = "/viewAllPetsServlet";
		if(act.equals("Add")) {
			path = "add-pet.html";
		} else if (act.equals("Delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("petId"));
				Pets petToDelete = ph.searchPetByID(tempId);
				ph.deletePet(petToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select Pet");
			}
		} else if (act.equals("Edit")) {
			
		}
		
		// directs traffic
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
		/*
		 * 
		GamesHelper dao = new GamesHelper();
		String act = request.getParameter("doThisToGame");
		
		//default to viewAllGames servlet unless to add or edit
		String path = "/viewAllGamesServlet";
		
		if(act.equals("Delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Games gameToDelete = dao.searchGameByID(tempId);
				dao.deleteGame(gameToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an game");
			}
		} else if (act.equals("Edit")) {
			try {
				Integer tempID = Integer.parseInt(request.getParameter("id"));
				Games gameToEdit = dao.searchGameByID(tempID);
				request.setAttribute("gameToEdit", gameToEdit);
				path = "/edit-game.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an game");
			}
		} else if (act.equals("Add")) {
			path = "/index.html";
		}
		
		 */
	}

}
