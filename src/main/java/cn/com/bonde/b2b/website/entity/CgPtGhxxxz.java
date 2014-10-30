package cn.com.bonde.b2b.website.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CgPtGhxxxz entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cg_pt_ghxxxz", catalog = "b2b")
public class CgPtGhxxxz implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private Long xzxh;
	private Long spDm;
	private Integer ghxh;
	private Long czyDm;
	private Timestamp xzsj;

	// Constructors

	/** default constructor */
	public CgPtGhxxxz()
	{
	}

	/** full constructor */
	public CgPtGhxxxz(Long spDm, Integer ghxh, Long czyDm, Timestamp xzsj)
	{
		this.spDm = spDm;
		this.ghxh = ghxh;
		this.czyDm = czyDm;
		this.xzsj = xzsj;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "xzxh", unique = true, nullable = false)
	public Long getXzxh()
	{
		return this.xzxh;
	}

	public void setXzxh(Long xzxh)
	{
		this.xzxh = xzxh;
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

	@Column(name = "ghxh")
	public Integer getGhxh()
	{
		return this.ghxh;
	}

	public void setGhxh(Integer ghxh)
	{
		this.ghxh = ghxh;
	}

	@Column(name = "czy_dm")
	public Long getCzyDm()
	{
		return this.czyDm;
	}

	public void setCzyDm(Long czyDm)
	{
		this.czyDm = czyDm;
	}

	@Column(name = "xzsj", length = 19)
	public Timestamp getXzsj()
	{
		return this.xzsj;
	}

	public void setXzsj(Timestamp xzsj)
	{
		this.xzsj = xzsj;
	}

}