package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BandNavigationServlet
 */
@WebServlet("/BandNavigationServlet")
public class BandNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BandNavigationServlet() {
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
		
		BandHelper bh = new BandHelper();
		String process = request.getParameter("doThisToBand");
		
		if (process == null) {
			getServletContext().getRequestDispatcher("/viewAllBandsServlet").forward(request, response);
		} else if (process.equals("edit")) {
			
			
		} else if (process.equals("delete")) {
			
		} else if (process.equals("add")) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
		
		
	}

}
