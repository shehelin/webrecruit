<%@ page import="com.hl.recruit.entity.UserEntity" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="import.jsp" %>
<%
	UserEntity user = (UserEntity) request.getSession().getAttribute("user");
	String userName = "";
	String userId = "";
	String userStatus = "";
	if (user != null){
		userName = user.getUserName();
		userId = user.getUserId();
		userStatus = user.getUserStatus();
	}

%>

<script type="text/javascript">
	var userName = "<%=userName%>";
	var userStatus = "<%=userStatus%>";
	$(function () {
		if( userName == ""){
            $("li.login-login").css("display","");
            $("li.login-stand").css("display","none");
            $("#fcy").css("display","none");
		}else{
            $("li.login-login").css("display","none");
            $("li.login-stand").css("display","");
            $("#fcy").css("display","");
		}
		if(userStatus == "1") {
            $("#USER").css("display", "none");
        }
		else if(userStatus == "2"){
			$("#COMPANY").css("display","none");
		}

    });

</script>
 <div class="navbar navbar-fixed-top navbar-default" style="" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<%=contextPath%>">Web Recruit</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="<%=contextPath%>"><span class="glyphicon glyphicon-home"></span> 首页</a></li>
				<li class="dropdown" id="USER">
                     <a class="dropdown-toggle glyphicon glyphicon-lock" data-toggle="dropdown" href="#">求职通道<b class="caret"></b></a>
                      <ul class="dropdown-menu">
                         <li><a href="<%=contextPath%>/resume/">简历信息</a></li>
						  <li class="divider"></li>
						 <li><a href="<%=contextPath%>/employeeJob/employeeUser">我的求职</a></li>
                      </ul>
                 </li>
                 <li class="dropdown" id="COMPANY">
                     <a class="dropdown-toggle glyphicon glyphicon-briefcase" data-toggle="dropdown" href="#"> 企业通道<b class="caret"></b></a>
                      <ul class="dropdown-menu">
						  <li><a href="<%=contextPath%>/company/">企业信息</a></li>
                         <li class="divider"></li>
						 <li><a href="<%=contextPath%>/recruit/my">我的招聘</a></li>
						 <li><a href="<%=contextPath%>/employeeJob/employeeCompany">我的应聘</a></li>
                      </ul>
                 </li>
			</ul>
			 <ul class="nav navbar-nav navbar-right">
      			<li class="login-login"><a href="<%=contextPath%>/login"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
      			<li class="login-register"><a href="<%=contextPath%>/register"><span class="glyphicon glyphicon-log-in"></span> 注册</a></li>
				 <li class="dropdown" id="userName">
					 <a class="dropdown-toggle glyphicon glyphicon-user" id="fcy"data-toggle="dropdown" href="#"><%=userName%><b class="caret"></b></a>
					 <ul class="dropdown-menu">
						 <li><a href="<%=contextPath%>/user/updatePwd">修改密码</a></li>
						 <li><a href="<%=contextPath%>/user/updateUser">用户信息</a></li>
					 </ul>
			 	</li>
      			<li class="login-stand"><a href="<%=contextPath%>/logout"><span class="glyphicon glyphicon-log-in"></span> 注销</a></li>
   	 		</ul>
		</div>
		
	</div><!-- /.container -->
</div>

