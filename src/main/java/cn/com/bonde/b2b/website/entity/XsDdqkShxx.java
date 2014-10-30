package cn.com.bonde.b2b.website.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * XsDdqkShxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "xs_ddqk_shxx", catalog = "b2b")
public class XsDdqkShxx implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private Long ddxh;
	private String fhfsDm;
	private String shrXm;
	private String shrDh;
	private String shrDz;

	// Constructors

	/** default constructor */
	public XsDdqkShxx()
	{
	}

	/** full constructor */
	public XsDdqkShxx(String fhfsDm, String shrXm, String shrDh, String shrDz)
	{
		this.fhfsDm = fhfsDm;
		this.shrXm = shrXm;
		this.shrDh = shrDh;
		this.shrDz = shrDz;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ddxh", unique = true, nullable = false)
	public Long getDdxh()
	{
		return this.ddxh;
	}

	public void setDdxh(Long ddxh)
	{
		this.ddxh = ddxh;
	}

	@Column(name = "fhfs_dm", length = 2)
	public String getFhfsDm()
	{
		return this.fhfsDm;
	}

	public void setFhfsDm(String fhfsDm)
	{
		this.fhfsDm = fhfsDm;
	}

	@Column(name = "shr_xm", length = 30)
	public String getShrXm()
	{
		return this.shrXm;
	}

	public void setShrXm(String shrXm)
	{
		this.shrXm = shrXm;
	}

	@Column(name = "shr_dh", length = 12)
	public String getShrDh()
	{
		return this.shrDh;
	}

	public void setShrDh(String shrDh)
	{
		this.shrDh = shrDh;
	}

	@Column(name = "shr_dz", length = 100)
	public String getShrDz()
	{
		return this.shrDz;
	}

	public void setShrDz(String shrDz)
	{
		this.shrDz = shrDz;
	}

}