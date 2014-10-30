package cn.com.bonde.b2b.website.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SpSpxq entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sp_spxq", catalog = "b2b")
public class SpSpxq implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private Long spDm;
	private String spxqCffs;
	private String spxqFile;
	private String spxq;

	// Constructors

	/** default constructor */
	public SpSpxq()
	{
	}

	/** full constructor */
	public SpSpxq(String spxqCffs, String spxqFile, String spxq)
	{
		this.spxqCffs = spxqCffs;
		this.spxqFile = spxqFile;
		this.spxq = spxq;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sp_dm", unique = true, nullable = false)
	public Long getSpDm()
	{
		return this.spDm;
	}

	public void setSpDm(Long spDm)
	{
		this.spDm = spDm;
	}

	@Column(name = "spxq_cffs", length = 1)
	public String getSpxqCffs()
	{
		return this.spxqCffs;
	}

	public void setSpxqCffs(String spxqCffs)
	{
		this.spxqCffs = spxqCffs;
	}

	@Column(name = "spxq_file", length = 100)
	public String getSpxqFile()
	{
		return this.spxqFile;
	}

	public void setSpxqFile(String spxqFile)
	{
		this.spxqFile = spxqFile;
	}

	@Column(name = "spxq")
	public String getSpxq()
	{
		return this.spxq;
	}

	public void setSpxq(String spxq)
	{
		this.spxq = spxq;
	}

}