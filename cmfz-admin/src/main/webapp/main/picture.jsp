<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>


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
                    '<td rowspan=2 style="border:0"><img src="images/' + rowData.picture_id + '.png" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.picture_id + '</p>' +
                    '<p>Status: ' + rowData.picture_id + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            pagination:true,
            url:"/mcfz/picture/showAll.do",
            columns:[[
                {field:'picture_id',title:'代码',width:100,align:'center'},
                {field:'picture_path',title:'名称',width:100,align:'center'},
                {field:'picture_date',title:'代码',width:100,align:'center'},
                {field:'picture_description',title:'名称',width:100,align:'center'},
                {field:'picture_status',title:'价格',width:100,align:'center'},
//                {title:'操作',width:100,align:'center'}
            ]],
        });
    });

</script>

<div>
	<h1>aaa</h1>
	<table id="dg" >

	</table>
</div>