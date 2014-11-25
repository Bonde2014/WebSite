/**
 * 
 */
package cn.com.bonde.b2b.website.entity.findEntity;

/**
 * @author Administrator
 *
 */
public class SupplySelfFindEntity extends BaseFindEntity
{
 	 
    private Long spflDm;  //商品分类代码
    
	 private Long spppDm;  //商品品牌代码
	 
	 private Long ghsDm;   //供货商代码
    
    public Long getSpflDm() {
		return spflDm;
	}

	public void setSpflDm(Long spflDm) {
		this.spflDm = spflDm;
	}

	public Long getSpppDm() {
		return spppDm;
	}

	public void setSpppDm(Long spppDm) {
		this.spppDm = spppDm;
	}

	public Long getGhsDm() {
		return ghsDm;
	}

	public void setGhsDm(Long ghsDm) {
		this.ghsDm = ghsDm;
	}


}
