package cn.com.bonde.b2b.website.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DmSpfl2 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dm_spfl2", catalog = "b2b")
public class DmSpfl2 implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private Long spppDm;
	private String spppMc;
	private String bz;

	// Constructors

	/** default constructor */
	public DmSpfl2()
	{
	}

	/** full constructor */
	public DmSpfl2(String spppMc, String bz)
	{
		this.spppMc = spppMc;
		this.bz = bz;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sppp_dm", unique = true, nullable = false)
	public Long getSpppDm()
	{
		return this.spppDm;
	}

	public void setSpppDm(Long spppDm)
	{
		this.spppDm = spppDm;
	}

	@Column(name = "sppp_mc", length = 20)
	public String getSpppMc()
	{
		return this.spppMc;
	}

	public void setSpppMc(String spppMc)
	{
		this.spppMc = spppMc;
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