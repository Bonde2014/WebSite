package cn.com.bonde.b2b.website.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import cn.com.bonde.b2b.website.dao.IBaseCodeDao;
import cn.com.bonde.b2b.website.entity.DmSpfl;
import cn.com.bonde.b2b.website.entity.DmSpfl2;

@Service
public class BaseCodeService implements ApplicationListener<ContextRefreshedEvent> {
    
    private static final Logger log = Logger.getLogger(BaseCodeService.class);

    @Resource
    private IBaseCodeDao              baseCodeDao;

    private static List<DmSpfl> spflList;
    
    private static List<DmSpfl2> spfl2List;
    

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {// root application context 没有parent，他就是老大.
            try {
                spflList = baseCodeDao.getEntitiesListByProperties(DmSpfl.class, null);
                spfl2List = baseCodeDao.getEntitiesListByProperties(DmSpfl2.class, null);
            } catch (Exception e) {
                log.error("init BaseCodeService error!",e);
            }
        }
    }
    
    /**
     * 商品分类
     * @return
     */
    public static List<DmSpfl> getSpflList(){
        return spflList;
    }
    
    /**
     * 品牌分类
     * @return
     */
    public static List<DmSpfl2> getPpflList(){
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
