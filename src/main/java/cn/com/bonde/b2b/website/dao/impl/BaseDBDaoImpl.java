package cn.com.bonde.b2b.website.dao.impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.Table;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cn.com.bonde.b2b.website.dao.IBaseDBDao;
import cn.com.bonde.b2b.website.entity.findEntity.BaseFindEntity;
import cn.com.bonde.b2b.website.util.DataSwitch;
import cn.com.bonde.b2b.website.util.MyException;
import cn.com.bonde.b2b.website.util.Pager;

@Transactional
public class BaseDBDaoImpl implements IBaseDBDao
{
	public BaseDBDaoImpl()
	{
	}

	@Autowired
	private SessionFactory sessionFactory = null;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2012-4-17
	 * @功能说明：获得session
	 * @return
	 */
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2012-4-18
	 * @功能说明：根据泛型实体的class获得ClassMetadata
	 * @param <T>
	 * @param typeClass
	 * @return
	 */
	private <T> AbstractEntityPersister getClassMetadata(Class<T> typeClass)
	{
		return (SingleTableEntityPersister) sessionFactory.getClassMetadata(typeClass);
	}

	/**
	 * 
	 * @创建人：焦元超
	 * @创建时间：2012-5-19
	 * @功能说明：根据实体获取数据库表名
	 * @param entity
	 * @return 表名
	 */
	public <T> String getTableNameByEntity(Class<T> typeClass)
	{
		try
		{
			return typeClass.getAnnotation(Table.class).name();
		}
		catch (Exception e)
		{

		}
		return "";
	}

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2012-4-18
	 * @功能说明：根据泛型实体的class获得该实体对应表中主键列
	 * @param <T>
	 * @param typeClass
	 * @return
	 */
	public <T> String getPrimaryKey(Class<T> typeClass)
	{
		AbstractEntityPersister classMetadata = (SingleTableEntityPersister) sessionFactory.getClassMetadata(typeClass);
		return classMetadata.getIdentifierColumnNames()[0];
	}

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2012-12-18
	 * @功能说明：根据泛型实体的class获得该实体主键列映射属性
	 * @param <T>
	 * @param typeClass
	 * @return
	 */
	private <T> String getPrimaryPropertyName(Class<T> typeClass)
	{
		ClassMetadata meta = sessionFactory.getClassMetadata(typeClass);
		return meta.getIdentifierPropertyName();// 主键名称
	}

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
	@Override
    @SuppressWarnings("unchecked")
	public <T> T getEntityByPrimaryId(Class<T> typeClass, Serializable primaryId) throws Exception
	{
		T returnClass = null;
		try
		{
			returnClass = (T) this.getSession().get(typeClass, primaryId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			new MyException(e, BaseDBDaoImpl.class, "根据泛型实体的typeClass和primaryId获得相应的实体出错,方法：getEntityByPrimaryId ");
			throw e;
		}
		return returnClass;
	}

	/**
	 * 
	 * @author chenan
	 * @param entity
	 * @function 将实体游离化，使其不跟数据库做关联
	 * @return true 成功 | false 失败
	 * @throws Exception
	 * 
	 */

	@Override
    public void evictEntity(Object entity) throws Exception
	{
		try
		{
			this.getSession().evict(entity);
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "将实体游离化，使其不跟数据库做关联出错,方法：evictEntity ");
			throw e;
		}
	}

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

	@Override
    public boolean addEntity(Object entity) throws Exception
	{
		boolean result = false;
		try
		{
			this.getSession().evict(entity);
			String s = this.getSession().save(entity).toString();
			this.getSession().flush();
			if (s.trim().length() != 0)
			{
				result = true;
			}
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "添加实体出错,方法：addEntity ");
			throw e;
		}
		return result;
	}

	/**
	 * 
	 * @创建人：司徒
	 * @创建时间：2011-9-22
	 * @功能说明：更新实体，若实体中某项未赋值 则为null
	 * @param entity
	 * @return
	 */
	@Override
    public boolean updateEntiy(Object entity) throws Exception
	{
		boolean result = false;
		try
		{
			this.getSession().update(entity);
			this.getSession().flush();
			result = true;
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "更新实体，若实体中某项未赋值 则为null出错,方法：updateEntiy ");
			throw e;
		}
		return result;
	}

	/**
	 * 
	 * @创建人：焦元超
	 * @创建时间：2012-6-12
	 * @功能说明：合并更新实体,缓存中存在实体时，不允许直接更新实体
	 * @param entity
	 * @return
	 */
	@Override
    public boolean updateMergeEntiy(Object entity) throws Exception
	{
		boolean result = false;
		try
		{
			this.getSession().merge(entity);
			this.getSession().flush();
			result = true;
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "合并更新实体,缓存中存在实体时，不允许直接更新实体出错,方法：updateMergeEntiy ");
			throw e;
		}
		return result;
	}

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
	@Override
    public <T> boolean updateAllBySql(Class<T> typeClass, String primaryKeyValues, String fieldName, Object fieldValue) throws Exception
	{
		boolean result = false;
		String keys = "";
		try
		{
			String[] idArr = primaryKeyValues.split(",");
			for (String id : idArr)
			{
				keys += "'" + id + "',";
			}
			keys += "'-1'";

			String tableName = typeClass.getAnnotation(Table.class).name();
			String primaryKey = this.getPrimaryKey(typeClass);
			String sql = "UPDATE " + tableName + " SET " + fieldName + "='" + fieldValue + "' WHERE " + primaryKey + " in (" + keys + ")";
			SQLQuery query = this.getSession().createSQLQuery(sql);
			int flag = query.executeUpdate();
			if (flag > 0)
				result = true;
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "根据主键id批量修改某一字段的值错误,方法：updateAllBySql ");
			throw e;
		}
		return result;
	}

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
	@Override
    public boolean updateBySql(String sql, Map<String, Object> parasMaps) throws Exception
	{
		boolean result = false;
		try
		{
			SQLQuery query = this.getSession().createSQLQuery(sql);
			if (parasMaps != null && parasMaps.size() > 0)
			{
				Iterator<String> keySet = parasMaps.keySet().iterator();
				while (keySet.hasNext())
				{
					String key = keySet.next();
					if (sql.contains(":" + key))
						query.setParameter(key, parasMaps.get(key));
				}
			}
			if (query.executeUpdate() > 0)
			{
				result = true;
			}
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "根据sql更新数据错误,方法：updateBySql ");
			throw e;
		}
		return result;
	}

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
	@Override
    public <T> boolean updateBySql(Class<T> typeClass, Map<String, Object> updateMaps, Map<String, Object> parasMaps) throws Exception
	{
		boolean result = false;
		try
		{
			String tableName = typeClass.getAnnotation(Table.class).name();
			StringBuffer sbSql = new StringBuffer();
			sbSql.append("UPDATE ");
			sbSql.append(tableName);
			sbSql.append(" SET ");
			for (String key : updateMaps.keySet())
			{
				sbSql.append(key + "=:" + key + ",");
			}

			String sql = sbSql.toString().substring(0, sbSql.toString().length() - 1);
			sbSql = new StringBuffer();
			sbSql.append(sql);
			sbSql.append(" WHERE 1 = 1 ");
			for (String key : parasMaps.keySet())
			{
				sbSql.append(" AND " + key + "=:" + key);
			}
			SQLQuery query = this.getSession().createSQLQuery(sbSql.toString());
			for (String key : updateMaps.keySet())
			{
				query.setParameter(key, updateMaps.get(key));
			}
			for (String key : parasMaps.keySet())
			{
				query.setParameter(key, parasMaps.get(key));
			}
			int flag = query.executeUpdate();
			if (flag > 0)
			{
				result = true;
			}
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "根据要更新的字段Map和条件字段Map更新一个表中的数据错误,方法：updateBySql ");
			throw e;
		}
		return result;
	}

	/**
	 * 
	 * @创建人：司徒
	 * @创建时间：2011-9-22
	 * @功能说明：更新实体，若实体中某项未赋值 则不更新该字段 可更新本实体中的自由字段和外键字段 需要至少为该实体主键和其他任意一字段赋值
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@Override
    @SuppressWarnings("unused")
	public boolean updateEntiyFieldBySql(Object entity) throws Exception
	{
		Boolean result = false;
		try
		{
			Map<String, Object> paras = new HashMap<String, Object>();
			String tableName = entity.getClass().getAnnotation(Table.class).name();
			String primaryKey = this.getPrimaryKey(entity.getClass());
			Object primaryValue = "";
			boolean isPrimaryKey = false;
			StringBuffer sbSql = new StringBuffer();
			sbSql.append(" UPDATE ");
			sbSql.append(tableName);
			sbSql.append(" SET ");
			BeanInfo beanInfo = Introspector.getBeanInfo(entity.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors)
			{
				String name = propertyDescriptor.getName();
				Type type = propertyDescriptor.getPropertyType();
				String typeStr = type.toString();
				if (typeStr.contains("java.util.Set") || typeStr.contains("java.util.List") || typeStr.contains("java.lang.Class") || typeStr.equals("class")
						|| name.trim().length() == 0)
				{
					continue;
				}
				Method method = propertyDescriptor.getReadMethod();
				Object value = method.invoke(entity);
				if (value == null)
				{
					continue;
				}
				String[] dbKeyNameArr = this.getClassMetadata(entity.getClass()).getPropertyColumnNames(name);
				String key = "";
				if (dbKeyNameArr.length > 0)
				{
					key = dbKeyNameArr[0];
				}
				else
				{
					continue;
				}
				if (key.equalsIgnoreCase(primaryKey))
				{
					primaryValue = value;
					isPrimaryKey = true;
				}
				if (isPrimaryKey && value == null)
				{
					throw new MyException(entity.getClass(), "该实体主键未赋值，无法更新!");
				}
				else if (value == null)
				{
					continue;
				}

				if (typeStr.contains(".model.entity"))
				{
					String foreignKey = this.getClassMetadata(value.getClass()).getIdentifierPropertyName();
					BeanInfo foreignBeanInfo = Introspector.getBeanInfo(value.getClass());

					PropertyDescriptor[] foreignpropertyDescriptors = foreignBeanInfo.getPropertyDescriptors();

					for (PropertyDescriptor foreignpropertyDescriptor : foreignpropertyDescriptors)
					{
						String tempKey = foreignpropertyDescriptor.getName();
						if (tempKey.equalsIgnoreCase(foreignKey))
						{
							value = foreignpropertyDescriptor.getReadMethod().invoke(value);
							break;
						}
					}
				}

				sbSql.append(key);
				sbSql.append(" = :");
				sbSql.append(key);
				sbSql.append(",");
				paras.put(key, value);
			}
			String sql = sbSql.toString().substring(0, sbSql.toString().length() - 1);
			sbSql = new StringBuffer(sql);
			sbSql.append(" WHERE ");
			sbSql.append(primaryKey);
			sbSql.append(" = :");
			sbSql.append(primaryKey);
			paras.put(primaryKey, primaryValue);
			if (paras.values().size() < 2)
			{
				throw new MyException(entity.getClass(), "需要至少为该实体主键和其他任意一字段赋值，无法更新!");
			}

			SQLQuery query = this.getSession().createSQLQuery(sbSql.toString());
			for (String parasKey : paras.keySet())
			{
				query.setParameter(parasKey, paras.get(parasKey));
			}

			int flag = query.executeUpdate();
			if (flag > 0)
				result = true;

		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "更新实体出错,方法：updateEntiyFieldBySql ");
			throw e;
		}

		return result;

	}

	@Override
    public <T> boolean deleteByPrimaryId(Class<T> typeClass, Serializable id) throws Exception
	{
		boolean result = false;
		try
		{
			this.getSession().delete(this.getSession().get(typeClass, id));
			this.getSession().flush();
			result = true;
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "根据主键id删除失败：deleteByPrimaryId ");
			throw e;
		}
		return result;
	}

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
	@Override
    public <T> boolean deleteByPrimaryIds(Class<T> typeClass, String primaryKeyValues) throws Exception
	{
		Boolean result = false;
		try
		{
			String[] keyArr = primaryKeyValues.split(",");
			String key = "";
			for (String string : keyArr)
			{
				key += "'" + string + "',";
			}
			key += "'-1'";

			String tableName = typeClass.getAnnotation(Table.class).name();
			String primaryKey = this.getPrimaryKey(typeClass);
			String sql = "DELETE FROM " + tableName + " WHERE " + primaryKey + " in (" + key + ")";
			SQLQuery query = this.getSession().createSQLQuery(sql);
			int flag = query.executeUpdate();
			if (flag > 0)
				result = true;
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "物理批量删除失败,方法：updateMergeEntiy) ");
			throw e;
		}
		return result;
	}

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
	@Override
    public <T> boolean deleteByField(Class<T> typeClass, String fieldName, Object fieldValue) throws Exception
	{
		Boolean result = false;
		try
		{
			String tableName = typeClass.getAnnotation(Table.class).name();
			String primaryKey = this.getPrimaryKey(typeClass);

			String valueClassName = fieldValue.getClass().getName();
			String sql = "";
			if (valueClassName.contains("String") && !fieldName.equalsIgnoreCase(primaryKey))
			{
				sql = "DELETE FROM " + tableName + " WHERE " + fieldName + " = '" + fieldValue + "'";
			}
			else
			{
				sql = "DELETE FROM " + tableName + " WHERE LOWER(" + fieldName + ") = LOWER('" + fieldValue + "')";
			}
			SQLQuery query = this.getSession().createSQLQuery(sql);
			int flag = query.executeUpdate();
			if (flag > 0)
				result = true;
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "根据表中字段和给定字符 删除失败,方法：deleteByField");
			throw e;
		}
		return result;
	}

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2014-4-9
	 * @功能说明：根据字段fieldName，fieldValue删除 ，返回删除数据个数
	 * @return
	 * @throws MyException
	 */
	@Override
    public <T> int deleteByFiled(Class<T> typeClass, String fieldName, Object fieldValue) throws Exception
	{
		int flag = 0;
		try
		{
			String tableName = typeClass.getAnnotation(Table.class).name();
			String primaryKey = this.getPrimaryKey(typeClass);
			String valueClassName = fieldValue.getClass().getName();
			String sql = "";
			if (valueClassName.contains("String") && !fieldName.equalsIgnoreCase(primaryKey))
			{
				sql = "DELETE FROM " + tableName + " WHERE " + fieldName + " = '" + fieldValue + "'";
			}
			else
			{
				sql = "DELETE FROM " + tableName + " WHERE LOWER(" + fieldName + ") = LOWER('" + fieldValue + "')";
			}
			SQLQuery query = this.getSession().createSQLQuery(sql);
			flag = query.executeUpdate();
		}
		catch (Exception e)
		{
			// new MyException(e, typeClass,
			// "根据表中字段和给定字符 删除失败public <T> boolean deleteByKey(Class<T> typeClass,String key, Object value)");
			throw e;
		}
		return flag;
	}

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
	@Override
    public <T> boolean deleteAllByField(Class<T> typeClass, String fieldName, Object fieldValues) throws Exception
	{
		Boolean result = false;
		try
		{
			if (fieldValues == null)
			{
				return false;
			}
			String tableName = typeClass.getAnnotation(Table.class).name();
			String primaryKey = this.getPrimaryKey(typeClass);
			String[] valueArr = fieldValues.toString().split(",");
			String idStr = "";

			String prefixStr = "";
			String suffixStr = "";
			if (fieldName.equalsIgnoreCase(primaryKey))
			{
				prefixStr = "LOWER(";
				suffixStr = ")";
			}

			for (String id : valueArr)
			{
				if (id.trim().length() == 0)
				{
					continue;
				}
				idStr += prefixStr + "'" + id + "'" + suffixStr + ",";
			}
			if (idStr.length() > 0)
			{
				idStr = idStr.substring(0, idStr.length() - 1);
			}

			String sql = "DELETE FROM " + tableName + " WHERE " + prefixStr + fieldName + suffixStr + " in (" + idStr + ")";
			SQLQuery query = this.getSession().createSQLQuery(sql);
			int flag = query.executeUpdate();
			if (flag > 0)
				result = true;
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, " 根据fieldName字段批量删除 fieldName in （1,2,3）失败,方法：deleteAllByField");
			throw e;
		}
		return result;
	}

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
	@Override
    public boolean deleteBySql(String sql, Map<String, Object> parasMaps) throws Exception
	{
		boolean result = false;
		try
		{
			SQLQuery query = this.getSession().createSQLQuery(sql);
			// query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			if (parasMaps != null && parasMaps.size() > 0)
			{
				Iterator<String> keySet = parasMaps.keySet().iterator();
				while (keySet.hasNext())
				{
					String key = keySet.next();
					if (sql.contains(":" + key))
						query.setParameter(key, parasMaps.get(key));
				}
			}
			int flag = query.executeUpdate();
			if (flag >= 0)
			{
				result = true;
			}

		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, " 根据sql和删除条件集合删除数据失败,方法：deleteBySql");
			throw e;
		}
		return result;
	}

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
	@Override
    @SuppressWarnings("unchecked")
	public <T> List<T> getEntitiesListByProperty(Class<T> typeClass, String propertyName, Object propertyValue, String... orderBy) throws Exception
	{
		try
		{
			String primaryKey = this.getPrimaryKey(typeClass).replace("_", "");

			SimpleExpression expression = Restrictions.eq(propertyName, propertyValue);
			if (propertyValue instanceof String && !propertyName.equalsIgnoreCase(primaryKey))
			{
				expression.ignoreCase();
			}
			Criteria criteria = this.getSession().createCriteria(typeClass).add(expression);
			for (String order : orderBy)
			{
				order = order.trim();
				if (order.length() == 0)
				{
					continue;
				}
				String[] orderArr = order.split(" ");
				String keyName = orderArr[0];
				String ascOrDesc = "ASC";
				if (orderArr.length > 1)
				{
					ascOrDesc = orderArr[1];
				}
				if (ascOrDesc.equalsIgnoreCase("ASC"))
				{
					criteria.addOrder(Order.asc(keyName));
				}
				else
				{
					criteria.addOrder(Order.desc(keyName));
				}
			}
			return criteria.list();
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "基于泛型、条件key以及keyValue的获得实体基本信息逻辑接口出错,方法：getEntitiesListByKey");
			throw e;
		}
	}

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
	@Override
    @SuppressWarnings("unchecked")
	public <T> List<T> getEntitiesListByProperties(Class<T> typeClass, Map<String, Object> propertyMap, String... orderBy) throws Exception
	{
		try
		{
			String primaryKey = this.getPrimaryKey(typeClass).replace("_", "");

			Criteria criteria = this.getSession().createCriteria(typeClass);

			if (propertyMap != null && propertyMap.size() > 0)
			{
				for (String key : propertyMap.keySet())
				{
					if (key.trim().length() == 0)
					{
						continue;
					}
					SimpleExpression expression = Restrictions.eq(key, propertyMap.get(key));
					if (propertyMap.get(key) instanceof String && !key.equalsIgnoreCase(primaryKey))
					{
						expression.ignoreCase();
					}
					criteria.add(expression);
				}
			}
			for (String order : orderBy)
			{
				order = order.trim();
				if (order.length() == 0)
				{
					continue;
				}
				String[] orderArr = order.split(" ");
				String keyName = orderArr[0];
				String ascOrDesc = "ASC";
				if (orderArr.length > 1)
				{
					ascOrDesc = orderArr[1];
				}
				if (ascOrDesc.equalsIgnoreCase("ASC"))
				{
					criteria.addOrder(Order.asc(keyName));
				}
				else
				{
					criteria.addOrder(Order.desc(keyName));
				}
			}
			return criteria.list();
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "基于泛型、条件key以及keyValue的获得实体基本信息逻辑接口出错,方法：getEntitiesListByKeys");
			throw e;
		}
	}

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
	@Override
    @SuppressWarnings("unchecked")
	public <T> List<T> getEntityByPrimaryIds(Class<T> typeClass, String ids) throws Exception
	{
		try
		{
			String primaryKey = this.getPrimaryPropertyName(typeClass);
			String[] idArr = ids.split(",");
			Criteria criteria = this.getSession().createCriteria(typeClass);
			criteria.add(Restrictions.in(primaryKey, idArr));
			return criteria.list();
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "根据主键id字符串集获取到实体集合错误,方法：getEntityByPrimaryIds");
			throw e;
		}
	}

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
	@Override
    public Pager getListBySQLQuery(String sql, Map<String, Object> parasMaps, BaseFindEntity findEntity, String... totalCountSql) throws Exception
	{
		Pager pager=new Pager();
		try
		{
			SQLQuery query = this.getSession().createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			if (parasMaps != null)
			{
				Iterator<String> keySet = parasMaps.keySet().iterator();
				while (keySet.hasNext())
				{
					String key = keySet.next();
					if (sql.contains(":" + key))
					{
						query.setParameter(key, parasMaps.get(key));
					}
				}
			}
			query.setMaxResults(findEntity.getRows());
			query.setFirstResult((findEntity.getPage()-1)*findEntity.getRows());
			
			List resultList = query.list();
			Integer totalCount = getTotalCountBySQLQuery(sql, parasMaps, totalCountSql);
			pager.setPageSize(findEntity.getRows());
			pager.setPageNo(findEntity.getPage());
			pager.setRows(resultList);
			pager.setTotal(totalCount);
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "查询逻辑失败 ,方法： getListBySQLQuery");
			throw e;
		}
		return pager;
	}

	/**
	 * @function 根据查询条件查询记录数的个数
	 * @param sql
	 *            sql查询语句
	 * @param map
	 *            用map封装查询条件
	 * @return 数据库中满足查询条件的数据的条数
	 * @throws Exception
	 */
	@Override
    public Integer getTotalCountBySQLQuery(String sql, Map<String, Object> map, String... totalCountSql) throws Exception
	{
		try
		{
			if (totalCountSql == null || totalCountSql.equals("") || totalCountSql.length == 0)
			{
				sql = "select count(*) from (" + sql + ")  T";
			}
			else
			{
				sql = totalCountSql[0];
			}
			SQLQuery query = this.getSession().createSQLQuery(sql);
			if (map != null)
			{
				Iterator<String> it = map.keySet().iterator();
				while (it.hasNext())
				{
					String key = it.next();
					if (sql.contains(":" + key))
					{
						query.setParameter(key, map.get(key));
					}
				}
			}
			Integer i = DataSwitch.convertObjectToInteger(query.list().get(0));
			return i;
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "根据查询条件查询记录数的个数失败,方法：getTotalCountByQuery");
			throw e;
		}

	}

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
	@Override
    @SuppressWarnings("unchecked")
	public List<Map<String, Object>> getMapListBySql(String sql, Map<String, Object> parasMaps) throws Exception
	{
		try
		{
			List<Map<String, Object>> resultList = null;
			SQLQuery query = this.getSession().createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			if (parasMaps != null && parasMaps.size() > 0)
			{
				Iterator<String> keySet = parasMaps.keySet().iterator();
				while (keySet.hasNext())
				{
					String key = keySet.next();
					if (sql.contains(":" + key))
						query.setParameter(key, parasMaps.get(key));
				}
			}
			resultList = query.list();
			return resultList;
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "根据sql和查询条件查询出list数据集失败,方法：getMapListBySql");
			throw e;
		}
	}

	/**
	 * 
	 * @创建人：司徒
	 * @创建时间：2012-6-5
	 * @功能说明：根据Sql获得单独的值
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	@Override
    public Object getObjectValue(String sql) throws Exception
	{
		try
		{
			SQLQuery query = this.getSession().createSQLQuery(sql);
			return query.uniqueResult();
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "根据Sql获得单独的值错误,方法： getObjectValue");
			throw e;
		}
	}

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
	@Override
    public Object getObjectValue(String sql, Map<String, Object> parasMaps) throws Exception
	{
		try
		{
			SQLQuery query = this.getSession().createSQLQuery(sql);
			if (parasMaps != null && parasMaps.size() > 0)
			{
				for (String key : parasMaps.keySet())
				{
					query.setParameter(key, parasMaps.get(key));
				}
			}
			return query.uniqueResult();
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "根据Sql及查询条件集合获得单独的值错误,方法： getObjectValue");
			throw e;
		}
	}

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
	@Override
    public <T> boolean isExist(Class<T> typeClass, String fieldName, Object fieldValue) throws Exception
	{
		boolean isExist = false;
		String valueClassName = fieldValue.getClass().getName();
		try
		{
			String tableName = typeClass.getAnnotation(Table.class).name();
			String primaryKey = this.getPrimaryKey(typeClass);
			String sql = "";
			if (valueClassName.contains("String") && !fieldName.toLowerCase().equals(primaryKey.toLowerCase()))
			{
				sql = "SELECT COUNT(" + primaryKey + ") AS NUM FROM " + tableName + " WHERE LOWER(" + fieldName + ")= LOWER(:key)";
			}
			else
			{
				sql = "SELECT COUNT(" + primaryKey + ") AS NUM FROM " + tableName + " WHERE " + fieldName + "= :key";
			}
			SQLQuery query = this.getSession().createSQLQuery(sql);
			query.setParameter("key", fieldValue);
			int flag = DataSwitch.convertObjectToInteger(query.uniqueResult());
			if (flag > 0)
			{
				isExist = true;
			}
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "验证单个字段是否存在失败,方法： isExist");
			throw e;
		}
		return isExist;
	}

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
	@Override
    public <T> boolean isExist(Class<T> typeClass, Map<String, Object> fieldMap) throws Exception
	{
		boolean isExist = false;

		try
		{
			String tableName = typeClass.getAnnotation(Table.class).name();
			String primaryKey = this.getPrimaryKey(typeClass);
			StringBuffer sbSql = new StringBuffer();
			sbSql.append("SELECT COUNT(" + primaryKey + ") AS NUM FROM " + tableName + " WHERE 1 = 1 ");

			if (fieldMap == null || fieldMap.size() == 0)
			{
				throw new Exception("条件Map为空！");
			}
			for (String key : fieldMap.keySet())
			{
				String valueClassName = fieldMap.get(key).getClass().getName();
				sbSql.append(" AND ");
				if (valueClassName.contains("String") && !key.toLowerCase().equals(primaryKey.toLowerCase()))
				{
					if (fieldMap.get(key) == "" || fieldMap.get(key) == null)
					{
						sbSql.append(key);
						sbSql.append(" IS NULL");
					}
					else
					{
						sbSql.append(" LOWER(");
						sbSql.append(key);
						sbSql.append(") =");
						sbSql.append("  LOWER(:" + key + ")");
					}

				}
				else
				{
					sbSql.append(key);
					sbSql.append(" = :" + key);
				}
			}
			SQLQuery query = this.getSession().createSQLQuery(sbSql.toString());
			for (String key : fieldMap.keySet())
			{
				// 应洪峰 2011-4-11 如果这个key所对应的值为空时，就跳过。
				if (fieldMap.get(key) == "" || fieldMap.get(key) == null)
				{
					continue;
				}
				else
				{
					query.setParameter(key, fieldMap.get(key));
				}
			}

			int flag = DataSwitch.convertObjectToInteger(query.uniqueResult());

			if (flag > 0)
			{
				isExist = true;
			}
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "验证多个字段是否存在失败,方法：isExist");
			throw e;
		}
		return isExist;
	}

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2014年8月21日
	 * @功能说明：hibernate执行hql查询实体集合,paramMap要么没有，要么只有一个。
	 * @return
	 * @throws MyException
	 */
	@Override
    @SuppressWarnings("unchecked")
	public <T> List<T> getEntityListByHQL(final String hql, Map<String, Object>... paramMap) throws Exception
	{
		try
		{
			final Query query = this.getSession().createQuery(hql);
			if (paramMap.length != 0)
			{
				Map<String, Object> paramMaps = paramMap[0];
				if (paramMaps != null && paramMaps.size() > 0)
				{
					query.setProperties(paramMap);
				}
			}
			return query.list();
		}
		catch (Exception e)
		{
			new MyException(e, BaseDBDaoImpl.class, "根据hql语句和查询条件获取实体集合：getEntityListByHQL");
			throw e;
		}
	}
	
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
    @Override
    public Pager getListByHQL(String hql, Map<String, Object> parasMaps, BaseFindEntity findEntity, String... totalCountSql) throws Exception
    {
        Pager pager=new Pager();
        try
        {
            final Query query = this.getSession().createQuery(hql);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            if (parasMaps != null)
            {
                Iterator<String> keySet = parasMaps.keySet().iterator();
                while (keySet.hasNext())
                {
                    String key = keySet.next();
                    if (hql.contains(":" + key))
                    {
                        query.setParameter(key, parasMaps.get(key));
                    }
                }
            }
            query.setMaxResults(findEntity.getRows());
            query.setFirstResult((findEntity.getPage()-1)*findEntity.getRows());
            
            List resultList = query.list();
            Integer totalCount = getTotalCountBySQLQuery(hql, parasMaps, totalCountSql);
            pager.setPageSize(findEntity.getRows());
            pager.setPageNo(findEntity.getPage());
            pager.setRows(resultList);
            pager.setTotal(totalCount);
        }
        catch (Exception e)
        {
            new MyException(e, BaseDBDaoImpl.class, "查询逻辑失败 ,方法： getListBySQLQuery");
            throw e;
        }
        return pager;
    }

}
