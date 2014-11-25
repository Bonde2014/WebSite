package cn.com.bonde.b2b.website.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SpSpxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sp_spxx", catalog = "b2b")
public class SpSpxx implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private Long spDm;
	private Long spflDm;
	private Long spppDm;
	private String spxh;
	private String spmc;
	private String tzms;
	private String jldw;
	private Double scjg;

	// Constructors

	/** default constructor */
	public SpSpxx()
	{
	}


	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sp_dm", unique = true, nullable = false)
	public Long getSpDm()
	{
		return this.spDm;
	}

	public void setSpDm(Long spDm)
	{
		this.spDm = spDm;
	}

	@Column(name = "spfl_dm")
	public Long getSpflDm()
	{
		return this.spflDm;
	}

	public void setSpflDm(Long spflDm)
	{
		this.spflDm = spflDm;
	}

	@Column(name = "sppp_dm")
	public Long getSpppDm()
	{
		return this.spppDm;
	}

	public void setSpppDm(Long spppDm)
	{
		this.spppDm = spppDm;
	}

	@Column(name = "spxh", length = 30)
	public String getSpxh()
	{
		return this.spxh;
	}

	public void setSpxh(String spxh)
	{
		this.spxh = spxh;
	}

	@Column(name = "spmc", length = 50)
	public String getSpmc()
	{
		return this.spmc;
	}

	public void setSpmc(String spmc)
	{
		this.spmc = spmc;
	}

	@Column(name = "tzms", length = 100)
	public String getTzms()
	{
		return this.tzms;
	}

	public void setTzms(String tzms)
	{
		this.tzms = tzms;
	}

	@Column(name = "jldw", length = 6)
	public String getJldw()
	{
		return this.jldw;
	}

	public void setJldw(String jldw)
	{
		this.jldw = jldw;
	}

	@Column(name = "scjg", precision = 10, scale = 2)
	public Double getScjg()
	{
		return this.scjg;
	}

	public void setScjg(Double scjg)
	{
		this.scjg = scjg;
	}

}