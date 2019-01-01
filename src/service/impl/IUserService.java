package service.impl;

import vo.User;

public interface IUserService {
		public User validateUser(String username,String password);
		public User registerUser(User user);			//ÊµÏÖ£¨×¢²á£«µÇÂ¼£©µÄService
		public boolean updatapwd(String username,String password,String newpassword);	
		public boolean updateMessage(Integer userid,String sex,Integer age);
}
