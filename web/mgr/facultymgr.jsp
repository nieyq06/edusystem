<%@ page import="entity.Faculty" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: nyq
  Date: 2022/5/18
  Time: 0:21
  Introduction: 院系管理
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>院系信息管理</title>
</head>
<body><div class="select">
    <div class="select-form">
        <div class="row g-3" style="margin-right: 0px">
            <div class="col">
                <input type="text" class="form-control" name="facultyId" id="facultyId" placeholder="模糊搜索">
            </div>
            <div class="col">
                <input type="text" class="form-control" name="facultyName" id="facultyName" placeholder="模糊搜索">
            </div>

            <div class="col-6">
                <button type="button" class="btn btn-success" id="btnSelect"> 搜索</button>
                <button type="button" class="btn btn-success btn-float-r" id="btnOutput" onclick="fileOutput"> 导出
                </button>
                <button type="button" class="btn btn-info btn-float-r" id="btnImport" onclick="fileImport()"> 导入
                </button>
                <button type="button" class="btn btn-warning btn-float-r" id="btnAdd" onclick="btnAdd()"> 添加
                </button>
            </div>

        </div>
    </div>

</div>
<div class="tablecentent">
    <table class="table table-hover text-muted" id="table" data-toolbar="#toolbar">
        <div class="text-center" id="loading" style="display: none">
            <div class="spinner-grow text-primary" role="status"
                 style="position: absolute; z-index: 1001;margin-top: 5rem;">
                <span class="visually-hidden">Loading...</span>
            </div>
        </div>
    </table>
</div>


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
                        <label for="infoFacultyId" class="col-sm-2 col-form-label">二级学院ID</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="infoFacultyId" id="infoFacultyId"
                                   ria-label="课程ID" required>
                            <div class="invalid-feedback">
                                二级学院ID不能为空
                            </div>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="infoFacultyName" class="col-sm-2 col-form-label">二级学院名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="infoFacultyName" id="infoFacultyName"
                                   ria-label="课程名称" required>
                            <div class="invalid-feedback">
                                二级学院名称不能为空
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

<div class="modal fade" id="deleteModel" aria-hidden="true" aria-labelledby="delete" tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalToggleLabel">提示：二级学院课程</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p><em id="delFaculty"></em> | <em id="delFacultyName"></em></p>
            </div>
            <div class="modal-footer">
                <button class="btn btn-danger" data-bs-dismiss="modal" onclick="isDelete()">确认删除</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script>
    onload = getAll()
    var setInfoFacultyId = ""
    var setDeleteUserId = ""
    var isSave = "";//保存按钮状态

    function btnAdd() {
        isSave = "insert"
        $("#infoFacultyId").attr("readonly",false)
        $("#infoModalLabel").html("添加二级学院信息")
        clearModelInfo()
        $('#infoModal').modal('show');
    }

    function clearModelInfo() {
        setInfoFacultyId="";
        $("#infoFacultyId").val("");
        $("#infoFacultyName").val("");

    }

    // 获取所有课程信息
    function getAll() {
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
            pageSize: 15,   //每页的记录行数（*）
            url: "/edusystem/admin/safe/getFacultyByAllServlet",//这个接口需要处理bootstrap table传递的固定参数

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
                    facultyId: $('#facultyId').val(),                        // 模糊搜索
                    facultyName: $('#facultyName').val()                     // 院系
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
                field: 'FacultyId',
                title: '院系ID'
            }, {
                align: 'center',
                valign: 'middle',
                field: 'FacultyName',
                title: '院系名称'
            }, {
                field: 'operate',
                title: '操作',
                align: 'center',
                valign: 'middle',
                width: 200,
                events: {
                    'click #edit': function (e, value, row, index) {
                        btnEdit(row.FacultyId)
                    },
                    'click #delete': function (e, value, row, index) {
                        $("#delFaculty").html(row.FacultyId)
                        $("#delFacultyName").html(row.FacultyName)
                        btnDelete(row.FacultyId);
                    }
                },

                formatter: function (value, row, index) {
                    var result = "";
                    result += '<button id="edit" class=" btn btn-info btn-sm operation" data-toggle="modal" data-target="#editModal">编辑</button>';
                    result += '<button id="delete" class="btn btn-danger btn-sm operation"  style="margin-left:10px;">删除</button>';
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
    function btnEdit(val) {
        $("#infoModalLabel").html("修改院系信息")
        $("#infoFacultyId").attr("readonly",true)
        isSave = "update"
        $('#infoModal').modal('show');
        $.ajax({
            type: "get",
            dataType: "json",
            url: "${pageContext.request.contextPath}/admin/safe/getFacultyByIdServlet",
            data: {"facultyId": val},
            success: function (flag) {
                if (flag != null) {
                    setInfoFacultyId = flag.FacultyId;
                    $("#infoFacultyId").val(flag.FacultyId)
                    $("#infoFacultyName").val(flag.FacultyName)
                }else {
                    model_Msg("#modelMsg", "#mesg", "出差啦，请重试", "alert modal-sm alert-danger", 1000)

                }
            }
        });
    }

    //保存按钮
    function btnSave() {
        console.log(setInfoFacultyId)
        let infoFacultyName = document.getElementById("infoFacultyName").value
        if (isSave == "update") {
            $.ajax({
                method: "post",
                dataType: "json",
                url: "/edusystem/admin/safe/updateFacultyServlet",
                data: {
                    "infoFacultyId": setInfoFacultyId,
                    "infoFacultyName": infoFacultyName,
                },
                success: function (flag) {
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
        if (isSave == "insert") {
            let infoFacultyId = document.getElementById("infoFacultyId").value;
            $.ajax({
                method: "post",
                dataType: "json",
                url: "/edusystem/admin/safe/insertFacultyServlet",
                data: {
                    "FacultyId": infoFacultyId,
                    "FacultyName": infoFacultyName,
                },
                success: function (flag) {
                    if (flag.res == "1") {
                        $('#infoModal').modal('hide');
                        getAll();
                        model_Msg("#modelMsg", "#mesg", "添加成功", "alert modal-sm alert-success", 1000)
                    } else {
                        model_Msg("#modelMsg", "#mesg", "添加失败", "alert modal-sm alert-danger", 1000)
                    }
                }
            })
        }
    }

    //删除按钮
    function btnDelete(val, no, name) {
        setDeleteUserId = val;
        $('#deleteModel').modal('show');
    }

    //确认删除
    function isDelete() {
        $.ajax({
            url: "/edusystem/admin/safe/deleteFacultyServlet",
            method: "post",
            dataType: "json",
            data: {"facultyId": setDeleteUserId},
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
