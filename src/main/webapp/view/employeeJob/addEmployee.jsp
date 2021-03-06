<%--
  Created by IntelliJ IDEA.
  User: helin.she
  Date: 2019/4/9
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.hl.recruit.entity.UserEntity" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../base/import.jsp" %>
<%
    UserEntity user = (UserEntity) request.getSession().getAttribute("user");
    String userName = "";
    String userId = "";
    String userStatus = "";
    if (user != null){
        userName = user.getUserName();
        userId = user.getUserId();
        userStatus = user.getUserStatus();
    }
    String comId = request.getParameter("comId");
    String empJob = request.getParameter("jobName");

%>
<html>
<head>
    <title>申请求职</title>
    <link rel="stylesheet" href="<%=contextPath%>/layui-v2.4.5/layui/css/layui.css" media="all"/>
</head>

<body style="margin-top: 30px">
<fieldset class="layui-elem-field layui-field-title">
    <legend>申请求职</legend>
</fieldset>
<div id="form1" lay-filter="form1" class="layui-form layui-form-pane">

    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">申请人</label>
            <div class="layui-input-block">
                <input  type="text" name="empName"  placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">申请岗位</label>
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
        <label class="layui-form-label">工作地址</label>
        <div class="layui-input-inline">
            <select name="jobProvince" id="jobProvince" lay-filter="queryProvince">
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="jobCity" id="jobCity" lay-filter="queryCity">
                <option value=""></option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="jobTown" id="jobTown">
                <option value=""></option>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">对企业想说的话</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" name="remark" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-form-text" style="display: none">
        <div class="layui-input-block">
            <input  disabled="disabled"  name="userId" class="layui-input" />
            <input disabled="disabled" name="comId" class="layui-input"/>

        </div>
    </div>
    <div style="margin-left: 40%">
        <button class="layui-btn" lay-submit lay-filter="click">申请</button>
        <button class="layui-btn layui-btn-primary" lay-submit lay-filter="cancel">退出</button>
    </div>

</div>
<script type="text/javascript">
    layui.use(['form','laydate'], function() {
        //接收职位信息
        var comId = "<%=comId%>";
        var empJob = "<%=empJob%>";


        //模块加载
        var form = layui.form;
        var laydate = layui.laydate;
        var resultData;//区域字典值

        //日期映射
        laydate.render({
            elem: '#beginTime'
        });
        laydate.render({
            elem: '#endTime'
        });
        //区域初始化
        initArea();
        //数据初始化
        initData();

        //form表单提交事件
        form.on('submit(click)',function (data) {
            var data1 = data.field;
            var Province = $("#jobProvince").find("option:selected").text();
            var City = $("#jobCity").find("option:selected").text();
            var Town =$("#jobTown").find("option:selected").text();
            var jobArea = Province+City+Town;
            data1['empArea'] = jobArea;
            $.ajax({
                url: '<%=contextPath%>/employeeJob/addEmployeeJob',
                type: "post",
                dataType : "json",
                data: data1,
                async: false,//这得注意是同步
                success: function (data) {
                    if(data){
                        layer.msg('申请成功', {
                            icon : 1
                        }, function() {
                            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                            parent.layer.close(index); //关闭窗口
                            parent.window.location.href = "<%=contextPath%>/"; //刷新父页面
                        });

                    }else{
                        layer.alert('申请失败');
                        <%--layer.msg('添加失败', {--%>
                            <%--icon : 2--%>
                        <%--}, function() {--%>
                            <%--var index = parent.layer.getFrameIndex(window.name); //获取窗口索引--%>
                            <%--parent.layer.close(index); //关闭窗口--%>
                            <%--parent.window.location.href = "<%=contextPath%>/recruit/"; //刷新父页面--%>
                        <%--});--%>
                    }
                }
            });
        });

        //退出事件-返回事件
        form.on('submit(cancel)',function () {
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index); //关闭窗口
            parent.window.location.href = "<%=contextPath%>/"; //刷新父页面
        });

        //区域市事件
        form.on('select(queryProvince)', function(data){
            queryCity(data.value);
        });

        //区域县事件
        form.on('select(queryCity)', function(data){
            queryTown(data.value);
        });

        /**
         * 初始化区域
         */
        function initArea(){
            //区域省初始化
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
                    $("#jobProvince").html(htmls);
                }
            });
            form.render('select');//需要渲染一下
        }
        /**
         * 初始化数据
         */
        function initData(){
            //表单赋初值
            var data1={};
            data1['comId'] = comId;
            data1['empJob'] = empJob;
            data1['userId'] = '<%=userId%>';

            //表单初始赋值
            form.val('form1', data1);
            form.render();
        }
        /**
         * 区域市
         * @param data
         */
        function queryCity(data) {
            $.ajax({
                url: '<%=contextPath%>/areaDict/queryCity',
                type: "post",
                dataType : "json",
                data: {
                    pid: data
                },
                async: false,//这得注意是同步
                success: function (result) {
                    resultData = result;
                    var htmls = '<option value=""></option>'; //全局变量
                    for(var x in resultData){
                        htmls += '<option value = "' + resultData[x].id + '">' + resultData[x].district + '</option>'
                    }
                    $("#jobCity").html(htmls);
                    $("#jobTown").html('<option value=""></option>');
                }
            });
            form.render('select');//需要渲染一下
        }

        /**
         * 区域区县
         * @param data
         */
        function queryTown(data){
            $.ajax({
                url: '<%=contextPath%>/areaDict/queryTown',
                type: "post",
                dataType : "json",
                data:{
                    pid: data
                },
                async: false,//这得注意是同步
                success: function (result) {
                    resultData = result;
                    var htmls = '<option value=""></option>'; //全局变量
                    for(var x in resultData){
                        htmls += '<option value = "' + resultData[x].id + '">' + resultData[x].district + '</option>'
                    }
                    $("#jobTown").html(htmls);
                }
            });
            form.render('select');//需要渲染一下

        }
    });
</script>

</body>
</html>
