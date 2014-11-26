package cn.com.bonde.b2b.website.entity;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * XsGwc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "xs_gwc", catalog = "b2b")
public class XsGwc implements java.io.Serializable
{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8922432571976777843L;
	private XsGwcId id;
	private Integer spSl;
	private Timestamp tjsj;

	// Constructors

	/** default constructor */
	public XsGwc()
	{
	}

	/** minimal constructor */
	public XsGwc(XsGwcId id)
	{
		this.id = id;
	}


	// Property accessors
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "khDm", column = @Column(name = "kh_dm", nullable = false)),
			@AttributeOverride(name = "spDm", column = @Column(name = "sp_dm", nullable = false)) })
	public XsGwcId getId()
	{
		return this.id;
	}

	public void setId(XsGwcId id)
	{
		this.id = id;
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

	
	@Column(name = "tjsj", length = 19)
	public Timestamp getTjsj()
	{
		return this.tjsj;
	}

	public void setTjsj(Timestamp tjsj)
	{
		this.tjsj = tjsj;
	}

}