package cn.com.bonde.b2b.website.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DmQxJs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dm_qx_js", catalog = "b2b")
public class DmQxJs implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private Long jsDm;
	private String jsMc;
	private String bz;

	// Constructors

	/** default constructor */
	public DmQxJs()
	{
	}

	/** full constructor */
	public DmQxJs(String jsMc, String bz)
	{
		this.jsMc = jsMc;
		this.bz = bz;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "js_dm", unique = true, nullable = false)
	public Long getJsDm()
	{
		return this.jsDm;
	}

	public void setJsDm(Long jsDm)
	{
		this.jsDm = jsDm;
	}

	@Column(name = "js_mc", length = 20)
	public String getJsMc()
	{
		return this.jsMc;
	}

	public void setJsMc(String jsMc)
	{
		this.jsMc = jsMc;
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