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
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.picturePath + '" <!--style="height:150px;width:150px"--></td>' +
                    '<td style="border:0">' +
//                    '<p>Attribute: ' + rowData.picture_id + '</p>' +
//                    '<p>Status: ' + rowData.picture_id + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            pagination:true,
            url:"${pageContext.request.contextPath}/picture/showAll.do",
            columns:[[
                {field:'pictureId',title:'ID',width:100,align:'center'},
                {field:'picturePath',title:'图片名称',width:100,align:'center'},
                {field:'pictureDate',title:'上传时间',width:100,align:'center'},
                {field:'pictureDescription',title:'图片描述',width:100,align:'center'},
                {field:'pictureStatus',title:'状态',width:100,align:'center'},
                {field:'status',title:'操作',width:100,align:'center',formatter:function(value,row,index){
                    //$("#del").linkbutton({});
                    return "<a name=\"dgA\" class=\"easyui-linkbutton\" data-options=\"height:20,iconCls:'icon-edit'\" onClick=\"modfiy()\">修改</a>";
                }}
            ]],
			onLoadSuccess:function () {
				$("a[name='dgA']").linkbutton({});
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
				});
            },
        });
        $('#help').linkbutton({
            iconCls: 'icon-help'
        });

    });
    function modfiy() {
		$("#change").dialog({
            width:400,
            height:300,
            title:"更改图片信息",
			href:"${pageContext.request.contextPath}/main/change.jsp",

            onLoad:function(){
                var selected = $("#dg").datagrid("getSelected");
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