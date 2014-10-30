package cn.com.bonde.b2b.website.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * QxQdsXsry entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "qx_qds_xsry", catalog = "b2b")
public class QxQdsXsry implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private QxQdsXsryId id;

	// Constructors

	/** default constructor */
	public QxQdsXsry()
	{
	}

	/** full constructor */
	public QxQdsXsry(QxQdsXsryId id)
	{
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "qdsDm", column = @Column(name = "qds_dm", nullable = false)),
			@AttributeOverride(name = "xsryDm", column = @Column(name = "xsry_dm", nullable = false)) })
	public QxQdsXsryId getId()
	{
		return this.id;
	}

	public void setId(QxQdsXsryId id)
	{
		this.id = id;
	}

}