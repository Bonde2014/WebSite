package cn.com.bonde.b2b.website.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

/**
 * 定义输出到页面json
 * 
 * @author 李雪飞 北京国网中电 2010-7-29
 * 
 */
public class WriteJsonToPage {
	public static void WriteJson(Object json) {
		if (json == null) {
			json = "";
		}
		String jsonString = json.toString();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = null;
		try {
			 writer = response.getWriter();
			writer.write(jsonString);
			System.out.println(jsonString);
		} catch (IOException e) {
			System.out.println("向页面输出是出现错误！");
		}
		finally{
			if(writer !=null){
				writer.close();
			}
		}
	}
}
