package cn.com.bonde.b2b.website.action;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.bonde.b2b.website.entity.QxDlxx;
import cn.com.bonde.b2b.website.entity.QxKhxx;
import cn.com.bonde.b2b.website.service.ILoginService;
import cn.com.bonde.b2b.website.service.IRegisterService;
import cn.com.bonde.b2b.website.util.Constants;
import cn.com.bonde.b2b.website.util.MD5;
import cn.com.bonde.b2b.website.util.MyException;
import cn.com.bonde.b2b.website.util.WriteJsonToPage;

/**
 * @author Administrator
 * <p>功能描述: 客户注册管理Action，包括渠道商和供货商的网站注册，</p>
 * <p>         渠道商注册后，不立即生效，需要管理端审核并分配销售人员后才能登录，</p>
 * <p>         供货商注册后，立即可以登录</p>
 */

@Controller
@Scope("prototype")
@ParentPackage(value = "base")
@Namespace(value = "/")
@Results({ 
           @Result(name = "initRegister", location = "/pages/register.jsp")})
public class RegisterAction extends ProjectBaseAction
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5748465179322729840L;
	
	private Log log = LogFactory.getLog(RegisterAction.class);

	@Resource(name = "registerService")
	private IRegisterService registerService;
	private QxDlxx qxDlxx;
	private QxKhxx qxKhxx;
	
	private String khlb;  //页面传递的客户类别，0-渠道商，1-供货商
	

	/**
	 * @return the qxDlxx
	 */
	public QxDlxx getQxDlxx()
	{
		return qxDlxx;
	}

	/**
	 * @param qxDlxx
	 *            the qxDlxx to set
	 */
	public void setQxDlxx(QxDlxx qxDlxx)
	{
		this.qxDlxx = qxDlxx;
	}

	
    @Action(value = "initRegister")
    public String init() throws Exception {
        return "initRegister";
    }
    
    @Action(value = "addRegist")
    public void addRegist() throws Exception {
        log.info("开始保存注册信息【khlb="+khlb+", khmc="+qxKhxx.getKhMc()+"】");
        qxDlxx.setDllx("0".equalsIgnoreCase(khlb)?"1":"2");//登录类型，1-渠道商，2-供货商
        qxDlxx.setYxbz("0".equalsIgnoreCase(khlb)?"0":"1");  //有效标识，0-无效，渠道商要等管理端审核后才有效，供货商直接有效
        qxDlxx.setDlkl(MD5.getMd5(qxDlxx.getDlkl()));  //对登录口令要进行md5混淆
        qxKhxx.setDlm(qxDlxx.getDlm());
        qxKhxx.setKhlb(khlb);
        WriteJsonToPage.WriteJson(registerService.addRegistInfo(qxDlxx, qxKhxx));   //json返回
        //TODO：提交的中文，进到库里都变成乱码了，似乎是提交到action层就变成乱码了
        //TODO: 渠道商登录时，需要控制有效标识
        //TODO：电话号码的校验
    }
    

	public String getKhlb() {
		return khlb;
	}

	public void setKhlb(String khlb) {
		this.khlb = khlb;
	}

	public IRegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(IRegisterService registerService) {
		this.registerService = registerService;
	}

	public QxKhxx getQxKhxx() {
		return qxKhxx;
	}

	public void setQxKhxx(QxKhxx qxKhxx) {
		this.qxKhxx = qxKhxx;
	}
	

	
}
