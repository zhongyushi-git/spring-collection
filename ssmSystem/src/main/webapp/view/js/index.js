var selectList = [];
var isCreate = true;
$(function () {
    initTable();

    $("#create").click(function () {
        isCreate = true;
    })
    $("#update").click(function () {
        if (selectList.length != 1) {
            alert("只能选择一条数据");
            return;
        }
        getOneById();
        isCreate = false;
        $('#myModal').modal('show')
        $("#id").css("readOnly","true");
    })
    $("#del").click(function () {
        if (selectList.length == 0) {
            alert("请选择数据");
            return;
        }
        delByArr();
    });
    $("#save").click(function () {
        var form = {};
        form.id = $("#id").val();
        form.name = $("#name").val();
        form.password = $("#password").val();
        form.phone = $("#phone").val();
        if (form.id == null || form.id == "") {
            alert("请输入用户名");
            return;
        } else if (form.password == null || form.password == "") {
            alert("请输入密码");
            return;
        }
        if (isCreate) {
            create(form)
        } else {
            update(form)
        }
    })
    //模态框 关闭前事件
    $('#myModal').on('hide.bs.modal', function () {
        $("#id").val("");
        $("#name").val("");
        $("#password").val("");
        $("#phone").val("");
    });
})

//初始化表格
function initTable() {
    $("#table").bootstrapTable({
        url: applicationName + "/user/getList",
        striped: true, //是否显示行间隔色
        pagination: true,//是否分页
        sidePagination: 'server',//server:服务器端分页|client：前端分页
        pageNumber: 1, //初始化加载第一页
        pageSize: 5,//单页记录数
        pageList: [5, 10, 20, 30],//可选择单页记录数
        showRefresh: true,//刷新按钮
        queryParams: queryParams,
        onCheck: onCheck,
        onUncheck: onUncheck,
        columns: [{
            checkbox: true,
        }, {
            title: '用户名',
            field: 'id',
            sortable: true
        }, {
            title: '姓名',
            field: 'name',
            sortable: true
        }, {
            title: '电话',
            field: 'phone',
            sortable: true
        }]
    })
}

//设置查询的参数
function queryParams(params) {
    //这里的键的名字和控制器的变量名必须一致，这边改动，控制器也需要改成一样的
    var temp = {
        limit: params.limit,                         //页面大小
        page: params.offset/params.limit + 1,   //页码
    };
    return temp;
}

//选中触发
function onCheck(row) {
    selectList.push(row.id)
}

//取消选中触发
function onUncheck(row) {
    for (var i = 0; i < selectList.length; i++) {
        if (selectList[i] == row.id) {
            selectList.splice(i, 1)
        }
    }
}

//根据数组的值删除
function delByArr() {
    var msg = "您真的确定要删除吗？请确认！";
    if (confirm(msg) == true) {
        $.ajax({
            url: applicationName + "/user/delByArr/" + selectList,
            type: 'delete',
            success: function (data) {
                selectList = [];
                if (data.code == 200) {
                    alert("删除成功");
                    $("#table").bootstrapTable("refresh");
                } else {
                    alert("删除失败")
                }
            }, error: function (err) {
                console.log("发生错误" + err)
            }
        })
    } else {
        return false;
    }
}

//添加
function create(form) {
    console.log(form)
    $.ajax({
        url: applicationName + "/user/create",
        type: 'post',
        data: JSON.stringify(form),
        contentType: 'application/json',
        success: function (data) {
            selectList = [];
            if (data.code == 200) {
                alert("添加成功");
                $('#myModal').modal('hide')
                $("#table").bootstrapTable("refresh");
            } else {
                alert("添加失败")
            }
        }, error: function (err) {
            console.log("发生错误" + err)
        }
    })
}

//修改
function update(form) {
    console.log(form)
    $.ajax({
        url: applicationName + "/user/update",
        type: 'post',
        data: JSON.stringify(form),
        contentType: 'application/json',
        success: function (data) {
            selectList = [];
            if (data.code == 200) {
                alert("修改成功");
                $('#myModal').modal('hide')
                $("#table").bootstrapTable("refresh");
            } else {
                alert("修改失败")
            }
        }, error: function (err) {
            console.log("发生错误" + err)
        }
    })
}

//查询一条
function getOneById() {
    $.get(applicationName + "/user/getOneById/" + selectList[0], function (data) {
        if (data.code == 200) {
            for (var p in data.rows) { //遍历json对象的每个key/value对,p为key
                $("#"+p).val(data.rows[p]);
            }
        } else {
            alert("查询失败")
        }
    })
}
