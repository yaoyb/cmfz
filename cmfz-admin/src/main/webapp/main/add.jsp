<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false" %>


<script type="text/javascript">

	$(function(){
		$("#hold").linkbutton({
			onClick:function () {
                $.messager.confirm("添加图片","确定添加该轮播图吗",function(r){
                    if(r){
                        //提交数据
                        $("#addForm").form("submit",{
                            url:"${pageContext.request.contextPath}/picture/upload.do",
                            success:function () {
                                $("#change").dialog("close");
                                $.messager.show({
                                    title:"温馨提示",
                                    msg:"添加成功，窗口2秒后关闭",
                                    timeout:2000,
                                    showType:"slide",
                                });
                                $('#dg').datagrid("reload",{});
                            }
                        })
                    }
                });
            }
		});

		$("#cancle").linkbutton({
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
	<form id="addForm" method="post" enctype="multipart/form-data">
		<table style="text-align:center;margin:auto;margin-top:20px">

			<tr>
				<td>轮播图描述:</td>
				<td><input class="easyui-textbox" name="pictureDescription" ></td>
			</tr>
			<tr>
				<td>轮播图状态:</td>
				<%--<td><input class="easyui-textbox" name="picture_status" ></td>--%>
				<td><select class="easyui-combobox" name="pictureStatus" style="width:170px;">
					<option value="show">展示</option>
					<option value="unshow">未展示</option>>
				</select></td>
			</tr>
			<tr>
				<td>上传轮播图:</td>
				<td><input class="easyui-filebox" id="myFile" name="myFile" ></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<a id="hold">保存</a>
					<a id="cancle">取消</a>
				</td>
			</tr>

		</table>
	</form>
</div>