package cn.com.bonde.b2b.website.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DmQxGns entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dm_qx_gns", catalog = "b2b")
public class DmQxGns implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private Long gnsDm;
	private String sjGnsDm;
	private String gnsMc;
	private String gnsUrl;
	private String bz;

	// Constructors

	/** default constructor */
	public DmQxGns()
	{
	}

	/** full constructor */
	public DmQxGns(String sjGnsDm, String gnsMc, String gnsUrl, String bz)
	{
		this.sjGnsDm = sjGnsDm;
		this.gnsMc = gnsMc;
		this.gnsUrl = gnsUrl;
		this.bz = bz;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "gns_dm", unique = true, nullable = false)
	public Long getGnsDm()
	{
		return this.gnsDm;
	}

	public void setGnsDm(Long gnsDm)
	{
		this.gnsDm = gnsDm;
	}

	@Column(name = "sj_gns_dm", length = 6)
	public String getSjGnsDm()
	{
		return this.sjGnsDm;
	}

	public void setSjGnsDm(String sjGnsDm)
	{
		this.sjGnsDm = sjGnsDm;
	}

	@Column(name = "gns_mc", length = 30)
	public String getGnsMc()
	{
		return this.gnsMc;
	}

	public void setGnsMc(String gnsMc)
	{
		this.gnsMc = gnsMc;
	}

	@Column(name = "gns_url", length = 100)
	public String getGnsUrl()
	{
		return this.gnsUrl;
	}

	public void setGnsUrl(String gnsUrl)
	{
		this.gnsUrl = gnsUrl;
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