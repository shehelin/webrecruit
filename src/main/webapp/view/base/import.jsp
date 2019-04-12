<%--
  Created by IntelliJ IDEA.
  User: helin.she
  Date: 2019/2/27
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<% String contextPath = request.getContextPath();%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 1. 创建视口 为了使bootstrap前端框架能够做出不同设备的视图效果（移动端、pc端）-->
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<!-- 2. 导入 jquery  js/jquery -->
<script type = "text/javascript" src="<%=contextPath%>/js/jquery-1.11.0.min.js" >
</script>
<!-- 3. 导入 bootstrap 的 .css  -->
<link rel="stylesheet" href="<%=contextPath%>/bootstrap-3.3.5-dist/css/bootstrap.css" />
<!-- 4. 导入 bootstrap 的 .js -->
<script type="text/javascript" src="<%=contextPath%>/bootstrap-3.3.5-dist/js/bootstrap.js" ></script>
<%-- layui 导入 --%>
<script type="text/javascript" src="<%=contextPath%>/layui-v2.4.5/layui/layui.js" ></script>



