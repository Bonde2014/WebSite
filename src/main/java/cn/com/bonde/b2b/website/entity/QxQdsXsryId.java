package cn.com.bonde.b2b.website.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * QxQdsXsryId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class QxQdsXsryId implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private Long qdsDm;
	private Long xsryDm;

	// Constructors

	/** default constructor */
	public QxQdsXsryId()
	{
	}

	/** full constructor */
	public QxQdsXsryId(Long qdsDm, Long xsryDm)
	{
		this.qdsDm = qdsDm;
		this.xsryDm = xsryDm;
	}

	// Property accessors

	@Column(name = "qds_dm", nullable = false)
	public Long getQdsDm()
	{
		return this.qdsDm;
	}

	public void setQdsDm(Long qdsDm)
	{
		this.qdsDm = qdsDm;
	}

	@Column(name = "xsry_dm", nullable = false)
	public Long getXsryDm()
	{
		return this.xsryDm;
	}

	public void setXsryDm(Long xsryDm)
	{
		this.xsryDm = xsryDm;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof QxQdsXsryId))
			return false;
		QxQdsXsryId castOther = (QxQdsXsryId) other;

		return ((this.getQdsDm() == castOther.getQdsDm()) || (this.getQdsDm() != null && castOther.getQdsDm() != null && this.getQdsDm().equals(
				castOther.getQdsDm())))
				&& ((this.getXsryDm() == castOther.getXsryDm()) || (this.getXsryDm() != null && castOther.getXsryDm() != null && this.getXsryDm().equals(
						castOther.getXsryDm())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getQdsDm() == null ? 0 : this.getQdsDm().hashCode());
		result = 37 * result + (getXsryDm() == null ? 0 : this.getXsryDm().hashCode());
		return result;
	}

}