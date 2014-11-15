/**
 * 
 */
package cn.com.bonde.b2b.website.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.com.bonde.b2b.website.dao.ICatalogDao;
import cn.com.bonde.b2b.website.entity.DmSpfl;
import cn.com.bonde.b2b.website.service.BaseCodeService;
import cn.com.bonde.b2b.website.service.ICatalogService;
import cn.com.bonde.b2b.website.util.JsonUtil;

/**
 * @author Administrator
 *
 */
@Service(value = "catalogService")
public class CatalogSevriceImpl implements ICatalogService
{
	private Log log = LogFactory.getLog(CatalogSevriceImpl.class);
	
	@Resource(name="catalogDao")
	private ICatalogDao catalogDao;
	

	public ICatalogDao getCatalogDao() {
		return catalogDao;
	}


	public void setCatalogDao(ICatalogDao catalogDao) {
		this.catalogDao = catalogDao;
	}


	@Override
	public String queryCatalog(Long spflDm) throws Exception
	{
		log.info("商品大类【"+spflDm+"】");
		 String catlogStr = "";
		List<DmSpfl> list = BaseCodeService.getSpflList();
		if(!CollectionUtils.isEmpty(list)){
			int catanum=list.size();
			Map<Long, Map<String,Object>> catlogMap=new HashMap<Long, Map<String,Object>>();
			//先整理一级分类组成的Map
			for (int i=0; i<catanum; i++){
				DmSpfl spfl=list.get(i);
				if ((spfl.getSjSpflDm()==null&&spflDm==null)||(spflDm!=null&&spflDm.equals(spfl.getSjSpflDm()))){
				    Map<String,Object> dlMap=new HashMap<String,Object>();  //构造一级分类的map对象
					dlMap.put("dldm", spfl.getSpflDm());  //大类代码
					dlMap.put("dlmc", spfl.getSpflMc());  //大类名称
					dlMap.put("xllb", new ArrayList<DmSpfl>());   //小类列表	 
					catlogMap.put(spfl.getSpflDm(), dlMap);
				}
			}
			//再整理二级分类，更细的分类直接就丢弃了
			for(DmSpfl spfl : list){
			    if (catlogMap.containsKey(spfl.getSjSpflDm())){
                    ((ArrayList)catlogMap.get(spfl.getSjSpflDm()).get("xllb")).add(spfl);  //将匹配的分类对象添加到小类列表中
                }
			}
			//根据组织好的分类树，转成Json串
			List<Map<String,Object>> resutList = new ArrayList<Map<String,Object>>();
			Iterator<Long> iterator = catlogMap.keySet().iterator();
			while(iterator.hasNext()){
			    resutList.add(catlogMap.get(iterator.next()));
			}
			catlogStr = JsonUtil.getJsonFromObject(resutList);
		}
		return catlogStr;
	}

}
