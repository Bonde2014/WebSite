package cn.com.bonde.b2b.website.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * QxDlxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "qx_dlxx", catalog = "b2b")
public class QxDlxx implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private Long dlm;
	private String dlkl;
	private String yxbz;
	private String dllx;
	private String xgsj;

	// Constructors

	/** default constructor */
	public QxDlxx()
	{
	}

	/** full constructor */
	public QxDlxx(String dlkl, String yxbz, String dllx, String xgsj)
	{
		this.dlkl = dlkl;
		this.yxbz = yxbz;
		this.dllx = dllx;
		this.xgsj = xgsj;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "dlm", unique = true, nullable = false)
	public Long getDlm()
	{
		return this.dlm;
	}

	public void setDlm(Long dlm)
	{
		this.dlm = dlm;
	}

	@Column(name = "dlkl", length = 40)
	public String getDlkl()
	{
		return this.dlkl;
	}

	public void setDlkl(String dlkl)
	{
		this.dlkl = dlkl;
	}

	@Column(name = "yxbz", length = 50)
	public String getYxbz()
	{
		return this.yxbz;
	}

	public void setYxbz(String yxbz)
	{
		this.yxbz = yxbz;
	}

	@Column(name = "dllx", length = 50)
	public String getDllx()
	{
		return this.dllx;
	}

	public void setDllx(String dllx)
	{
		this.dllx = dllx;
	}

	@Column(name = "xgsj", length = 50)
	public String getXgsj()
	{
		return this.xgsj;
	}

	public void setXgsj(String xgsj)
	{
		this.xgsj = xgsj;
	}

}