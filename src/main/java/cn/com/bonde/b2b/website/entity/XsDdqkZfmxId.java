package cn.com.bonde.b2b.website.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * XsDdqkZfmxId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class XsDdqkZfmxId implements java.io.Serializable
{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ddid;
	private Integer xxh;

	// Constructors

	/** default constructor */
	public XsDdqkZfmxId()
	{
	}

	/** full constructor */
	public XsDdqkZfmxId(Integer ddid, Integer xxh)
	{
		this.ddid = ddid;
		this.xxh = xxh;
	}

	// Property accessors

	@Column(name = "ddid", nullable = false)
	public Integer getDdid()
	{
		return this.ddid;
	}

	public void setDdid(Integer ddid)
	{
		this.ddid = ddid;
	}

	@Column(name = "xxh", nullable = false)
	public Integer getXxh()
	{
		return this.xxh;
	}

	public void setXxh(Integer xxh)
	{
		this.xxh = xxh;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof XsDdqkZfmxId))
			return false;
		XsDdqkZfmxId castOther = (XsDdqkZfmxId) other;

		return ((this.getDdid() == castOther.getDdid()) || (this.getDdid() != null && castOther.getDdid() != null && this.getDdid().equals(castOther.getDdid())))
				&& ((this.getXxh() == castOther.getXxh()) || (this.getXxh() != null && castOther.getXxh() != null && this.getXxh().equals(castOther.getXxh())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getDdid() == null ? 0 : this.getDdid().hashCode());
		result = 37 * result + (getXxh() == null ? 0 : this.getXxh().hashCode());
		return result;
	}

}