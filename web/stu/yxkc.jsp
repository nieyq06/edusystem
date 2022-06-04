<%--
  Created by IntelliJ IDEA.
  User: nyq
  Date: 2022/6/4
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>已选课程</title>
</head>
<body>

<div class="select-form">
    <div class="row g-3" style="margin-right: 0px">
        <div class="col">
            <input type="text" class="form-control" name="selectC" id="selectC" placeholder="课程名称">
        </div>

        <div class="col-6">
            <button type="button" class="btn btn-success" id="btnSelect"> 搜索</button>
            </button>
        </div>
    </div>

</div>
<table class="table table-hover text-muted" id="table" data-toolbar="#toolbar">
    <div class="text-center" id="loading" style="display: none">
        <div class="spinner-grow text-primary" role="status"
             style="position: absolute; z-index: 1001;margin-top: 5rem;">
            <span class="visually-hidden">Loading...</span>
        </div>
    </div>
</table>

<%--信息提示框--%>
<div class="modal fade" tabindex="-1" role="dialog" id="modelMsg" backdrop="static">
    <div class="modal-dialog modal-sm " role="document">
        <div id="mesg" style="text-align: center;">
        </div>
    </div>
</div>

</body>
</html>
<script>
    onload = getAll()

    // 获取所有课程信息
    function getAll() {
        var user = ${sessionScope.userInfo}
            showLoading();
        var stuNo = user.UserNo;
        $('#table').bootstrapTable('destroy');
        $('#table').bootstrapTable({
            method: 'get',
            toolbar: '#toolbar',  //工具按钮用哪个容器
            cache: false,   //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,//分页
            sortable: false,   //是否启用排序
// sortOrder: "asc",   //排序方式
            pageNumber: 1,   //初始化加载第一页，默认第一页
            pageSize: 16,   //每页的记录行数（*）
            url: "/edusystem/stu/getYxkcServlet",//这个接口需要处理bootstrap table传递的固定参数

            queryParamsType: '', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
// 设置为 '' 在这种情况下传给服务器的参数为：pageSize,pageNumber

            sidePagination: "server",  //分页方式：client客户端分页，server服务端分页（*）

//自定义分页字符串显示为中文
            formatShowingRows: function (pageFrom, pageTo, totalRows) {
                return "显示 " + pageFrom + "-" + pageTo + " 条记录，共 " + totalRows + " 条记录";
            },

            formatNoMatches: function () {
                return "未查询到相关记录";
            },
            queryParams: function (params) {
                return {
                    pageSize: params.pageSize,                     // 每页记录条数
                    pageNumber: params.pageNumber,                 // 当前页索引
                    selectC: $('#selectC').val(),                        // 模糊搜索
                    stuNo:stuNo
                };
            },

            columns: [{
//序号自增实现方法
                align: 'center',
                valign: 'middle',
                title: '序号',
                field: 'xh',
                formatter: function (value, row, index) {
                    return index + 1;
                }
            }, {
                align: 'center',
                valign: 'middle',
                field: 'CourseId',
                title: '课程ID'
            }, {
                align: 'center',
                valign: 'middle',
                field: 'CourseName',
                title: '课程名称'
            }, {
                align: 'center',
                valign: 'middle',
                field: 'Credit',
                title: '学分'
            }, {
                align: 'center',
                valign: 'middle',
                field: 'FacultyName',
                title: '所属二级学院'
            }, {
                align: 'center',
                valign: 'middle',
                field: 'UserName',
                title: '教师姓名'
            }, {
                field: 'operate',
                title: '操作',
                align: 'center',
                valign: 'middle',
                width: 200,
                events: {
                    'click #edit': function (e, value, row, index) {
                        btnTxkc(row.CourseId)
                    },
                },

                formatter: function (value, row, index) {
                    var result = "";
                    result += '<button id="edit" class=" btn btn-info btn-sm operation" data-toggle="modal" data-target="#editModal">退选</button>';
                    return result;
                }
            }],
        });
        completeLoading();
        // 查询按钮
        $('#btnSelect').click(function () {
            $('#table').bootstrapTable('refresh', {pageNumber: 1});
        });
    }



    function btnTxkc(val) {
        let user = ${sessionScope.userInfo};
        let stuNo = user.UserNo;
        $.ajax({
            type: "post",
            dataType: "json",
            url: "${pageContext.request.contextPath}/stu/withdrawFromTheCourseServlet",
            data: {"courseId": val,"stuNo":stuNo},
            success: function (flag) {
                console.log(flag)
                if (flag.res==1) {
                    model_Msg("#modelMsg", "#mesg", "推选成功", "alert modal-sm alert-success", 1000)

                    getAll();
                } else {
                    model_Msg("#modelMsg", "#mesg", "出差啦，请重试", "alert modal-sm alert-danger", 1000)

                }
            }
        });
    }


    //移除loading效果
    function completeLoading() {
        document.getElementById("loading").style.display = "none";
    }

    //展示loading效果
    function showLoading() {
        document.getElementById("loading").style.display = "block";
    }

</script>
<style>
    .no-records-found {
        text-align: center;
    }
</style>