package cn.com.bonde.b2b.website.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * XsGwcId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class XsGwcId implements java.io.Serializable
{

	// Fields

	private Long khDm;
	private Long spDm;

	// Constructors

	/** default constructor */
	public XsGwcId()
	{
	}

	/** full constructor */
	public XsGwcId(Long khDm, Long spDm)
	{
		this.khDm = khDm;
		this.spDm = spDm;
	}

	// Property accessors

	@Column(name = "kh_dm", nullable = false)
	public Long getKhDm()
	{
		return this.khDm;
	}

	public void setKhDm(Long khDm)
	{
		this.khDm = khDm;
	}

	@Column(name = "sp_dm", nullable = false)
	public Long getSpDm()
	{
		return this.spDm;
	}

	public void setSpDm(Long spDm)
	{
		this.spDm = spDm;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof XsGwcId))
			return false;
		XsGwcId castOther = (XsGwcId) other;

		return ((this.getKhDm() == castOther.getKhDm()) || (this.getKhDm() != null && castOther.getKhDm() != null && this.getKhDm().equals(castOther.getKhDm())))
				&& ((this.getSpDm() == castOther.getSpDm()) || (this.getSpDm() != null && castOther.getSpDm() != null && this.getSpDm().equals(
						castOther.getSpDm())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getKhDm() == null ? 0 : this.getKhDm().hashCode());
		result = 37 * result + (getSpDm() == null ? 0 : this.getSpDm().hashCode());
		return result;
	}

}