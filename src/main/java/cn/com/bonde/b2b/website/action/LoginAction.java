package cn.com.bonde.b2b.website.action;

import cn.com.bonde.b2b.website.dao.IUserDAO;
import cn.com.bonde.b2b.website.vo.User;

public class LoginAction extends ProjectBaseAction {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5748465179322729840L;
    
    private IUserDAO userDAO;
    
    
    public String login(){
        User user = userDAO.findUserByNameAndPass(getParameter("username"), getParameter("password"));
        userDAO.saveUser(getParameter("username"), getParameter("password"));
        return SUCCESS;
    }


    /**
     * @return the userDAO
     */
    public IUserDAO getUserDAO() {
        return userDAO;
    }


    /**
     * @param userDAO the userDAO to set
     */
    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

}
