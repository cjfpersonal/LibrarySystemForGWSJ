package com.gwsj.j2ee.service;

import org.springframework.stereotype.Service;

import com.gwsj.j2ee.vo.Result;
import com.gwsj.j2ee.vo.StudentInfoVo;
import com.gwsj.j2ee.vo.UserVo;


public interface ILoginService{

	
	/**
	 * 该方法验证用户名和密码
	 * @param UserVo
	 * @return boolean
	 * 
	 * true表示登录成功,false表示登录失败 
	 * 
	 */
	boolean isSuccessLogin(UserVo userVo);
	/**
	 * 該方法为注册方法
	 * @param StudentInfoVo
	 * @return boolean
	 * 
	 * true表示注册成功，false表示注册失败
	 */
	boolean isSuccessRegister(StudentInfoVo studentInfoVo,Result result);
	
}
