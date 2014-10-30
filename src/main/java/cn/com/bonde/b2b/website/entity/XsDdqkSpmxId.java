package cn.com.bonde.b2b.website.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * XsDdqkSpmxId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class XsDdqkSpmxId implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private Long ddxh;
	private Integer xxh;

	// Constructors

	/** default constructor */
	public XsDdqkSpmxId()
	{
	}

	/** full constructor */
	public XsDdqkSpmxId(Long ddxh, Integer xxh)
	{
		this.ddxh = ddxh;
		this.xxh = xxh;
	}

	// Property accessors

	@Column(name = "ddxh", nullable = false)
	public Long getDdxh()
	{
		return this.ddxh;
	}

	public void setDdxh(Long ddxh)
	{
		this.ddxh = ddxh;
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
		if (!(other instanceof XsDdqkSpmxId))
			return false;
		XsDdqkSpmxId castOther = (XsDdqkSpmxId) other;

		return ((this.getDdxh() == castOther.getDdxh()) || (this.getDdxh() != null && castOther.getDdxh() != null && this.getDdxh().equals(castOther.getDdxh())))
				&& ((this.getXxh() == castOther.getXxh()) || (this.getXxh() != null && castOther.getXxh() != null && this.getXxh().equals(castOther.getXxh())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getDdxh() == null ? 0 : this.getDdxh().hashCode());
		result = 37 * result + (getXxh() == null ? 0 : this.getXxh().hashCode());
		return result;
	}

}