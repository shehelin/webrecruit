<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="../base/base.jsp" %>
    <title>企业信息</title>
    <link rel="stylesheet" href="<%=contextPath%>/layui-v2.4.5/layui/css/layui.css" />
</head>
<body style="margin-top: 70px">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>企业信息</legend>
</fieldset>
<form id="form1" lay-filter="form1" class="layui-form layui-form-pane">

    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">企业编号</label>
            <div class="layui-input-block">
                <input disabled="disabled" type="text" name="comId" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline" >
            <label class="layui-form-label">企业名称</label>
            <div class="layui-input-block" >
               <input diabled="disabled" type="text" name="comName" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">企业类型</label>
            <div class="layui-input-block">
                <input disabled="disabled" type="text" name="comType" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>


    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">企业地址</label>
            <div class="layui-input-block">
                <input disabled="disabled" type="text" name="comAddress"  autocomplete="off" class="layui-input" lay-verify="required">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">企业电话</label>
            <div class="layui-input-block">
                <input disabled="disabled" type="text" name="comTel"  autocomplete="off" class="layui-input" lay-verify ="required">
            </div>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">企业概要</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" disabled="disabled"  name="comInfo" class="layui-textarea"></textarea>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" disabled="disabled"  name="remark" class="layui-textarea"></textarea>
        </div>
    </div>

    <div class="layui-form-item layui-form-text" style="display: none">
        <div class="layui-input-block">
            <input  disabled="disabled"  name="userId" class="layui-input" />
        </div>
    </div>
    <div class="layui-form-item">
        <button  type="button" style="margin-left:40%" class="layui-btn" onclick="Controller()">企业操作</button>
        <button id="doCompany"  type="button" disabled="disabled"
                class="layui-btn layui-btn-primary" onclick="doCompanys()" >保存</button>
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
            url : "<%=contextPath%>/company/queryCompanyById",
            type : "post",
            dataType:"json",
            async:false,
            data : {
            },
            success : function(data) {

                if(data.length==0){
                    return;
                }
                data1 = JSON.parse(JSON.stringify(data[0]));
            },
            error : function() {
                alert('系统异常');
            }
        });

        //表单初始赋值
        form.val('form1', data1);

        form.render();
    });

    function Controller() {
        $("[disabled]").removeAttr("disabled");
        $("#doCompany").attr('class','layui-btn');
    }

    function doCompanys(){
        var data1 = getFormData("#form1");
        $.ajax({
            url : "<%=contextPath%>/company/doCompany",
            type : "post",
            dataType:"json",
            async:false,
            data : data1,
            success : function(data) {
                if (data.status == 200) {
                    alert("保存成功");
                    window.parent.location.href = "<%=contextPath%>/company/";
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
