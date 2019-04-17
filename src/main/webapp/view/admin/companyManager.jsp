<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../base/import.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>企业信息</title>
    <link rel="stylesheet" href="<%=contextPath%>/layui-v2.4.5/layui/css/layui.css" media="all"/>
</head>
<hr/>
<div></div>
<div id="form1" lay-filter="form1" class="layui-form layui-form-pane">

    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">审核状态</label>
            <div class="layui-input-block">
                <select name="status" id="status" >
                </select>
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">企业类型</label>
            <div class="layui-input-block">
                <select  id="comType" name="comType"  >
                </select>
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">企业Id</label>
            <div class="layui-input-block">
                <input  type="text" id="comId" name="comId"  autocomplete="off" class="layui-input" >
            </div>
        </div>

        <button class="layui-btn" lay-submit lay-filter="search">搜索</button>

    </div>

</div>

<table id="demo" lay-filter="test"> </table>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="no">回退</a>
    <a class="layui-btn layui-btn-xs" lay-event="yes">通过</a>
</script>

<script type="text/javascript">

    layui.use(['table','form','laydate'], function() {
        var table = layui.table;
        var form = layui.form;
        //初始化

        $("#status").html(getDict('status'));
        $("#comType").html(getDict('BUSINESS_TYPE'));
        form.render('select');//需要渲染一下

        table.render({
            elem: '#demo'
            , height: 400
            , url: '<%=contextPath%>/company/queryPageCompany'
            , method:'post'
            , page: true //开启分页
            , skin: 'line'
            , cols: [[ //表头
                {field:'status',title:'审核状态',width:130,sort:true,
                    templet:function (data) {
                        if(data.status=='1'){
                            return '审核通过';
                        }else if(data.status =='2'){
                            return '回退成功';
                        }else{
                            return '待审核';
                        }
                    }}
                , {field: 'comId', title: '企业ID', width: 130, sort: true}
                , {field: 'comName', title: '企业名称', width: 130, sort: true}
                , {field: 'comType', title: '企业类型', width: 130,sort:true,
                    templet:function(data){
                        return getDictName('BUSINESS_TYPE',data.comType);
                    }},
                , {field: 'comAddress', title: '企业地址', width: 130, sort: true}
                , {field: 'comTel', title: '企业电话', width: 130, sort: true}
                , {field: 'comInfo', title: '企业信息', width: 130, sort: true}
                , {field: 'remark', title: '备注', width: 130, sort: true}
                , {field: 'createTime', title: '发布时间', width: 130, sort: true}
                , {title: '操作', align: 'center', toolbar: '#barDemo',fixed:'right',width: 200}
            ]]
        });


        //表列条工具事件捕捉
        table.on('tool(test)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            if (layEvent === 'detail') { //查看
                //todo 查看企业详情
                layer.open({
                    title:'详细企业信息',
                    type:2,
                    area: ['700px', '400px'],
                    offset: 'auto',
                    async:false,
                    content:'<%=contextPath%>/view/company/companyDetail.jsp?userId='+data.userId
                });
            }else if(layEvent==='yes'){
                var data = obj.data; //获得当前行数据
                if(data['status'] === '1'){
                    layer.alert('已经是该状态了');
                    return;
                }
                data['status'] = '1';
                layer.confirm('是否通过审核？',function(){
                    $.ajax({
                        url: '<%=contextPath%>/company/updateStatus',
                        type: "post",
                        dataType : "json",
                        data: data,
                        async:false,
                        success: function (data) {
                            if(data){
                                layer.alert('通过审核');
                                reloadCompany(null);
                            }else{
                                layer.alert('审核失败');
                            }
                        }, error: function(){
                            layer.alert('系统异常');
                        }
                    });
                });

            }else if(layEvent==='no'){

                var data = obj.data; //获得当前行数据
                if(data['status'] === '2'){
                    layer.alert('已经是该状态了');
                    return;
                }
                data['status'] = '2';
                layer.confirm('是否回退？',function() {
                    $.ajax({
                        url: '<%=contextPath%>/company/updateStatus',
                        type: "post",
                        dataType: "json",
                        data: data,
                        async: false,
                        success: function (data) {
                            if (data) {
                                layer.alert('回退成功');
                                reloadCompany(null);
                            } else {
                                layer.alert('无法回退，具备某些条件（发布过招聘信息等）');
                            }
                        },
                        error: function () {
                            layer.alert('系统异常');
                        }
                    });
                });
            }

        });

        //form表单提交事件
        form.on('submit(search)',function (data) {
            reloadCompany(data.field);
        });



        function reloadCompany(data) {
            table.reload('demo', {
                url: '<%=contextPath%>/company/queryPageCompany'
                ,where: data //设定异步数据接口的额外参数
                //,height: 300
                ,method:'post'
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        }

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

        function getDictName(dictType,dictId){
            var result;
            $.ajax({
                url: '<%=contextPath%>/areaDict/queryDict',
                type: "post",
                dataType : "json",
                async: false,//这得注意是同步
                data:{
                    dictTypeId: dictType,
                    dictId : dictId
                },
                success: function (data) {
                    result = data;
                }
            });
            return result[0].dictName;
        }


    });


</script>
</body>
</html>
