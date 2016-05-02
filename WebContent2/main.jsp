<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/main.css">
<link type="text/css" rel="stylesheet" href="css/kendo.bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="css/kendo.common.min.css">
<link type="text/css" rel="stylesheet" href="css/kendo.common-bootstrap.core.min.css">
<link type="text/css" rel="stylesheet" href="css/kendo.common-bootstrap.min.css">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/kendo.web.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<title>管理员操作</title>
</head>
  
  <body>
<div class="header">
		<h3>管理员管理</h3>
		<p><span class="UserName">陈剑锋</span>|<span class="LoginOut"><a href="index.html">注销</a></span></p>
	</div>
	<div class="Search">
		<button id="textButton"class="chaxun">查询</button>
		<input class="FindBook" id="countries" type="text"  />
		<div class="List">
			<ul>
				<li><a href="#" class="StudentControlHead">学生管理 </a></li>
				<li><a href="#" class="BooksControlHead">书籍管理 </a></li>
				<li><a href="#" class="BooksReturnHead">图书归还 </a></li>
				<li><a href="#" class="AccountEditHead">账户修改 </a></li>
				<li><a href="#" class="HistoryHead">历史记录 </a></li>
			</ul>
		</div>
	</div>
	<div class="neirong">
	<!--1、学生信息-->
	<div class="StudentInformation info0">
		<fieldset>
	    	<legend>学生信息</legend>
			<div id="grid1" data-role="grid" class="liebiao">
	        </div> 
        </fieldset>
	</div>

	<!--2、书籍管理-->
	<div class="BooksControl info1">
		<fieldset>
	    	<legend>书籍管理</legend>
			<div id="grid2" >
	        </div> 
        </fieldset>
	</div>

	<!--3、图书管理-->
	<div class="BooksReturn info2">
		<fieldset>
    	<legend>图书管理</legend>
		<div id="grid3" data-role="grid" class="liebiao">
        </div>
        </fieldset> 
	</div>

	<!--4、账户管理-->
	<div class="AccountEdit info3">
		<fieldset>
    	<legend>账户管理</legend>
		<div id="grid4" data-role="grid" class="liebiao"
		data-columns="[{
                 field:'score',
                 title: '学号'
               }, {
                 field: 'name',
                 title: '姓名'
               }, {
                 field: 'school',
                 title: '学院',
           		<!-- template: '#:kendo.toString(new Date(birthday) , \'yyyy-MM-dd\')#' -->
               },{
               	 field: 'sex',
               	 title: '性别'
               },{command:
               ['edit','destroy'],title:'编辑',width:'200px'}]" 
        data-bind="source:list"  data-selectable="single"data-editable="inline" data-toolbar="['create']">
        </div> 
        </fieldset>
	</div>

	<!--5、历史记录-->
	<div class="HistoryRecord info4">
		<fieldset>
    	<legend>历史记录</legend>
		<div id="grid5" data-role="grid" class="liebiao"
		data-columns="[{
                 field:'score',
                 title: '学号'
               }, {
                 field: 'name',
                 title: '姓名'
               }, {
                 field: 'school',
                 title: '学院',
           		<!-- template: '#:kendo.toString(new Date(birthday) , \'yyyy-MM-dd\')#' -->
               },{
               	 field: 'sex',
               	 title: '性别'
               },{command:
               ['edit','destroy'],title:'编辑',width:'200px'}]" 
        data-bind="source:list"  data-selectable="single"data-editable="inline" data-toolbar="['create']">
        </div> 
        </fieldset>
	</div>
</div>
</body>
</html>
