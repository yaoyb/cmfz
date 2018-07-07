<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false" %>


<script type="text/javascript">

	$(function(){
		$("#hold2").linkbutton({
			onClick:function () {
                $.messager.confirm("信息更改","确定保存信息吗",function(r){
                    if(r){
                        //提交数据
                        $("#changeForm").form("submit",{
                            url:"${pageContext.request.contextPath}/picture/modify.do",
                            success: function(res){
                                if(res=="success"){
                                    $.messager.alert("提交信息","更改成功！");
                                    $("#change").dialog("close");
                                    $('#dg').datagrid("reload",{});
                                }else{
                                    $.messager.alert("提交信息","更改失败！");
                                    $("#change").dialog("close");
                                    $('#dg').datagrid("reload",{});
                                }
                            },
                        });
                    }
                });
            }
		});

		$("#cancle2").linkbutton({
			onClick:function () {
                $("#change").dialog("close");
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
	<form id="changeForm" method="post">
		<table style="text-align:center;margin:auto;margin-top:20px">
			<tr>
				<td>ID:</td>
				<td><input class="easyui-textbox" name="pictureId" readonly="readonly" ></td>
			</tr>
			<tr>
				<td>图片名称:</td>
				<td><input class="easyui-textbox" name="picturePath" readonly="readonly"></td>
			</tr>
			<tr>
				<td>上传时间:</td>
				<td><input class="easyui-datetimebox" name="pictureDate" ></td>
			</tr>
			<tr>
				<td>图片描述:</td>
				<td><input class="easyui-textbox" name="pictureDescription" ></td>
			</tr>
			<tr>
				<td>状态:</td>
				<%--<td><input class="easyui-textbox" name="picture_status" ></td>--%>
				<td><select class="easyui-combobox" name="pictureStatus" style="width:170px;">
					<option value="show">展示</option>
					<option value="unshow">未展示</option>>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<a id="hold2">保存</a>
					<a id="cancle2">取消</a>
				</td>
			</tr>

		</table>
	</form>
</div>