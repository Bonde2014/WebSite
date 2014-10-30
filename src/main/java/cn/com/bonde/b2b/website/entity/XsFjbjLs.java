package cn.com.bonde.b2b.website.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * XsFjbjLs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "xs_fjbj_ls", catalog = "b2b")
public class XsFjbjLs implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private Long bjxh;
	private Long spDm;
	private Long jg1;
	private Long jg2;
	private Long jg3;
	private Long jg0;
	private Timestamp bjsj;
	private Long bjryDm;

	// Constructors

	/** default constructor */
	public XsFjbjLs()
	{
	}

	/** full constructor */
	public XsFjbjLs(Long spDm, Long jg1, Long jg2, Long jg3, Long jg0, Timestamp bjsj, Long bjryDm)
	{
		this.spDm = spDm;
		this.jg1 = jg1;
		this.jg2 = jg2;
		this.jg3 = jg3;
		this.jg0 = jg0;
		this.bjsj = bjsj;
		this.bjryDm = bjryDm;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "bjxh", unique = true, nullable = false)
	public Long getBjxh()
	{
		return this.bjxh;
	}

	public void setBjxh(Long bjxh)
	{
		this.bjxh = bjxh;
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

	@Column(name = "jg1", precision = 10, scale = 0)
	public Long getJg1()
	{
		return this.jg1;
	}

	public void setJg1(Long jg1)
	{
		this.jg1 = jg1;
	}

	@Column(name = "jg2", precision = 10, scale = 0)
	public Long getJg2()
	{
		return this.jg2;
	}

	public void setJg2(Long jg2)
	{
		this.jg2 = jg2;
	}

	@Column(name = "jg3", precision = 10, scale = 0)
	public Long getJg3()
	{
		return this.jg3;
	}

	public void setJg3(Long jg3)
	{
		this.jg3 = jg3;
	}

	@Column(name = "jg0", precision = 10, scale = 0)
	public Long getJg0()
	{
		return this.jg0;
	}

	public void setJg0(Long jg0)
	{
		this.jg0 = jg0;
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

	@Column(name = "bjry_dm")
	public Long getBjryDm()
	{
		return this.bjryDm;
	}

	public void setBjryDm(Long bjryDm)
	{
		this.bjryDm = bjryDm;
	}

}