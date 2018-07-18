<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false" %>



<script type="text/javascript">

	$(function(){
        $('#logTab').datagrid({
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            pagination:true,
            url:"${pageContext.request.contextPath}/operation/showAll.do",
            columns:[[
                {field:'operationId',title:'ID',width:100,align:'center'},
                {field:'manager.mgrName',title:'管理员',width:100,align:'center'},
                {field:'operationTime',title:'操作时间',width:100,align:'center'},
                {field:'operationResource',title:'操作资源',width:100,align:'center'},
                {field:'operationAction',title:'操作详情',width:100,align:'center'},
                {field:'operationMassage',title:'操作信息',width:100,align:'center'},
                {field:'operationResult',title:'操作结果',width:100,align:'center'},
            ]],
        });

	});
	
</script>

<div>
	<table id="logTab" >
	</table>
</div>
