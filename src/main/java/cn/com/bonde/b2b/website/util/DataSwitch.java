package cn.com.bonde.b2b.website.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 数据类型转换类
 * 
 * @author 李雪飞 2010-04-15
 * 
 */
public class DataSwitch
{

	private static final Logger logger = Logger.getLogger(DataSwitch.class);

	/**
	 * 将整型对象格式字符串转换成整型对象，如果传入对象为 null 或 空，返回 0
	 * 
	 * @param 要转换对象
	 * @return 整型对象
	 */
	public static Integer convertObjectToInteger(Object value)
	{
		try
		{
			if (null != value)
			{
				return Integer.parseInt(value.toString());
			}
			else
			{
				return 0;
			}
		}
		catch (Exception e)
		{
			return 0;
		}
	}

	/**
	 * 将类型转换成Double对象，如果传入对象为 null 或 空，返回 0.0
	 * 
	 * @param 要转换对象
	 * @return Double类型对象
	 */
	public static Double convertObjectToDouble(Object value)
	{
		try
		{
			if (null != value)
			{
				return Double.parseDouble(value.toString());
			}
			else
			{
				return 0.0;
			}
		}
		catch (Exception e)
		{
			return 0.0;
		}
	}

	/**
	 * @author chenan
	 * @time 2013-1-6
	 * @function 格式化数字
	 * @param format
	 *            为"#.00"即保留2位小数、"#.000"即保留3位小数
	 * @return String
	 */
	public static String convertDoubleByFormat(Object value, String format)
	{
		try
		{
			if (null != value)
			{
				value = Double.parseDouble(value.toString());
				if (value instanceof Double)
				{
					if (format.equals(""))
					{
						return value.toString();
					}
					else
					{
						return new DecimalFormat(format).format(value);
					}
				}
			}
		}
		catch (Exception e)
		{
			return "0.0";
		}
		return "0.0";
	}

	/**
	 * 将对象转换成Long对象，如果传入对象为 null 或 空，返回 0l
	 * 
	 * @param 要转换对象
	 * @return Float类型对象
	 */
	public static Long convertObjectToLong(Object value)
	{
		try
		{
			if (null != value)
			{
				return Long.valueOf(value.toString());
			}
			else
			{
				return 0l;
			}
		}
		catch (Exception e)
		{
			return 0l;
		}
	}

	/**
	 * 将对象转换成Float对象，如果传入对象为 null 或 空，返回 0f
	 * 
	 * @param 要转换类型
	 * @return Float类型对象
	 */
	public static Float convertObjectToFloat(Object value)
	{
		try
		{
			if (null != value)
			{
				return Float.valueOf(value.toString());
			}
			else
			{
				return 0f;
			}
		}
		catch (Exception e)
		{
			return 0f;
		}
	}

	/**
	 * 将对象转换成BigDecimal对象，如果传入对象为 null 或 空，返回 null
	 * 
	 * @author 高洪涛 北京国网中电 2010-4-23
	 * @param value
	 * @return
	 * 
	 */
	public static BigDecimal convertObjectToBigDecimal(Object value)
	{
		try
		{
			if (null != value)
			{
				return (BigDecimal) value;
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			return null;
		}
	}

	/**
	 * 将对象转换成Short对象，如果传入对象为 null 或 空，返回 null
	 * 
	 * @author 高洪涛 北京国网中电 2010-4-23
	 * @param value
	 * @return
	 * 
	 */
	public static Short convertObjectToShort(Object value)
	{
		try
		{
			if (null != value)
			{
				return Short.parseShort(value.toString());
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将对象转换成Boolean对象，如果传入对象为 null 或 空，返回 0
	 * 
	 * @author 高洪涛 北京国网中电 2010-4-23
	 * @param value
	 * @return
	 * 
	 */
	public static Boolean convertObjectToBoolean(Object value)
	{
		try
		{
			if (null != value)
			{
				return (Boolean) value;
			}
			else
			{
				return false;
			}
		}
		catch (Exception e)
		{
			return false;
		}
	}

	/**
	 * 将对象转换成Character对象，如果传入对象为 null 或 空，返回 ' '
	 * 
	 * @param 要转换对象
	 * @return Charcter类型对象
	 */
	public static Character convertObjectToCharacter(Object value)
	{
		try
		{
			if (null != value)
			{
				return (Character) value;
			}
			else
			{
				return ' ';
			}
		}
		catch (Exception e)
		{
			return ' ';
		}
	}

	/**
	 * 将对象转换成String对象，如果传入对象为 null 或 空，返回 ""
	 * 
	 * @param 要转换对象
	 * @return String类型对象
	 */
	public static String convertObjectToString(Object value)
	{
		try
		{
			if (null != value)
			{
				return value.toString();
			}
			else
			{
				return "";
			}
		}
		catch (Exception e)
		{
			return "";
		}
	}
	
	
	//oracle.sql.Clob类型转换成String类型
    public static String convertClobToString(Clob clob) {
        String reString = "";
        Reader is = null;
        try {
            is = clob.getCharacterStream();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 得到流
        BufferedReader br = new BufferedReader(is);
        String s = null;
        try {
            s = br.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        StringBuffer sb = new StringBuffer();
        while (s != null) {
            //执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
            sb.append(s);
            try {
                s = br.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        reString = sb.toString();
        return reString;
    }

	/**
	 * 得到当前日期(2010年10月10日)，如果传入对象为 null 或 空，返回 ""
	 * 
	 * @param value
	 *            要转换时间对象
	 * @return 时间格式的字符串
	 */
	public static String convertObjectTolongDate(Object value)
	{
		try
		{
			if (null != value)
			{
				Date date = (Date) value;
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
				return simpleDateFormat.format(date);
			}
			else
			{
				return "";
			}
		}
		catch (Exception e)
		{
			return "";
		}
	}

	/**
	 * 得到当前日期(yyyy-MM-dd)，如果传入对象为 null 或 空，返回 ""
	 * 
	 * @param 要转换时间对象
	 * @return 时间格式的字符串
	 */
	public static String convertObjectToDateString(Object value)
	{
		try
		{
			if (null != value)
			{
				Date date = (Date) value;
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				return simpleDateFormat.format(date);
			}
			else
			{
				return "";
			}
		}
		catch (Exception e)
		{
			return "";
		}
	}

	/**
	 * 得到当前日期(yyyy-MM-dd HH:mm)，如果传入对象为 null 或 空，返回 ""
	 * 
	 * @param 要转换时间对象
	 * @return 时间格式的字符串
	 */
	public static String convertDateToString(Object value)
	{
		try
		{
			if (null != value)
			{
				Date date = (Date) value;
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				return simpleDateFormat.format(date);
			}
			else
			{
				return "";
			}
		}
		catch (Exception e)
		{
			return "";
		}
	}

	/**
	 * 
	 * @创建人：司徒
	 * @创建时间：2012-6-8
	 * @功能说明：根据formatType格式化时间字符串
	 * @param value
	 * @param formatType
	 * @return
	 */
	public static String convertDateToString(Object value, String formatType)
	{
		try
		{
			if (null != value)
			{
				Date date = (Date) value;
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatType);
				return simpleDateFormat.format(date);
			}
			else
			{
				return "";
			}
		}
		catch (Exception e)
		{
			return "";
		}
	}

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2011-12-30
	 * @功能说明：获得系统当前时间
	 * @return
	 */
	public static Date GetPresentTime()
	{
		try
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = new Date();
			String dateStr = format.format(d);
			return DataSwitch.convertObjectToDate(dateStr);
		}
		catch (Exception e)
		{
			logger.error("获得当前时间出错");
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2011-12-30
	 * @功能说明：获得系统当前日期
	 * @return
	 */
	public static Date GetPresentTime(String formatType)
	{
		try
		{
			SimpleDateFormat format = new SimpleDateFormat(formatType);
			Date d = new Date();
			String dateStr = format.format(d);
			return DataSwitch.convertObjectToDate(dateStr);
		}
		catch (Exception e)
		{
			logger.error("获得系统当前日期出错");
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2012-2-7
	 * @功能说明：Calendar转化为Date
	 * @param date
	 * @return
	 */
	public final static Calendar date2Calendar(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2012-2-7
	 * @功能说明：得到K天前或K天后的时间
	 * @param date
	 *            日期 格式为yyyy-MM-dd
	 * @param k
	 * @return Date类型
	 * @throws ParseException
	 */
	public final static Date getPastOrFutureDay(Date date, int k) throws ParseException
	{
		Calendar cal = date2Calendar(date);
		cal.add(Calendar.DATE, k);
		return cal.getTime();
	}

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2012-2-7
	 * @功能说明：得到K天前或K天后的时间
	 * @param date
	 *            日期 格式为yyyy-MM-dd
	 * @param k
	 * @return String类型
	 * @throws ParseException
	 */
	public final static String getPastOrFutureDayForString(Date date, int k) throws ParseException
	{
		Calendar cal = date2Calendar(date);
		cal.add(Calendar.DATE, k);
		return convertObjectToDateString(cal.getTime());

	}

	/**
	 * 
	 * @添加人：司徒彬
	 * @添加时间：2011-7-7
	 * @方法说明：转换成Date
	 * @param time
	 * @return
	 */
	public static Date convertObjectToDate(Object time)
	{
		try
		{
			String format = null;
			if (time == null || "".equals(DataSwitch.convertObjectToString(time)))
			{
				return null;
			}
			if (time.toString().contains(":"))
			{
				if (time.toString().indexOf(":") == time.toString().lastIndexOf(":"))
				{
					format = "yyyy-MM-dd HH:mm";
				}
				else
				{
					format = "yyyy-MM-dd HH:mm:ss";
				}
			}
			else
			{
				format = "yyyy-MM-dd";
			}
			return DateUtils.parseDate(time.toString(), new String[] { format });
		}
		catch (ParseException e)
		{
			logger.error("日期格式错误{" + time + "}，正确格式为：yyyy-MM-dd HH:mm");
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @param format
	 * @param time
	 * @return
	 */
	public static Date convertObjectToDateByFormat(String format, Object time)
	{
		try
		{
			return DateUtils.parseDate(time.toString(), new String[] { format });
		}
		catch (ParseException e)
		{
			logger.error("日期格式错误{" + time + "}，正确格式为：yyyy-MM-dd HH:mm");
			throw new RuntimeException(e);
		}
	}

	/**
	 * 得到当前时间(hh:mm:ss)，如果传入对象为 null 或 空，返回 ""
	 * 
	 * @param 要转换时间对象
	 * @return 时间格式的字符串
	 */
	@Deprecated
	public static String convertObjectToTimeString(Date value)
	{
		try
		{
			if (null != value)
			{
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
				return simpleDateFormat.format(value);
			}
			else
			{
				return "";
			}
		}
		catch (Exception e)
		{
			return "";
		}
	}

	/**
	 * 根据用户传入的实体类型，和页面级Map，获得返回实体
	 * 
	 * @author 高洪涛 北京国网中电 2010-4-22
	 * @param <T>
	 * @param typClass
	 * @param map
	 * @return T
	 * @throws IntrospectionException
	 * @throws Exception
	 * 
	 */
	public static <T> T ConvertDataTableToEntity(T typClass, Map<String, String[]> map)
	{
		try
		{
			BeanInfo beanInfo = Introspector.getBeanInfo(typClass.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors)
			{
				String name = propertyDescriptor.getName();
				Type type = propertyDescriptor.getPropertyType();
				String[] value = map.get(name);
				if (map.keySet().contains(name))
				{
					propertyDescriptor.getWriteMethod().invoke(typClass, getDefaultValue(Escape.unescape(value[0].trim()), type));
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		return typClass;

	}

	public static <T> T ConvertMapToEntity(T typClass, Map<String, Object> map)
	{
		try
		{
			BeanInfo beanInfo = Introspector.getBeanInfo(typClass.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors)
			{
				String name = propertyDescriptor.getName().toUpperCase();

				Type type = propertyDescriptor.getPropertyType();
				Object value = map.get(name);
				if (value == null || value.toString().length() == 0)
				{
					continue;
				}
				if (map.keySet().contains(name))
				{
					propertyDescriptor.getWriteMethod().invoke(typClass, getDefaultValue(value.toString().trim(), type));
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		return typClass;

	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> ConvertMapToEntitiesList(T typClass, List<Map<String, Object>> mapList)
	{
		List<T> list = new ArrayList<T>();
		try
		{
			BeanInfo beanInfo = Introspector.getBeanInfo(typClass.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (Map<String, Object> map : mapList)
			{
				typClass = (T) typClass.getClass().newInstance();
				for (PropertyDescriptor propertyDescriptor : propertyDescriptors)
				{
					String name = propertyDescriptor.getName().toUpperCase();

					Type type = propertyDescriptor.getPropertyType();
					Object value = map.get(name);
					if (value == null || value.toString().length() == 0)
					{
						continue;
					}
					if (map.keySet().contains(name))
					{
						propertyDescriptor.getWriteMethod().invoke(typClass, getDefaultValue(value.toString().trim(), type));
					}
				}
				list.add(typClass);
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		return list;

	}

	@SuppressWarnings("unchecked")
	public static <T> Set<T> ConvertMapToEntitiesSet(T typClass, List<Map<String, Object>> mapList)
	{
		Set<T> set = new HashSet<T>();
		try
		{
			BeanInfo beanInfo = Introspector.getBeanInfo(typClass.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (Map<String, Object> map : mapList)
			{
				typClass = (T) typClass.getClass().newInstance();
				for (PropertyDescriptor propertyDescriptor : propertyDescriptors)
				{
					String name = propertyDescriptor.getName().toUpperCase();

					Type type = propertyDescriptor.getPropertyType();
					Object value = map.get(name);
					if (value == null || value.toString().length() == 0)
					{
						continue;
					}
					if (map.keySet().contains(name))
					{
						propertyDescriptor.getWriteMethod().invoke(typClass, getDefaultValue(value.toString().trim(), type));
					}
				}
				set.add(typClass);
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return set;
	}

	@SuppressWarnings("unchecked")
	public static <T> Map<String, Object> ConvertEntityToMap(T typClass, T... childType)
	{
		Map<String, Object> map = new IdentityHashMap<String, Object>();
		try
		{

			BeanInfo beanInfo = Introspector.getBeanInfo(typClass.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors)
			{
				String name = propertyDescriptor.getName();
				if (name.endsWith("Entity") || name.endsWith("class") || name.endsWith("hibernateLazyInitializer"))
				{
					continue;
				}

				Method method = propertyDescriptor.getReadMethod();
				if (method == null)
				{
					continue;
				}
				Object value = method.invoke(typClass);
				if (propertyDescriptor.getPropertyType().equals(Set.class) || propertyDescriptor.getPropertyType().equals(List.class))
				{

					String nameTemp = name.replace("Entities", "Entity");

					if (nameTemp.equalsIgnoreCase("TTzliuchengEntityForTzlcTzsbid"))
					{

						System.out.println("111");

					}
					T entityType = null;
					for (T entityTypeTemp : childType)
					{
						String[] className = entityTypeTemp.getClass().getName().split("[.]");
						String classNameTemp = className[className.length - 1];
						if (nameTemp.equals(classNameTemp))
						{
							entityType = entityTypeTemp;
							break;
						}
					}
					if (entityType == null)
					{
						continue;
					}
					Set setValue = (Set) value;
					List<Object> childList = new ArrayList<Object>();
					for (Object object : setValue)
					{
						T newEntity = (T) object;
						Map<String, Object> childMap = ConvertEntityToMap(newEntity, childType);
						childList.add(childMap);

					}
					map.put(new String(name), childList);
				}
				else
				{
					map.put(new String(name), value);
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return map;

		// return typClass;

	}

	/*
	 * public static <T> T ConvertDataTableToEntity(T typClass, Map<String,
	 * String[]> map) { if (map != null) { try { for (String keyString :
	 * map.keySet()) { for (Field field :
	 * typClass.getClass().getDeclaredFields()) {
	 * 
	 * System.out.println("set" + new StringBuffer(field.getName()) .replace(0,
	 * 1, field .getName() .substring(0, 1) .toUpperCase()));
	 * 
	 * if (keyString.equals(field.getName())) { String[] value =
	 * map.get(keyString); Method method = typClass.getClass().getMethod( "set"
	 * + new StringBuffer(field.getName()) .replace(0, 1, field .getName()
	 * .substring(0, 1) .toUpperCase()), new Class[] { field.getType() });
	 * method .invoke(typClass, new Object[] { getDefaultValue(
	 * Escape.unescape(value[0] .trim()), field) });
	 * 
	 * }
	 * 
	 * } } } catch (Exception e) { System.out.println(e.getMessage()); } }
	 * return typClass; }
	 */

	/**
	 * 根据传入 json 字符串 及泛型类型，返回泛型集合
	 * 
	 * @author 李雪飞 北京国网中电 2010-8-16
	 * @param <T>
	 * @param typClass
	 *            泛型类
	 * @param jsonString
	 *            json字符串
	 * @return List<T> 泛型集合
	 */
	public static <T> List<T> convertObjeceToJSONArray(Class<T> typClass, String jsonString)
	{
		List<T> listTypeClass = new ArrayList<T>();
		T typeClT = null;
		try
		{
			JSONArray jsArray = new JSONArray(jsonString);
			for (int i = 0; i < jsArray.length(); i++)
			{
				typeClT = typClass.newInstance();
				JSONObject jsObject = (JSONObject) jsArray.get(i);
				for (int j = 0; j < jsObject.names().length(); j++)
				{
					String keyString = jsObject.names().get(j).toString();
					for (Field field : typeClT.getClass().getDeclaredFields())
					{
						if (keyString.equals(field.getName()))
						{
							String valueString = jsObject.getString(keyString).trim();
							Method method = typeClT.getClass().getMethod(
									"set" + new StringBuffer(field.getName()).replace(0, 1, field.getName().substring(0, 1).toUpperCase()),
									new Class[] { field.getType() });
							method.invoke(typeClT, new Object[] { getDefaultValue(Escape.unescape(valueString), field) });
						}
					}
				}
				listTypeClass.add(typeClT);
			}
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return listTypeClass;
	}

	/**
	 * 通过类型，把Object转型
	 * 
	 * @author 高洪涛 北京国网中电 2010-4-23
	 * @param value
	 * @param field
	 * @return
	 * 
	 */
	private static Object getDefaultValue(Object value, Field field)
	{
		Object resultObject = "";
		if (value == null)
		{
			resultObject = "";
		}
		else
		{
			if (field.getType() == String.class)
			{
				resultObject = convertObjectToString(value);
			}
			else if (field.getType() == Integer.class)
			{
				resultObject = convertObjectToInteger(value);
			}
			else if (field.getType() == Long.class)
			{
				resultObject = convertObjectToLong(value);
			}
			else if (field.getType() == Date.class)
			{
				resultObject = convertObjectToDate(value);
			}
			else if (field.getType() == Double.class)
			{
				resultObject = convertObjectToDouble(value);
			}
			else if (field.getType() == Float.class)
			{
				resultObject = convertObjectToFloat(value);
			}
			else if (field.getType() == Boolean.class)
			{
				resultObject = convertObjectToBoolean(value);
			}
			else if (field.getType() == BigDecimal.class)
			{
				resultObject = convertObjectToBigDecimal(value);
			}
			else
			{
				resultObject = "";
			}
		}
		return resultObject;
	}

	/**
	 * 通过类型，把Object转型
	 * 
	 * @author 司徒彬 北京国网中电 2010-4-23
	 * @param value
	 * @param field
	 * @return
	 * 
	 */
	private static Object getDefaultValue(Object value, Type type)
	{
		Object resultObject = "";
		if (value == null)
		{
			resultObject = "";
		}
		else
		{
			if (type == String.class)
			{
				resultObject = convertObjectToString(value);
			}
			else if (type == Integer.class || type == int.class)
			{
				resultObject = convertObjectToInteger(value);
			}
			else if (type == Long.class || type == long.class)
			{
				resultObject = convertObjectToLong(value);
			}
			else if (type == Date.class)
			{
				resultObject = convertObjectToDate(value);
			}
			else if (type == Double.class || type == double.class)
			{
				resultObject = convertObjectToDouble(value);
			}
			else if (type == Float.class || type == float.class)
			{
				resultObject = convertObjectToFloat(value);
			}
			else if (type == Boolean.class || type == boolean.class)
			{
				resultObject = convertObjectToBoolean(value);
			}
			else if (type == BigDecimal.class)
			{
				resultObject = convertObjectToBigDecimal(value);
			}
			else if (type == Short.class)
			{
				resultObject = convertObjectToShort(value);
			}
			else
			{
				resultObject = "";
			}
		}
		return resultObject;
	}

	/**
	 * 获取实体中现有值的方法
	 * 
	 * @author 高洪涛 北京国网中电 2010-4-22
	 * @param field
	 * @param target
	 * @return
	 * 
	 */
	private static Object getObjectValue(Field field, Object target)
	{
		Object result = null;
		try
		{
			Method method = target.getClass().getMethod("get" + new StringBuffer(field.getName()).replace(0, 1, field.getName().substring(0, 1).toUpperCase()),
					null);
			result = method.invoke(target, null);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 将 extjs 的分页参数含义，转换给 oracle row_number 函数的分页含义
	 * 
	 * @author 李雪飞 北京国网中电 2010-5-5
	 * @param start
	 *            记录开始行
	 * @param limit
	 *            往下走多少行记录
	 * @return
	 * 
	 */
	public static Vector<String> getRow_NumberParms(Integer start, Integer limit)
	{
		Vector<String> pageParms = new Vector<String>();
		try
		{
			Integer startRow = start + 1;
			Integer endRow = (start / limit + 1) * limit;
			pageParms.add(startRow.toString());
			pageParms.add(endRow.toString());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return pageParms;
	}

	public static String getJobName(String name)
	{
		if (StringUtils.isEmpty(StringUtils.trim(name)))
		{
			name = UUID.randomUUID().toString();
		}
		else
		{
			// 在名称后添加UUID，保证名称的唯一性
			name += "!" + UUID.randomUUID().toString();
		}
		return name;

	}

	/**
	 * 枚举类替换数据库查询出的常量
	 * 
	 * @author 夏意梁 北京国网中电 2011-08-01
	 * @param field
	 * @return List A
	 * @throws ClassNotFoundException
	 * @throws IntrospectionException
	 */
	@SuppressWarnings("unchecked")
	public static <T> List EnumOpration(List mapList, T enumClass, String... str) throws ClassNotFoundException, IntrospectionException
	{
		String className = enumClass.toString();
		Class clazz = Class.forName("com.gwzd.rm.model.");
		Object[] as = clazz.getEnumConstants();
		clazz.getSigners();
		BeanInfo beanInfo = Introspector.getBeanInfo(enumClass.getClass());
		@SuppressWarnings("unused")
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		Object[] fileds = enumClass.getClass().getEnumConstants();
		Method[] methods = enumClass.getClass().getMethods();
		MethodDescriptor[] ssss = beanInfo.getMethodDescriptors();

		for (Method ss : methods)
		{
			String s = ss.getName();
			System.out.println(s);
		}
		for (Object mapObject : mapList)
		{
			Map map = (Map) mapObject;
			for (String key : str)
			{
				Object value = map.get(key);

			}
		}
		return mapList;
	}

	public static <T> List<Object> ConvertEnumToList(T enumClass)
	{
		Map<String, String> maps = new HashMap<String, String>();
		try
		{
			BeanInfo beanInfo = Introspector.getBeanInfo(enumClass.getClass());

			Object[] enums = enumClass.getClass().getEnumConstants();

			for (Object enum1 : enums)
			{
				String s = enum1.toString();
			}
		}
		catch (IntrospectionException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static <T> T ConvertDataTableToEntitya(T typClass, Map<String, String[]> map)
	{
		try
		{
			BeanInfo beanInfo = Introspector.getBeanInfo(typClass.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors)
			{
				String name = propertyDescriptor.getName();
				Type type = propertyDescriptor.getPropertyType();
				String[] value = map.get(name);
				if (map.keySet().contains(name))
				{
					propertyDescriptor.getWriteMethod().invoke(typClass, getDefaultValue(Escape.unescape(value[0].trim()), type));
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		return typClass;

	}

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2012-5-29
	 * @功能说明：字符串格式转换，将str(1,2,3,4)格式的字符串转换为result('1','2','3','4')格式
	 * @param str
	 *            该参数的格式必须为1,2,3,4
	 * @return
	 */
	public static String converterStringFormat(String str)
	{
		String result = "";// 已选研究方向代码
		if (str.trim().length() != 0)
		{
			String[] strArr = str.trim().split(",");
			for (String strTemp : strArr)
			{
				result += "'" + strTemp + "',";
			}
			if (result.length() != 0)
			{
				result = result.substring(0, result.length() - 1);
			}
		}
		return result;
	}

	/**
	 * @获取周日期
	 * @修改人:焦元超
	 * @修改时间:2012.6.18
	 * @param zhou
	 *            年度
	 * @param kaiShiTime
	 *            学期代码
	 * @flag True返回周一时间 , False 返回周五时间
	 * @return Data
	 */
	public static Date GetZhouRiQi(int zhou, Date kaiShiTime, Boolean flag)
	{
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(kaiShiTime);
		if (flag)// 开始周
		{
			if (zhou > 1)
			{
				int days = (zhou - 1) * 7;
				rightNow.add(Calendar.DATE, days);
			}
		}
		else
		{
			if (zhou > 1)
			{
				int days = (zhou - 1) * 7 + 4;
				rightNow.add(Calendar.DATE, days);
			}
			else if (zhou == 1)
			{
				int days = 4;
				rightNow.add(Calendar.DATE, days);
			}
		}
		return rightNow.getTime();
	}

	/**
	 * 
	 * @创建人：司徒
	 * @创建时间：2012-12-27
	 * @功能说明： 获取支出单以及支票申领单单号
	 * @param type
	 * @return
	 */
	public static String GetDanHao(DanHaoType type)
	{
		String danHao = "";
		if (type.equals(DanHaoType.ZCD))
		{
			danHao = "ZCD";
		}
		else if (type.equals(DanHaoType.ZPSL))
		{
			danHao = "ZPSL";
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		danHao += df.format(new Date());
		return danHao;
	}

	/**
	 * 单号类型枚举 ZCD 为支出单 ZPSL为支票申领单
	 * 
	 * @author Erebus
	 * 
	 */
	public enum DanHaoType
	{
		ZPSL, ZCD
	}

	/**
	 * 参数名称：@param dateStr 待转换的日期（String格式，结构为yyyy-MM-dd） 返回值：String 小写汉字的日期
	 * 方法描述：土办法解决日期转换问题
	 * 
	 * @author：刘滔
	 */
	public static String yearStringToChineseSmall(String dateStr)
	{

		String resultStr = "";

		for (int j = 0; j < dateStr.length(); j++)
		{
			switch (dateStr.charAt(j))
			{
			case '0':
				resultStr += "〇";
				break;
			case '1':
				resultStr += "一";
				break;
			case '2':
				resultStr += "二";
				break;
			case '3':
				resultStr += "三";
				break;
			case '4':
				resultStr += "四";
				break;
			case '5':
				resultStr += "五";
				break;
			case '6':
				resultStr += "六";
				break;
			case '7':
				resultStr += "七";
				break;
			case '8':
				resultStr += "八";
				break;
			case '9':
				resultStr += "九";
				break;
			}
		}
		return resultStr;
	}

	public static String monthStringToChineseSmall(String dateStr)
	{
		if (dateStr.equals("01"))
		{
			return "一";
		}
		else if (dateStr.equals("02"))
		{
			return "二";
		}
		else if (dateStr.equals("03"))
		{
			return "三";
		}
		else if (dateStr.equals("04"))
		{
			return "四";
		}
		else if (dateStr.equals("05"))
		{
			return "五";
		}
		else if (dateStr.equals("06"))
		{
			return "六";
		}
		else if (dateStr.equals("07"))
		{
			return "七";
		}
		else if (dateStr.equals("08"))
		{
			return "八";
		}
		else if (dateStr.equals("09"))
		{
			return "九";
		}
		else if (dateStr.equals("10"))
		{
			return "十";
		}
		else if (dateStr.equals("11"))
		{
			return "十一";
		}
		else if (dateStr.equals("12"))
		{
			return "十二";
		}else{
			return "";
		}
	}

	public static String dayStringToChineseSmall(String day)
	{
		if (day.equals("01"))
		{
			return "一";
		}
		else if (day.equals("02"))
		{
			return "二";
		}
		else if (day.equals("03"))
		{
			return "三";
		}
		else if (day.equals("04"))
		{
			return "四";
		}
		else if (day.equals("05"))
		{
			return "五";
		}
		else if (day.equals("06"))
		{
			return "六";
		}
		else if (day.equals("07"))
		{
			return "七";
		}
		else if (day.equals("08"))
		{
			return "八";
		}
		else if (day.equals("09"))
		{
			return "九";
		}
		else if (day.equals("10"))
		{
			return "十";
		}
		else if (day.equals("11"))
		{
			return "十一";
		}
		else if (day.equals("12"))
		{
			return "十二";
		}
		else if (day.equals("13"))
		{
			return "十三";
		}
		else if (day.equals("14"))
		{
			return "十四";
		}
		else if (day.equals("15"))
		{
			return "十五";
		}
		else if (day.equals("16"))
		{
			return "十六";
		}
		else if (day.equals("17"))
		{
			return "十七";
		}
		else if (day.equals("18"))
		{
			return "十八";
		}
		else if (day.equals("19"))
		{
			return "十九";
		}
		else if (day.equals("20"))
		{
			return "二十";
		}
		else if (day.equals("21"))
		{
			return "二十一";
		}
		else if (day.equals("22"))
		{
			return "二十二";
		}
		else if (day.equals("23"))
		{
			return "二十三";
		}
		else if (day.equals("24"))
		{
			return "二十四";
		}
		else if (day.equals("25"))
		{
			return "二十五";
		}
		else if (day.equals("26"))
		{
			return "二十六";
		}
		else if (day.equals("27"))
		{
			return "二十七";
		}
		else if (day.equals("28"))
		{
			return "二十八";
		}
		else if (day.equals("29"))
		{
			return "二十九";
		}
		else if (day.equals("30"))
		{
			return "三十";
		}
		else if (day.equals("31"))
		{
			return "三十一";
		}else{
			return "";
		}
	}

}
