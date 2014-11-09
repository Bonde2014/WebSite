package cn.com.bonde.b2b.website.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import cn.com.bonde.b2b.website.dao.IBaseCodeDao;
import cn.com.bonde.b2b.website.entity.DmSpfl;

@Service
public class BaseCodeService implements ApplicationListener<ContextRefreshedEvent> {
    
    private static final Logger log = Logger.getLogger(BaseCodeService.class);

    @Resource
    private IBaseCodeDao              baseCodeDao;

    private static Map<String, List<? extends Object>> baseCodeMap;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {// root application context 没有parent，他就是老大.
            baseCodeMap = new HashMap<String, List<? extends Object>>();
            try {
                baseCodeMap.put("DM_SPFL", baseCodeDao.getEntitiesListByProperties(DmSpfl.class, null));
                baseCodeMap.put("DM_SPFL2", baseCodeDao.getEntitiesListByProperties(DmSpfl.class, null));
            } catch (Exception e) {
                log.error("init BaseCodeService error!",e);
            }
        }
    }
    
    public static List getBaseCodeList(String baseCodeName){
        return baseCodeMap.get(baseCodeName);
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
