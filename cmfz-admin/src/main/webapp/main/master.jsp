<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false" %>


<script type="text/javascript">

	$(function(){
		$("#masterTab").datagrid({
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            pagination:true,
			url:"${pageContext.request.contextPath}/master/showAll.do",
			columns:[[
				{field:'masterId',title:"上师ID",width:228,align:'center'},
                {field:'masterName',title:"上师法号",width:228,align:'center'},
                {field:'masterPhoto',title:"上师图片",width:228,align:'center'},
                {field:'masterSummary',title:"上师简介",width:228,align:'center'},
				{field:'operation',title:"操作",width:228,align:'center',formatter:function (value,row,index) {
					return "<a class=\"easyui-linkbutton\" data-options=\"height:20,iconCls:'icon-edit'\" onclick=\"chang()\" >修改</a>";
                }}
			]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.masterPhoto + '" <!--style="height:150px;width:150px"--></td>' +
                    '<td style="border:0">' +
                    '</td>' +
                    '</tr></table>';
            },
            onLoadSuccess:function () {
                $.parser.parse();
            }
		});

		$("#masterAdd").linkbutton({
			iconCls:'icon-add',
			onClick:function () {
				$("#masterChange").dialog({
                    width:400,
                    height:300,
                    title:"更改上师信息",
                    href:"${pageContext.request.contextPath}/main/addMaster.jsp",
				});
            },
		});

		$("#search").textbox({
			width:170,
			prompt:'请输入上师法名',
			icons:[{
			    iconCls:"icon-search",
				handler:function (e) {
					$("#masterTab").datagrid({
                        url:"${pageContext.request.contextPath}/master/showByName.do?name="+$('#search').val(),
					});
                }
			}],
		});

		$("#masterAddMore").linkbutton({
			iconCls:'icon-add',
			onClick:function () {
                $("#masterChange").dialog({
                    width:400,
                    height:300,
                    title:"批量添加上师信息",
                    href:"${pageContext.request.contextPath}/main/importMaster.jsp",
                });
            },
		});
	});
	
	function chang() {
		$("#masterChange").dialog({
			width:400,
			height:300,
			title:"更改上师信息",
			href:"${pageContext.request.contextPath}/main/changeMaster.jsp",
			onLoad:function () {
                var selected = $("#masterTab").datagrid("getSelected");
				$("#changeMasterForm").form("load",selected);
            }

		});
    }
	
</script>

<div>
	<table id="masterTab" >
		<input id="search" style="margin-right: 10px"/>
		<a href="#" id="masterAdd" >新增上师</a>
		<a href="#" id="masterAddMore" >批量添加上师</a>
	</table>
	<div id="masterChange" ></div>
</div>