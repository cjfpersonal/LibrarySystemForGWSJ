$(document).ready(function() {
	 $("#textButton").kendoButton();
	var jiluYemian=0; /*记录页面位置*/
	$(".List ul li:nth-child(1) a").addClass("ListAfter");
	$(".List ul li").click(function(){
		/*点击这个li；则里面的a添加.ListAfter;而他的父亲的朋友的孩子则失去.ListAfter*/
		$(this).children().addClass("ListAfter").parent().siblings().children().removeClass("ListAfter");
		yemianFeiru(""+$(this).index(),jiluYemian);jiluYemian=$(this).index();
	});						   
	/*function birthdayEditor(container , options){
		$('<input type="text" data-bind="value:' + options.field + '"/>')
		.appendTo(container)
		.kendoDatePicker({
		});
	}*/
	/*将学生的学号加入查询库中；输入部分学生号即刻match*/
	 var datalist = []; //数据来源
	 $.ajax({
			method:"POST",
			url:"ceshi.json",
			data:"",
			dataType:"JSON",
			before:function(data){},
			success:function(data){
				for (var i=0;i<data.length;i++){
					datalist[i]=""+data[i].score;  //根据学生的学号进行查询(注意后台最好传过来数组)
				}
			},
			error:function(data){
				//alert("2");
			},
		});
	$("#countries").kendoAutoComplete({
            dataSource: datalist,
            filter: "contains", //查询的方式：有包含contains和从头开始startswith
            placeholder: "输入写生学号", //input的内容
            separator: ""
        });
	/*点击查询，查询学生*/
	$(".chaxun").click(function(){
		$.ajax({
			method:"POST",
			url:"ceshi.json",
			data:"",
			dataType:"JSON",
			before:function(data){},
			success:function(data){
				alert($("#countries").val());
			},
			error:function(data){
				alert("2");
			},
		});
	});
	
	
	
	
	
	/*插入数据*/
	$("#grid2,#grid3,#grid4,#grid5").kendoGrid({
		dataSource: {
            transport: {
                read: {
                    url: "ceshi.json", //传给后台的url(位置)
                    dataType: "json", //前端后台的交互数据类型
                    data:{name:"123"}, //传给后台什么数据
					type:"get"
                },
                update: {
					url: "ceshi.json",
					dataType: "json",
					type: "post",
				},
				create: {
					url: "ceshi.json",
					dataType: "json",
					type: "post",
				},
				destroy: {
					url: "ceshi.json",
					dataType: "json",
					type: "post",
				}, 
            },
            pageSize: 10,  //设置页面内能放多少列
            group: {
                field: "学生所有信息",
                dir: "asc"
            }
        },
        editable: "popup",
        groupable: false, //是否显示分组，比如移动标题进行选择
        height: 550,  //设置列表的高度
        selectable: "multiple cell", //点击一行时是选中一行(multiple)还是选中单个(此时)
        pageable: true,  //是否显示换页的页尾
        sortable: true,  //是否有排序的功能
        editable:"inline", //编辑的形式：即修改选定的这一行
        toolbar:['create','save'], //是否有添加数据的功能，除了create还有其他两种，自己找
        bind:"source:list",
        columns:
        	[{field:"score",title: "学号"}, 
        	 {field: "name",title: "姓名"},
        	 {field: "school", title: "学院"},
        	 {field: "sex",title: "性别"},
        	 {command:['edit','destroy'],title:'编辑',width:'200px'}] //这是个修改的东西，可以改里面的标题和样式
    });

	/*var viewModel = kendo.observable({
    	list : new kendo.data.DataSource({
			schema:{
				model:{
					id:'id',
					fields:{
						score:{type: 'string'},
						name: {type:"string"},
						school: {type: 'string'},
						sex:{type:"string"}
					}
				}
			}
    	
    	})
    });         
	kendo.bind($('#grid2'), viewModel);*/
});


/*插入数据#grid1*/
$(function(){
	
	var crudServiceBaseUrl = "ceshi.json",
	dataSource = new kendo.data.DataSource({
	    transport: {
	        read:  {
	            url: crudServiceBaseUrl,
	            dataType: "json"
	        },
	        update: {
	            url: crudServiceBaseUrl ,
	            dataType: "json"
	        },
	        destroy: {
	            url: crudServiceBaseUrl ,
	            dataType: "json"
	        },
	        create: {
	            url: crudServiceBaseUrl,
	            dataType: "json"
	        },
	    },
	    batch: true,
	    pageSize: 10,
	    schema: {
	        model: {
	            //id: "id",
	            fields: {
	            	score:{type: 'string', validation: { required: true } },
					name: {type:"string",validation: { required: true } },
					school: {type: 'string',validation: { required: true } },
					sex:{type:"string",validation: { required: true } },
	            }
	        }
	    },
	});
	$("#grid1").kendoGrid({
		dataSource: dataSource,
		pageable: true,
		selectable: "multiple",
		height: 550,
		toolbar: ["create"],
	    columns:
	    	[{field:"score",title: "学号"}, 
	    	 {field: "name",title: "姓名"},
	    	 {field: "indormation", title: "学院"},
	    	 {field: "school", title: "学院"},
	    	 {field: "sex",title: "性别",}, //,editor: changeInformation, template: "#=sex.sexChange#"为添加下拉选择
	    	 //{command:['edit','destroy'],title:'编辑',width:'200px',}] , //这是个修改的东西，可以改里面的标题和样式
	    	 { command: ["edit","delete"], title: "编辑", width: "200px" }],
		editable: "popup"
	});
});
/*页面动画*/
function yemianFeiru(Feiru,Feichu){
	/*三种情况：左入右入不动*/
	if(Feiru==Feichu){}
	else if(parseInt(Feiru)<parseInt(Feichu)){
		$(".info"+Feichu).addClass("feichu2").removeClass("feiru2").removeClass("feichu").removeClass("feiru");
    	$(".info"+Feiru).addClass("feiru2").removeClass("feichu2").removeClass("feichu").removeClass("feiru");
	}else{
		$(".info"+Feichu).addClass("feichu").removeClass("feiru").removeClass("feiru2").removeClass("feichu2");
    	$(".info"+Feiru).addClass("feiru").removeClass("feichu").removeClass("feiru2").removeClass("feichu2");
	}
}