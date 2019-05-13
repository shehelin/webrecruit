<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册</title>
  </head>
  
  <body>
  <%@include file="../base/base.jsp"%>

  <div class="container" style="margin-top: 100px">
    <div class="row clearfix">
      <div class="col-md-12 column">
        <form id="form1" role="form">
          <div class="form-group">
            <label for="userId">用户登录名</label>
            <input style="width: 40%;" type="text" class="form-control" id="userId" name="userId"/>
            <span name="ct" id="ctId" class="label label-warning" style="display: none">ok</span>
          </div>
          <div class="form-group">
            <label for="userName">用户昵称</label>
            <input style="width: 40%" type="text" class="form-control" id="userName" name="userName"/>
            <span name="ct" id="ctName" class="label label-warning" style="display: none"></span>
          </div>
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
          <div class="form-group">
            <label for="userStatus">用户性质</label>
            <select style="width: 10%" id="userStatus" class="form-control" name="userStatus">
              <option value="1">企业用户</option>
              <option value="2">普通用户</option>
            </select>
          </div>
          <div class="form-group" style="width: 70%;float:right">
            <button id="btnOn" type="button" class="btn btn-default" onclick="doRegister();" >注册</button>
            <button type="reset" class="btn btn-default">重置</button>
          </div>
        </form>
      </div>
    </div>
  </div>
  </body>
</html>

<script type="text/javascript">
    //todo 2019-03-19
    $(function () {
        /* 校验 */
        $("#userId").blur(function () {
            var userId = $('#userId').val();
            var ct = $("#ctId");
            if(userId == "" || userId == null){
                warningInfo(ct,"不能为空值");
            }else{
                $.ajax({
                  url : "<%=contextPath%>/user/queryUserById",
                  type : "post",
                  dataType : "json",
                  data : {
                      'userId':userId
                  },
                  success : function(data) {
                      warningInfo(ct,"用户已存在");
                      return;
                  },
                  error : function() {
                      successInfo(ct);
                  }
              });
            }
        });

        $('#userName').blur(function () {

            var userName = $('#userName').val();
            var ct = $("#ctName");
            if(userName == "" || userName == null){
                warningInfo(ct,"不能为空值");
            }else{
                successInfo(ct);
            }
        });

        $('#pwd').blur(function () {

            var pwd = $('#pwd').val();
            var ct = $("#ctPwd");
            if(pwd == null || pwd == ""){
                warningInfo(ct,"不能为空值");
            }else{
                successInfo(ct);
            }
        });

        $('#reviewerPwd').blur(function () {
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

    function doRegister() {
        var data = getFormData('#form1');
        $.ajax({
            url : "<%=contextPath%>/user/doRegister",
            type : "post",
            dataType : "json",
            data : data,
            success : function(data) {
                if (data) {
                    alert("注册成功");
                    window.parent.location.href = "<%=contextPath%>";
                } else {
                    alert("注册失败");
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


</script>
<%-- 文件上传示例 --%>
<%--<div class="form-group">--%>
<%--<label for="exampleInputFile">File input</label><input type="file" id="exampleInputFile" />--%>
<%--<p class="help-block">--%>
<%--Example block-level help text here.--%>
<%--</p>--%>
<%--</div>--%>
<%--<div class="checkbox">--%>
<%--<label><input type="checkbox" />Check me out</label>--%>
<%--</div> --%>