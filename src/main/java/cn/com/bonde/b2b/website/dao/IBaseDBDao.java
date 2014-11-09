package cn.com.bonde.b2b.website.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.com.bonde.b2b.website.entity.findEntity.BaseFindEntity;
import cn.com.bonde.b2b.website.util.MyException;
import cn.com.bonde.b2b.website.util.Pager;

public interface IBaseDBDao
{

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2012-4-18
	 * @功能说明：根据泛型实体的typeClass和primaryId获得相应的实体
	 * @param <T>
	 * @param typeClass
	 *            泛型实体的class
	 * @param primaryId
	 *            实体中主键属性
	 * @return
	 * @throws Exception
	 */
	public <T> T getEntityByPrimaryId(Class<T> typeClass, Serializable primaryId) throws Exception;

	/**
	 * 
	 * @author chenan
	 * @param entity
	 * @function 将实体游离化，使其不跟数据库做关联
	 * @return true 成功 | false 失败
	 * @throws Exception
	 * 
	 */

	public void evictEntity(Object entity) throws Exception;

	/**
	 * 基于泛型的添加逻辑接口，通过连接Hibernate完成添加操作
	 * 
	 * @author 应洪峰 北京国网中电 2011-4-17
	 * @param entity
	 *            Hibernate自动生成的实体类
	 * @return true 成功 | false 失败
	 * @throws Exception
	 * 
	 */

	public boolean addEntity(Object entity) throws Exception;

	/**
	 * 
	 * @创建人：司徒
	 * @创建时间：2011-9-22
	 * @功能说明：更新实体，若实体中某项未赋值 则为null
	 * @param entity
	 * @return
	 */
	public boolean updateEntiy(Object entity) throws Exception;

	/**
	 * 
	 * @创建人：焦元超
	 * @创建时间：2012-6-12
	 * @功能说明：合并更新实体,缓存中存在实体时，不允许直接更新实体
	 * @param entity
	 * @return
	 */
	public boolean updateMergeEntiy(Object entity) throws Exception;

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2012-3-21
	 * @功能说明：根据主键id批量修改某一字段的值
	 * @param typeClass
	 *            泛型实体的class
	 * @param primaryKeyValues
	 *            主键的id值,例如1,2,3
	 * @param key
	 *            数据库中字段
	 * @param value
	 *            需要修改字段的值
	 * @return
	 * @throws Exception
	 */
	public <T> boolean updateAllBySql(Class<T> typeClass, String primaryKeyValues, String fieldName, Object fieldValue) throws Exception;

	/**
	 * 
	 * @创建人：焦元超
	 * @创建时间：2012-5-13
	 * @功能说明：根据sql更新数据
	 * @param sql
	 * @param parasMaps
	 * @return
	 * @throws Exception
	 */
	public boolean updateBySql(String sql, Map<String, Object> parasMaps) throws Exception;

	/**
	 * 
	 * @创建人：司徒
	 * @创建时间：2012-6-12
	 * @功能说明：根据要更新的字段Map和条件字段Map更新一个表中的数据
	 * @param <T>
	 * @param typeClass
	 * @param updateMaps
	 *            要更新的字段
	 * @param parasMaps
	 *            条件字段
	 * @return
	 * @throws Exception
	 */
	public <T> boolean updateBySql(Class<T> typeClass, Map<String, Object> updateMaps, Map<String, Object> parasMaps) throws Exception;

	/**
	 * 
	 * @创建人：司徒
	 * @创建时间：2011-9-22
	 * @功能说明：更新实体，若实体中某项未赋值 则不更新该字段 可更新本实体中的自由字段和外键字段 需要至少为该实体主键和其他任意一字段赋值
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public boolean updateEntiyFieldBySql(Object entity) throws Exception;

	public <T> boolean deleteByPrimaryId(Class<T> typeClass, Serializable id) throws Exception;

	/**
	 * 
	 * @添加人：司徒彬
	 * @添加时间：2011-7-1
	 * @方法说明：根据主键批量删除,使用jdbc
	 * @param typeClass
	 *            实体类的class
	 * @param primaryKeyValues
	 *            主键 格式如a,b,c
	 * @return
	 * @throws Exception
	 */
	public <T> boolean deleteByPrimaryIds(Class<T> typeClass, String primaryKeyValues) throws Exception;

	/**
	 * 
	 * @创建人：司徒
	 * @创建时间：2011-8-12
	 * @功能说明：根据字段删除 fieldName=fieldValue
	 * @param typeClass
	 *            泛型实体的class
	 * @param fieldName
	 *            fieldName为表中的字段名
	 * @param fieldValue
	 * @return
	 * @throws Exception
	 */
	public <T> boolean deleteByField(Class<T> typeClass, String fieldName, Object fieldValue) throws Exception;

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2014-4-9
	 * @功能说明：根据字段fieldName，fieldValue删除 ，返回删除数据个数
	 * @return
	 * @throws MyException
	 */
	public <T> int deleteByFiled(Class<T> typeClass, String fieldName, Object fieldValue) throws Exception;

	/**
	 * 
	 * @创建人：司徒
	 * @创建时间：2011-9-29
	 * @功能说明： 根据fieldName字段批量删除 fieldName in （1,2,3）
	 * @param typeClass
	 *            泛型实体的class
	 * @param fieldName
	 *            fieldName为表中的字段名
	 * @param fieldValues
	 * @return
	 * @throws Exception
	 */
	public <T> boolean deleteAllByField(Class<T> typeClass, String fieldName, Object fieldValues) throws Exception;

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2012-4-18
	 * @功能说明：根据sql和删除条件集合删除数据
	 * @param sql
	 * @param parasMaps
	 * @return
	 * @throws Exception
	 */
	public boolean deleteBySql(String sql, Map<String, Object> parasMaps) throws Exception;

	/**
	 * 
	 * @创建人：司徒
	 * @创建时间：2011-9-22
	 * @功能说明：根据单个的propertyName和propertyValue查询实体的结果集,并根据orderBy进行排序
	 * @param typeClass
	 *            泛型实体的class
	 * @param propertyName
	 *            查询条件中的字段,使用实体中的属性名,非数据库字段名
	 * @param propertyValue
	 *            查询的值
	 * @param orderBy
	 *            格式 : sbxhId asc——升序 、sbxiId——升序 、sbxhId desc——降序
	 * @return
	 * @throws Exception
	 */
	public <T> List<T> getEntitiesListByProperty(Class<T> typeClass, String propertyName, Object propertyValue, String... orderBy) throws Exception;

	/**
	 * 
	 * @创建人：司徒
	 * @创建时间：2011-9-22
	 * @功能说明：根据多个属性条件查询List，并根据orderBy排序
	 * @param typeClass
	 *            泛型实体的class
	 * @param propertyMap
	 *            查询条件的参数，key为实体中的属性名，value要查询的值
	 * @param orderBy
	 *            格式 : sbxhId asc——升序 、sbxiId——升序 、sbxhId desc——降序
	 * @return
	 * @throws Exception
	 */
	public <T> List<T> getEntitiesListByProperties(Class<T> typeClass, Map<String, Object> propertyMap, String... orderBy) throws Exception;

	/**
	 * 司徒彬
	 * 
	 * @param <T>
	 * @param typeClass
	 * @param ids
	 *            格式'1222,323232,232323'
	 * @return
	 * @throws Exception
	 */
	/**
	 * 
	 * @创建人：司徒
	 * @创建时间：2011-9-22
	 * @功能说明：根据主键id字符串集获取到实体集合
	 * @param typeClass
	 *            泛型实体的class
	 * @param ids
	 *            格式'1222,323232,232323'
	 * @return
	 * @throws Exception
	 */
	public <T> List<T> getEntityByPrimaryIds(Class<T> typeClass, String ids) throws Exception;

	/**
	 * @创建人：司徒
	 * @创建时间：2011-6-23
	 * @功能说明：根据查询条件获得分页记录
	 * @param sql
	 * @param parasMaps
	 * @param Pager
	 * @param totalCountSql
	 * @return
	 * @throws MyException
	 */
	public Pager getListBySQLQuery(String sql, Map<String, Object> parasMaps, BaseFindEntity findEntity, String... totalCountSql) throws Exception;

	/**
	 * @function 根据查询条件查询记录数的个数
	 * @param sql
	 *            sql查询语句
	 * @param map
	 *            用map封装查询条件
	 * @return 数据库中满足查询条件的数据的条数
	 * @throws Exception
	 */
	public Integer getTotalCountBySQLQuery(String sql, Map<String, Object> map, String... totalCountSql) throws Exception;

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2012-4-18
	 * @功能说明：根据sql和查询条件查询出list数据集
	 * @param sql
	 * @param parasMaps
	 * @return List<Map<String, Object>>
	 * @throws Exception
	 */
	public List<Map<String, Object>> getMapListBySql(String sql, Map<String, Object> parasMaps) throws Exception;

	/**
	 * 
	 * @创建人：司徒
	 * @创建时间：2012-6-5
	 * @功能说明：根据Sql获得单独的值
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public Object getObjectValue(String sql) throws Exception;

	/**
	 * 
	 * @创建人：司徒
	 * @创建时间：2012-6-5
	 * @功能说明：根据Sql及查询条件集合获得单独的值
	 * @param sql
	 * @param parasMaps
	 * @return
	 * @throws Exception
	 */
	public Object getObjectValue(String sql, Map<String, Object> parasMaps) throws Exception;

	/**
	 * 
	 * @创建人：司徒
	 * @创建时间：2011-9-21
	 * @功能说明：验证单个字段是否存在
	 * @param typeClass
	 *            泛型实体的class
	 * @param fieldName
	 *            fieldName为表中的字段名
	 * @param fieldValue
	 * @return 存在返TRUE
	 * @throws Exception
	 */
	public <T> boolean isExist(Class<T> typeClass, String fieldName, Object fieldValue) throws Exception;

	/**
	 * 
	 * @创建人：司徒
	 * @创建时间：2011-9-29
	 * @功能说明：验证多个字段是否存在
	 * @param typeClass
	 *            泛型实体的class
	 * @param fieldMap
	 *            key为数据库中字段
	 * @return 大于零 true
	 * @throws Exception
	 */
	public <T> boolean isExist(Class<T> typeClass, Map<String, Object> fieldMap) throws Exception;

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2014年8月21日
	 * @功能说明：hibernate执行hql查询实体集合,paramMap要么没有，要么只有一个。
	 * @return
	 * @throws MyException
	 */
	public <T> List<T> getEntityListByHQL(final String hql, Map<String, Object>... paramMap) throws Exception;

	
	public Pager getListByHQL(String hql, Map<String, Object> parasMaps, BaseFindEntity findEntity, String... totalCountSql) throws Exception;
}
