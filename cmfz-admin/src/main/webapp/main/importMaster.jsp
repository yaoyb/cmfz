<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false" %>


<script type="text/javascript">

	$(function(){
		$("#hold").linkbutton({
			onClick:function () {
                $.messager.confirm("添加图片","确定添加该文件吗",function(r){
                    if(r){
                        //提交数据
                        $("#addForm").form("submit",{
                            url:"${pageContext.request.contextPath}/master/importMaster.do",
                            success:function (res) {
                                if(res=="success"){
                                    $.messager.show({
                                        title:"温馨提示",
                                        msg:"添加成功，窗口2秒后关闭",
                                        timeout:2000,
                                        showType:"slide",
                                    });
                                    $("#masterChange").dialog("close");
//                                    $('#dg').datagrid("reload",{});
                                    $("#dg").datagrid({
                                        url:"${pageContext.request.contextPath}/master/showAll",
                                    });
                                }else{
                                    $.messager.show({
                                        title:"温馨提示",
                                        msg:"添加失败，窗口2秒后关闭",
                                        timeout:2000,
                                        showType:"slide",
                                    });
                                    $("#masterChange").dialog("close");
                                    $('#dg').datagrid("reload",{});
                                }
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
                    msg:"已经关闭添加页面",
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
				<td>添加批量上师信息文件（xls或xlsx格式）:</td>
			</tr>
			<tr>
				<td><input name="subfile" class="easyui-filebox" ></td>
			</tr>
			<tr>
				<td>
					<a id="hold">添加</a>
					<a id="cancle">取消</a>
				</td>
			</tr>

		</table>
	</form>
</div>