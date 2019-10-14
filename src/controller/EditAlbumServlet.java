package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Album;

/**
 * Servlet implementation class EditAlbumServlet
 */
@WebServlet("/EditAlbumServlet")
public class EditAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAlbumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Made it to EditAlbumServlet");
		
		AlbumHelper ah = new AlbumHelper();
		System.out.println("id parameter: " + request.getParameter("id"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		System.out.println("temp Id: " + request.getParameter("albumName"));
		String albumName = request.getParameter("albumName");
		System.out.println("releaseDate: " + request.getParameter("releaseDate"));
		Integer year = Integer.parseInt(request.getParameter("releaseDate").substring(0, 4));
		System.out.println("Year: " + year);
		Integer month = Integer.parseInt(request.getParameter("releaseDate").substring(5, 7));
		System.out.println("Month: " + month);
		Integer day = Integer.parseInt(request.getParameter("releaseDate").substring(8));
		System.out.println("Day: " + day);
		
		LocalDate ld;
		try {
			ld = LocalDate.of(year, month, day);
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		System.out.println(request.getParameter("releaseDate"));
		
		Album albumToEdit = ah.searchForAlbumByID(tempId);
		
		albumToEdit.setAlbumName(albumName);
		albumToEdit.setReleaseDate(ld);
		
		ah.updateAlbum(albumToEdit);
		
		getServletContext().getRequestDispatcher("/viewAllAlbumsServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
