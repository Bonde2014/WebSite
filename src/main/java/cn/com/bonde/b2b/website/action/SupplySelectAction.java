package cn.com.bonde.b2b.website.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import cn.com.bonde.b2b.website.entity.CgGhsSpmx;
import cn.com.bonde.b2b.website.entity.QxKhxx;
import cn.com.bonde.b2b.website.entity.findEntity.SearchFindEntity;
import cn.com.bonde.b2b.website.entity.findEntity.SupplyListFindEntity;
import cn.com.bonde.b2b.website.entity.findEntity.SupplySelfFindEntity;

import cn.com.bonde.b2b.website.service.ISupplySelfService;

import cn.com.bonde.b2b.website.util.Constants;
import cn.com.bonde.b2b.website.util.MyException;
import cn.com.bonde.b2b.website.util.Pager;


/**
 * @author Administrator
 * <p>功能描述: 供货商选择商品放入自己的货架、整理自己的货架</p>
 */

@Controller
@Scope("prototype")
@ParentPackage(value = "base")
@Namespace(value = "/")
@Results({ @Result(name = "success", location = "/pages/index.jsp") ,
    @Result(name = "supplyProducts", location = "/pages/supply.jsp"),
    @Result(name = "supplyManage", location = "/pages/supplymanage.jsp")
    })
public class SupplySelectAction extends ProjectBaseAction
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5748465179322729840L;
	
	private Log log = LogFactory.getLog(SupplySelectAction.class);

	@Resource(name = "supplySelfService")
	private ISupplySelfService supplyService;


	public ISupplySelfService getSupplyService() {
		return supplyService;
	}

	public void setSupplyService(ISupplySelfService supplyService) {
		this.supplyService = supplyService;
	}

	private Long spflDm;  //页面传递的商品分类代码
	private Long spppDm;  //页面传递的商品品牌代码
	private Long ghsDm;   //供货商代码  无须从前端传入，直接从session中取即可
	private List<Long> spdms; //待加入货架的商品代码列表
	private Long ghxh;    //待修改的供货序号
	
	private Pager  pager;  //分页属性
	private SupplySelfFindEntity findEntity; //查询待选商品的条件实体
	private SupplyListFindEntity supplyfindEntity;  //查询货架信息的条件实体
	

	public SupplySelfFindEntity getFindEntity() {
		return findEntity;
	}

	public void setFindEntity(SupplySelfFindEntity findEntity) {
		this.findEntity = findEntity;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	/**
	 * 选择待放入货架的商品信息，货架里已有的商品要过滤掉
	 */
	@Action(value = "selectSupply")
	public String selectSupply() throws Exception
	{       
		    Long ghsdm=((QxKhxx)this.getSession().getAttribute(Constants.SESSION_KHXX)).getKhDm();
            log.info("开始查询待放入货架的商品信息【spflDm="+spflDm+", spppDm="+spppDm+", ghsDm="+ghsdm+", currpage="+findEntity.getPage()+"】...");
		    findEntity.setSpflDm(spflDm);
		    findEntity.setSpppDm(spppDm);
		    findEntity.setGhsDm(ghsdm);
			findEntity.setRows(30);  //每页条数
			pager = supplyService.querySupplyProducts(findEntity);
			return "supplyProducts";
			//有几种做法：struts 跳转+标签   、easyuijson+ easyui.datagrid  、 json+ table+js  
			//String jsonString = EasyUIJsonUtil.getEasyUIJsonStr(pager);  //页面能否基于这个进行分页展示？ 
			//String jsonString =JsonUtil.getJsonFromObject(pager);
			//WriteJsonToPage.WriteJson(jsonString);  
	}

	/**
	 * 将一批商品放入货架
	 */
	@Action(value = "addSupply")
	public String addSupply() throws Exception
	{
		Long ghsdm=((QxKhxx)this.getSession().getAttribute(Constants.SESSION_KHXX)).getKhDm();
		log.info("开始将商品列表"+spdms+"放入[ghsdm="+ghsdm+"]的货架...");
		supplyService.addProduct2Supply(spdms, ghsdm);
        //暂不考虑失败时如何跳转
		//return "supplyManageInit";  //跳转到forward太麻烦，直接方法调用
		return supplyManageInit();
	}

	/**
	 * 查询某供货商的货架
	 */
	@Action(value = "supplyManageInit")
	public String supplyManageInit() throws Exception
	{
		Long ghsdm=((QxKhxx)this.getSession().getAttribute(Constants.SESSION_KHXX)).getKhDm();
		log.info("开始查询[ghsdm="+ghsdm+"]的货架...");
        if (supplyfindEntity == null) {
        	supplyfindEntity = new SupplyListFindEntity();
        }
		supplyfindEntity.setGhsDm(ghsdm);
		supplyfindEntity.setRows(30);  //每页条数
		pager=supplyService.querySupplyList(supplyfindEntity);  
        //暂不考虑失败时如何跳转
		return "supplyManage";  //跳转到货架管理页面
	}
    
    /**
     * @return the spflDm
     */
    public Long getSpflDm() {
        return spflDm;
    }

    
    /**
     * @param spflDm the spflDm to set
     */
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

	public List<Long> getSpdms() {
		return spdms;
	}

	public void setSpdms(List<Long> spdms) {
		this.spdms = spdms;
	}

	public SupplyListFindEntity getSupplyfindEntity() {
		return supplyfindEntity;
	}

	public void setSupplyfindEntity(SupplyListFindEntity supplyfindEntity) {
		this.supplyfindEntity = supplyfindEntity;
	}

	public Long getGhxh() {
		return ghxh;
	}

	public void setGhxh(Long ghxh) {
		this.ghxh = ghxh;
	}
	
}
