<%@ page import="entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Faculty" %>
<%@ page import="cn.hutool.json.JSONObject" %>
<%@ page import="cn.hutool.json.JSON" %>
<%@ page import="entity.Course" %><%--
  Created by IntelliJ IDEA.
  User: nyq
  Date: 2022/5/18
  Time: 0:20
  Introduction: 教师管理
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师信息管理</title>
</head>
<body>
<div class="select-form">
    <div class="row g-3" style="margin-right: 0px">
        <div class="col">
            <input type="text" class="form-control" name="selectFuzzy" id="selectFuzzy" placeholder="模糊搜索">
        </div>
        <div class="col-3">
            <select class="form-select" name="selectFaculty" id="selectFaculty" aria-label="选择院系">
                <option selected value="">选择院系</option>
                <% List<Faculty> faculty = (List<Faculty>) session.getAttribute("faculty");
                    for (Faculty f : faculty) {
                %>
                <option value="<%=f.getFacultyId()%>"><%=f.getFacultyName()%>
                </option>
                <% }%>
            </select>
        </div>
        <div class="col-6">
            <button type="button" class="btn btn-success" id="btnSelect"> 搜索</button>
            <button type="button" class="btn btn-success btn-float-r" id="btnOutput" onclick="fileOutput"> 导出
            </button>
            <button type="button" class="btn btn-info btn-float-r" id="btnImport" onclick="fileImport()"> 导入
            </button>
            <button type="button" class="btn btn-warning btn-float-r" id="btnInsert" onclick="btnInsert()"> 添加
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
                        <label for="infoUserNo" class="col-sm-2 col-form-label">教师编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="infoUserNo" id="infoUserNo" ria-label="教师编号"
                                   required>
                            <div class="invalid-feedback">
                                教师编号不能为空
                            </div>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="infoUsername" class="col-sm-2 col-form-label">教师姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="infoUsername" id="infoUsername"
                                   ria-label="教师姓名" required>
                            <div class="invalid-feedback">
                                教师姓名不能为空
                            </div>
                        </div>
                    </div>

                    <div class="mb-3 row">
                        <label for="infoMan" class="col-sm-2 col-form-label">性别</label>
                        <div class="col-sm-10">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="infoSex" id="infoMan" value="男"
                                       checked>
                                <label class="form-check-label" for="infoMan">
                                    男
                                </label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="infoSex" id="infoWomen" value="女">
                                <label class="form-check-label" for="infoWomen">
                                    女
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="mb-3 row">
                        <label for="infoTel" class="col-sm-2 col-form-label">电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="infoTel" id="infoTel" ria-label="电话" required>
                            <div class="invalid-feedback">
                                电话不能为空
                            </div>
                        </div>
                    </div>

                    <div class="mb-3 row">
                        <label for="infoTel" class="col-sm-2 col-form-label">二级学院</label>
                        <div class="col-sm-10">
                            <select class="form-select" aria-label="选择二级学院" id="infoFaculty" name="infoFaculty"
                                    ria-label="二级学院"
                                    onchange="facultyChange(this)" required>
                                <option selected value="选择二级学院">选择二级学院</option>
                                <%
                                    for (Faculty f : faculty) {
                                %>
                                <option value="<%=f.getFacultyId()%>"><%=f.getFacultyName()%>
                                </option>
                                <% }%>
                            </select>
                            <div class="invalid-feedback">
                                二级学院不能为空
                            </div>
                        </div>
                    </div>

                    <div class="mb-3 row">
                        <label for="infoTel" class="col-sm-2 col-form-label">主教课程</label>
                        <div class="col-sm-10">
                            <select class="form-select" aria-label="选择专业" id="infoCourse" name="infoCourse"
                                    ria-label="主教课程" required>
                                <option selected>选择专业</option>
                            </select>
                            <div class="invalid-feedback">
                                主教课程不能为空
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-success" onclick="btnSave()">保存</button>
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
                <h5 class="modal-title" id="exampleModalToggleLabel">提示：删除教师</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <h3> 编号：<em id="delUserNo"></em>，姓名：<em id="delUserName"></em></h3>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" data-bs-dismiss="modal" onclick="isDelete()">确认删除</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
<script>
    onload = getAll()
    var setInfoUserId = -1
    var setDeleteUserId = -1
    var infoSave = "";//保存按钮状态

    function btnInsert() {
        infoSave = "insert"
        $("#infoModalLabel").html("添加教师信息")
        clearModelInfo()
        $('#infoModal').modal('show');

    }

    function clearModelInfo() {
        $("#infoUserNo").val("");
        $("#infoUsername").val("");


        $("input[name='infoSex'][value=男]").attr("checked", true);
        $("input[name='infoSex'][value=女]").attr("checked", false);

        $("#infoTel").val("");
        $("#infoFaculty").val("", "选择二级学院");
        //重置专业下拉选项
        let obj = document.getElementById('infoCourse');
        obj.options.length = 1;
        $("#infoCourse").val("", "选择专业");

    }

    // 获取所有教师信息
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
            pageSize: 16,   //每页的记录行数（*）
            url: "/edusystem/admin/safe/getTeacherByAllServlet",//这个接口需要处理bootstrap table传递的固定参数

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
                    selectFuzzy: $('#selectFuzzy').val(),                        // 模糊搜索
                    selectFaculty: $('#selectFaculty').val()                     // 院系
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
                visible: false,
                field: 'UserId',
                title: 'id'
            }, {
                align: 'center',
                valign: 'middle',
                field: 'UserNo',
                title: '编码'
            }, {
                align: 'center',
                valign: 'middle',
                field: 'UserName',
                title: '姓名'
            }, {
                align: 'center',
                valign: 'middle',
                field: 'Sex',
                title: '性别'
            }, {
                align: 'center',
                valign: 'middle',
                field: 'Tel',
                title: '电话'
            }, {
                align: 'center',
                valign: 'middle',
                field: 'FacultyName',
                title: '院系'
            }, {
                align: 'center',
                valign: 'middle',
                field: 'CourseName',
                title: '主讲课程'
            }, {
                field: 'operate',
                title: '操作',
                align: 'center',
                valign: 'middle',
                width: 200,
                events: {
                    'click #edit': function (e, value, row, index) {
                        btnEdit(row.UserId)
                    },
                    'click #delete': function (e, value, row, index) {
                        $("#delUserNo").html(row.UserNo)
                        $("#delUserName").html(row.UserName)
                        btnDelete(row.UserId);
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
        $("#infoModalLabel").html("修改教师信息")
        infoSave = "update"
        $('#infoModal').modal('show');
        $.ajax({
            type: "get",
            dataType: "json",
            url: "${pageContext.request.contextPath}/admin/safe/getTeacherByIdServlet",
            data: {"userid": val},
            success: function (flag) {
                if (flag != null) {
                    setInfoUserId = flag.UserId;
                    $("#infoUserNo").val(flag.UserNo)
                    $("#infoUsername").val(flag.UserName)

                    if (flag.Sex == "男") {
                        $("input[name='infoSex'][value=女]").attr("checked", false)
                        $("input[name='infoSex'][value=" + flag.Sex + "]").attr("checked", true)
                    } else {
                        $("input[name='infoSex'][value=男]").attr("checked", false)
                        $("input[name='infoSex'][value=" + flag.Sex + "]").attr("checked", true)
                    }

                    $("#infoTel").val(flag.Tel)
                    $("#infoFaculty").val(flag.FacultyId, flag.FacultyName);
                    filterCourse(flag.FacultyId);
                    $("#infoCourse").val(flag.CourseId, flag.CourseName);
                }
            }
        });
    }

    //保存按钮
    function btnSave() {
        let infoUserNo = document.getElementById("infoUserNo").value
        let infoUsername = document.getElementById("infoUsername").value
        let infoSex = $('input[name=infoSex]:checked').val();
        let infoTel = document.getElementById("infoTel").value
        let infoFaculty = document.getElementById("infoFaculty").value
        let infoCourse = document.getElementById("infoCourse").value
        if (infoSave == "update") {
            if (infoUserNo == null || infoUserNo == "" || infoUsername == null || infoUsername == "") {
                return
            }
            $.ajax({
                method: "post",
                dataType: "json",
                url: "/edusystem/admin/safe/updateTeacherServlet",
                data: {
                    "infoUserId": setInfoUserId,
                    "infoUserNo": infoUserNo,
                    "infoUsername": infoUsername,
                    "infoSex": infoSex,
                    "infoTel": infoTel,
                    "infoFaculty": infoFaculty,
                    "infoCourse": infoCourse
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
        if (infoSave == "insert") {
            $.ajax({
                method: "post",
                dataType: "json",
                url: "/edusystem/admin/safe/insertTeacherServlet",
                data: {
                    "UserId": infoUserNo,
                    "UserName": infoUsername,
                    "Sex": infoSex,
                    "Tel": infoTel,
                    "FacultyId": infoFaculty,
                    "CourseId": infoCourse
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
        // modelDisplay("#deleteModel","show")
        $('#deleteModel').modal('show');
    }

    //确认删除
    function isDelete() {
        $.ajax({
            url: "/edusystem/admin/safe/deleteTeacherServlet",
            method: "post",
            dataType: "json",
            data: {"userid": setDeleteUserId},
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

    //设置课程过滤
    function filterCourse(val) {
        var temps_course = [];//每次更变二级学院后清空课程
        let temps = ${sessionScope.courses}
            console.log(temps)
        temps_course = temps.filter(function (e) {
            return e.FacultyId === val;
        });//json数据过滤
        let obj = document.getElementById('infoCourse');
        //重置下拉选项
        obj.options.length = 1;
        console.log(temps_course)
        //添加过滤后的课程
        for (let key in temps_course) {
            let item = "<option value='" + temps_course[key].CourseId + "'" + ">" + temps_course[key].CourseName + "</option>"
            $(item).appendTo("#infoCourse");
        }
    }

    function facultyChange(val) {
        let faculty = $('#infoFaculty').val()
        filterCourse(faculty);
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
    /*tr {*/
    /*    text-align: center*/
    /*}*/

    /*.select, .tablecentent {*/
    /*    padding-right: 5px;*/
    /*    padding-left: 5px;*/
    /*    display: inline-block;*/
    /*    width: calc(100% - 150px);*/
    /*}*/

    /*.row {*/
    /*    margin-top: 0;*/
    /*}*/

    /*td > span {*/
    /*    --bs-gutter-x: 1rem;*/
    /*}*/

    /*.operation {*/
    /*    margin: 0 5px 0 5px;*/
    /*}*/
    .no-records-found {
        text-align: center;
    }
</style>
