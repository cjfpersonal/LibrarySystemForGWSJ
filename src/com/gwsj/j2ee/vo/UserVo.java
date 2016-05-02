package com.gwsj.j2ee.vo;

public class UserVo {
	
	public String userid;
	public String password;
	public String statue;
	
	public UserVo() {}
	
	

	public UserVo(String userid, String password, String statue) {
		this.userid = userid;
		this.password = password;
		this.statue = statue;
	}



	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getStatue() {
		return statue;
	}


	public void setStatue(String statue) {
		this.statue = statue;
	}




}
