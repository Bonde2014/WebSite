package cn.com.bonde.b2b.website.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CgCgqkSpmxId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class CgCgqkSpmxId implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private Long cgxh;
	private Integer ghxh;

	// Constructors

	/** default constructor */
	public CgCgqkSpmxId()
	{
	}

	/** full constructor */
	public CgCgqkSpmxId(Long cgxh, Integer ghxh)
	{
		this.cgxh = cgxh;
		this.ghxh = ghxh;
	}

	// Property accessors

	@Column(name = "cgxh", nullable = false)
	public Long getCgxh()
	{
		return this.cgxh;
	}

	public void setCgxh(Long cgxh)
	{
		this.cgxh = cgxh;
	}

	@Column(name = "ghxh", nullable = false)
	public Integer getGhxh()
	{
		return this.ghxh;
	}

	public void setGhxh(Integer ghxh)
	{
		this.ghxh = ghxh;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CgCgqkSpmxId))
			return false;
		CgCgqkSpmxId castOther = (CgCgqkSpmxId) other;

		return ((this.getCgxh() == castOther.getCgxh()) || (this.getCgxh() != null && castOther.getCgxh() != null && this.getCgxh().equals(castOther.getCgxh())))
				&& ((this.getGhxh() == castOther.getGhxh()) || (this.getGhxh() != null && castOther.getGhxh() != null && this.getGhxh().equals(
						castOther.getGhxh())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getCgxh() == null ? 0 : this.getCgxh().hashCode());
		result = 37 * result + (getGhxh() == null ? 0 : this.getGhxh().hashCode());
		return result;
	}

}