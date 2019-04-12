<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>修改密码</title>
</head>

<body>
<%@include file="../base/base.jsp"%>

<div class="container" style="margin-top: 100px">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form id="form1" role="form">
                <div class="form-group">
                    <label for="userId">用户登录名</label>
                    <input style="width: 40%;" type="text" class="form-control" id="userId" name="userId"
                    value = "<%=userId%>" readonly="readonly"/>
                <div class="form-group">
                    <label for="pwd">密码</label>
                    <input style="width: 40%" type="password" class="form-control" id="pwd" name="pwd"/>
                    <span name="ct" id="ctPwd" class="label label-warning" style="display: none"></span>
                </div>
                <div class="form-group">
                    <label for="reviewerPwd">确认密码</label>
                    <input style="width: 40%" type="password" class="form-control" id="reviewerPwd" name="reviewerPwd"/>
                    <span name="ct" id="ctRPwd" class="label label-warning" style="display: none"></span>
                </div>
                <div class="form-group" style="width: 70%;float:right">
                    <button id="btnOn" type="button" class="btn btn-default" onclick="doUpdate();">修改</button>
                    <button type="reset" class="btn btn-default">重置</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript">

    $(function () {
        $('#pwd').blur(function () {
            btnOpenClick();
            var pwd = $('#pwd').val();
            var ct = $("#ctPwd");
            if(pwd == null || pwd == ""){
                warningInfo(ct,"不能为空值");
            }else{
                successInfo(ct);
            }
        });

        $('#reviewerPwd').blur(function () {
            btnOpenClick();
            var pwd = $('#pwd').val();
            var rpwd = $('#reviewerPwd').val();
            var ct = $("#ctRPwd");
            if(rpwd == null || rpwd == ""){
                warningInfo(ct,"不能为空值");
            }else if(pwd != rpwd){
                warningInfo(ct,"请确认密码是否一致");
            }else{
                successInfo(ct);
            }
        });
    });

    function doUpdate(){
        var data = getFormData('#form1');
        debugger;
        $.ajax({
            url : "<%=contextPath%>/user/doUpdatePwd",
            type : "post",
            dataType : "json",
            data : data,
            success : function(data) {
                if (data) {
                    alert("修改密码成功");
                    window.parent.location.href = "<%=contextPath%>";
                } else {
                    alert("修改密码失败");
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

    //提示信息控制（判空、非法字符等）
    //校验成功
    function successInfo(ct){
        ct.attr("class","label label-success");
        ct.css("display","");
        ct.attr("title","ok");
        ct.html("ok");
    }
    //校验失败-信息
    function warningInfo(ct,info){
        ct.attr("class","label label-warning");
        ct.css("display","");
        ct.attr("title",info);
        ct.html("warn");
    }

    function btnOpenClick(){
        var result = 0;
        var count = 0;
        $("span[name='ct']").each(function(i){
            count = ++i;
            if($(this).html()=='ok'){
                ++result;
            }
        });
        if(result == count){
            $('#btnOn').removeAttr('disabled');
        }else {
            $('#btnOn').attr('disabled','disabled');
        }
    }

</script>