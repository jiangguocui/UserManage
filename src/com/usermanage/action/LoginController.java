package com.usermanage.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usermanage.entity.Tmanager;
import com.usermanage.entity.Tuser;
import com.usermanage.service.TmanagerService;
import com.usermanage.service.TuserService;
import com.usermanage.util.Password;

@Controller
public class LoginController {
	@Resource
	private TuserService tuserService;
	@Resource
	private TmanagerService tmanagerService;
	/*
	 * 登录
	 */
	@RequestMapping(value = "login")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		
		String msg = "";
		String uname = request.getParameter("uname").trim();
		String password = request.getParameter("password").trim();
		//判断用户类型用的 user=0代表普通用户 *user=1代表管理员
		String user=request.getParameter("type");
		System.out.println(user+">>>>>>>>");
		if (uname.length() == 0 || uname.length() == 0) {
			msg = "请填写完整信息";
			request.setAttribute("msg", msg);
			return "index";

		} 
		if("0".equals(user)){
			String sql = "from Tuser t where (t.userPhone='" + uname
					+ "' and " + "t.userPassword='" + Password.createPassword(password)+ "')"
					+" or (t.userEmail='" + uname
					+ "' and " + "t.userPassword='" + Password.createPassword(password)+ "')";
		/*String sql = "from Tuser t where (t.userPhone=?"
				+ " and " + "t.userPassword=?)"
				+" or (t.userEmail=?"
				+ " and " + "t.userPassword=?)";*/
			List<Tuser> tusers=tuserService.TuserBysql(sql);
			if(tusers.size()<=0){
				msg="用户名或密码错误";
				request.setAttribute("msg", msg);
				return "index";
			}
				//将用户存入session
				HttpSession session=request.getSession();
				//SessionListener.isLogined(session, userLogins.get(0).getUsername());
				request.getSession().setAttribute("loginUser", tusers.get(0));
				return "/web/welcome";
		}else{
			String sql = "from Tmanager t where (t.managerPhone='" + uname
					+ "' and " + "t.managerPassword='" + Password.createPassword(password)+ "')"
					+" or (t.managerEmail='" + uname
					+ "' and " + "t.managerPassword='" + Password.createPassword(password)+ "')";
			List<Tmanager> tmanagers=tmanagerService.TmanagerBysql(sql);
			if(tmanagers.size()<=0){
				msg="用户名或密码错误";
				request.setAttribute("msg", msg);
				return "index";
			}
				//将用户存入session
				request.getSession().setAttribute("mloginUser", tmanagers.get(0));
			return "/manager/welcome";
		}
	}
	/*
	 注销
	 */
	@RequestMapping(value="logout.do")
	public String logout(HttpServletRequest request ,HttpServletResponse response ){
		request.getSession().invalidate();
		return "index";
	}

}
