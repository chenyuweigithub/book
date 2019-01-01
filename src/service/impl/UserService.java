package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import vo.User;
import dao.impl.IUserDAO;

public class UserService implements IUserService{
	private IUserDAO userDAO;
	//实现直接（仅验证）的登录服务，适用于已有账号的用户
	public User validateUser(String username,String password){
		return userDAO.validateUser(username, password);
	}

	//实现（注册＋验证）的登录服务，适用于初次注册的用户
	public User registerUser(User user){
		//由于这项业务要经过注册、验证两个阶段，先后使用userDAO接口的两个方法
		boolean b = userDAO.saveUser(user);			//把注册的账号信息写入数据库
		//随即开始验证
		if(b==true)
		return userDAO.validateUser(user.getUsername(), user.getPassword());
		else 
		return null;
	}
	public IUserDAO getUserDAO(){
		return userDAO;
	}
	public void setUserDAO(IUserDAO userDAO){
		this.userDAO=userDAO;
	}

	@Override
	public boolean updatapwd(String username, String password, String newpassword) {	
		return userDAO.updatepwd(username, password, newpassword);
		// TODO Auto-generated method stub
	}

	@Override
	public boolean updateMessage(Integer userid, String sex, Integer age) {
		// TODO Auto-generated method stub
		return userDAO.updateMessage(userid, sex, age);
	}
}
