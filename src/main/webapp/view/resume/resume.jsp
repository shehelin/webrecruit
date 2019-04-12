<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="../base/base.jsp" %>
    <title>企业信息</title>
</head>
<link rel="stylesheet" href="<%=contextPath%>/layui-v2.4.5/layui/css/layui.css" />

<body style="margin-top: 70px">


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>我的简历</legend>
</fieldset>
<form id="form1" lay-filter="form1" class="layui-form layui-form-pane">
    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">姓 名</label>
            <div class="layui-input-block">
                <input disabled="disabled" type="text" name="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline" >
            <label class="layui-form-label">性 别</label>
            <div class="layui-input-inline" >
                <select  name="sex" lay-verify ="required">
                    <option value="0"></option>
                    <option value="1">男</option>
                    <option value="2">女</option>
                </select>
            </div>
        </div>
    </div>

    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">民 族</label>
            <div class="layui-input-block">
                <input disabled="disabled" type="text" name="nation" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">出生日期</label>
            <div class="layui-input-block">
                <input disabled="disabled" type="text" name="birthDate" id="date1" autocomplete="off" class="layui-input" lay-verify="required">
            </div>
        </div>

    </div>

    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">籍 贯</label>
            <div class="layui-input-block">
                <input disabled="disabled" type="text" name="birthArea"  autocomplete="off" class="layui-input" lay-verify ="required">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">现所在地</label>
            <div class="layui-input-inline">
                <input disabled="disabled" type="text" name="localArea" autocomplete="off" class="layui-input" lay-verify ="required">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">就读学校</label>
            <div class="layui-input-inline">
                <input disabled="disabled" type="text" name="graduation" autocomplete="off" class="layui-input" lay-verify ="required">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">学 历</label>
            <div class="layui-input-inline">
                <input disabled="disabled" type="text" name="educationLevel" autocomplete="off" class="layui-input" lay-verify ="required">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">专业名称</label>
            <div class="layui-input-block">
                <input disabled="disabled" type="text" name="major"  autocomplete="off" class="layui-input" lay-verify ="required">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">政治面貌</label>
            <div class="layui-input-inline">
                <input disabled="disabled" type="text" name="politicStatus" autocomplete="off" class="layui-input" lay-verify ="required">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">联系方式</label>
            <div class="layui-input-inline">
                <input disabled="disabled" type="text" name="phone" autocomplete="off" class="layui-input" lay-verify ="required">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">E-mail</label>
            <div class="layui-input-inline">
                <input disabled="disabled" type="text" name="email" autocomplete="off" class="layui-input" lay-verify ="required">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">求职意向</label>
        <div class="layui-input-block">
            <input disabled="disabled" type="text" name="jobName" autocomplete="off" placeholder="请输入" class="layui-input" lay-verify ="required">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">技能专长</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" disabled="disabled"  name="skill" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">社会/项目经验</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" disabled="disabled"  name="experience" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-form-text" style="display: none">
        <div class="layui-input-block">
            <input  disabled="disabled"  name="resumeId" class="layui-input" />
            <input  disabled="disabled"  name="userId" class="layui-input" />
            <input  disabled="disabled"  name="fileId" class="layui-input" />
        </div>
        <div>

        </div>
    </div>
    <div class="layui-form-item">
        <button  type="button" style="margin-left:40%" class="layui-btn" onclick="resumeController()">简历操作</button>
        <button id="doResume"  type="button" disabled="disabled"
                 class="layui-btn layui-btn-primary" onclick="doResumes()" >保存</button>
    </div>
</form>

<script type="text/javascript">

        layui.use(['form', 'layedit', 'laydate'], function(){
            var form = layui.form
                ,layer = layui.layer
                ,layedit = layui.layedit
                ,laydate = layui.laydate;

            //日期
            laydate.render({
                elem: '#date'
            });
            laydate.render({
                elem: '#date1'
            });

            //创建一个编辑器
            // var editIndex = layedit.build('LAY_demo_editor');

            var data1;

            $.ajax({
                url : "<%=contextPath%>/resume/queryResume",
                type : "post",
                dataType:"json",
                async:false,
                data : {
                },
                success : function(data) {
                    data1 = JSON.parse(JSON.stringify(data.data[0]));
                },
                error : function() {
                    alert('系统异常');
                }
            });

            //表单初始赋值
            form.val('form1', data1);

            form.render();
        });

        function resumeController() {
            $("[disabled]").removeAttr("disabled");
            $("#doResume").attr('class','layui-btn');
        }

        function doResumes(){
           var data1 = getFormData("#form1");
            $.ajax({
                url : "<%=contextPath%>/resume/setResume",
                type : "post",
                dataType:"json",
                async:false,
                data : data1,
                success : function(data) {
                    if (data.status == 200) {
                        alert("保存成功");
                        window.parent.location.href = "<%=contextPath%>/resume/";
                    } else {
                        alert("保存失败");
                    }
                },
                error : function() {
                    alert('系统异常');
                }
            });
        }

        /**
         * 获取表单信息
         * @param id
         * @returns {string}
         */
        function getFormData(id) {
            var d = {};
            var t = $(id).serializeArray();
            $.each(t, function () {
                d[this.name] = this.value;
            });

            return d;
        }
</script>

</body>
</html>

