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

import cn.com.bonde.b2b.website.dao.ICatalogDao;
import cn.com.bonde.b2b.website.entity.DmSpfl;
import cn.com.bonde.b2b.website.service.BaseCodeService;
import cn.com.bonde.b2b.website.service.ICatalogService;

import com.google.gson.Gson;

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
	public String queryCatalog(String spfl_dm)throws Exception
	{
		log.info("商品大类【"+spfl_dm+"】");
		List<DmSpfl> list = BaseCodeService.getSpflList();
		if(list==null||list.size()==0){
			log.info("系统内存中找不到具体的商品分类结构");
			return "";
		}else{
			int catanum=list.size();
			Map<String, Map> catlogMap=new HashMap<String, Map>();
			//先整理一级分类组成的Map
			for (int i=0; i<catanum; i++){
				DmSpfl spfl=list.get(i);
				if (String.valueOf(spfl.getSjSpflDm()).equals(spfl_dm)){
					Map dlMap=new HashMap();  //构造一级分类的map对象
					dlMap.put("dldm", spfl.getSpflDm());  //大类代码
					dlMap.put("dlmc", spfl.getSpflMc());  //大类名称
					dlMap.put("xllb", new ArrayList());   //小类列表	 
					catlogMap.put(String.valueOf(spfl.getSpflDm()), dlMap);
				}
			}
			//再整理二级分类，更细的分类直接就丢弃了
			for (int i=0; i<catanum; i++){
				DmSpfl spfl=list.get(i);
				String tmpsjfldm=String.valueOf(spfl.getSjSpflDm());
				if (catlogMap.containsKey(tmpsjfldm)){
					Map dlMap=catlogMap.get(tmpsjfldm);
					((ArrayList)dlMap.get("xllb")).add(spfl);  //将匹配的分类对象添加到小类列表中
				}
			}
			//将分类Map转成分类树
			List<Map> catlogTree=new ArrayList();
			Iterator<String> iterator = catlogMap.keySet().iterator();
	        while (iterator.hasNext()) {
	        	catlogTree.add(catlogMap.get(iterator.next()));
	        }
	        HashMap resultMap=new HashMap();
	        resultMap.put("catlogTree", catlogTree);
			//根据组织好的分类树，转成Json串
			Gson gson=new Gson();
	        String catlogStr=gson.toJson(resultMap);
			log.info(catlogStr);
			return catlogStr;
		}
		
	}


}
