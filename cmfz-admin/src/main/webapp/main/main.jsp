<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">   
<script type="text/javascript" src="../js/jquery.min.js"></script>   
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/datagrid-detailview.js"></script>
<script type="text/javascript">

	$(function(){

        $.ajax({
			type:"POST",
			url:"/cmfz/menu/showFirst.do",
            async: false,
			success:function (menuList) {

				$.each(menuList,function (index,value) {
                    var firstcontent="";

					$.ajax({
                        type:"POST",
                        url:"/cmfz/menu/showSecond.do",
						data:"id="+value.id,
                        async: false,
						success:function (data) {
                            firstcontent+="<ul>";
                            $.each(data,function (num,second) {
                                firstcontent+="<li style=\"list-style-type:none;\"><a class=\"easyui-linkbutton\" data-options=\"plain:true,iconCls:'"+second.menuIcon+"'\" onclick=\"addpage('"+second.menuName+"','"+second.menuUrl+"')\">"+second.menuName+"</a></li>";
                            });
                            firstcontent+="</ul>";
                        }
					});

                    $("#aa").accordion('add',{
                        title: value.menuName,
                        content: firstcontent,
						iconCls:value.menuIcon,
                        selected: false
                    });
                })
            }
		});
	});

   function addpage(tt,path) {
        //首先判断原选项卡中是否含有已点击的选项

        var result = $("#tab").tabs("exists",tt);
        //如果已经含有，跳转
        if(result){
            $("#tab").tabs("select",tt);
        }else{//如果没有，新建
            $("#tab").tabs("add",{
                title:tt,
                href:"${pageContext.request.contextPath}/main/"+path,
                closable:true,
            });
        }
    }
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:xxxxx &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 gaozhy@zparkhr.com.cn</div>
    </div>   
       
    <div id="bb" data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">

		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tab" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url('${pageContext.request.contextPath}/main/image/shouye.jpg');background-repeat: no-repeat;background-size:100% 100%;"></div>
			<%--<div style="background-image: url('image/shouye.jpg')" ></div>--%>
		</div>  
    </div>   
</body> 
</html>