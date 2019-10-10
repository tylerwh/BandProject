package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="band")
@NamedQuery(name="Band.findBands", query="select b from Band b")
public class Band {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BAND_ID")
	private int bandId;
	@Column(name="BAND_NAME")
	private String bandName;
	// Should we have an instance of the Album class to address the OneToMany relationship?
	@OneToMany(cascade = CascadeType.PERSIST, fetch=FetchType.EAGER) 
	@JoinTable(
			joinColumns= {@JoinColumn(name="BAND_ID", referencedColumnName="BAND_ID")},
			inverseJoinColumns= {@JoinColumn(name="ALBUM_ID", referencedColumnName="ALBUM_ID", unique=true)}
			)
	private List<Album> album;
	
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
		this.bandId = this.getBandId();
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
