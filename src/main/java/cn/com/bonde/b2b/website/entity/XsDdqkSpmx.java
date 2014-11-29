package cn.com.bonde.b2b.website.entity;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private XsDdqkSpmxId id;
	private Long spDm;
	private Double spJg;
	private Double spJgCj;
	private Integer spSl;
	private Double spZj;

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
	public XsDdqkSpmx(XsDdqkSpmxId id, Long spDm, Double spJg, Double spJgCj, Integer spSl, Double spZj)
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
	@AttributeOverrides({ @AttributeOverride(name = "ddid", column = @Column(name = "ddid", nullable = false)),
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

	@Column(name = "sp_jg", precision = 10)
	public Double getSpJg()
	{
		return this.spJg;
	}

	public void setSpJg(Double spJg)
	{
		this.spJg = spJg;
	}

	@Column(name = "sp_jg_cj", precision = 10)
	public Double getSpJgCj()
	{
		return this.spJgCj;
	}

	public void setSpJgCj(Double spJgCj)
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

	@Column(name = "sp_zj", precision = 10)
	public Double getSpZj()
	{
		return this.spZj;
	}

	public void setSpZj(Double spZj)
	{
		this.spZj = spZj;
	}

}