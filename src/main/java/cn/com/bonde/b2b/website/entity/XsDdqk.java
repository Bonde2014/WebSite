package cn.com.bonde.b2b.website.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * XsDdqk entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "xs_ddqk", catalog = "b2b")
public class XsDdqk implements java.io.Serializable
{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ddid;
	private String ddxh;
	private Long qdsDm;
	private Double ddzje;
	private Double ddzjeGj;
	private String ddzt;
	private Long xsryDm;
	private Date ddscsj;
	private Date ddqrsj;
	private Date ddfhsj;
	private Date ddzfsj;

	// Constructors

	/** default constructor */
	public XsDdqk()
	{
	}

	/** full constructor */
	public XsDdqk(String ddxh, Long qdsDm, Double ddzje, Double ddzjeGj, String ddzt, Long xsryDm, Date ddscsj, Date ddqrsj, Date ddfhsj,
			Date ddzfsj)
	{
		this.ddxh = ddxh;
		this.qdsDm = qdsDm;
		this.ddzje = ddzje;
		this.ddzjeGj = ddzjeGj;
		this.ddzt = ddzt;
		this.xsryDm = xsryDm;
		this.ddscsj = ddscsj;
		this.ddqrsj = ddqrsj;
		this.ddfhsj = ddfhsj;
		this.ddzfsj = ddzfsj;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ddid", unique = true, nullable = false)
	public Integer getDdid()
	{
		return this.ddid;
	}

	public void setDdid(Integer ddid)
	{
		this.ddid = ddid;
	}

	@Column(name = "ddxh", length = 20)
	public String getDdxh()
	{
		return this.ddxh;
	}

	public void setDdxh(String ddxh)
	{
		this.ddxh = ddxh;
	}

	@Column(name = "qds_dm")
	public Long getQdsDm()
	{
		return this.qdsDm;
	}

	public void setQdsDm(Long qdsDm)
	{
		this.qdsDm = qdsDm;
	}

	@Column(name = "ddzje", precision = 10)
	public Double getDdzje()
	{
		return this.ddzje;
	}

	public void setDdzje(Double ddzje)
	{
		this.ddzje = ddzje;
	}

	@Column(name = "ddzje_gj", precision = 10)
	public Double getDdzjeGj()
	{
		return this.ddzjeGj;
	}

	public void setDdzjeGj(Double ddzjeGj)
	{
		this.ddzjeGj = ddzjeGj;
	}

	@Column(name = "ddzt", length = 2)
	public String getDdzt()
	{
		return this.ddzt;
	}

	public void setDdzt(String ddzt)
	{
		this.ddzt = ddzt;
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

	@Column(name = "ddscsj", length = 19)
	public Date getDdscsj()
	{
		return this.ddscsj;
	}

	public void setDdscsj(Date ddscsj)
	{
		this.ddscsj = ddscsj;
	}

	@Column(name = "ddqrsj", length = 19)
	public Date getDdqrsj()
	{
		return this.ddqrsj;
	}

	public void setDdqrsj(Date ddqrsj)
	{
		this.ddqrsj = ddqrsj;
	}

	@Column(name = "ddfhsj", length = 19)
	public Date getDdfhsj()
	{
		return this.ddfhsj;
	}

	public void setDdfhsj(Date ddfhsj)
	{
		this.ddfhsj = ddfhsj;
	}

	@Column(name = "ddzfsj", length = 19)
	public Date getDdzfsj()
	{
		return this.ddzfsj;
	}

	public void setDdzfsj(Date ddzfsj)
	{
		this.ddzfsj = ddzfsj;
	}

}