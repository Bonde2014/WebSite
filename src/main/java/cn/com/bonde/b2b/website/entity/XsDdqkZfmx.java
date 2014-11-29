package cn.com.bonde.b2b.website.entity;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * XsDdqkZfmx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "xs_ddqk_zfmx", catalog = "b2b")
public class XsDdqkZfmx implements java.io.Serializable
{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private XsDdqkZfmxId id;
	private String zffsDm;
	private String yhzhPt;
	private Long fkzhQds;
	private Double zfje;
	private Timestamp zfsj;
	private String zfbz;

	// Constructors

	/** default constructor */
	public XsDdqkZfmx()
	{
	}

	/** minimal constructor */
	public XsDdqkZfmx(XsDdqkZfmxId id)
	{
		this.id = id;
	}

	/** full constructor */
	public XsDdqkZfmx(XsDdqkZfmxId id, String zffsDm, String yhzhPt, Long fkzhQds, Double zfje, Timestamp zfsj, String zfbz)
	{
		this.id = id;
		this.zffsDm = zffsDm;
		this.yhzhPt = yhzhPt;
		this.fkzhQds = fkzhQds;
		this.zfje = zfje;
		this.zfsj = zfsj;
		this.zfbz = zfbz;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "ddid", column = @Column(name = "ddid", nullable = false)),
			@AttributeOverride(name = "xxh", column = @Column(name = "xxh", nullable = false)) })
	public XsDdqkZfmxId getId()
	{
		return this.id;
	}

	public void setId(XsDdqkZfmxId id)
	{
		this.id = id;
	}

	@Column(name = "zffs_dm", length = 2)
	public String getZffsDm()
	{
		return this.zffsDm;
	}

	public void setZffsDm(String zffsDm)
	{
		this.zffsDm = zffsDm;
	}

	@Column(name = "yhzh_pt", length = 20)
	public String getYhzhPt()
	{
		return this.yhzhPt;
	}

	public void setYhzhPt(String yhzhPt)
	{
		this.yhzhPt = yhzhPt;
	}

	@Column(name = "fkzh_qds")
	public Long getFkzhQds()
	{
		return this.fkzhQds;
	}

	public void setFkzhQds(Long fkzhQds)
	{
		this.fkzhQds = fkzhQds;
	}

	@Column(name = "zfje", precision = 10)
	public Double getZfje()
	{
		return this.zfje;
	}

	public void setZfje(Double zfje)
	{
		this.zfje = zfje;
	}

	@Column(name = "zfsj", length = 19)
	public Timestamp getZfsj()
	{
		return this.zfsj;
	}

	public void setZfsj(Timestamp zfsj)
	{
		this.zfsj = zfsj;
	}

	@Column(name = "zfbz", length = 50)
	public String getZfbz()
	{
		return this.zfbz;
	}

	public void setZfbz(String zfbz)
	{
		this.zfbz = zfbz;
	}

}