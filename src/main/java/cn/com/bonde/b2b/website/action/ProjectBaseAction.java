/**
 * 
 */
package cn.com.bonde.b2b.website.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.com.bonde.b2b.website.util.DataSwitch;

import com.opensymphony.xwork2.ActionSupport;


public class ProjectBaseAction extends ActionSupport {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4281801356502607766L;


    /**
     * 获取HttpServletResponse对象
     * 
     * @return
     */
    public HttpServletResponse getResponse() {
    	
        return ServletActionContext.getResponse();
    }

    /**
     * 获取HttpServletRequest对象
     * 
     * @return
     */
    public HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    /**
     * 为HttpServletRequest设置属性
     * 
     * @param attrName
     * @param attrValue
     */
    public void setReuestAttr(String attrName, Object attrValue) {
        getRequest().setAttribute(attrName, attrValue);
    }

    /**
     * 获取session属性
     * 
     * @return
     */
    public HttpSession getSession() {
        return ServletActionContext.getRequest().getSession();
    }

    /**
     * 为session设置属性
     * 
     * @param attrName
     * @param attrValue
     */
    public void setSessionAttr(String attrName, Object attrValue) {
        getSession().setAttribute(attrName, attrValue);
    }

    /**
     * 页面参数转换成实体 创建人：焦元超 创建时间：2012-4-23
     * 
     * @param attrName
     * @param attrValue
     */
    @SuppressWarnings("unchecked")
    public <T> T ConvertDataTableToEntity(Class<T> typClass) throws Exception {

        try {
            T t = typClass.newInstance();
            Map map = this.getRequest().getParameterMap();
            return (T) DataSwitch.ConvertDataTableToEntity(t, map);
        } catch (Exception e) {
            throw e;
        }
    }

    
    

    /**
     * 
     * @创建人：司徒
     * @创建时间：2012-6-6
     * @功能说明：根据参数名获得参数
     * @param paraName
     * @return
     */
    public String getParameter(String paraName) {
        return DataSwitch.convertObjectToString(this.getRequest().getParameter(
                paraName));
    }


    /**
     * jyc ajax url中文解码
     * 
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public String GetURLDecode(String strValue) {
        try {
            return URLDecoder.decode(strValue, "utf-8");
        } catch (Exception ex) {
        }
        return "";
    }



    /**
     * 
     * @创建人：应洪峰
     * @创建时间：2012-11-9
     * @功能说明：返回一个即将新建临时文件的抽象路径
     * @param type
     * @return
     */
    public String getFileUrl(String type) {
        return "Resource/fileTemp/" + UUID.randomUUID() + "."+type;
    }
    

    /**
     * 
     * @创建人：应洪峰
     * @创建时间：2012-9-25
     * @功能说明：返回一个即将创建临时文件的抽象路径
     * @return
     */
    public String getTargetDirUrl() {
        return "Resource/fileTemp/" + UUID.randomUUID();
    }
    
    
    /**
     * 
     * @创建人：应洪峰
     * @创建时间：2012-7-20
     * @功能说明：根据文件的相对路径获取该文件的绝对路径
     * @param fileUrl
     * @return
     */
    public String getAbsolutePath(String fileUrl) {
        return ServletActionContext.getServletContext().getRealPath(fileUrl);
    }

}
