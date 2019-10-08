package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "band")
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
	

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getBandId() {
		return bandId;
	}

	public void setBandId(int bandId) {
		this.bandId = bandId;
	}

	public String getMemberRole() {
		return memberRole;
	}


	public void setMemberRole(String memberRole) {
		this.memberRole = memberRole;
	}

	@Override
	public String toString() {
		return "BandMembers [memberId=" + memberId + ", memberName=" + memberName + ", bandId=" + bandId
				+ ", memberRole=" + memberRole + "]";
	}
	
	

}
