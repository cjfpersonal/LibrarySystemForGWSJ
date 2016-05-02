package com.gwsj.j2ee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gwsj.j2ee.Constant.Constant;
import com.gwsj.j2ee.service.ILoginService;
import com.gwsj.j2ee.vo.Result;
import com.gwsj.j2ee.vo.StudentInfoVo;
import com.gwsj.j2ee.vo.UserVo;

@Controller
public class LoginController extends BaseController{

	@Autowired
	private ILoginService loginService;
	
	@RequestMapping("/login")
	@ResponseBody public Result Login(@RequestBody UserVo userVo,HttpServletResponse httpServletResponse,HttpSession httpSession,Model model)
	{
		Result result=new Result();
		System.out.println(userVo.getUserid() + " ------"+userVo.getPassword()+"----"+userVo.getStatue());
		if(loginService.isSuccessLogin(userVo))
		{
		  
			httpSession.setAttribute(Constant.SESSION_USER, userVo.getUserid());
			result.setErrNum(Constant.ALL_HANDLE_SUCCESS);
		}
		
		else{
		   result.setErrNum(Constant.LOGIN_NOT_SUCCESS);
		}
		return result;
	}	
	
	@RequestMapping("/register")
	@ResponseBody public Result register(@RequestBody StudentInfoVo studentInfoVo,HttpServletResponse httpServletResponse,HttpSession httpSession,Model model)
	{
		Result result=new Result();
		if(loginService.isSuccessRegister(studentInfoVo,result))
		{
			result.setErrNum(Constant.ALL_HANDLE_SUCCESS);
		}
		return result;
	}	
	
}
