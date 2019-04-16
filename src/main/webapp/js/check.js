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

layui.use(['form','laydate'],function () {
    var form = layui.form;
    var laydate = layui.laydate;
    var resultData;//区域字典值

    //区域省
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
                $("#queryTown").html('<option value=""></option>');
            }
        });
        form.render('select');//需要渲染一下

    });

    //区域县事件
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


