package cn.com.bonde.b2b.website.entity;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * CgCgqkSpmx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cg_cgqk_spmx", catalog = "b2b")
public class CgCgqkSpmx implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private CgCgqkSpmxId id;
	private Long spJgCj;
	private Timestamp cgsl;
	private Long cgje;

	// Constructors

	/** default constructor */
	public CgCgqkSpmx()
	{
	}

	/** minimal constructor */
	public CgCgqkSpmx(CgCgqkSpmxId id)
	{
		this.id = id;
	}

	/** full constructor */
	public CgCgqkSpmx(CgCgqkSpmxId id, Long spJgCj, Timestamp cgsl, Long cgje)
	{
		this.id = id;
		this.spJgCj = spJgCj;
		this.cgsl = cgsl;
		this.cgje = cgje;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "cgxh", column = @Column(name = "cgxh", nullable = false)),
			@AttributeOverride(name = "ghxh", column = @Column(name = "ghxh", nullable = false)) })
	public CgCgqkSpmxId getId()
	{
		return this.id;
	}

	public void setId(CgCgqkSpmxId id)
	{
		this.id = id;
	}

	@Column(name = "sp_jg_cj", precision = 10, scale = 0)
	public Long getSpJgCj()
	{
		return this.spJgCj;
	}

	public void setSpJgCj(Long spJgCj)
	{
		this.spJgCj = spJgCj;
	}

	@Column(name = "cgsl", length = 19)
	public Timestamp getCgsl()
	{
		return this.cgsl;
	}

	public void setCgsl(Timestamp cgsl)
	{
		this.cgsl = cgsl;
	}

	@Column(name = "cgje", precision = 10, scale = 0)
	public Long getCgje()
	{
		return this.cgje;
	}

	public void setCgje(Long cgje)
	{
		this.cgje = cgje;
	}

}