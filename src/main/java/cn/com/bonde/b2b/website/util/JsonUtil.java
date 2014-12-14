package cn.com.bonde.b2b.website.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.google.gson.Gson;

public class JsonUtil {
	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2012-5-17
	 * @功能说明：根据jsonObject获得相应的Map
	 * @param jsonObject
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getMapFromJsonObject(JSONObject jsonObject)throws Exception {
		try {
			Iterator<String> keyIter = jsonObject.keys();
			String key;
			Object value;
			Map<String, Object> valueMap = new HashMap<String, Object>();
			while (keyIter.hasNext()) {
				key = keyIter.next();
				value = jsonObject.get(key);
				valueMap.put(key, value);
			}
			return valueMap;
		} catch (JSONException e) {
			throw e;
		}
	}

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2012-5-17
	 * @功能说明：json字符串转换为List<Map>集合
	 * @param jsonStr
	 * @return
	 */
	public static List<Map<String, Object>> getListFromJson(String jsonStr) {
		List<Map<String, Object>> list = null;
		try {
			JSONArray jsonArray = JSONArray.fromObject(string2Json(jsonStr));
			JSONObject jsonObject;
			list = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < jsonArray.size(); i++) {
				jsonObject = jsonArray.getJSONObject(i);
				list.add(getMapFromJsonObject(jsonObject));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * @function 将json字符串转换为 List<Map<String, Object>>
	 * @param jsonStr
	 * @return
	 */
	public static List<Map<String, Object>> convertJsonStrToList(String jsonStr) {
		List<Map<String, Object>> list = null;
		try {
			JSONArray jsonArray = JSONArray.fromObject(jsonStr);
			JSONObject jsonObject;
			list = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < jsonArray.size(); i++) {
				jsonObject = jsonArray.getJSONObject(i);
				list.add(getMapFromJsonObject(jsonObject));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	/**
     * JSON字符串特殊字符处理，比如：“\A1;1300”
     * @param s
     * @return String
     */
    public static String string2Json(String s) {      
        StringBuffer sb = new StringBuffer();      
        for (int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);  
        	 switch (c){
             case '\\':      
                 sb.append("\\\\");      
                 break;      
             case '/':      
                 sb.append("\\/");      
                 break;      
             case '\b':      
                 sb.append("\\b");      
                 break;      
             case '\f':      
                 sb.append("\\f");      
                 break;      
             case '\n':      
                 sb.append("\\n");      
                 break;      
             case '\r':      
                 sb.append("\\r");      
                 break;      
             case '\t':      
                 sb.append("\\t");      
                 break;      
             default:      
                 sb.append(c);   
        	 }
         }    
        return sb.toString();   
        }
	
	
	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2012-5-17
	 * @功能说明：json字符串转换为实体,包括实体中外键关系的子实体
	 * @param <T>
	 * @param json
	 * @param classType
	 * @return
	 */
	public static <T> T getEntityFromJson(String json, Class<T> classType) {
		T entity = null;
		try {
			entity = classType.newInstance();
			Gson gson = new Gson();
			entity = gson.fromJson(string2Json(json), classType);
		} catch (Exception e) {
			new MyException(e, JsonUtil.class, "json字符串转换为实体异常！");
		}
		return entity;
	}
	
	
	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2012-5-17
	 * @功能说明：objcet转换为json字符串
	 * @param obj
	 * @return
	 */
	public static String getJsonFromObject(Object obj){
		String json = "";
		try{
		Gson gson = new Gson();
		json=gson.toJson(obj);
		}catch (Exception e) {
			new MyException(e, JsonUtil.class, "objcet转换为json字符串异常！");
		}
		return json;
	}
	
}
