<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false" %>


<script type="text/javascript">
    $(function () {
        $('#dg').datagrid({
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="images/' + rowData.picture_path + '.jpg" <!--style="height:150px;width:150px"-->></td>' +
                    '<td style="border:0">' +
//                    '<p>Attribute: ' + rowData.picture_id + '</p>' +
//                    '<p>Status: ' + rowData.picture_id + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            pagination:true,
            url:"${pageContext.request.contextPath}/picture/showAll.do",
            columns:[[
                {field:'picture_id',title:'ID',width:100,align:'center'},
                {field:'picture_path',title:'图片名称',width:100,align:'center'},
                {field:'picture_date',title:'上传时间',width:100,align:'center'},
                {field:'picture_description',title:'图片描述',width:100,align:'center'},
                {field:'picture_status',title:'状态',width:100,align:'center'},
                {field:'status',title:'操作',width:100,align:'center',formatter:function(value,row,index){
                    //$("#del").linkbutton({});
                    return "<a class=\"easyui-linkbutton\" data-options=\"height:20,iconCls:'icon-edit'\" onClick=\"modfiy('"+row.picture_id+"')\">修改</a>";
                }}
            ]],
			onLoadSuccess:function () {
				$.parser.parse();
            }
        });

        $('#add').linkbutton({
            iconCls: 'icon-add',
			onClick:function () {
                $("#change").dialog({
                    width:400,
                    height:300,
                    title:"添加图片",
                    href:"${pageContext.request.contextPath}/main/add.jsp",
                    buttons:[{
                        text:"保存",
                        handler:function () {
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
                                        }
									})
                                }
                            });
                        }
                    },{
                        text:"取消",
                        handler:function () {
                            $("#change").dialog("close");
                            $.messager.show({
                                title:"温馨提示",
                                msg:"已经关闭修改页面",
                                timeout:2000,
                                showType:"slide",
                            });
                        }
                    }],
				});
            },
        });
        $('#help').linkbutton({
            iconCls: 'icon-help'
        });

    });
    function modfiy(id) {
        var selected = $("#dg").datagrid("getSelected");
		$("#change").dialog({
            width:400,
            height:300,
            title:"更改图片信息",
			href:"${pageContext.request.contextPath}/main/change.jsp",
			buttons:[{
			    text:"保存",
				handler:function () {
                    $.messager.confirm("信息更改","确定保存信息吗",function(r){
                        if(r){
                            //提交数据
                            $("#changeForm").form("submit",{
//                                conentType:"json",
                                url:"${pageContext.request.contextPath}/picture/modify.do",
                                success: function(){
                                    $.messager.alert("提交信息","更改成功！");
                                    $("#change").dialog("close");
                                }
                            });
                        }
                    });
                }
			},{
                text:"取消",
                handler:function () {
                    $("#change").dialog("close");
                    $.messager.show({
                        title:"温馨提示",
                        msg:"已经关闭修改页面",
                        timeout:2000,
                        showType:"slide",
                    });
                }
			}],
            onLoad:function(){
                $("#changeForm").form("load",selected); //在加载表单时将行数据加载到表单元素中
            }

		});
    }

</script>

<div>
	<table id="dg" >
		<a href="#" id="add">新增轮播图</a>
		<a href="#" id="help">帮助</a>
	</table>
	<div id="change" ></div>
</div>