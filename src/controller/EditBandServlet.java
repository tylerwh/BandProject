package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Band;

/**
 * Servlet implementation class EditBandServlet
 */
@WebServlet("/EditBandServlet")
public class EditBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		BandHelper bh = new BandHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		String bandName = request.getParameter("bandName");
		
		Band bandToEdit = bh.searchForBandByID(tempId);
		
		bandToEdit.setBandName(bandName);
		
		bh.updateBand(bandToEdit);
		
		getServletContext().getRequestDispatcher("/viewAllBandsServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
