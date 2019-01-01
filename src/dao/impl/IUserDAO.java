package dao.impl;

import vo.User;
public interface IUserDAO{
	public User validateUser(String username,String password);
	public boolean saveUser(User user);
	public boolean updatepwd(String username,String password,String newpassword);
	public boolean updateMessage(Integer username,String sex,Integer age);
}
