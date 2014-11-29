package cn.com.bonde.b2b.website.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DmPsfs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dm_psfs", catalog = "b2b")
public class DmPsfs implements java.io.Serializable
{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String psfsdm;
	private String psfsmc;
	private Integer pxwz;
	private Integer sfyx;

	// Constructors

	/** default constructor */
	public DmPsfs()
	{
	}

	/** full constructor */
	public DmPsfs(String psfsmc, Integer pxwz, Integer sfyx)
	{
		this.psfsmc = psfsmc;
		this.pxwz = pxwz;
		this.sfyx = sfyx;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "psfsdm", unique = true, nullable = false, length = 2)
	public String getPsfsdm()
	{
		return this.psfsdm;
	}

	public void setPsfsdm(String psfsdm)
	{
		this.psfsdm = psfsdm;
	}

	@Column(name = "psfsmc", length = 50)
	public String getPsfsmc()
	{
		return this.psfsmc;
	}

	public void setPsfsmc(String psfsmc)
	{
		this.psfsmc = psfsmc;
	}

	@Column(name = "pxwz")
	public Integer getPxwz()
	{
		return this.pxwz;
	}

	public void setPxwz(Integer pxwz)
	{
		this.pxwz = pxwz;
	}

	@Column(name = "sfyx")
	public Integer getSfyx()
	{
		return this.sfyx;
	}

	public void setSfyx(Integer sfyx)
	{
		this.sfyx = sfyx;
	}

}