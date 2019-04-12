<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="../base/base.jsp" %>
    <title>应聘栏</title>
    <link rel="stylesheet" href="<%=contextPath%>/layui-v2.4.5/layui/css/layui.css" media="all"/>
</head>
<body style="margin-top: 70px">

<style type="text/css">
    .layui-table-page {
        position:fixed;
    }
</style>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>应聘信息</legend>
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
            <label class="layui-form-label">申请状态</label>
            <div class="layui-input-block">
                <select name="status" id="status" >
                    <option value="">请选择</option>
                    <option value="审核">审核</option>
                    <option value="通过">通过</option>
                    <option value="拒绝">拒绝</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <button class="layui-btn" lay-submit lay-filter="search">搜索</button>
            <input type="reset" class="layui-btn layui-btn-primary" value="重置"/>
        </div>
    </div>
</div>

<table id="demo" lay-filter="test"> </table>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
</script>

<script type="text/javascript">

    layui.use(['table','form','laydate'], function() {
        var companyInfo={};
        //初始化企业信息
        $.ajax({
            url: '<%=contextPath%>/company/queryCompanyById',
            type: "post",
            dataType : "json",
            async:false,
            success: function (data) {
                if(data.length==0){
                    return;
                }
                companyInfo = JSON.parse(JSON.stringify(data[0]));
            }
        });
        var comId = companyInfo.comId;
        //加载模块
        var table = layui.table;
        var form = layui.form;
        //映射数据
        table.render({
            elem: '#demo'
            , height: 400
            , url: '<%=contextPath%>/employeeJob/queryEmpRelCompany'
            , where:{
                comId:comId
            }
            , page: true
            , skin: 'line'
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
                , {title: '操作', align: 'center', toolbar: '#barDemo',fixed:'right',width: 130}
            ]]
        });

        //表列条工具事件捕捉
        table.on('tool(test)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if (layEvent === 'detail') { //查看
                //todo 查看简历信息 resume
                layer.open({
                    title:'详细招聘信息',
                    type:2,
                    area: ['750px', '600px'],
                    offset: 'auto',
                    async:false,
                    content:'<%=contextPath%>/view/recruit/recruitDetail.jsp?recruitId='+data.recruitId
                });
            }
        });

        //form表单提交事件
        form.on('submit(search)',function (data) {
            var data1 = data.field;
            data1['comId'] = comId;
            debugger;
            table.reload('demo', {
                url: '<%=contextPath%>/employeeJob/queryEmpRelCompany'
                ,where: data1 //设定异步数据接口的额外参数
                //,height: 300
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        });

    });


</script>
</body>
</html>
