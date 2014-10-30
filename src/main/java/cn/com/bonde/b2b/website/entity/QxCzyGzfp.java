package cn.com.bonde.b2b.website.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * QxCzyGzfp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "qx_czy_gzfp", catalog = "b2b")
public class QxCzyGzfp implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private QxCzyGzfpId id;

	// Constructors

	/** default constructor */
	public QxCzyGzfp()
	{
	}

	/** full constructor */
	public QxCzyGzfp(QxCzyGzfpId id)
	{
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "czyDm", column = @Column(name = "czy_dm", nullable = false)),
			@AttributeOverride(name = "gwDm", column = @Column(name = "gw_dm", nullable = false, length = 2)),
			@AttributeOverride(name = "jsDm", column = @Column(name = "js_dm", nullable = false)) })
	public QxCzyGzfpId getId()
	{
		return this.id;
	}

	public void setId(QxCzyGzfpId id)
	{
		this.id = id;
	}

}