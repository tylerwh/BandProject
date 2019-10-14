package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BandMembers;

/**
 * Servlet implementation class EditMemberServlet
 */
@WebServlet("/EditMemberServlet")
public class EditMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Made it into EditMemberServlet");
		
		BandMembersHelper bmh = new BandMembersHelper();
		System.out.println("ID: " + request.getParameter("id"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		System.out.println("Name: " + request.getParameter("memberName"));
		String memberName = request.getParameter("memberName");
		System.out.println("Role: " + request.getParameter("memberRole"));
		String memberRole = request.getParameter("memberRole");
		
		BandMembers memberToEdit = bmh.searchForBandByID(tempId);
		
		memberToEdit.setMemberName(memberName);
		memberToEdit.setMemberRole(memberRole);
		
		bmh.updateBandMember(memberToEdit);
		
		getServletContext().getRequestDispatcher("/viewAllBandMembersServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
