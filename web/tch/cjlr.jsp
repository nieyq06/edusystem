<%@ page import="entity.Faculty" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: nyq
  Date: 2022/5/30
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩录入</title>
</head>
<body>
<div class="select-form">
    <div class="row g-3" style="margin-right: 0px">
        <div class="col">
            <input type="text" class="form-control" name="selectStuNo" id="selectStuNo" placeholder="学号">
        </div>
        <div class="col">
            <input type="text" class="form-control" name="selectStuName" id="selectStuName" placeholder="姓名">
        </div>

        <div class="col-6">
            <button type="button" class="btn btn-success" id="btnSelect"> 搜索</button>
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

<!-- 修改 -->
<div class="modal fade" id="infoModal" tabindex="-1" aria-labelledby="infoModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="infoModalLabel"></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form class="needs-validation" novalidate>
                <div class="modal-body">
                    <div class="mb-3 row">
                        <label for="inputStuNo" class="col-sm-2 col-form-label">学号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="inputStuNo" id="inputStuNo"
                                   ria-label="学号" required readonly>
                            <div class="invalid-feedback">
                                学号不能为空
                            </div>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="inputStuName" class="col-sm-2 col-form-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="inputStuName" id="inputStuName"
                                   ria-label="学号" required readonly>
                            <div class="invalid-feedback">
                                姓名不能为空
                            </div>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="inputCourseName" class="col-sm-2 col-form-label">课程名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="inputCourseName" id="inputCourseName"
                                   ria-label="课程名称" required readonly>
                            <input type="text" hidden id="inputCourseId"/>
                            <div class="invalid-feedback">
                                课程名称不能为空
                            </div>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="inputScores" class="col-sm-2 col-form-label">成绩</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="inputScores" id="inputScores"
                                   ria-label="成绩" required>
                            <div class="invalid-feedback">
                                成绩不能为空
                            </div>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-success" onclick="btnSave()">保存</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
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
    var setCourseId = ""
    var setDeleteUserId = ""
    var isSave = "";//保存按钮状态

    function clearModelInfo() {
        setCourseId = "";
        $("#infoFacultyId").val("");
        $("#infoFacultyName").val("");

    }

    // 获取所有学生信息
    function getAll() {
        var user = ${sessionScope.userInfo}
            showLoading();
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
            url: "/edusystem/tch/getSelectStuServlet",//这个接口需要处理bootstrap table传递的固定参数

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
                    stuNo: $('#selectStuNo').val(),                        // 模糊搜索
                    stuName: $('#selectStuName').val(),
                    teacherNo: user.UserNo
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
                field: 'UserNo',
                title: '学号'
            }, {
                align: 'center',
                valign: 'middle',
                field: 'UserName',
                title: '姓名'
            }, {
                align: 'center',
                valign: 'middle',
                field: 'FacultyName',
                title: '所属二级学院'
            }, {
                align: 'center',
                valign: 'middle',
                field: 'SubjectName',
                title: '专业名称'
            }, {
                align: 'center',
                valign: 'middle',
                field: 'CourseName',
                title: '课程名称'
            },{
                align: 'center',
                valign: 'middle',
                field: 'CourseId',
                visible: false,
                title: '课程id'
            }, {
                align: 'center',
                valign: 'middle',
                field: 'Credit',
                title: '学分'
            }, {
                align: 'center',
                valign: 'middle',
                field: 'Scores',
                title: '成绩',
            }, {
                field: 'operate',
                title: '操作',
                align: 'center',
                valign: 'middle',
                width: 200,
                events: {
                    'click #edit': function (e, value, row, index) {
                        btnEdit(row)
                    },
                    'click #delete': function (e, value, row, index) {
                        $("#delFaculty").html(row.CourseId)
                        $("#delFacultyName").html(row.CourseName)
                        btnDelete(row.CourseId);
                    }
                },

                formatter: function (value, row, index) {
                    var result = "";
                    result += '<button id="edit" class=" btn btn-info btn-sm operation" data-toggle="modal" data-target="#editModal">录入成绩</button>';
                    // result += '<button id="delete" class="btn btn-danger btn-sm operation"  style="margin-left:10px;">删除</button>';
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


    //编辑按钮
    function btnEdit(row) {
        console.log(row)
        $("#infoModalLabel").html("成绩录入")
        $('#infoModal').modal('show');

        $("#inputStuNo").val(row.UserNo)
        $("#inputStuName").val(row.UserName)
        $("#inputCourseName").val(row.CourseName)
        $("#inputCourseId").val(row.CourseId)
        $("#inputScores").val(row.Scores)
    }

    //保存按钮
    function btnSave() {
        let stuNo = document.getElementById("inputStuNo").value
        let score = document.getElementById("inputScores").value
        let courseId = document.getElementById("inputCourseId").value
        if (inputScores == "" || inputScores == null || inputStuNo == "" || inputStuNo == null) {
            return
        }
        $.ajax({
            method: "post",
            dataType: "json",
            url: "/edusystem/tch/gradeEntryServlet",
            data: {
                "stuNo": stuNo,
                "score": score,
                "courseId": courseId,
            },
            success: function (flag) {
                console.log(flag)
                if (flag.res == "1") {
                    $('#infoModal').modal('hide');
                    getAll();
                    model_Msg("#modelMsg", "#mesg", "修改成功", "alert modal-sm alert-success", 1000)
                } else {
                    model_Msg("#modelMsg", "#mesg", "修改失败", "alert modal-sm alert-danger", 1000)
                }
            }
        })

    }


    //删除按钮
    function btnDelete(val, no, name) {
        setDeleteUserId = val;
        $('#deleteModel').modal('show');
    }

    //确认删除
    function isDelete() {
        $.ajax({
            url: "/edusystem/admin/safe/deleteCourseServlet",
            method: "post",
            dataType: "json",
            data: {"infoCourseId": setDeleteUserId},
            success: function (flag) {
                if (flag.res == "1") {
                    getAll();
                    model_Msg("#modelMsg", "#mesg", "删除成功", "alert modal-sm alert-success", 1000)
                } else {
                    model_Msg("#modelMsg", "#mesg", "删除失败", "alert modal-sm alert-danger", 1000)
                }
            }
        })
    }

    //移除loading效果
    function completeLoading() {
        document.getElementById("loading").style.display = "none";
    }

    //展示loading效果
    function showLoading() {
        document.getElementById("loading").style.display = "block";
    }

    // 如果存在无效字段，则用于禁用表单提交的示例启动器 JavaScript
    (function () {
        'use strict'
// 获取我们想要应用自定义 Bootstrap 验证样式的所有表单
        var form = document.querySelectorAll('.needs-validation')
// 循环它们并防止提交
        Array.prototype.slice.call(form)
            .forEach(function (form) {
                form.addEventListener('click', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }
                    form.classList.add('was-validated')
                }, false)
            })
    })()

</script>
<style>
    .no-records-found {
        text-align: center;
    }
</style>
