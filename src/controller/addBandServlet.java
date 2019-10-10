package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Album;
import model.Band;
import model.BandMembers;

/**
 * Servlet implementation class addBandServlet
 */
@WebServlet("/addBandServlet")
public class addBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Made it to servlet");
		String band = request.getParameter("band");
		
		String bandMember = request.getParameter("band member");
		String bandMemberRole = request.getParameter("band member role");
		
		String album = request.getParameter("album");
		String albumYear = request.getParameter("release year");
		String albumMonth = request.getParameter("release month");
		String albumDay = request.getParameter("release day");
		
		System.out.println("Retrieved parameters from index.html");
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(albumYear), Integer.parseInt(albumMonth), Integer.parseInt(albumDay));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		Band b= new Band(band);
		BandHelper bh = new BandHelper();
		bh.insertBand(b);
		
		System.out.println("New band created");
		
		//Get the band that has been persisted so we can make sure they are being persisted
		Band savedBand = bh.searchForOneBandByName(band);
		System.out.println(savedBand.toString());
		
		BandMembers bm = new BandMembers(bandMember, bandMemberRole, savedBand);
		BandMembersHelper bmh = new BandMembersHelper();
		bmh.insertBandMember(bm);
		
		System.out.println("New bandmembers created");
		
		Album a = new Album(album, ld, savedBand);
		AlbumHelper ah = new AlbumHelper();
		ah.insertAlbum(a);
		
		System.out.println("New album created");
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
