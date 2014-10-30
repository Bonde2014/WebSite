package cn.com.bonde.b2b.website.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SpGgcsBjb entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sp_ggcs_bjb", catalog = "b2b")
public class SpGgcsBjb implements java.io.Serializable
{

	// Fields
	private static final long serialVersionUID = 1461965188817873018L;
	private Long spDm;
	private String cpu;
	private String mem;
	private String disk;
	private String size;
	private String weight;
	private String display;

	// Constructors

	/** default constructor */
	public SpGgcsBjb()
	{
	}

	/** full constructor */
	public SpGgcsBjb(String cpu, String mem, String disk, String size, String weight, String display)
	{
		this.cpu = cpu;
		this.mem = mem;
		this.disk = disk;
		this.size = size;
		this.weight = weight;
		this.display = display;
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

	@Column(name = "cpu", length = 40)
	public String getCpu()
	{
		return this.cpu;
	}

	public void setCpu(String cpu)
	{
		this.cpu = cpu;
	}

	@Column(name = "mem", length = 40)
	public String getMem()
	{
		return this.mem;
	}

	public void setMem(String mem)
	{
		this.mem = mem;
	}

	@Column(name = "disk", length = 40)
	public String getDisk()
	{
		return this.disk;
	}

	public void setDisk(String disk)
	{
		this.disk = disk;
	}

	@Column(name = "size", length = 40)
	public String getSize()
	{
		return this.size;
	}

	public void setSize(String size)
	{
		this.size = size;
	}

	@Column(name = "weight", length = 40)
	public String getWeight()
	{
		return this.weight;
	}

	public void setWeight(String weight)
	{
		this.weight = weight;
	}

	@Column(name = "display", length = 40)
	public String getDisplay()
	{
		return this.display;
	}

	public void setDisplay(String display)
	{
		this.display = display;
	}

}