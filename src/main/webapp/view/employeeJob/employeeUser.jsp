<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="../base/base.jsp" %>
    <title>求职栏</title>
    <link rel="stylesheet" href="<%=contextPath%>/layui-v2.4.5/layui/css/layui.css" media="all"/>
</head>
<body style="margin-top: 70px">

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>我申请过的求职</legend>
</fieldset>
<div id="form1" lay-filter="form1" class="layui-form layui-form-pane">

    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">职 位</label>
            <div class="layui-input-block">
                <input  type="text" name="empJob"  placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">期望薪资</label>
            <div class="layui-input-block">
                <input  type="text" name="empSalary"  placeholder="￥" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">期望地址</label>
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
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">申请状态</label>
        <div class="layui-input-inline">
            <select name="status" id="status" >
                <option value="">请选择</option>
                <option value="审核">审核</option>
                <option value="通过">通过</option>
                <option value="拒绝">拒绝</option>
            </select>
        </div>

        <button class="layui-btn" lay-submit lay-filter="search">搜索</button>
        <input type="reset" class="layui-btn layui-btn-primary" value="重置"/>
    </div>

</div>

<table id="demo" lay-filter="test"> </table>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="del">撤销申请</a>
</script>

<script type="text/javascript">

    layui.use(['table','form','laydate'], function() {
        var table = layui.table;
        var form = layui.form;
        var laydate = layui.laydate;
        //招聘实例
        table.render({
            elem: '#demo'
            , height: 400
            , url: '<%=contextPath%>/employeeJob/queryEmployeeJob?userId=<%=userId%>'
            , page: true //开启分页
            , skin: 'line'
            ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            , cols: [[ //表头
                {type: 'checkbox', fixed: 'left'},
                {field: 'empId', title: '申请编号',sort: true, fixed: 'left',hide:true}
                ,{field: 'comId',title:'企业编号', sort:true, fixed:'left',hide:true}
                , {field: 'empName', title: '申请人', width: 140, sort: true}
                , {field: 'empJob', title: '岗位', width: 140, sort: true}
                , {field: 'empSalary', title: '期望薪资', width: 140, sort: true}
                , {field: 'empArea', title: '期望工作地点', width: 140, sort: true}
                , {field: 'remark', title: '备注', width: 140, sort: true}
                , {field: 'comName', title: '应聘单位', width: 140, sort: true}
                , {field: 'status', title: '申请状态', width: 140, sort: true}
                , {field: 'createTime', title: '申请时间', width: 140, sort: true}
                , {title: '操作', align: 'center', toolbar: '#barDemo',fixed:'right',width: 200}
            ]]
        });
        //日期映射
        laydate.render({
            elem: '#_'
        });

        //表列条工具事件捕捉
        table.on('tool(test)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if (layEvent === 'del') { //删除
                layer.confirm('真的撤销申请吗？', function (index) {
                    //向服务端发送删除指令
                    $.ajax({
                        url:'<%=contextPath%>/employeeJob/delEmployeeJob'
                        ,type:'post'
                        ,dataType:'json'
                        ,data:{
                            empId: data.empId
                        }
                        ,async:false
                        ,success:function(data){
                            if(data){
                                layer.alert('撤销成功');
                                obj.del(); //删除对应行（tr）的DOM结构
                                layer.close(index);
                            }else{
                                layer.alert('撤销失败');
                            }
                        }
                    });
                });

            }else if(layEvent === 'update'){//编辑

            }
        });

        //form表单提交事件
        form.on('submit(search)',function (data) {

            var data1 = data.field;
            var Province = $("#queryProvince").find("option:selected").text();
            var City = $("#queryCity").find("option:selected").text();
            var Town =$("#queryTown").find("option:selected").text();
            var area = Province+City+Town;
            data1['empArea'] = area;
            console.log(data1);
            debugger;
            table.reload('demo', {
                url: '<%=contextPath%>/employeeJob/queryEmployeeJob'
                ,where: data1 //设定异步数据接口的额外参数
                //,height: 300
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        });


        //区域省
        var resultData;

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
                    $("#queryTown").html(htmls);
                }
            });
            form.render('select');//需要渲染一下

        });

        //区域县
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


    });


</script>
</body>
</html>
