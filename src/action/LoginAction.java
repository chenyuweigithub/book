package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import service.impl.IUserService;
import vo.User;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private User user;
	protected IUserService userService;
	//�û�ע�ᣬ��Service��������
	public String register(){
		User u=new User(user.getUsername(),user.getPassword(),user.getSex(),user.getAge(), null);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("user",u);
		if(userService.registerUser(u)!=null)
		{
			session.setAttribute("validated", true);
			return SUCCESS;
		}
		return ERROR;
	}
	public String updatepwd(){
		boolean validated=false;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		validated = userService.updatapwd(user.getUsername(),user.getPassword(),user.getNewpassword());
		if(validated)
		{
			session.setAttribute("validated", validated);
			return "success";
		}
		else
		{
			
			session.setAttribute("validated", validated);
			return "error";
		}	
	}
	
	public String updateMessage(){
		boolean validated=false;
		System.out.println(user.getUserid());
		validated = userService.updateMessage(user.getUserid(),user.getSex(),user.getAge());
		if(validated)
		{
			//��֤�ɹ������ַ�"success"
			return "success";
		}
		else
		{
			//��֤ʧ�ܷ����ַ�"error"
			return "error";
		}
		
	}
	
	public String logout(){
		user.setUsername("");
		user.setPassword("");
		user.setNewpassword("");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("user",null);
		System.out.println(user.getUsername());
		return "success";
	}
	
	//�����û������execute����
	public String execute() throws Exception{
		boolean validated=false;			//��֤�ɹ���ʶ
		User u=userService.validateUser(user.getUsername(), user.getPassword());
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("user",u);
		if(u!=null)
		{
			validated=true;			//��ʶΪtrue��ʾ��֤�ɹ�ͨ��
		}
		System.out.print(validated);
		if(validated)
		{
			session.setAttribute("validated", true);
			return "success";
		}
		else
		{
			//��֤ʧ�ܷ����ַ�"error"
			return "error";
		}
	}
	public User getUser(){
		return user;
	}
	public void setUser(User user){
		this.user=user;
	}
	public IUserService getUserService(){
		return this.userService;
	}
	public void setUserService(IUserService userService){
		this.userService=userService;
	}
}

