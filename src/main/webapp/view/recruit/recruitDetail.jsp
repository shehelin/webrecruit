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

%>
<html>
<head>
    <title>招聘详情</title>
    <link rel="stylesheet" href="<%=contextPath%>/layui-v2.4.5/layui/css/layui.css" media="all"/>
</head>

<body style="margin-top: 30px">
<fieldset class="layui-elem-field layui-field-title">
    <legend>招聘详情</legend>
</fieldset>
<div id="form1" lay-filter="form1" class="layui-form layui-form-pane">

    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">企业名称</label>
            <div class="layui-input-block">
                <input disabled="disabled"  type="text" name="comName"  placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>

    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">企业电话</label>
            <div class="layui-input-block">
                <input disabled="disabled"  type="text" name="comTel"  placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">地址</label>
            <div class="layui-input-block">
                <input disabled="disabled"  type="text" name="comAddress"  placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">企业信息</label>
        <div class="layui-input-block">
            <textarea disabled="disabled" placeholder="请输入内容" name="comInfo" class="layui-textarea"></textarea>
        </div>
    </div>

    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">招聘职位</label>
            <div class="layui-input-block">
                <input disabled="disabled"  type="text" name="jobName"  placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">招聘人数</label>
            <div class="layui-input-block">
                <input disabled="disabled"  type="text" name="jobNumber"  placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>


    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">最低薪资</label>
            <div class="layui-input-block">
                <input disabled="disabled"  type="text" name="minSalary"  placeholder="￥" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">最高薪资</label>
            <div class="layui-input-block">
                <input disabled="disabled"  type="text" name="maxSalary"  placeholder="￥" autocomplete="off" class="layui-input">
            </div>
        </div>

    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">开始时间</label>
            <div class="layui-input-block">
                <input disabled="disabled"  type="text" id="beginTime" name="beginTime"  autocomplete="off" class="layui-input" >
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">结束时间</label>
            <div class="layui-input-block">
                <input disabled="disabled"  type="text" id="endTime" name="endTime"  autocomplete="off" class="layui-input" >
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">工作地址</label>
        <div class="layui-input-inline">
            <input disabled="disabled"  type="text" disabled="disabled" id="jobArea" name="jobArea"  autocomplete="off" class="layui-input" >
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">应聘条件</label>
        <div class="layui-input-block">
            <textarea disabled="disabled" placeholder="请输入内容" name="recruitCondition" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-form-text" style="display: none">
        <div class="layui-input-block">
            <input disabled="disabled"  disabled="disabled"  name="userId" class="layui-input" />
            <input disabled="disabled" disabled="disabled" name="recruitId" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">联系人</label>
            <div class="layui-input-inline">
                <input disabled="disabled"  type="text" name="realName"  placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">联系电话</label>
            <div class="layui-input-block">
                <input disabled="disabled"  type="text" name="phone"  placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">Email</label>
            <div class="layui-input-block">
                <input disabled="disabled"  type="text" name="email"  placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <input disabled="disabled"  type="text" name="recruitId"  style="display: none" placeholder="请输入" autocomplete="off" class="layui-input">
        <input disabled="disabled"  type="text" name="comId"  style="display: none" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
    <div style="margin-left: 40%">
        <button id="enjoyJob" class="layui-btn" lay-submit lay-filter="click">申请职位</button>
        <button class="layui-btn layui-btn-primary" lay-submit  lay-filter="cancel">返回</button>
    </div>
</div>
<script type="text/javascript">
    layui.use(['form','laydate'], function() {
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

        //数据初始化
        initData();

        //form表单提交事件
        form.on('submit(click)',function (data) {
            var data1 = data.field;
            //todo 申请职位
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            document.write("<form action='<%=contextPath%>/employeeJob/addEmployeeView' method='post' name='form2' style='display:none'>");
            document.write("<input type='hidden' name='comId' value="+data1.comId+">");
            document.write("<input type='hidden' name='jobName' value="+data1.jobName+">");
            document.write("</form>");
            document.form2.submit();
            parent.layer.title('申请职位流程');
        });

        //返回
        form.on('submit(cancel)',function () {
            //关闭窗口
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index); //关闭窗口
            parent.window.location.href = "<%=contextPath%>/"; //刷新父页面
        });

        /**
         * 初始化数据
         */
        function initData(){
            //表单赋初值
            var data1;
            var recruitId = '<%=request.getParameter("recruitId")%>';
            $.ajax({
                url : "<%=contextPath%>/recruit/queryRecruitById",
                type : "post",
                dataType:"json",
                async:false,
                data : {
                    recruitId: recruitId
                },
                success : function(data) {
                    if(data.length==0){
                        return;
                    }
                    data1 = JSON.parse(JSON.stringify(data[0]));
                },
                error : function() {
                    layer.alert('系统异常');
                }
            });

            //表单初始赋值
            form.val('form1', data1);
            form.render();
        }

    });

    //权限控制
    $(function () {
        var userStatus = '<%=userStatus%>';
        if(userStatus=='1' ||userStatus=='0'){
            $("#enjoyJob").css('display','none');
        }
    });


</script>


</body>
</html>
