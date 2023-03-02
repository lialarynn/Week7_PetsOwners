package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Owners;

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
		
		OwnersHelper oh = new OwnersHelper();
		
		String act = request.getParameter("doThisToOwners");
		
		String path = "/viewAllOwnersServlet";
		if(act.equals("Add")) {
			path = "add-owner.html";
		} else if (act.equals("Delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("ownerId"));
				Owners ownerToDelete = oh.searchOwnerByID(tempId);
				oh.deleteOwner(ownerToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select Owner");
			}
		} else if (act.equals("Edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("ownerId"));
				Owners ownerToEdit = oh.searchOwnerByID(tempId);
				request.setAttribute("ownerToEdit", ownerToEdit);
				request.setAttribute("month", ownerToEdit.getBirthday().getMonthValue());
				request.setAttribute("date", ownerToEdit.getBirthday().getDayOfMonth());
				request.setAttribute("year", ownerToEdit.getBirthday().getYear());
				path = "/edit-owner.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select Owner");
			}
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}