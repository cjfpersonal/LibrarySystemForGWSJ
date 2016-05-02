// JavaScript Document
/*鼠标光环*/
var oCenter=document.getElementsByClassName("center");
var oHuan=document.getElementsByClassName("huan");
var r=70;
var t=8;
var kuoda=1;
var timer=null;
clearInterval(timer);
timer=setInterval(function(){
	t++;r=r-kuoda;if(r<25||r>75){kuoda=-kuoda;}
	for(var i=0;i<oHuan.length;i++) {
		var jiaoduX = Math.sin((i * 30-t) * Math.PI / 180) * r;
		var jiaoduY = Math.cos((i * 30-t) * Math.PI / 180) * r;
		oHuan[i].style.left = oCenter[0].offsetLeft + jiaoduX + "px";
		oHuan[i].style.top = oCenter[0].offsetTop + jiaoduY + "px";
	}
},30);
clearInterval(timer);
onmousemove=function(ev){
	var oCenter=document.getElementsByClassName("center");
	var e=ev||event;
	oCenter[0].style.left=e.clientX-oCenter[0].offsetWidth/2+parseInt(document.body.scrollLeft)+"px";
	oCenter[0].style.top=e.clientY-oCenter[0].offsetHeight/2+parseInt(document.body.scrollTop)+"px";
	if(parseInt(oCenter[0].style.left)<parseInt(document.body.scrollLeft)+r){
		oCenter[0].style.left=parseInt(document.body.scrollLeft)+76+"px";
	}if(parseInt(oCenter[0].style.top)<parseInt(document.body.scrollTop)+r){
		oCenter[0].style.top=parseInt(document.body.scrollTop)+76+"px";
	}if(parseInt(oCenter[0].style.top)>parseInt(document.body.scrollTop)+parseInt(document.body.clientHeight)-r-oHuan[0].offsetHeight){
		oCenter[0].style.top=parseInt(document.body.scrollTop)+parseInt(document.body.clientHeight)-76-oHuan[0].offsetHeight+"px";
	}if(parseInt(oCenter[0].style.left)>parseInt(document.body.scrollLeft)+parseInt(document.body.clientWidth)-r-oHuan[0].offsetWidth){
		oCenter[0].style.left=parseInt(document.body.scrollLeft)+parseInt(document.body.clientWidth)-76-oHuan[0].offsetWidth+"px";
	}
};
/*登录内容*/
var juese=2;/*记录角色：1为管理员，2为用户*/
var sexchoose=1;/*记录男女：1为男；2为女*/
function xx(id){return document.getElementById(id);}
$(document).ready(function() { 
	var admin=document.getElementById("admin");
	var adminSpan=admin.getElementsByTagName("span");
	var user=document.getElementById("user");
	var userSpan=user.getElementsByTagName("span");
	/*初始化*/
	changeColor(user,userSpan,admin,adminSpan,2);
	user.onclick=function(){changeColor(user,userSpan,admin,adminSpan,2);xx("resign").style.display="initial";},
	admin.onclick=function(){changeColor(admin,adminSpan,user,userSpan,1);xx("resign").style.display="none";},
	xx("reset").onclick=function(){qingkong();},/*重置*/
	xx("submit").onclick=function(){login();},
	/*注册弹出*/
	xx("resign").onclick=function(){
		qingkong();
		xx("ResignVeil").classList.add("ResignVeilAfter");
		xx("resign_inf").classList.add("resign_infAfter");
		xx("ResignVeil").classList.remove("ResignVeilAfter2");
		xx("resign_inf").classList.remove("resign_infAfter2");
		xx("ResignVeil").style.display="block";
		xx("resign_inf").style.display="block";
	},
	xx("ResignVeil").onclick=function(){
		xx("ResignVeil").classList.remove("ResignVeilAfter");
		xx("resign_inf").classList.remove("resign_infAfter");
		xx("ResignVeil").classList.add("ResignVeilAfter2");
		xx("resign_inf").classList.add("resign_infAfter2");
	},
	/*选择性别*/
	xx("boy").onclick=function(){SexChoice("boy","girl");sexchoose=1;};
	xx("girl").onclick=function(){SexChoice("girl","boy");sexchoose=2;};
	/*注册成功*/
	$("#ResignConfirm").click(function(){ResignPanduan();});
});



/*性别选择*/
function SexChoice(obj1,obj2){
	xx(obj1).src="resource/img/yes.png";
	xx(obj2).src="resource/img/no.png";
}

/*登录对接*/
function login(){
	if(xx("userText").value==""){alert("请输入您的用户名!");}
	else if(xx("password").value==""){alert("请输入您的密码!");}
	else{
		var a;
		if(juese==1){a=1;}
		else{a=0;}
		var logindata ={"userid" : "" + xx("userText").value,
				"password" : "" + xx("password").value,
				"statue" : "" + a};
		$.ajax({
			/*前端：1为管理员，2为用户；后台的0：学生；1：管理员*/
			url:"login",
			type:"post",
			data:JSON.stringify(logindata),
		   dataType:"json",
		   contentType:"application/json",
		   success:function(data){
				if(data.errNum == "0"){
					qingkong();
					window.location.href = "main.html";
					
				}
				else{
					alert("您的用户名和密码不匹配！");
				}
		   }
		});
		/*var a;
		if(juese==1){a="管理员";window.location="main.html";}
		else{a="用户";window.location="Student.html";}
		alert("登录身份："+a+"   "+a+"："+xx("userText").value+"    密码："+xx("password").value);
		qingkong();*/
	}
}
/*对接注册*/
function ResignPanduan(){
	if(xx("ResignScore").value==""){alert("请输入您的学号!");}
	else if(xx("ResignName").value==""){alert("请输入您的用户名!");}
	else if(xx("ResignPassword").value==""){alert("请输入您的密码!");}
	else if(xx("ResignSchool").value==""){alert("请输入您的学院!");}
	else{
		var sex;
		if(sexchoose==1){sex=1;}else{sex=0;}
		var registerjson= {
				"student_id" : xx("ResignScore").value,
				"student_name" : ""+xx("ResignName").value,
				"student_password" : ""+xx("ResignPassword").value,
				"student_college" : ""+xx("ResignSchool").value,
				"student_sex" : ""+sex
			}
		/*var logindata ={"userid" : "" + xx("ResignScore").value,
				"password" : "" + xx("ResignScore").value,
				"statue" : "" + a}*/
		$.ajax({
			url:"register",
			type:"post",
			data:JSON.stringify(registerjson),
		    dataType:"json",
		    contentType:"application/json",
		    success:function(data){
			   if(data.errNum == "0"){
				   alert("恭喜您成功注册!");
				   xx("ResignVeil").classList.remove("ResignVeilAfter");
					xx("resign_inf").classList.remove("resign_infAfter");
					xx("ResignVeil").classList.add("ResignVeilAfter2");
					xx("resign_inf").classList.add("resign_infAfter2");
					qingkong();
			    }
			     else if(data.errNum == "10017"){
				   alert("注册失败，该学号已被注册!");
			    }
			     else{
			    	 alert("注册失败，服务器繁忙！");
			     }
		    },
			error:function(data){
			   alert("shabi");
		   }
		 });
	 }
}
/*所有内容清空*/
function qingkong(){
	xx("userText").value="";
	xx("password").value="";
	xx("ResignName").value="";
	xx("ResignScore").value="";
	xx("ResignPassword").value="";
	xx("ResignSchool").value="";
	xx("boy").src="resource/img/yes.png";
	xx("girl").src="resource/img/no.png";
	sexchoose=1;
}
function changeColor(obj1,obj2,obj3,obj4,jue){
	obj1.style.color="white";
	obj2[1].style.border="2px solid white";
	obj3.style.color="#95a0aa";
	obj4[1].style.border="2px solid #95a0aa";
	juese=jue;
}
