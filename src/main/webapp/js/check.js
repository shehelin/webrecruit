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
