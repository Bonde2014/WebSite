package cn.com.bonde.b2b.website.util;


import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

/*
 * 错误类的使用方法：
 * 当方法报错的时候 new MyException(),如果是dao层调用 MyException(Exception exception,Class clazz,String msgString)构造方法，如果是 service 层出错，
 * 调用 MyException(String msgString) 或 MyException(String msgString, boolean isClose, boolean isReturn)
 * 
 * */
/**
 * 
 * 自定义错误日志管理类
 * 
 * @author 李雪飞 北京国网中电 2010-4-29
 * 
 */
@SuppressWarnings("unchecked")
public class MyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Log4j 错误日志
	private Logger logger = null;

	/**
	 * 自定义错误类的默认构造
	 */
	public MyException() {
	
	}

	/**
	 * 自定义错误类的构造函数，写进错误日志
	 * 
	 * @param exception
	 *            错误信息
	 * @param clazz
	 *            错误发生地点
	 * @param msgString
	 *            自己定义的错误提示，方便log4错误日志查找
	 */
	public MyException(Exception exception, Class clazz, String msgString) {
		logger = Logger.getLogger(clazz);
		String error = "Info:" + msgString;
		error += "\r\n Class:" + clazz.getName();
		if (exception.getMessage() != null) {
			error += "\r\n Message:" + exception.getMessage();
		}
		if (exception.getCause() != null) {
			error += "\r\n Cause:" + exception.getCause();
		}
		if(clazz.getName().endsWith("Action")||clazz.getName().endsWith("action")||clazz.getName().contains("Action")){
		   ServletActionContext.getRequest().setAttribute("errString", msgString);
		   logger.error(error,exception);
		}else{
			logger.error(error);
		}
		exception.printStackTrace();
	}

	/**
	 * 自定义错误类的构造函数，展示给用户
	 * 
	 * @param msgString
	 *            展示给页面的错误信息
	 */
	public MyException(String msgString) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("errString", msgString);
		logger = Logger.getRootLogger();
		logger.error(msgString);
	}

	public MyException(Class clazz, String msgString) {
		logger = Logger.getRootLogger();
		logger.error(clazz.getName() + msgString);
	}

	/**
	 * 自定义错误类的构造函数，展示给用户
	 * 
	 * @param msgString
	 *            展示给页面用的错误信息
	 * @param isClose
	 *            错误页面是否有关闭按钮， True 显示，Flase 不显示
	 * @param isReturn
	 *            错误页面是否有返回按钮， True 显示，Flase 不显示
	 */
	public MyException(String msgString, boolean isClose, boolean isReturn) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("errString", msgString);
		session.setAttribute("isClose", isClose);
		session.setAttribute("isReturn", isReturn);
	}
}
