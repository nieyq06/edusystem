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
<div class="select">
    <form class=" needs-validation" method="post">
        <div class="row g-3" style="margin-right: 0px">
            <div class=" col">
                <input type="text" class="form-control" placeholder="搜索内容">
            </div>
            <div class="col-2">
                <select class="form-select" aria-label="Default select example">
                    <option selected>选择院系</option>
                    <% List<Faculty> faculty = (List<Faculty>) session.getAttribute("faculty");
                        for (Faculty f : faculty) {
                    %>
                    <option value="<%=f.getFacultyId()%>"><%=f.getFacultyName()%>
                    </option>
                    <% }%>
                </select>
            </div>
            <div class="col-6">
                <button type="button" class="btn btn-success" onclick="selectbtn"> 搜索</button>
            </div>

        </div>
    </form>

</div>
<div class="tablecentent">
    <table class="table table-hover" id="table">
        <thead>
        <tr style="text-align: center" class="text-muted card-title">
            <th data-field="#" style="width: 50px" data-field="id">#</th>
            <th data-sortable="true" data-field="UserNo">编码</th>
            <th data-sortable="true" data-field="UserName">姓名</th>
            <th data-sortable="false" data-field="Sex">性别</th>
            <th data-sortable="false" data-field="Tel">电话</th>
            <th data-sortable="true" data-field="FacultyName">院系</th>
            <th data-sortable="true" data-field="CourseName">主讲课程</th>
            <th>操作</th>
            <th style="display: none">id</th>
        </tr>
        </thead>
        <tbody class="text-muted" style="text-align: center">

        <div class="text-center" id="loading" style="display: none">
            <div class="spinner-grow text-primary" role="status"
                 style="position: absolute; z-index: 1001;margin-top: 5rem;">
                <span class="visually-hidden">Loading...</span>
            </div>
        </div>


        </tbody>
    </table>
</div>


<!-- Modal -->
<div class="modal fade" id="infoModal" tabindex="-1" aria-labelledby="infoModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="infoModalLabel">教师信息修改</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form class="needs-validation" method="post" novalidate>
                <div class="modal-body">
                    <div class="mb-3 row">
                        <label for="infoUserNo" class="col-sm-2 col-form-label">教师编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="infoUserNo" id="infoUserNo" required>
                            <div class="invalid-feedback">
                                教师编号不能为空
                            </div>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="infoUsername" class="col-sm-2 col-form-label">教师姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="infoUsername" id="infoUsername">
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
                            <input type="text" class="form-control" name="infoTel" id="infoTel">
                        </div>
                    </div>

                    <div class="mb-3 row">
                        <label for="infoTel" class="col-sm-2 col-form-label">二级学院</label>
                        <div class="col-sm-10">
                            <select class="form-select" aria-label="选择二级学院" id="infoFaculty" name="infoFaculty"
                                    onchange="facultyChange(this)">
                                <option selected>选择二级学院</option>
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
                            <select class="form-select" aria-label="选择专业" id="infoCourse" name="infoCourse">
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
                    <button type="buttom" class="btn btn-success" onclick="savebtn()">保存</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
<script>
    // window.onload = function (){
    //     var getUserId = "";
    //     console.log("id:"+getUserId);
    //     getAll();
    // };
    onload(getAll())
    var setInfoUserId=-1

    function getAll() {
        showLoading();
        console.log("到~")
        $.ajax({
            type: "get",
            dataType: "json",
            url: "/edusystem/admin/safe/getTeacherByAllServlet",
            data: null,
            success: function (flag) {
                console.log(flag)

                let table = document.getElementById("table");
                if (flag.length > 0) {
                    for (let i = 0; i < flag.length; i++) {
                        let row = table.insertRow(table.rows.length);
                        let c0 = row.insertCell(0)
                        c0.innerHTML = i + 1;
                        let c1 = row.insertCell(1);
                        c1.innerHTML = flag[i].UserNo;
                        let c2 = row.insertCell(2);
                        c2.innerHTML = flag[i].UserName;
                        let c3 = row.insertCell(3);
                        c3.innerHTML = flag[i].Sex;
                        let c4 = row.insertCell(4);
                        c4.innerHTML = flag[i].Tel;
                        let c5 = row.insertCell(5);
                        c5.innerHTML = flag[i].FacultyName;
                        let c6 = row.insertCell(6);
                        c6.innerHTML = flag[i].CourseName;
                        let c7 = row.insertCell(7);
                        c7.innerHTML =
                            // "<span class='badge bg-primary btn btn-success' onclick=btnInfo(this) data-bs-toggle="modal" data-bs-target="#infoModal">修改</span>"+
                            "<span class='badge btn btn-success operation' onclick=btnEdit(this)>修改</span>" +
                            "<span class='badge btn btn-danger operation' onclick=btnDelete(this)>删除</span>"
                        let c8 = row.insertCell(8);
                        c8.innerHTML = flag[i].UserId;
                        c8.style.display = "none"
                    }
                } else {
                    $("#table>tbody").html("");
                    let zwsj = " <tr><th class='text-muted' colspan='8'>暂无数据</th></tr> "
                    $(zwsj).appendTo("#table");
                }
                completeLoading();
            }
        });

    }

    function btnEdit(val) {
        let value = $(val).parent().parent().find("td");
        let id = value.eq(8).text();
        console.log(id)
        $("#infoUserNo").val();
        $("#infoUsername").val();
        $("input[name='infoSex'][value=女]").attr("checked", false)
        $("input[name='infoSex'][value=男]").attr("checked", true)
        $("#infoTel").val();
        $("#infoFaculty").val();

        $('#infoModal').modal('show');
        $.ajax({
            type: "get",
            dataType: "json",
            url: "${pageContext.request.contextPath}/admin/safe/getTeacherByIdServlet",
            data: {"userid": id},
            success: function (flag) {
                if (flag != null) {
                    console.log(flag)
                    setInfoUserId = flag.UserId;
                    $("#infoUserNo").val(flag.UserNo)
                    $("#infoUsername").val(flag.UserName)
                    $("#input").val(flag.Sex)
                    if (flag.Sex == "男") {
                        $("input[name='infoSex'][value=女]").attr("checked", false)
                        $("input[name='infoSex'][value=" + flag.Sex + "]").attr("checked", true)
                    } else {
                        $("input[name='infoSex'][value=男]").attr("checked", false)
                        $("input[name='infoSex'][value=" + flag.Sex + "]").attr("checked", true)
                    }
                    $("#infoTel").val(flag.Tel)
                    $("#infoFaculty").val(flag.FacultyId, flag.FacultyName);
                    filterCorse(flag.FacultyId);
                    $("#infoCourse").val(flag.CourseId, flag.CourseName);

                }
            }
        });
        console.log(value.eq(1).text())
    }



    //设置课程过滤
    function filterCorse(val) {
        var temps_course = [];//每次更变二级学院后清空课程
        let temps = ${sessionScope.courses}
            temps_course = temps.filter(function (e) {
                return e.FacultyId === val;
            });//json数据过滤
        let obj = document.getElementById('infoCourse');
        //重置下拉选项
        obj.options.length = 1;
        //添加过滤后的课程
        let i=1
        for (let key in temps_course) {
            let item = "<option value='" + temps_course[key].CourseId + "'" + ">" + temps_course[key].CourseName + "</option>"
            $(item).appendTo("#infoCourse");
        }
    }
    function facultyChange(val) {
        let faculty = $('#infoFaculty').val()
        console.log("二级学院："+faculty);
        filterCorse(faculty);
    }
    <%--    function btnDelete(val){--%>
    <%--        console.log(<%request.getAttribute("faculty");%>)--%>
    <%--        let value = $(val).parent().parent().find("td");--%>
    <%--        let id=value.eq(1).text();--%>
    <%--        console.log(value.eq(1).text())--%>
    <%--    }--%>
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
    tr {
        text-align: center
    }

    .select, .tablecentent {
        padding-right: 5px;
        padding-left: 5px;
        display: inline-block;
        width: calc(100% - 150px);
    }

    .row {
        margin-top: 0;
    }

    td > span {
        --bs-gutter-x: 1rem;
    }

    .operation {
        margin: 0 5px 0 5px;
    }
</style>
