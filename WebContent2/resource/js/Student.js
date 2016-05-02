$(document).ready(function() {
	var jiluYemian=0;/*记录页面位置*/
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
	/*查询书籍*/
	 var data = ["chenjianf","asd","fdg"];//数据来源
	$("#countries").kendoAutoComplete({
            dataSource: data,
            filter: "contains", //查询的方式：有包含contains和从头开始startswith
            placeholder: "输入您查询的资料",
            separator: ""
        });
	/*加入分页*/
	$("#grid1,#grid2,#grid3,#grid4,#grid5").kendoGrid({
        height: 500,
        groupable: true,
        sortable: true,
        pageable: {
            refresh: true,
            pageSizes: true,
            buttonCount: 5
        }
    });

	var viewModel = kendo.observable({
    	list : new kendo.data.DataSource({
			schema:{
				model:{
					id:'id',
					fields:{
						name:{type: 'string'},
						birthday: {},
						gender: {type: 'string'},
						clazzId:{defaultValue: 1}
					}
				}
			}
    	})
    });         
	kendo.bind('body', viewModel);
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