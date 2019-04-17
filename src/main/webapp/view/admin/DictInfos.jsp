<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../base/import.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>数据字典</title>
    <link rel="stylesheet" href="<%=contextPath%>/layui-v2.4.5/layui/css/layui.css" media="all"/>
</head>
<hr/>
<div></div>
<div id="form1" lay-filter="form1" class="layui-form layui-form-pane">

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">字典值id</label>
            <div class="layui-input-block">
                <input  type="text" id="dictTypeId" name="dictTypeId"  autocomplete="off" class="layui-input" >
            </div>
        </div>
        <button class="layui-btn" lay-submit lay-filter="search">搜索</button>

    </div>

</div>
<div style="margin-left: 10px ;float:left">
    <table id="demo" lay-filter="test" > </table>
</div>
<div style="margin-left: 20px;float: left">
    <table id="demo2" lay-filter="test2" > </table>
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script type="text/javascript">

    layui.use(['table','form','laydate'], function() {
        var table = layui.table;
        var form = layui.form;
        //初始化
        var findDictTypeId ;

        table.render({
            elem: '#demo'
            , height: 400
            , width:460
            , url: '<%=contextPath%>/areaDict/queryDictTypes'
            , method:'post'
            , page: false //开启分页
            , skin: 'line'
            , toolbar: 'default'
            , cols: [[ //表头
                 {field: 'dictTypeId', title: '字典Id', width: 130, sort: true}
                , {field: 'dictTypeName', title: '字典名称', width: 130, sort: true}
                , {title: '操作', align: 'center', toolbar: '#barDemo',width: 200}
            ]]
        });


        //表列条工具事件捕捉
        table.on('tool(test)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            if (layEvent === 'detail') { //查看
                findDictTypeId = data.dictTypeId;
                findDict(findDictTypeId);
            }else if(layEvent === 'del'){
                layer.confirm("确定删除吗，系统可能会受到影响",function () {
                    $.ajax({
                        url:'<%=contextPath%>/areaDict/delDictType'
                        ,async:false
                        ,type: "post"
                        ,dataType : "json"
                        ,data:data
                        ,success:function(data){
                           if(data){
                               layer.alert("删除成功");
                               window.location.href='';
                           }else{
                               layer.alert("删除失败");
                               window.location.href='';
                           }
                        },
                        error : function () {
                            layer.alert("系统异常");
                        }
                    });

                });
            }
        });

        table.on('toolbar(test)',function (obj) {
            switch(obj.event){
                case 'add':
                    layer.open({
                        title:'添加信息',
                        type:2,
                        area: ['400px', '400px'],
                        offset: 'auto',
                        async:false,
                        content:'<%=contextPath%>/view/admin/addDictType.jsp'
                    });
                    break;
                case 'delete':
                    layer.msg('删除');
                    break;
                case 'update':
                    layer.msg('编辑');
                    break;
            };
        });

        table.on('toolbar(test2)',function (obj) {
            switch(obj.event){
                case 'add':
                    layer.open({
                        title:'添加信息',
                        type:2,
                        area: ['400px', '400px'],
                        offset: 'auto',
                        async:false,
                        content:'<%=contextPath%>/view/admin/addDict.jsp?dictTypeId='+findDictTypeId
                    });
                    break;
                case 'delete':
                    layer.msg('删除');
                    break;
                case 'update':
                    layer.msg('编辑');
                    break;
            };
        });


        //form表单提交事件
        form.on('submit(search)',function (data) {
            reloadCompany(data.field);
        });



        function reloadCompany(data) {
            table.reload('demo', {
                url: '<%=contextPath%>/areaDict/queryDictTypes'
                ,where: data //设定异步数据接口的额外参数
                //,height: 300
                ,method:'post'
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        }

        function findDict(data) {
            table.render({
                elem: '#demo2'
                , height: 400
                , width:390
                , url: '<%=contextPath%>/areaDict/queryDicts'
                , where:{
                    dictTypeId: data
                }
                , method:'post'
                , page: false //开启分页
                , skin: 'line'
                , toolbar: 'default'
                , cols: [[ //表头
                    {field: 'dictTypeId', title: '字典类型', width: 130, sort: true}
                    , {field: 'dictId', title: '字典Id', width: 130, sort: true}
                    , {field: 'dictName', title: '字典值', width: 130, sort: true}
                ]]
            });
        }


    });


</script>
</body>
</html>
