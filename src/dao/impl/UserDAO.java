package dao.impl;

import java.util.List;

import org.hibernate.*;

import vo.User;

public class UserDAO  extends BaseDAO implements IUserDAO {
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User validateUser(String username,String password){		
		String sql="from User u where u.username=? and u.password=?";
		Session session=getSession();
		Query query=session.createQuery(sql);
		query.setParameter(0,username);
		query.setParameter(1,password);
		List users=query.list();
		if(users.size()!=0)
		{
			User user=(User)users.get(0);
			return user;
		}
		session.close();
		return null;
	}
	public boolean findUser(String username){		
		String sql="from User u where u.username=?";
		Session session=getSession();
		Query query=session.createQuery(sql);
		query.setParameter(0,username);
		List users=query.list();
		if(users.size()!=0)  //如果存在用户返回false
		{
			session.close();
			return false;
		}
		else
		{
			session.close();
			return true;
		}
		
		
	}
	
	public boolean updatepwd(String username,String password,String newpassword){
		boolean validated = false;
		User u=validateUser(username,password);
		if(u!=null)
		{
			validated=true;			//标识为true表示验证成功通过
		}
		System.out.print("up"+validated);
		if(validated)			//验证成功返回字符串"success"
		{
			String sql="update User u set u.password=? where u.username=?";
			Session session=getSession();
			Query query=session.createQuery(sql);
			query.setParameter(0,newpassword);
			query.setParameter(1,username);
			query.executeUpdate();
			return true;
		}
		else 			//验证失败返回字符串"error"
		{
			return false;
		}
	}
	
	@Override
	public boolean updateMessage(Integer userid, String sex, Integer age) {
		boolean validated = false;
		String sql="update User u set u.sex=?,u.age=? where u.userid=?";
		Session session=getSession();
		Query query=session.createQuery(sql);
		query.setParameter(0,sex);
		query.setParameter(1,age);
		query.setParameter(2,userid);
		query.executeUpdate();
		return true;
	}
	
	public boolean saveUser(User user){
		boolean isunhasuser=false;
		if(findUser(user.getUsername())){
			isunhasuser=true;
		}
		System.out.print("save"+isunhasuser);
		
		if(isunhasuser==true){
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		return true;
		}
		else{
		return false;
		}
		
	}

}
