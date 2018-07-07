<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false" %>


<script type="text/javascript">

	$(function(){
		$("#hold4").linkbutton({
			onClick:function () {
                $.messager.confirm("添加上师","确定添加该上师信息吗",function(r){
                    if(r){
                        //提交数据
                        $("#addMasterForm").form("submit",{
                            url:"${pageContext.request.contextPath}/master/add.do",
							success:function (res) {
                                if(res=="success"){
                                    $.messager.show({
                                        title:"温馨提示",
                                        msg:"添加成功，窗口2秒后关闭",
                                        timeout:2000,
                                        showType:"slide",
                                    });
                                    $("#masterChange").dialog("close");
                                    $('#masterTab').datagrid("reload",{});
                                }else{
                                    $.messager.show({
                                        title:"温馨提示",
                                        msg:"添加失败，窗口2秒后关闭",
                                        timeout:2000,
                                        showType:"slide",
                                    });
                                }
                            }
                        })
                    }
                });
            }
		});

		$("#cancle4").linkbutton({
			onClick:function () {
                $("#masterChange").dialog("close");
                $.messager.show({
                    title:"温馨提示",
                    msg:"已经关闭添加页面",
                    timeout:2000,
                    showType:"slide",
                });
            }
		});

	});
	
</script>

<div>
	<form id="addMasterForm" method="post" enctype="multipart/form-data">
		<table style="text-align:center;margin:auto;margin-top:20px">

			<tr>
				<td>上师法号:</td>
				<td><input class="easyui-textbox" name="masterName" ></td>
			</tr>
			<tr>
				<td>上师图片:</td>
				<td><input class="easyui-textbox" name="masterPhoto" ></td>
			</tr>
			<tr>
				<td>上师简介:</td>
				<td><input class="easyui-textbox" name="masterSummary" ></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<a id="hold4">保存</a>
					<a id="cancle4">取消</a>
				</td>
			</tr>

		</table>
	</form>
</div>