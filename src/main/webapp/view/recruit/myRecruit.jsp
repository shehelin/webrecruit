<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="../base/base.jsp" %>
    <title>我的招聘</title>
    <link rel="stylesheet" href="<%=contextPath%>/layui-v2.4.5/layui/css/layui.css" media="all"/>
</head>
<body style="margin-top: 70px">

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>我的招聘栏</legend>
</fieldset>
<div id="form1" lay-filter="form1" class="layui-form layui-form-pane">

    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">职 位</label>
            <div class="layui-input-block">
                <input  type="text" name="jobName"  placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">期望薪资</label>
            <div class="layui-input-block">
                <input  type="text" name="enjoySalary"  placeholder="￥" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">开始时间</label>
            <div class="layui-input-block">
                <input  type="text" id="beginTime" name="beginTime"  autocomplete="off" class="layui-input" >
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">结束时间</label>
            <div class="layui-input-block">
                <input  type="text" id="endTime" name="endTime"  autocomplete="off" class="layui-input" >
            </div>
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">工作地址</label>
        <div class="layui-input-inline">
            <select name="queryProvince" id="queryProvince" lay-filter="queryProvince">
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="queryCity" id="queryCity" lay-filter="queryCity">
                <option value=""></option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="queryTown" id="queryTown">
                <option value=""></option>
            </select>
        </div>

        <button class="layui-btn" lay-submit lay-filter="search">搜索</button>
        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>

</div>

<table id="demo" lay-filter="test"> </table>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger  layui-btn-xs" lay-event="del">删除</a>

</script>

<script type="text/javascript">

    layui.use(['table','form','laydate'], function() {
        var table = layui.table;
        var form = layui.form;
        var laydate = layui.laydate;
        var resultData;//区域字典值
        //招聘实例
        table.render({
            elem: '#demo'
            , height: 500
            , url: '<%=contextPath%>/recruit/queryRecruit?userId=<%=userId%>'
            , page: true //开启分页
            , toolbar: 'default'
            , skin: 'line'
            // ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            , cols: [[ //表头
                {type: 'checkbox', fixed: 'left'},
                {field: 'comId', title: '企业ID', width: 130, sort: true, fixed: 'left'}
                , {field: 'comName', title: '企业名称', width: 130, sort: true}
                , {field: 'jobName', title: '招聘职位', width: 130, sort: true}
                , {field: 'jobNumber', title: '招聘人数', width: 130, sort: true}
                , {field: 'jobArea', title: '职位地点', width: 130, sort: true}
                , {field: 'minSalary', title: '薪资低估', width: 130, sort: true}
                , {field: 'maxSalary', title: '薪资高估', width: 130, sort: true}
                , {field: 'beginTime', title: '招聘时间', width: 130, sort: true}
                , {field: 'endTime', title: '结束时间', width: 130, sort: true}
                , {title: '操作', align: 'center', toolbar: '#barDemo',fixed:'right',width: 130}
            ]]
        });
        //日期映射
        laydate.render({
            elem: '#beginTime'
        });
        laydate.render({
            elem: '#endTime'
        });

        //form表单提交事件
        form.on('submit(search)',function (data) {

            var data = data.field;
            var Province = $("#queryProvince").find("option:selected").text();
            var City = $("#queryCity").find("option:selected").text();
            var Town =$("#queryTown").find("option:selected").text();
            var jobArea = Province+City+Town;
            data['jobArea'] = jobArea;
            table.reload('demo', {
                url: '<%=contextPath%>/recruit/queryRecruit?userId=<%=userId%>'
                ,where: data //设定异步数据接口的额外参数
                //,height: 300
                ,method:'post'
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        });


        //区域省
        $.ajax({
            url: '<%=contextPath%>/areaDict/queryProvince',
            type: "post",
            dataType : "json",
            async: false,//这得注意是同步
            success: function (result) {
                resultData = result;
                var htmls = '<option value=""></option>'; //全局变量
                for(var x in resultData){
                    htmls += '<option value = "' + resultData[x].id + '">' + resultData[x].district + '</option>'
                }
                $("#queryProvince").html(htmls);
            }
        });
        form.render('select');//需要渲染一下

        //区域市事件
        form.on('select(queryProvince)', function(data){
            $.ajax({
                url: '<%=contextPath%>/areaDict/queryCity',
                type: "post",
                dataType : "json",
                data: {
                    pid: data.value
                },
                async: false,//这得注意是同步
                success: function (result) {
                    resultData = result;
                    var htmls = '<option value=""></option>'; //全局变量
                    for(var x in resultData){
                        htmls += '<option value = "' + resultData[x].id + '">' + resultData[x].district + '</option>'
                    }
                    $("#queryCity").html(htmls);
                    $("#queryTown").html('<option value=""></option>');
                }
            });
            form.render('select');//需要渲染一下

        });

        //区域县事件
        form.on('select(queryCity)', function(data){
            $.ajax({
                url: '<%=contextPath%>/areaDict/queryTown',
                type: "post",
                dataType : "json",
                data:{
                    pid: data.value
                },
                async: false,//这得注意是同步
                success: function (result) {
                    resultData = result;
                    var htmls = '<option value=""></option>'; //全局变量
                    for(var x in resultData){
                        htmls += '<option value = "' + resultData[x].id + '">' + resultData[x].district + '</option>'
                    }
                    $("#queryTown").html(htmls);
                }
            });
            form.render('select');//需要渲染一下

        });

        //表列条工具事件捕捉
        table.on('tool(test)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象


            if (layEvent === 'del') { //删除
                layer.confirm('真的删除它么', function (index) {
                    //向服务端发送删除指令
                    $.ajax({
                       url:'<%=contextPath%>/recruit/delRecruit'
                        ,type:'post'
                        ,dataType:'json'
                        ,data:data
                        ,async:false
                        ,success:function(data){
                           if(data){
                               layer.alert('删除成功');
                               obj.del(); //删除对应行（tr）的DOM结构
                               layer.close(index);
                           }else{
                               layer.alert('删除失败');
                           }

                        }
                    });

                });
            } else if (layEvent === 'edit') { //编辑
                layer.open({
                    title:'编辑信息',
                    type:2,
                    area: ['750px', '600px'],
                    offset: 'auto',
                    async:false,
                    content:'<%=contextPath%>/view/recruit/updateRecruit.jsp?recruitId='+data.recruitId
                });
            }
        });

        //监听头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id)
                ,data = checkStatus.data; //获取选中的数据
            switch(obj.event){
                case 'add':
                    layer.open({
                        title:'编辑信息',
                        type:2,
                        area: ['750px', '600px'],
                        offset: 'auto',
                        async:false,
                        content:'<%=contextPath%>/view/recruit/addRecruit.jsp'
                    });
                    break;
                case 'update':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else if(data.length > 1){
                        layer.msg('只能同时编辑一个');
                    } else {
                        layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
                    }
                    break;
                case 'delete':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else {
                        layer.msg('删除');
                    }
                    break;
            };
        });
    });

</script>
</body>
</html>
