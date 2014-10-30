package cn.com.bonde.b2b.website.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * QxKhxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "qx_khxx", catalog = "b2b")
public class QxKhxx implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private Long khDm;
	private Long dlm;
	private String khlb;
	private String khMc;
	private String qdsJb;
	private String fzrXm;
	private String lxdh;
	private String lxdz;
	private Long xsryDm;
	private Long lrrDm;
	private Timestamp lrsj;

	// Constructors

	/** default constructor */
	public QxKhxx()
	{
	}

	/** full constructor */
	public QxKhxx(Long dlm, String khlb, String khMc, String qdsJb, String fzrXm, String lxdh, String lxdz, Long xsryDm, Long lrrDm, Timestamp lrsj)
	{
		this.dlm = dlm;
		this.khlb = khlb;
		this.khMc = khMc;
		this.qdsJb = qdsJb;
		this.fzrXm = fzrXm;
		this.lxdh = lxdh;
		this.lxdz = lxdz;
		this.xsryDm = xsryDm;
		this.lrrDm = lrrDm;
		this.lrsj = lrsj;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "kh_dm", unique = true, nullable = false)
	public Long getKhDm()
	{
		return this.khDm;
	}

	public void setKhDm(Long khDm)
	{
		this.khDm = khDm;
	}

	@Column(name = "dlm")
	public Long getDlm()
	{
		return this.dlm;
	}

	public void setDlm(Long dlm)
	{
		this.dlm = dlm;
	}

	@Column(name = "khlb", length = 1)
	public String getKhlb()
	{
		return this.khlb;
	}

	public void setKhlb(String khlb)
	{
		this.khlb = khlb;
	}

	@Column(name = "kh_mc", length = 50)
	public String getKhMc()
	{
		return this.khMc;
	}

	public void setKhMc(String khMc)
	{
		this.khMc = khMc;
	}

	@Column(name = "qds_jb", length = 1)
	public String getQdsJb()
	{
		return this.qdsJb;
	}

	public void setQdsJb(String qdsJb)
	{
		this.qdsJb = qdsJb;
	}

	@Column(name = "fzr_xm", length = 30)
	public String getFzrXm()
	{
		return this.fzrXm;
	}

	public void setFzrXm(String fzrXm)
	{
		this.fzrXm = fzrXm;
	}

	@Column(name = "lxdh", length = 12)
	public String getLxdh()
	{
		return this.lxdh;
	}

	public void setLxdh(String lxdh)
	{
		this.lxdh = lxdh;
	}

	@Column(name = "lxdz", length = 100)
	public String getLxdz()
	{
		return this.lxdz;
	}

	public void setLxdz(String lxdz)
	{
		this.lxdz = lxdz;
	}

	@Column(name = "xsry_dm")
	public Long getXsryDm()
	{
		return this.xsryDm;
	}

	public void setXsryDm(Long xsryDm)
	{
		this.xsryDm = xsryDm;
	}

	@Column(name = "lrr_dm")
	public Long getLrrDm()
	{
		return this.lrrDm;
	}

	public void setLrrDm(Long lrrDm)
	{
		this.lrrDm = lrrDm;
	}

	@Column(name = "lrsj", length = 19)
	public Timestamp getLrsj()
	{
		return this.lrsj;
	}

	public void setLrsj(Timestamp lrsj)
	{
		this.lrsj = lrsj;
	}

}