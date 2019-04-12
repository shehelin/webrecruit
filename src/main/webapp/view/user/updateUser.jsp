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
                </div>
                <div class="form-group">
                    <label for="userName">用户昵称</label>
                    <input style="width: 40%" type="text" class="form-control" id="userName" name="userName"
                    value="<%=userName%>"/>
                </div>
                <div class="form-group">
                    <label for="realName">真实姓名</label>
                    <input style="width: 40%" type="text" class="form-control" id="realName" name="realName"
                    value="<%=user.getRealName()%>"/>
                </div>
                <div class="form-group">
                    <label for="sex">性别</label>
                    <select style="width: 10%" id="sex" class="form-control" name="sex">
                        <option value="1">男</option>
                        <option value="2">女</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="phone">联系电话</label>
                    <input style="width: 40%" type="text" class="form-control" id="phone" name="phone"
                    value="<%=user.getPhone()%>"/>
                </div>
                <div class="form-group">
                    <label for="email">邮箱地址</label>
                    <input style="width: 40%" type="text" class="form-control" id="email" name="email"
                    value="<%=user.getEmail()%>"/>
                </div>
                <div class="form-group" style="width: 70%;float:right">
                    <button id="btnOn" type="button" class="btn btn-default" onclick="doUpateUser();">保存</button>
                    <button type="reset" class="btn btn-default">重置</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

<script type="text/javascript">
    $(function(){
        var sexId = "<%=user.getSex()%>";
        $("#sex").val(sexId);


    });

    function doUpateUser(){
        var data = getFormData('#form1');
        $.ajax({
            url : "<%=contextPath%>/user/doUpdateUser",
            type : "post",
            dataType : "json",
            data : data,
            success : function(data) {
                if (data) {
                    alert("保存成功");
                    refresh();
                } else {
                    alert("保存失败");
                }

            },
            error : function() {
                alert('系统异常');
            }
        });
    }

    function refresh(){
        var data = getFormData('#form1');
        $.ajax({
            url : "<%=contextPath%>/user/queryUserById",
            type : "post",
            dataType : "json",
            data : data,
            success : function(data) {
                if (data != null) {
                    window.location.href="";
                } else {
                    alert("未知错误");
                    window.parent.location.href = "<%=contextPath%>";
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