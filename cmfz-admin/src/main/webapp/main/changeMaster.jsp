<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false" %>


<script type="text/javascript">

	$(function(){
		$("#hold3").linkbutton({
			onClick:function () {
                $.messager.confirm("信息更改","确定保存信息吗",function(r){
                    if(r){
                        //提交数据
                        $("#changeMasterForm").form("submit",{
                            url:"${pageContext.request.contextPath}/master/change.do",
                            success: function(){
                                $.messager.alert("提交信息","更改成功！");
                                $("#masterChange").dialog("close");
                                $('#masterTab').datagrid("reload",{});
                            },

                        });
                    }
                });
            }
		});

		$("#cancle3").linkbutton({
			onClick:function () {
                $("#masterChange").dialog("close");
                $.messager.show({
                    title:"温馨提示",
                    msg:"已经关闭修改页面",
                    timeout:2000,
                    showType:"slide",
                });
            }
		});

	});
	
</script>

<div>
	<form id="changeMasterForm" method="post">
		<table style="text-align:center;margin:auto;margin-top:20px">
			<tr>
				<td>上师ID:</td>
				<td><input class="easyui-textbox" name="masterId" readonly="readonly" ></td>
			</tr>
			<tr>
				<td>上师法号:</td>
				<td><input class="easyui-textbox" name="masterName"></td>
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
					<a id="hold3">保存</a>
					<a id="cancle3">取消</a>
				</td>
			</tr>

		</table>
	</form>
</div>