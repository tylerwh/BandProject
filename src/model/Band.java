package model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="band")
public class Band {
	
	@Id
	@GeneratedValue
	private int bandId;
	@Column
	private String bandName;
	// Should we have an instance of the Album class to address the OneToMany relationship?
	@OneToMany(cascade = CascadeType.PERSIST) 
	@JoinColumn(name = "album_fk")
	private ArrayList<Album> album = new ArrayList<Album>();
	
	public Band() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Band(String bandName) {
		super();
		this.bandName = bandName;
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

	/**
	 * @return the bandName
	 */
	public String getBandName() {
		return bandName;
	}

	/**
	 * @param bandName the bandName to set
	 */
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	@Override
	public String toString() {
		return "Band [bandId=" + bandId + ", bandName=" + bandName + "]";
	}
	

}
