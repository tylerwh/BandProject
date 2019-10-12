package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Album;
import model.BandMembers;

/**
 * Servlet implementation class MemberNavigationServlet
 */
@WebServlet("/MemberNavigationServlet")
public class MemberNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberNavigationServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
		BandMembersHelper bmh = new BandMembersHelper();
		String process = request.getParameter("doThisToMember");
		
		if (process == null) {
			getServletContext().getRequestDispatcher("/viewAllBandMembersServlet").forward(request, response);
		} else if (process.equals("edit")) {
			
			
		} else if (process.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				BandMembers memberToDelete = bmh.searchForBandByID(tempId);
				bmh.deleteBandMember(memberToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllBandMembersServlet").forward(request, response);
			}
			
		} else if (process.equals("add")) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}
