<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../base/import.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>招聘信息</title>
    <link rel="stylesheet" href="<%=contextPath%>/layui-v2.4.5/layui/css/layui.css" media="all"/>
</head>
<hr/>
<div></div>
<div id="form1" lay-filter="form1" class="layui-form layui-form-pane">

    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">职 位</label>
            <div class="layui-input-block">
                <input  type="text" name="jobName"  placeholder="请输入" autocomplete="off" class="layui-input">
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
        var laydate = layui.laydate;
        //招聘实例
        table.render({
            elem: '#demo'
            , height: 400
            , url: '<%=contextPath%>/recruit/queryMyRecruit'
            , page: true //开启分页
            , skin: 'line'
            // ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            , cols: [[ //表头
                {field:'status',title:'审核状态',width:130,sort:true,
                  templet:function (data) {
                      if(data.status=='1'){
                          return '审核通过';
                      }else if(data.status =='2'){
                          return '审核失败';
                      }else{
                          return '待审核';
                      }
                  }},
                {field:'valid',title:'是否过期',width:130, templet:function (data) {
                        if(data.valid=='1'){
                            return '有效';
                        }else if(data.valid =='2'){
                            return '过期';
                        }else{
                            return '失效';
                        }
                    }}
                , {field: 'comId', title: '企业ID', width: 130, sort: true}
                , {field: 'comName', title: '企业名称', width: 130, sort: true}
                , {field: 'jobName', title: '招聘职位', width: 130, sort: true}
                , {field: 'jobNumber', title: '招聘人数', width: 130, sort: true}
                , {field: 'jobArea', title: '职位地点', width: 130, sort: true}
                , {field: 'minSalary', title: '薪资低估', width: 130, sort: true}
                , {field: 'maxSalary', title: '薪资高估', width: 130, sort: true}
                , {field: 'beginTime', title: '招聘时间', width: 130, sort: true}
                , {field: 'endTime', title: '结束时间', width: 130, sort: true}
                , {field: 'createTime', title: '发布时间', width: 130, sort: true}
                , {title: '操作', align: 'center', toolbar: '#barDemo',fixed:'right',width: 200}
            ]]
        });
        //日期映射
        laydate.render({
            elem: '#beginTime'
        });
        laydate.render({
            elem: '#endTime'
        });

        //表列条工具事件捕捉
        table.on('tool(test)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            console.log(data);
            if (layEvent === 'detail') { //查看
                //todo 查看招聘详情
                layer.open({
                    title:'详细招聘信息',
                    type:2,
                    area: ['700px', '400px'],
                    offset: 'auto',
                    async:false,
                    content:'<%=contextPath%>/view/recruit/recruitDetail.jsp?recruitId='+data.recruitId
                });
            }else if(layEvent==='yes'){
                var data = obj.data; //获得当前行数据
                data['status'] = '1';
                data['valid'] = '1'
                layer.confirm('是否通过审核？',function(){
                    $.ajax({
                        url: '<%=contextPath%>/recruit/updateStatus',
                        type: "post",
                        dataType : "json",
                        data: data,
                        async:false,
                        success: function (data) {
                            if(data){
                                layer.alert('通过审核');
                                reloadRecruit(null);
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
                data['status'] = '2';
                data['valid'] = '0';
                layer.confirm('是否回退？',function() {
                    $.ajax({
                        url: '<%=contextPath%>/recruit/updateStatus',
                        type: "post",
                        dataType: "json",
                        data: data,
                        async: false,
                        success: function (data) {
                            if (data) {
                                layer.alert('回退成功');
                                reloadRecruit(null);
                            } else {
                                layer.alert('回退失败');
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
            reloadRecruit(data.field);

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


        function reloadRecruit(data) {
            table.reload('demo', {
                url: '<%=contextPath%>/recruit/queryMyRecruit'
                ,where: data //设定异步数据接口的额外参数
                //,height: 300
                ,method:'post'
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        }

    });


</script>
</body>
</html>
