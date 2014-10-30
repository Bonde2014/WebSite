package cn.com.bonde.b2b.website.entity;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * XsDdqkSpmx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "xs_ddqk_spmx", catalog = "b2b")
public class XsDdqkSpmx implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private XsDdqkSpmxId id;
	private Long spDm;
	private Long spJg;
	private Long spJgCj;
	private Integer spSl;
	private Timestamp spZj;

	// Constructors

	/** default constructor */
	public XsDdqkSpmx()
	{
	}

	/** minimal constructor */
	public XsDdqkSpmx(XsDdqkSpmxId id)
	{
		this.id = id;
	}

	/** full constructor */
	public XsDdqkSpmx(XsDdqkSpmxId id, Long spDm, Long spJg, Long spJgCj, Integer spSl, Timestamp spZj)
	{
		this.id = id;
		this.spDm = spDm;
		this.spJg = spJg;
		this.spJgCj = spJgCj;
		this.spSl = spSl;
		this.spZj = spZj;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "ddxh", column = @Column(name = "ddxh", nullable = false)),
			@AttributeOverride(name = "xxh", column = @Column(name = "xxh", nullable = false)) })
	public XsDdqkSpmxId getId()
	{
		return this.id;
	}

	public void setId(XsDdqkSpmxId id)
	{
		this.id = id;
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

	@Column(name = "sp_jg_cj", precision = 10, scale = 0)
	public Long getSpJgCj()
	{
		return this.spJgCj;
	}

	public void setSpJgCj(Long spJgCj)
	{
		this.spJgCj = spJgCj;
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

	@Column(name = "sp_zj", length = 19)
	public Timestamp getSpZj()
	{
		return this.spZj;
	}

	public void setSpZj(Timestamp spZj)
	{
		this.spZj = spZj;
	}

}