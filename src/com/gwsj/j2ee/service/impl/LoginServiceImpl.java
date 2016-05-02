package com.gwsj.j2ee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwsj.j2ee.Constant.Constant;
import com.gwsj.j2ee.Dao.LoginDao;
import com.gwsj.j2ee.Dao.RegisterDao;
import com.gwsj.j2ee.pojo.Student_Info;
import com.gwsj.j2ee.service.ILoginService;
import com.gwsj.j2ee.vo.Result;
import com.gwsj.j2ee.vo.StudentInfoVo;
import com.gwsj.j2ee.vo.UserVo;

@Service
public class LoginServiceImpl implements ILoginService{

	@Autowired
	private LoginDao logindao;
	
	@Autowired
	private RegisterDao registerdao;
	
	public boolean isSuccessLogin(UserVo userVo) {
		// TODO Auto-generated method stub
		
		return logindao.findbyUserVo(userVo);
		
	}

	public boolean isSuccessRegister(StudentInfoVo studentInfoVo,Result result) {
		// TODO Auto-generated method stub
		
		try{
			
			if(studentInfoVo != null)
			{
				
				Student_Info studentInfo=new Student_Info();
				studentInfo.setStudent_id(Integer.valueOf(studentInfoVo.getStudent_id()));
				studentInfo.setStudent_name(studentInfoVo.getStudent_name());
				studentInfo.setStudent_college(studentInfoVo.getStudent_college());
				studentInfo.setStudent_password(studentInfoVo.getStudent_password());
				studentInfo.setStudent_sex(Integer.valueOf(studentInfoVo.getStudent_sex()));
				return logindao.save(studentInfo);
			}
			
		}catch(Exception e)
		{
			result.setErrNum(Constant.REGISTER_IS_EXIST);
			return false;
		}
		
		return false;
	}
	


}
