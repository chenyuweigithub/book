package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import vo.User;
import dao.impl.IUserDAO;

public class UserService implements IUserService{
	private IUserDAO userDAO;
	//ʵ��ֱ�ӣ�����֤���ĵ�¼���������������˺ŵ��û�
	public User validateUser(String username,String password){
		return userDAO.validateUser(username, password);
	}

	//ʵ�֣�ע�ᣫ��֤���ĵ�¼���������ڳ���ע����û�
	public User registerUser(User user){
		//��������ҵ��Ҫ����ע�ᡢ��֤�����׶Σ��Ⱥ�ʹ��userDAO�ӿڵ���������
		boolean b = userDAO.saveUser(user);			//��ע����˺���Ϣд�����ݿ�
		//�漴��ʼ��֤
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
