<%@ page import="entity.User" %>
<%@ page import="java.util.List" %><%--
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
                <input type="text" class="form-control"  placeholder="搜索内容">
            </div>
            <div class="col-2">
                <select class="form-select" aria-label="Default select example">
                    <option selected>选择院系</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>
            </div>
            <div class="col-6">
                <button class="btn btn-success" onclick="selectbtn"> 搜索</button>
            </div>

        </div>
    </form>

</div>
    <div class="tablecentent">
    <table class="table table-hover" id="table">
        <thead>
        <tr style="text-align: center" class="text-muted card-title" >

            <th data-field="#" style="width: 50px" data-field="id">#</th>
            <th data-sortable="true" data-field="userid">编码</th>
            <th data-sortable="true" data-field="userName">姓名</th>
            <th data-sortable="false" data-field="sex">性别</th>
            <th data-sortable="false" data-field="Tel">电话</th>
            <th data-sortable="true" data-field="FacultyName">院系</th>
            <th data-sortable="true" data-field="MajorCourse">主讲课程</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody class="text-muted" style="text-align: center">
        <div id="loadingDiv" style="display: none; ">
            <div id="layout"
                 style="position: absolute;top: 40%; left: 40%;width: 15%; height: 15%;  z-index: 1001;text-align:center;">
                <img width="100px" src="/edusystem/img/giphy-unscreen.gif" />
            </div>
        </div>


        </tbody>
    </table>
</div>
</body>
</html>
<script>
    console.log(<%request.getAttribute("faculty");%>)
    $(function selectbtn() {
        showLoading();
        $.ajax({
            type: "get",
            dataType: "json",
            url: "${pageContext.request.contextPath}/admin/safe/getTeacherByAllServlet",
            data: null,
            success: function (flag) {
                let table=document.getElementById("table");
                for(let i=0; i<flag.length; i++){
                    let row=table.insertRow(table.rows.length);
                    let c0=row.insertCell(0)
                    c0.innerHTML=i+1;
                    let c1=row.insertCell(1);
                    c1.innerHTML=flag[i].userid;
                    let c2=row.insertCell(2);
                    c2.innerHTML=flag[i].username;
                    let c3=row.insertCell(3);
                    c3.innerHTML=flag[i].sex;
                    let c4=row.insertCell(4);
                    c4.innerHTML=flag[i].tel;
                    let c5=row.insertCell(5);
                    c5.innerHTML=flag[i].facultyname;
                    let c6=row.insertCell(6);
                    c6.innerHTML=flag[i].coursename;
                    let c7=row.insertCell(7);
                    c7.innerHTML=
                        // "<span class='badge bg-primary btn btn-success' onclick=btnInfo(this)>修改</span>"+
                        "<span class='badge btn btn-success operation' onclick=btnEdit(this)>修改</span>"+
                        "<span class='badge btn btn-danger operation' onclick=btnDelete(this)>删除</span>"
                }
                completeLoading();
            }
        });
    })

    function btnEdit(val){
        let value = $(val).parent().parent().find("td");
        let id=value.eq(1).text();
        console.log(value.eq(1).text())
    }
    function btnDelete(val){
        console.log(<%request.getAttribute("faculty");%>)
        let value = $(val).parent().parent().find("td");
        let id=value.eq(1).text();
        console.log(value.eq(1).text())
    }
    //移除loading效果
    function completeLoading() {
        document.getElementById("loadingDiv").style.display = "none";
    }
    //展示loading效果
    function showLoading() {
        document.getElementById("loadingDiv").style.display = "block";
    }
</script>
<style>
    tr{
        text-align: center
    }
    .select,.tablecentent{
        padding-right: 5px;
        padding-left: 5px;
        display:inline-block;
        width: calc(100% - 150px);
    }
    .row {
        margin-top: 0;
    }
    td>span{
        --bs-gutter-x: 1rem;
    }
    .operation{
        margin: 0 5px 0 5px;
    }
</style>
