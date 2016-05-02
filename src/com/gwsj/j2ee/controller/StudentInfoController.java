package com.gwsj.j2ee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gwsj.j2ee.Constant.Constant;
import com.gwsj.j2ee.pojo.Student_Info;
import com.gwsj.j2ee.service.IStudentInfoService;
import com.gwsj.j2ee.service.impl.StudentInfoServiceImpl;
import com.gwsj.j2ee.vo.Result;

@Controller
public class StudentInfoController extends BaseController{

	@Autowired 
	private IStudentInfoService StudentInfoService;
	
	/*
	 * 增加学生信息的方法
	 * 
	 */
	@RequestMapping("/addStudentInfo")
	public String addStudentInfo(@RequestParam(required=true) Integer userid,@RequestParam(required=true) String password)
	{
		Student_Info student_Info=new Student_Info();
		student_Info.setStudent_id(userid);
		student_Info.setStudent_name("张三");
		student_Info.setStudent_college("计算机与软件学院");
		student_Info.setStudent_password(password);
		student_Info.setStudent_sex(1);
		
		if(StudentInfoService.addStudentInfo(student_Info))
		{
			return "/WEB-INF/pages/system.jsp";
		}
		
		else{
			return "/login.jsp";
		}
		
		
	}
	/*
	 * 
	 * 删除学生的方法
	 */
	@RequestMapping("/deleteStudentInfo")
	@ResponseBody public Result deleteStudentInfo(@RequestParam(required=true) Integer userid)
	{
		Result result=new Result();
		if(StudentInfoService.deleteStudentInfo(userid))
		{
			result.setErrNum(Constant.ALL_HANDLE_SUCCESS);
			result.setMessage(getMessage(Constant.ALL_HANDLE_SUCCESS));
			result.setData(null);
		}
		return result;
	}
	
	
}
