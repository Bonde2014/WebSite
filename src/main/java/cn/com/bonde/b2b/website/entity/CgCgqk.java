package cn.com.bonde.b2b.website.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CgCgqk entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cg_cgqk", catalog = "b2b")
public class CgCgqk implements java.io.Serializable
{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1461965188817873018L;
	private Long cgxh;
	private Long cgryDm;
	private Timestamp cgsj;
	private Long cgzje;

	// Constructors

	/** default constructor */
	public CgCgqk()
	{
	}

	/** full constructor */
	public CgCgqk(Long cgryDm, Timestamp cgsj, Long cgzje)
	{
		this.cgryDm = cgryDm;
		this.cgsj = cgsj;
		this.cgzje = cgzje;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cgxh", unique = true, nullable = false)
	public Long getCgxh()
	{
		return this.cgxh;
	}

	public void setCgxh(Long cgxh)
	{
		this.cgxh = cgxh;
	}

	@Column(name = "cgry_dm")
	public Long getCgryDm()
	{
		return this.cgryDm;
	}

	public void setCgryDm(Long cgryDm)
	{
		this.cgryDm = cgryDm;
	}

	@Column(name = "cgsj", length = 19)
	public Timestamp getCgsj()
	{
		return this.cgsj;
	}

	public void setCgsj(Timestamp cgsj)
	{
		this.cgsj = cgsj;
	}

	@Column(name = "cgzje", precision = 10, scale = 0)
	public Long getCgzje()
	{
		return this.cgzje;
	}

	public void setCgzje(Long cgzje)
	{
		this.cgzje = cgzje;
	}

}