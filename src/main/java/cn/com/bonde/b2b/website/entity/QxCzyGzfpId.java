package cn.com.bonde.b2b.website.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * QxCzyGzfpId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class QxCzyGzfpId implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private Long czyDm;
	private String gwDm;
	private Long jsDm;

	// Constructors

	/** default constructor */
	public QxCzyGzfpId()
	{
	}

	/** full constructor */
	public QxCzyGzfpId(Long czyDm, String gwDm, Long jsDm)
	{
		this.czyDm = czyDm;
		this.gwDm = gwDm;
		this.jsDm = jsDm;
	}

	// Property accessors

	@Column(name = "czy_dm", nullable = false)
	public Long getCzyDm()
	{
		return this.czyDm;
	}

	public void setCzyDm(Long czyDm)
	{
		this.czyDm = czyDm;
	}

	@Column(name = "gw_dm", nullable = false, length = 2)
	public String getGwDm()
	{
		return this.gwDm;
	}

	public void setGwDm(String gwDm)
	{
		this.gwDm = gwDm;
	}

	@Column(name = "js_dm", nullable = false)
	public Long getJsDm()
	{
		return this.jsDm;
	}

	public void setJsDm(Long jsDm)
	{
		this.jsDm = jsDm;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof QxCzyGzfpId))
			return false;
		QxCzyGzfpId castOther = (QxCzyGzfpId) other;

		return ((this.getCzyDm() == castOther.getCzyDm()) || (this.getCzyDm() != null && castOther.getCzyDm() != null && this.getCzyDm().equals(
				castOther.getCzyDm())))
				&& ((this.getGwDm() == castOther.getGwDm()) || (this.getGwDm() != null && castOther.getGwDm() != null && this.getGwDm().equals(
						castOther.getGwDm())))
				&& ((this.getJsDm() == castOther.getJsDm()) || (this.getJsDm() != null && castOther.getJsDm() != null && this.getJsDm().equals(
						castOther.getJsDm())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getCzyDm() == null ? 0 : this.getCzyDm().hashCode());
		result = 37 * result + (getGwDm() == null ? 0 : this.getGwDm().hashCode());
		result = 37 * result + (getJsDm() == null ? 0 : this.getJsDm().hashCode());
		return result;
	}

}