<%--
  Created by IntelliJ IDEA.
  User: helin.she
  Date: 2019/4/9
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../base/import.jsp" %>

<html>
<head>
    <title>添加数据类型</title>
    <link rel="stylesheet" href="<%=contextPath%>/layui-v2.4.5/layui/css/layui.css" media="all"/>
</head>

<body style="margin-top: 30px">
<fieldset class="layui-elem-field layui-field-title">
    <legend>添加数据类型</legend>
</fieldset>
<div id="form1" lay-filter="form1" class="layui-form layui-form-pane">

    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">数据键值</label>
            <div class="layui-input-block">
                <input  type="text" name="dictId"  placeholder="请输入" autocomplete="off" class="layui-input" lay-verify="required">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">数据名称</label>
            <div class="layui-input-block">
                <input  type="text" name="dictName"  placeholder="请输入" autocomplete="off" class="layui-input" lay-verify="required">
            </div>
        </div>

        <div class="layui-inline" style="display: none">
            <label class="layui-form-label">数据类型</label>
            <div class="layui-input-block">
                <input  type="text" name="dictTypeId"  placeholder="请输入" autocomplete="off" class="layui-input" lay-verify="required">
            </div>
        </div>
    </div>

    <div style="margin-left: 40%">
        <button class="layui-btn" lay-submit lay-filter="click">添加</button>
    </div>

</div>
<script type="text/javascript">
    layui.use(['form','laydate'], function() {
        //模块加载
        var form = layui.form;
        var findDictTypeId = '<%=request.getParameter("dictTypeId")%>';
        var data =
            {
                dictTypeId:findDictTypeId
            };
        form.val('form1',data);
        form.render();

        //form表单提交事件
        form.on('submit(click)', function (data) {
            var data1 = data.field;
            $.ajax({
                url: '<%=contextPath%>/areaDict/addDict',
                type: "post",
                dataType: "json",
                data: data1,
                async: false,//这得注意是同步
                success: function (data) {
                    if (data) {
                        layer.msg('添加成功', {
                            icon: 1
                        }, function () {
                            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                            parent.layer.close(index); //关闭窗口
                            parent.window.location.href = "<%=contextPath%>/view/admin/DictInfos.jsp"; //刷新父页面
                        });

                    } else {
                        layer.alert('添加失败');

                    }
                }
            });
        });

    });

</script>

</body>
</html>
