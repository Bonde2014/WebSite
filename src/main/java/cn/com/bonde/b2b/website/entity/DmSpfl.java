package cn.com.bonde.b2b.website.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DmSpfl entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dm_spfl", catalog = "b2b")
public class DmSpfl implements java.io.Serializable
{

	// Fields

	private static final long serialVersionUID = 1L;
	private Long spflDm;
	private String spflMc;
	private Long sjSpflDm;
	private String bz;

	// Constructors

	/** default constructor */
	public DmSpfl()
	{
	}

	/** full constructor */
	public DmSpfl(String spflMc, Long sjSpflDm, String bz)
	{
		this.spflMc = spflMc;
		this.sjSpflDm = sjSpflDm;
		this.bz = bz;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "spfl_dm", unique = true, nullable = false)
	public Long getSpflDm()
	{
		return this.spflDm;
	}

	public void setSpflDm(Long spflDm)
	{
		this.spflDm = spflDm;
	}

	@Column(name = "spfl_mc", length = 20)
	public String getSpflMc()
	{
		return this.spflMc;
	}

	public void setSpflMc(String spflMc)
	{
		this.spflMc = spflMc;
	}

	@Column(name = "sj_spfl_dm")
	public Long getSjSpflDm()
	{
		return this.sjSpflDm;
	}

	public void setSjSpflDm(Long sjSpflDm)
	{
		this.sjSpflDm = sjSpflDm;
	}

	@Column(name = "bz", length = 50)
	public String getBz()
	{
		return this.bz;
	}

	public void setBz(String bz)
	{
		this.bz = bz;
	}

}