<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false" %>


<script type="text/javascript">

	$(function(){


	});
	
</script>

<div>
	<form id="changeForm" method="post">
		<table style="text-align:center;margin:auto;margin-top:20px">
			<tr>
				<td>ID:</td>
				<td><input class="easyui-textbox" name="picture_id" readonly="readonly" ></td>
			</tr>
			<tr>
				<td>图片名称:</td>
				<td><input class="easyui-textbox" name="picture_path" readonly="readonly"></td>
			</tr>
			<tr>
				<td>上传时间:</td>
				<td><input class="easyui-datetimebox" name="picture_date" ></td>
			</tr>
			<tr>
				<td>图片描述:</td>
				<td><input class="easyui-textbox" name="picture_description" ></td>
			</tr>
			<tr>
				<td>状态:</td>
				<%--<td><input class="easyui-textbox" name="picture_status" ></td>--%>
				<td><select class="easyui-combobox" name="picture_status" style="width:170px;">
					<option value="show">展示</option>
					<option value="unshow">未展示</option>>
				</select></td
			</tr>

		</table>
	</form>
</div>