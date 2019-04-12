<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@include file="../base/import.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>登录</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background: url(<%=contextPath%>/common/images/bj.jpg) top left no-repeat;
        }
    </style>

    <script type="text/javascript" src="<%=contextPath%>/common/js/jquery-1.9.1.js"></script>

    <script type="text/javascript">

        function doLogin() {
            var userId = $('#username').val();
            var pwd = $('#password').val();
            var userStatus = $('#userStatus option:selected').val();
            if (userId == null || userId == "") {
                alert("请输入用户名");
                return;
            }
            if (pwd == null || pwd == "") {
                alert("请输入密码");
                return;
            }
            $.ajax({
                url : "<%=contextPath%>/doLogin",
                type : "post",
                dataType : "json",
                data : {
                    "userId" : userId,
                    "pwd" : pwd,
                    "userStatus":userStatus
                },
                success : function(data, textStatus, jqXHR) {
                    if (data.status == 200) {
                        //window.location.href = "/fkqb/login/goMain";
                        window.parent.location.href = "<%=contextPath%>";
                    } else {
                        alert("用户名或密码错误 ");
                    }

                },
                error : function() {
                    alert('系统异常');
                }
            });
        }
    </script>

</head>

<body>
<div style=" width:502px; height:333px; margin:0 auto; background:url(<%=contextPath%>/common/images/dlbj.png) no-repeat; margin-top:200px; overflow:hidden;">
    <div style="width: 370px; height: 47px; overflow: hidden; margin: 0 auto; margin-top: 64px; margin-bottom: 22px;">
        <img src="<%=contextPath%>/common/images/yhm.jpg" style="float: left;">
        <input id="username" name="" type="text"
               style="float: left; width: 310px; padding-left: 10px; height: 47px; line-height: 47px; font-size: 14px; color: #666; background: #FFF; border: 0; display: block;"
               placeholder="输入用户名"  value=""/>
    </div>
    <div style="width: 370px; height: 47px; overflow: hidden; margin: 0 auto; margin-bottom: 22px;">
        <img src="<%=contextPath%>/common/images/mm.jpg" style="float: left;">
        <input id="password" name="" type="password"
               style="float: left; width: 310px; padding-left: 10px; height: 47px; line-height: 47px; font-size: 14px; color: #666; background: #FFF; border: 0; display: block;"
               placeholder="输入密码" value="" />
    </div>
    <div style = "width: 370px; height: 47px; overflow: hidden; margin: 0 auto;">
        <select id="userStatus" name="userStatus" style="float: right;margin-right: 10px">
            <option value="1">企业用户</option>
            <option value="2">普通用户</option>
        </select>
    </div>
    <div style="width: 264px; height: 30; display: block; margin: 0 auto; margin-top: auto; margin-left: 130px;border: 0; cursor: pointer;">
        <img src="<%=contextPath%>/common/images/dl.png"
             style="float: left;width: 224px; height: 30; display: block; margin: 0 auto; margin-top: 5px; border: 0; cursor: pointer;"
             onclick="doLogin();" >
        <a href="<%=contextPath%>/admin">
            <img src="<%=contextPath%>/common/images/admin.png"
                 style="width: 30px; height: 30px;float: left;margin-top: 12px;margin-left: 5px">
        </a>
    </div>
</div>

</body>
</html>