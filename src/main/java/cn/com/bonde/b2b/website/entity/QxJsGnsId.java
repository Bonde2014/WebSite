package cn.com.bonde.b2b.website.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * QxJsGnsId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class QxJsGnsId implements java.io.Serializable
{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1461965188817873018L;
	private Long jsDm;
	private String gnsDm;

	// Constructors

	/** default constructor */
	public QxJsGnsId()
	{
	}

	/** full constructor */
	public QxJsGnsId(Long jsDm, String gnsDm)
	{
		this.jsDm = jsDm;
		this.gnsDm = gnsDm;
	}

	// Property accessors

	@Column(name = "js_dm", nullable = false)
	public Long getJsDm()
	{
		return this.jsDm;
	}

	public void setJsDm(Long jsDm)
	{
		this.jsDm = jsDm;
	}

	@Column(name = "gns_dm", nullable = false, length = 6)
	public String getGnsDm()
	{
		return this.gnsDm;
	}

	public void setGnsDm(String gnsDm)
	{
		this.gnsDm = gnsDm;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof QxJsGnsId))
			return false;
		QxJsGnsId castOther = (QxJsGnsId) other;

		return ((this.getJsDm() == castOther.getJsDm()) || (this.getJsDm() != null && castOther.getJsDm() != null && this.getJsDm().equals(castOther.getJsDm())))
				&& ((this.getGnsDm() == castOther.getGnsDm()) || (this.getGnsDm() != null && castOther.getGnsDm() != null && this.getGnsDm().equals(
						castOther.getGnsDm())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getJsDm() == null ? 0 : this.getJsDm().hashCode());
		result = 37 * result + (getGnsDm() == null ? 0 : this.getGnsDm().hashCode());
		return result;
	}

}