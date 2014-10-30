package cn.com.bonde.b2b.website.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * QxCzy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "qx_czy", catalog = "b2b")
public class QxCzy implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private Long czyDm;
	private Long dlm;
	private String czyXm;
	private String ssbm;
	private String lxdh;
	private Long lrrDm;
	private Timestamp lrsj;

	// Constructors

	/** default constructor */
	public QxCzy()
	{
	}

	/** full constructor */
	public QxCzy(Long dlm, String czyXm, String ssbm, String lxdh, Long lrrDm, Timestamp lrsj)
	{
		this.dlm = dlm;
		this.czyXm = czyXm;
		this.ssbm = ssbm;
		this.lxdh = lxdh;
		this.lrrDm = lrrDm;
		this.lrsj = lrsj;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "czy_dm", unique = true, nullable = false)
	public Long getCzyDm()
	{
		return this.czyDm;
	}

	public void setCzyDm(Long czyDm)
	{
		this.czyDm = czyDm;
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

	@Column(name = "czy_xm", length = 20)
	public String getCzyXm()
	{
		return this.czyXm;
	}

	public void setCzyXm(String czyXm)
	{
		this.czyXm = czyXm;
	}

	@Column(name = "ssbm", length = 40)
	public String getSsbm()
	{
		return this.ssbm;
	}

	public void setSsbm(String ssbm)
	{
		this.ssbm = ssbm;
	}

	@Column(name = "lxdh", length = 20)
	public String getLxdh()
	{
		return this.lxdh;
	}

	public void setLxdh(String lxdh)
	{
		this.lxdh = lxdh;
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