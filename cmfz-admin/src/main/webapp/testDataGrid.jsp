<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>test</title>
    <link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="themes/IconExtension.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/datagrid-detailview.js"></script>
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
                url:"${pageContext.request.contextPath}/picture/showAll.do",
                columns:[[
                    {field:'picture_id',title:'代码',width:100,align:'center'},
                    {field:'picture_path',title:'名称',width:100,align:'center'},
                    {field:'picture_date',title:'代码',width:100,align:'center'},
                    {field:'picture_description',title:'名称',width:100,align:'center'},
                    {field:'picture_status',title:'价格',width:100,align:'center'}
                ]],
                pagination:true,
            });
        });

    </script>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <table id="dg"></table>
    </body>
</html>
