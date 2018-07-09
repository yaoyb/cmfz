<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false" %>
<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.js"></script>
<script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E('#editor');
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/upload.do';
    editor.customConfig.uploadFileName = 'files';
    editor.create();

    $(function () {


        $.ajax({
            type:"POST",
            url:"/cmfz/master/showAllMaster.do",
            async: false,
            success:function (masterList) {
                $.each(masterList,function (index,value) {
                    $("#author").append("<option value='"+value.masterId+"'>"+value.masterName+"</option>");
				});
			},
		});

		$("#articleSubmit").linkbutton({
			onClick:function () {
			    document.getElementById("hidden").value=editor.txt.html();
				$("#editFrom").form("submit",{
				    url:"${pageContext.request.contextPath}/article/add.do",
					success:function (res) {
						if(res=="success"){
                            $.messager.show({
                                title:"温馨提示",
                                msg:"提交成功，窗口2秒后关闭",
                                timeout:2000,
                                showType:"slide",
                            });
                            //将内容清空
							$("#editFrom").form("clear");
                            editor.txt.html('<p><br></p>');
                        }else{
                            $.messager.show({
                                title:"温馨提示",
                                msg:"提交失败，窗口2秒后关闭",
                                timeout:2000,
                                showType:"slide",
                            });
                        }
                    }
				})
            }
		});
    });

</script>


<div>
	<form  id="editFrom" method="post" enctype="multipart/form-data" >
		<p style="line-height: 40px">
			<span>文章标题:</span>
			<input class="easyui-textbox" name="articleName" >
		</p>
		<p style="line-height: 40px">
			<span>文章作者:</span>
			<select id="author" class="easyui-combobox" name="masterId" style="width:200px;"></select>
		</p>

		<div id="editor"></div>
		<input id="hidden" hidden="hidden" type="text" name="articleContent" >

		<a id="articleSubmit" style="margin: 20px 30px;width: 120px;height: 40px">提交</a>
	</form>


</div>



