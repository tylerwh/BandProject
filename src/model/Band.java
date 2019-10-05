package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="band")
public class Band {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BAND_ID")
	private int bandId;
	@Column(name="BAND_NAME")
	private String bandName;
	
	public Band() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Band(int bandId, String bandName) {
		super();
		this.bandId = bandId;
		this.bandName = bandName;
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
