<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="../base/import.jsp" %>
    <title>企业信息详情</title>
    <link rel="stylesheet" href="<%=contextPath%>/layui-v2.4.5/layui/css/layui.css" />
</head>
<body style="margin-top: 70px">
<fieldset class="layui-elem-field layui-field-title" >
    <legend>企业信息</legend>
</fieldset>
<div id="form1" lay-filter="form1" class="layui-form layui-form-pane">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">审核状态</label>
            <div class="layui-input-block">
                <select disabled="disabled"  id = "status" name="status" >
                </select>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">企业编号</label>
            <div class="layui-input-block">
                <input disabled="disabled" type="text" id="comId" name="comId"  placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline" >
            <label class="layui-form-label">企业名称</label>
            <div class="layui-input-block" >
               <input disabled="disabled" type="text" name="comName"  placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">企业类型</label>
            <div class="layui-input-block">
                <select  name="comType" id="comType" >
                </select>
            </div>
        </div>
    </div>


    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">企业地址</label>
            <div class="layui-input-block">
                <input disabled="disabled" type="text" name="comAddress"  autocomplete="off" class="layui-input" >
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">企业电话</label>
            <div class="layui-input-block">
                <input disabled="disabled" type="text" name="comTel"  autocomplete="off" class="layui-input" >
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
        <button style="margin-left: 40%" class="layui-btn layui-btn-primary" lay-submit  lay-filter="cancel">返回</button>
    </div>
</div>
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
        //字典
        $("#comType").html(getDict("BUSINESS_TYPE"));
        $("#status").html(getDict("status"));
        form.render('select');


        var userId = '<%=request.getParameter("userId")%>';
        $.ajax({
            url : "<%=contextPath%>/company/queryCompanyById",
            type : "post",
            dataType:"json",
            async:false,
            data : {
                userId:userId
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

        //返回
        form.on('submit(cancel)',function () {
            //关闭窗口
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index); //关闭窗口
        });


        function getDict(dictType){
            var result;
            var htmls = '<option value=""></option>'; //全局变量
            $.ajax({
                url: '<%=contextPath%>/areaDict/queryDict',
                type: "post",
                dataType : "json",
                async: false,//这得注意是同步
                data:{
                    dictTypeId: dictType
                },
                success: function (data) {
                    result = data;
                    for(var x in result){
                        htmls += '<option value = "' + result[x].dictId + '">' + result[x].dictName + '</option>'
                    }
                }
            });
            return htmls;
        }
    });




</script>
</body>
</html>
