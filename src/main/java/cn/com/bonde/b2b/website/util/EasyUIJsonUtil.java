package cn.com.bonde.b2b.website.util;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

/**
 * EasyUIJson工具
 * @author 强当安
 *
 */
public class EasyUIJsonUtil {
	/**
	 * 
	 * @功能描述: 生成easyui的json字符串
	 * @创建人: 强当安
	 * @创建时间: Jun 3, 2014 10:52:06 AM
	 * @param pager
	 * @return String 返回类型
	 */
	public static String getEasyUIJsonStr(Pager pager){
		String jsonStr="";
		Gson gson=new Gson();
		jsonStr=gson.toJson(pager);
		System.out.println("jsonStr= "+jsonStr);
		return jsonStr;
	}
	/***
	  * @功能描述:生成绘图用json数据
	  * @创建人:刘凯
	  * @创建时间:2014-7-9   上午10:19:50
	  * @param list
	  * @param key
	  * @param value
	  * @return 绘图用json数据
	 */
	public static String getHighchartsJson(List<Map<String, Object>> list, String key, String value){
		
		String highchartsJson = "[";
		for(Map<String, Object> rysymjMap : list){
			highchartsJson += "['" + rysymjMap.get(key) + "'," + rysymjMap.get(value) + "],";
		}
			
		highchartsJson = highchartsJson + "]";		
		return highchartsJson;
	}

}
