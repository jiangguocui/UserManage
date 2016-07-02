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
import com.usermanage.util.Fenye;
import com.usermanage.util.Password;

@Controller
@RequestMapping(value="manager")
public class ManagerController {
	@Resource
	private TmanagerService tmanagerService;
	@Resource
	private TuserService tuserService;
	@Resource
	private DegreeService degreeService;
	@Resource
	private PoliticalService politicalService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "tolistUser")
	public String tolistUser(HttpServletRequest request,
			HttpServletResponse response) {
		List<Tuser> tusers = tuserService.listTuser();
		// 开始分页
		int record = 1;
		if (request.getParameter("record") != null)
			record = Integer.parseInt(request.getParameter("record"));
		int pageRecords = 5; // 每页显示的记录数
		int allRecords = tusers.size(); // 总的记录
		int allPage = (allRecords - 1) / pageRecords + 1; // 总页数
		Fenye pages = new Fenye();
		tusers = pages.fenYe(tusers, pageRecords, record, allPage, allRecords);// 调用Pages的方法，进行分页
		request.setAttribute("record", record);// 当前页
		request.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
		request.setAttribute("allPage", allPage);// 总的页数*/
		request.setAttribute("tusers", tusers);
		return "/manager/listUser";

	}

	@RequestMapping(value = "toUserinfoBy{id}", method = RequestMethod.GET)
	public String toUserInfo(HttpServletRequest request,
			HttpServletResponse response, @PathVariable long id) {
		Tuser tuser = tuserService.findTuserById(id);
		if (tuser != null) {
			request.setAttribute("tuser", tuser);
		}
		List<Degree> degrees = degreeService.listDegree();
		List<Political> politicals = politicalService.listPolitical();
		request.setAttribute("degrees", degrees);
		request.setAttribute("politicals", politicals);
		return "/manager/modifyuserInfo";

	}
	//删除用户
	@RequestMapping("deleteUser{id}.html")
	public String deleteUser(HttpServletRequest request,
			HttpServletResponse response, @PathVariable long id, int record) {
		tuserService.deleteTuser(id);

		return "redirect:tolistUser?record=" + record;
	}

	/*
	 * 定位到添加页面
	 */
	@RequestMapping(value = "toAdduserInfo")
	public String toAdduserInfo(HttpServletRequest request,
			HttpServletResponse response) {
		List<Degree> degrees = degreeService.listDegree();
		List<Political> politicals = politicalService.listPolitical();
		request.setAttribute("degrees", degrees);
		request.setAttribute("politicals", politicals);
		return "/manager/adduserInfo";

	}

	/*
	 * 实现添加
	 */
	@RequestMapping(value = "addinfo{id}", method = RequestMethod.GET)
	public String modifyinfo(HttpServletRequest request,
			HttpServletResponse response) {
		String userSchool = "";
		String userPhone = "";
		String userEmail = "";
		String job = "";
		String company = "";
		String msg = "";
		String userName = "";
		String userBirthday = "";
		String userGender = "";
		// 获取用户姓名
		userName = request.getParameter("userName").trim();
		System.out.println(userName+">>>>>>>>>userName");
		// 获取用户生日
		userBirthday = request.getParameter("userBirthday").trim();
		// 获取用户性别
		userGender = request.getParameter("userGender").trim();
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
		//判断邮箱或电话是否存在
		String sql="from Tuser t where t.userPhone='"+userPhone+"' or t.userEmail='"+userEmail+"'";
		List<Tuser> list=tuserService.TuserBysql(sql);
		if(list.size()>0){
			return "redirect:tolistUser";
		}else{
		Tuser tuser = new Tuser();
		tuser.setCompany(company);
		tuser.setDegree(degree);
		tuser.setJob(job);
		tuser.setPolitical(political);
		tuser.setUserEmail(userEmail);
		tuser.setUserSchool(userSchool);
		tuser.setUserPhone(userPhone);
		tuser.setUserName(userName);
		tuser.setUserGender(userGender);
		tuser.setUserBirthday(userBirthday);
		tuser.setUserPassword(Password.createPassword("123456"));
		try {
			// 更新个人信息
			tuserService.saveTuser(tuser);
			msg = "添加成功";
		} catch (Exception e) {
			msg = "添加失败";
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		return "redirect:tolistUser";
		}
	}

	/*
	 * 管理员修改密码
	 */
	@RequestMapping(value = "modifyMpassword{managerId}.do", method = RequestMethod.GET)
	public String modifypassword(HttpServletRequest request,
			HttpServletResponse response, @PathVariable long managerId) {
	/*	Tmanager mloginUser=(Tmanager) request.getSession().getAttribute("mloginUser");
		if(mloginUser==null){
			return "index";
		}*/
		String oldPassword = "";
		String newPassword = "";
		// 旧密码
		oldPassword = request.getParameter("oldPassword").trim();
		String sql = "from Tmanager t where t.managerId='" + managerId
				+ "' and t.managerPassword='"
				+ Password.createPassword(oldPassword) + "'";
		List<Tmanager> tmanagers = tmanagerService.TmanagerBysql(sql);
		// 判断旧密码是否正确
		if (tmanagers.size() <= 0) {
			String msg = "原密码错误";
			request.setAttribute("msg", msg);
			return "/manager/modifypassword";
		}
		newPassword = request.getParameter("confirmPassword").trim();
		Tmanager tmanager = tmanagerService.findTmanagerById(managerId);
		tmanager.setManagerPassword(Password.createPassword(newPassword));
		// 更新密码
		try {
			tmanagerService.updateTmanager(tmanager);
			// 更新成功注销
			return "redirect:/logout.do";
		} catch (Exception e) {
			e.printStackTrace();
		}
		String msg = "修改失败";
		request.setAttribute("msg", msg);
		return "/manager/modifypassword";

	}

	/*
	 * 返回学历列表
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "tolistDegree")
	public String tolistDegree(HttpServletRequest request,
			HttpServletResponse response) {
	/*	Tmanager mloginUser=(Tmanager) request.getSession().getAttribute("mloginUser");
		if(mloginUser==null){
			return "index";
		}*/
		List<Degree> degrees = degreeService.listDegree();
		// 开始分页
		int record = 1;
		if (request.getParameter("record") != null)
			record = Integer.parseInt(request.getParameter("record"));
		int pageRecords = 5; // 每页显示的记录数
		int allRecords = degrees.size(); // 总的记录
		int allPage = (allRecords - 1) / pageRecords + 1; // 总页数
		Fenye pages = new Fenye();
		degrees = pages
				.fenYe(degrees, pageRecords, record, allPage, allRecords);// 调用Pages的方法，进行分页
		request.setAttribute("record", record);// 当前页
		request.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
		request.setAttribute("allPage", allPage);// 总的页数*/
		request.setAttribute("degrees", degrees);
		return "/manager/listDegree";

	}
	/*
	 * 删除学历
	 */
	@RequestMapping(value="deleteDegree{id}.html")
	public String deleteDegree(HttpServletRequest request,
			HttpServletResponse response, @PathVariable long id, int record) {
		degreeService.deletedegree(id);

		return "redirect:tolistDegree?record=" + record;
	}
	
	/*
	 * 添加学历
	 */
	@RequestMapping(value="addDegree")
	public String addDegree(HttpServletRequest request,HttpServletResponse response){
		/*Tmanager mloginUser=(Tmanager) request.getSession().getAttribute("mloginUser");
		if(mloginUser==null){
			return "index";
		}*/
		String name="";
		name=request.getParameter("name");
		Degree degree=new Degree();
		degree.setName(name);
		try {
			degreeService.saveDegree(degree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:tolistDegree";
	}
	/*
	 * 修改学历
	 */
	@RequestMapping(value="modifyDegree.html")
	public String modifyDegree(HttpServletRequest request,HttpServletResponse response){
		/*Tmanager mloginUser=(Tmanager) request.getSession().getAttribute("mloginUser");
		if(mloginUser==null){
			return "index";
		}*/
		long id=Integer.parseInt(request.getParameter("id"));
		int record =Integer.parseInt(request.getParameter("record"));
		String name=request.getParameter("name");
		Degree degree=degreeService.finddegreeById(id);
		degree.setName(name);
		degreeService.updateDegree(degree);
		return "redirect:tolistDegree?record=" + record;
		
	}
	/*
	 * 返回政治面貌列表
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "tolistPolitical")
	public String tolistPolitical(HttpServletRequest request,
			HttpServletResponse response) {
	/*	Tmanager mloginUser=(Tmanager) request.getSession().getAttribute("mloginUser");
		if(mloginUser==null){
			return "index";
		}*/
		List<Political> politicals = politicalService.listPolitical();
		// 开始分页
		int record = 1;
		if (request.getParameter("record") != null)
			record = Integer.parseInt(request.getParameter("record"));
		int pageRecords = 5; // 每页显示的记录数
		int allRecords = politicals.size(); // 总的记录
		int allPage = (allRecords - 1) / pageRecords + 1; // 总页数
		Fenye pages = new Fenye();
		politicals = pages
				.fenYe(politicals, pageRecords, record, allPage, allRecords);// 调用Pages的方法，进行分页
		request.setAttribute("record", record);// 当前页
		request.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
		request.setAttribute("allPage", allPage);// 总的页数*/
		request.setAttribute("politicals", politicals);
		return "/manager/listPolitical";

	}
	/*
	 * 添加政治面貌
	 */
	@RequestMapping(value="addPolitical")
	public String addPolitical(HttpServletRequest request,HttpServletResponse response){
		/*Tmanager mloginUser=(Tmanager) request.getSession().getAttribute("mloginUser");
		if(mloginUser==null){
			return "index";
		}*/
		String name="";
		name=request.getParameter("name");
		Political political=new Political();
		political.setName(name);
		try {
			politicalService.savePolitical(political);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:tolistPolitical";
	}
	/*
	 * 删除政治面貌
	 */
	@RequestMapping(value="deletePolitical{id}.html")
	public String deletePolitical(HttpServletRequest request,
			HttpServletResponse response, @PathVariable long id, int record) {
		politicalService.deletePolitical(id);
		return "redirect:tolistPolitical?record=" + record;
	}
	/*
	 * 修改学历
	 */
	@RequestMapping(value="modifyPolitical.html")
	public String modifyPolitical(HttpServletRequest request,HttpServletResponse response){
		long id=Integer.parseInt(request.getParameter("id"));
		int record =Integer.parseInt(request.getParameter("record"));
		String name=request.getParameter("name");
		Political political=politicalService.findPoliticalById(id);
		political.setName(name);
		politicalService.updatePolitical(political);
		return "redirect:tolistPolitical?record=" + record;
		
	}

}
