package model;

import java.time.LocalDate;

public class Album {
	
	private int albumId;
	private String albumName;
	private LocalDate releaseDate;
	private int bandId;
	
	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Album(String albumName, LocalDate releaseDate, int bandId) {
		super();
		this.albumName = albumName;
		this.releaseDate = releaseDate;
		this.bandId = bandId;
	}

	/**
	 * @return the albumId
	 */
	public int getAlbumId() {
		return albumId;
	}

	/**
	 * @param albumId the albumId to set
	 */
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	/**
	 * @return the albumName
	 */
	public String getAlbumName() {
		return albumName;
	}

	/**
	 * @param albumName the albumName to set
	 */
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	/**
	 * @return the releaseDate
	 */
	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * @return the bandId
	 */
	public int getBandId() {
		return bandId;
	}

	/**
	 * @param bandId the bandId to set
	 */
	public void setBandId(int bandId) {
		this.bandId = bandId;
	}

	@Override
	public String toString() {
		return "Album [albumId=" + albumId + ", albumName=" + albumName + ", releaseDate=" + releaseDate + ", bandId="
				+ bandId + "]";
	}

}
