/**
 * 获取表单信息
 * @param id
 * @returns {string}
 */
function getFormData1(id) {
    var d = {};
    var t = $(id).serializeArray();
    $.each(t, function () {
        d[this.name] = this.value;
    });

    return d;
}

function getDict(dictType){
    var result;
    var htmls = '<option value=""></option>'; //全局变量
    $.ajax({
        url: '../areaDict/queryDict',
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
        url: '../areaDict/queryDict',
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





