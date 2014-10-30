package cn.com.bonde.b2b.website.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CgGhsSpmx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cg_ghs_spmx", catalog = "b2b")
public class CgGhsSpmx implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private Long ghxh;
	private Long ghsDm;
	private Long spDm;
	private Long spJg;
	private Integer spSl;
	private String ghbz;
	private Timestamp bjsj;

	// Constructors

	/** default constructor */
	public CgGhsSpmx()
	{
	}

	/** minimal constructor */
	public CgGhsSpmx(Long ghsDm)
	{
		this.ghsDm = ghsDm;
	}

	/** full constructor */
	public CgGhsSpmx(Long ghsDm, Long spDm, Long spJg, Integer spSl, String ghbz, Timestamp bjsj)
	{
		this.ghsDm = ghsDm;
		this.spDm = spDm;
		this.spJg = spJg;
		this.spSl = spSl;
		this.ghbz = ghbz;
		this.bjsj = bjsj;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ghxh", unique = true, nullable = false)
	public Long getGhxh()
	{
		return this.ghxh;
	}

	public void setGhxh(Long ghxh)
	{
		this.ghxh = ghxh;
	}

	@Column(name = "ghs_dm", nullable = false)
	public Long getGhsDm()
	{
		return this.ghsDm;
	}

	public void setGhsDm(Long ghsDm)
	{
		this.ghsDm = ghsDm;
	}

	@Column(name = "sp_dm")
	public Long getSpDm()
	{
		return this.spDm;
	}

	public void setSpDm(Long spDm)
	{
		this.spDm = spDm;
	}

	@Column(name = "sp_jg", precision = 10, scale = 0)
	public Long getSpJg()
	{
		return this.spJg;
	}

	public void setSpJg(Long spJg)
	{
		this.spJg = spJg;
	}

	@Column(name = "sp_sl")
	public Integer getSpSl()
	{
		return this.spSl;
	}

	public void setSpSl(Integer spSl)
	{
		this.spSl = spSl;
	}

	@Column(name = "ghbz", length = 1)
	public String getGhbz()
	{
		return this.ghbz;
	}

	public void setGhbz(String ghbz)
	{
		this.ghbz = ghbz;
	}

	@Column(name = "bjsj", length = 19)
	public Timestamp getBjsj()
	{
		return this.bjsj;
	}

	public void setBjsj(Timestamp bjsj)
	{
		this.bjsj = bjsj;
	}

}