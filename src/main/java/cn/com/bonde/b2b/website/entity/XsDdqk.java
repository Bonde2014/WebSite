package cn.com.bonde.b2b.website.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * XsDdqk entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "xs_ddqk", catalog = "b2b")
public class XsDdqk implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private Long ddxh;
	private Long qdsDm;
	private Long ddzje;
	private Long ddzjeGj;
	private String ddzt;
	private Long xsryDm;
	private Timestamp ddscsj;
	private Timestamp ddqrsj;
	private Timestamp ddfhsj;
	private Timestamp ddzfsj;

	// Constructors

	/** default constructor */
	public XsDdqk()
	{
	}

	/** full constructor */
	public XsDdqk(Long qdsDm, Long ddzje, Long ddzjeGj, String ddzt, Long xsryDm, Timestamp ddscsj, Timestamp ddqrsj, Timestamp ddfhsj, Timestamp ddzfsj)
	{
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
	@Column(name = "ddxh", unique = true, nullable = false)
	public Long getDdxh()
	{
		return this.ddxh;
	}

	public void setDdxh(Long ddxh)
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

	@Column(name = "ddzje", precision = 10, scale = 0)
	public Long getDdzje()
	{
		return this.ddzje;
	}

	public void setDdzje(Long ddzje)
	{
		this.ddzje = ddzje;
	}

	@Column(name = "ddzje_gj", precision = 10, scale = 0)
	public Long getDdzjeGj()
	{
		return this.ddzjeGj;
	}

	public void setDdzjeGj(Long ddzjeGj)
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

	@Column(name = "ddscsj", length = 50)
	public Timestamp getDdscsj()
	{
		return this.ddscsj;
	}

	public void setDdscsj(Timestamp ddscsj)
	{
		this.ddscsj = ddscsj;
	}

	@Column(name = "ddqrsj", length = 19)
	public Timestamp getDdqrsj()
	{
		return this.ddqrsj;
	}

	public void setDdqrsj(Timestamp ddqrsj)
	{
		this.ddqrsj = ddqrsj;
	}

	@Column(name = "ddfhsj", length = 19)
	public Timestamp getDdfhsj()
	{
		return this.ddfhsj;
	}

	public void setDdfhsj(Timestamp ddfhsj)
	{
		this.ddfhsj = ddfhsj;
	}

	@Column(name = "ddzfsj", length = 19)
	public Timestamp getDdzfsj()
	{
		return this.ddzfsj;
	}

	public void setDdzfsj(Timestamp ddzfsj)
	{
		this.ddzfsj = ddzfsj;
	}

}