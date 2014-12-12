package cn.com.bonde.b2b.website.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.com.bonde.b2b.website.dao.IBaseCodeDao;
import cn.com.bonde.b2b.website.entity.CatalogVO;
import cn.com.bonde.b2b.website.entity.DmSpfl;
import cn.com.bonde.b2b.website.entity.DmSpfl2;

@Service(value = "baseCodeService")
public class BaseCodeService implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger  log = Logger.getLogger(BaseCodeService.class);

    @Resource
    private IBaseCodeDao         baseCodeDao;

    private static List<DmSpfl>  spflList;
    
    private static List<CatalogVO> spflTreeList;

    private static List<DmSpfl2> spfl2List;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {// root application context 没有parent，他就是老大.
            try {
                spflList = baseCodeDao.getEntitiesListByProperties(DmSpfl.class, null);
                spfl2List = baseCodeDao.getEntitiesListByProperties(DmSpfl2.class, null);
                structData();
            } catch (Exception e) {
                log.error("init BaseCodeService error!", e);
            }
        }
    }
    
    private void structData(){
        if(CollectionUtils.isEmpty(spflList)){
           return;
        }
        spflTreeList = new ArrayList<CatalogVO>();
        Map<Long,DmSpfl> rootCatalogMap = new TreeMap<Long, DmSpfl>();
        Map<Long,List<DmSpfl>> map = new HashMap<Long, List<DmSpfl>>();
        for(DmSpfl dmSpfl : spflList){
            Long pid = dmSpfl.getSjSpflDm();
            if(pid==null){
                rootCatalogMap.put(dmSpfl.getSpflDm(),dmSpfl);
                continue;
            }
            List<DmSpfl> list = map.get(dmSpfl.getSjSpflDm());
            if(list==null){
                list = new ArrayList<DmSpfl>();
                map.put(pid, list);
            }
            list.add(dmSpfl);
        }
        //循环rootCatalog
        Iterator<Long> iterator = rootCatalogMap.keySet().iterator();
        while(iterator.hasNext()){
            Long id = iterator.next();
            CatalogVO catalogVO = new CatalogVO();
            catalogVO.setId(id);
            catalogVO.setName(rootCatalogMap.get(id).getSpflMc());
            buildCatalogTree(catalogVO, map.get(id), map);
            spflTreeList.add(catalogVO);
        }
    }
    
    private void buildCatalogTree(CatalogVO vo,List<DmSpfl> list,Map<Long,List<DmSpfl>> map){
        if(!CollectionUtils.isEmpty(list)){
            List<CatalogVO> childList = new ArrayList<CatalogVO>();
            vo.setChildList(childList);
            for(DmSpfl dmSpfl : list){
                CatalogVO catalogVO = new CatalogVO();
                catalogVO.setId(dmSpfl.getSpflDm());
                catalogVO.setName(dmSpfl.getSpflMc());
                childList.add(catalogVO);
                buildCatalogTree(catalogVO, map.get(dmSpfl.getSpflDm()), map);
            }
        }
    }

    /**
     * 商品分类
     * 
     * @return
     */
    public static List<DmSpfl> getSpflList() {
        return spflList;
    }
    
    public static List<CatalogVO> getCatalogTreeList(){
        return spflTreeList;
    }

    /**
     * @param spflDm 根据传入的spflDm获取所有上级,包括自己；
     * @return
     */
    public static List<DmSpfl> getSpflList(Long spflDm) {
        List<DmSpfl> list = new ArrayList<DmSpfl>();
        Long sjSpflDm = spflDm;
        do {
            for (DmSpfl spfl : spflList) {
                if (sjSpflDm.equals(spfl.getSpflDm())) {
                    sjSpflDm = spfl.getSjSpflDm();
                    list.add(spfl);
                    break;
                }
            }
        } while (sjSpflDm != null);
        return list;
    }

    /**
     * 品牌分类
     * 
     * @return
     */
    public static List<DmSpfl2> getPpflList() {
        return spfl2List;
    }

    /**
     * @return the baseCodeDao
     */
    public IBaseCodeDao getBaseCodeDao() {
        return baseCodeDao;
    }

    /**
     * @param baseCodeDao the baseCodeDao to set
     */
    public void setBaseCodeDao(IBaseCodeDao baseCodeDao) {
        this.baseCodeDao = baseCodeDao;
    }

}
