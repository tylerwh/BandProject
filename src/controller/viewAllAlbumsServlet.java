package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewAllAlbumsServlet
 */
@WebServlet("/viewAllAlbumsServlet")
public class viewAllAlbumsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllAlbumsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AlbumHelper bh = new AlbumHelper();
		
		System.out.println("In the viewAllAlbumsServlet");
		
		request.setAttribute("allAlbums", bh.showAllAlbums());
		
		System.out.println("Set attribute for allAlbums");
		
		if(bh.showAllAlbums().isEmpty()){
			request.setAttribute("allAlbums", " ");
		}
		
		getServletContext().getRequestDispatcher("/view-albums.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
