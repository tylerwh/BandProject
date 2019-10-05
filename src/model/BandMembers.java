package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="band_members")
public class BandMembers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MEMBER_ID")
	private int memberId;
	@Column(name="MEMBER_NAME")
	private String memberName;
	@ManyToOne
	@JoinColumn(name="BAND_ID")
	private int bandId;
	@Column(name="MEMBER_ROLE")
	private String memberRole;
	
	public BandMembers() {
		super();
		// TODO Auto-generated constructor stub
	}	

	public BandMembers(int memberId, String memberName, int bandId, String memberRole) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.bandId = bandId;
		this.memberRole = memberRole;
	}

	public BandMembers(String memberName, int bandId, String memberRole) {
		super();
		this.memberName = memberName;
		this.bandId = bandId;
		this.memberRole = memberRole;
	}

	public BandMembers(String memberName, String memberRole) {
		super();
		this.memberName = memberName;
		this.memberRole = memberRole;
	}
	
	/**
	 * @return the memberId
	 */
	public int getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	 * @return the memberRole
	 */
	public String getMemberRole() {
		return memberRole;
	}

	/**
	 * @param memberRole the memberRole to set
	 */
	public void setMemberRole(String memberRole) {
		this.memberRole = memberRole;
	}

	@Override
	public String toString() {
		return "BandMembers [memberId=" + memberId + ", memberName=" + memberName + ", bandId=" + bandId
				+ ", memberRole=" + memberRole + "]";
	}
	
	

}
