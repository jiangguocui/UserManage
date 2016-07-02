package com.usermanage.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.usermanage.entity.Degree;
import com.usermanage.entity.Political;
import com.usermanage.entity.Tmanager;
import com.usermanage.entity.Tuser;
import com.usermanage.service.DegreeService;
import com.usermanage.service.PoliticalService;
import com.usermanage.service.TmanagerService;
import com.usermanage.service.TuserService;
import com.usermanage.util.Password;

@Controller
public class UserController {
	@Resource
	private TuserService tuserService;
	@Resource
	private DegreeService degreeService;
	@Resource
	private PoliticalService politicalService;
	@Resource
	private TmanagerService tmanagerService;
	/*
	 * 返回个人信息
	 * 
	 */
	@RequestMapping(value = "web/toUserInfo{id}.do", method = RequestMethod.GET)
	public String toUserInfo(HttpServletRequest request,
			HttpServletResponse response, @PathVariable long id) {
		String t = request.getParameter("t");
		System.out.println(t);
		Tuser tuser = tuserService.findTuserById(id);
		if (tuser != null) {
			request.setAttribute("tuser", tuser);
		}
		// t=0 代表返回user。jsp t=1代表返回 modifyinfo。jsp
		if (t.equals("0")) {
			return "/web/user";
		} else {
			List<Degree> degrees = degreeService.listDegree();
			List<Political> politicals = politicalService.listPolitical();
			request.setAttribute("degrees", degrees);
			request.setAttribute("politicals", politicals);
			return "/web/modifyinfo";
		}
	}

	@RequestMapping(value = "modifyinfo{id}.do", method = RequestMethod.GET)
	public String modifyinfo(HttpServletRequest request,
			HttpServletResponse response, @PathVariable long id) {
		String userSchool = "";
		String userPhone = "";
		String userEmail = "";
		String job = "";
		String company = "";
		String msg = "";
		//t=0 代表管理那边修改用户信息 否则是用户自己修改
		String t=request.getParameter("t");
		// 获取政治面貌的id
		long politicalsId = Integer
				.parseInt(request.getParameter("politicals"));
		// 获取政治面貌对象
		Political political = politicalService.findPoliticalById(politicalsId);
		// 获取学历的id
		long degreeId = Integer.parseInt(request.getParameter("degrees"));
		// 获取学历对象
		Degree degree = degreeService.finddegreeById(degreeId);
		// 获取学校
		userSchool = request.getParameter("userSchool").trim();
		// 获取电话
		userPhone = request.getParameter("userPhone").trim();
		// 获取邮箱
		userEmail = request.getParameter("userEmail").trim();
		// 获取工作
		job = request.getParameter("job").trim();
		// 获取公司
		company = request.getParameter("company").trim();
		Tuser tuser = tuserService.findTuserById(id);
		tuser.setCompany(company);
		tuser.setDegree(degree);
		tuser.setJob(job);
		tuser.setPolitical(political);
		tuser.setUserEmail(userEmail);
		tuser.setUserSchool(userSchool);
		tuser.setUserPhone(userPhone);
		try {
			// 更新个人信息
			tuserService.updateTuser(tuser);
			msg = "修改成功";
		} catch (Exception e) {
			msg = "修改失败";
			e.printStackTrace();
		}
		List<Degree> degrees = degreeService.listDegree();
		List<Political> politicals = politicalService.listPolitical();
		request.setAttribute("degrees", degrees);
		request.setAttribute("politicals", politicals);
		request.setAttribute("tuser", tuser);
		request.setAttribute("msg", msg);
		if("0".equals(t)){
			return "/manager/modifyuserInfo";
		}
		return "/web/modifyinfo";
	}

	/*
	 * 修改密码
	 */
	@RequestMapping(value = "web/modifypassword{id}.do", method = RequestMethod.GET)
	public String modifypassword(HttpServletRequest request,
			HttpServletResponse response, @PathVariable long id) {
		String oldPassword = "";
		String newPassword = "";
		System.out.println(id+">>>>>>>>>>id");
		// 旧密码
		oldPassword = request.getParameter("oldPassword").trim();
		String sql = "from Tuser t where t.id='" + id
				+ "' and t.userPassword='" +  Password.createPassword(oldPassword) + "'";
		List<Tuser> tusers = tuserService.TuserBysql(sql);
		// 判断旧密码是否正确
		if (tusers.size() <= 0) {
			String msg = "原密码错误";
			request.setAttribute("msg", msg);
			return "/web/modifypassword";
		}
		newPassword = request.getParameter("confirmPassword").trim();
		Tuser tuser = tuserService.findTuserById(id);
		tuser.setUserPassword( Password.createPassword(newPassword));
		// 更新密码
		try {
			tuserService.updateTuser(tuser);
			// 更新成功注销
			return "redirect:/logout.do";
		} catch (Exception e) {
			e.printStackTrace();
		}
		String msg = "修改失败";
		request.setAttribute("msg", msg);
		return "/web/modifypassword";

	}
}
