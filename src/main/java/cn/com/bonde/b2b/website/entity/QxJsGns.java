package cn.com.bonde.b2b.website.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * QxJsGns entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "qx_js_gns", catalog = "b2b")
public class QxJsGns implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private QxJsGnsId id;

	// Constructors

	/** default constructor */
	public QxJsGns()
	{
	}

	/** full constructor */
	public QxJsGns(QxJsGnsId id)
	{
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "jsDm", column = @Column(name = "js_dm", nullable = false)),
			@AttributeOverride(name = "gnsDm", column = @Column(name = "gns_dm", nullable = false, length = 6)) })
	public QxJsGnsId getId()
	{
		return this.id;
	}

	public void setId(QxJsGnsId id)
	{
		this.id = id;
	}

}