<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: nyq
  Date: 2022/5/17
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员首页</title>
    <link href="../dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="../dist/persona-writing.css" rel="stylesheet">
    <link href="../dist/css/sidebars.css" rel="stylesheet">
</head>
<body>
<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
    <symbol id="kanban" viewBox="0 0 16 16" width="32" height="32" fill="currentColor" class="bi bi-kanban-fill">
        <title>kanban</title>
        <path
                d="M2.5 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h11a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2h-11zm5 2h1a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1h-1a1 1 0 0 1-1-1V3a1 1 0 0 1 1-1zm-5 1a1 1 0 0 1 1-1h1a1 1 0 0 1 1 1v7a1 1 0 0 1-1 1h-1a1 1 0 0 1-1-1V3zm9-1h1a1 1 0 0 1 1 1v10a1 1 0 0 1-1 1h-1a1 1 0 0 1-1-1V3a1 1 0 0 1 1-1z"/>
    </symbol>
    <symbol id="home" viewBox="0 0 16 16">
        <path fill-rule="evenodd"
              d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6zm5-.793V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
        <path fill-rule="evenodd"
              d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
    </symbol>
    <symbol id="people" viewBox="0 0 16 16">
        <path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
        <path fill-rule="evenodd"
              d="M5.216 14A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216z"/>
        <path d="M4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5z"/>
    </symbol>
    <symbol id="book" viewBox="0 0 16 16">
        <path d="M8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
    </symbol>
    <symbol id="building" viewBox="0 0 16 16">
        <path fill-rule="evenodd"
              d="M14.763.075A.5.5 0 0 1 15 .5v15a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5V14h-1v1.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V10a.5.5 0 0 1 .342-.474L6 7.64V4.5a.5.5 0 0 1 .276-.447l8-4a.5.5 0 0 1 .487.022zM6 8.694 1 10.36V15h5V8.694zM7 15h2v-1.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 .5.5V15h2V1.309l-7 3.5V15z"/>
        <path
                d="M2 11h1v1H2v-1zm2 0h1v1H4v-1zm-2 2h1v1H2v-1zm2 0h1v1H4v-1zm4-4h1v1H8V9zm2 0h1v1h-1V9zm-2 2h1v1H8v-1zm2 0h1v1h-1v-1zm2-2h1v1h-1V9zm0 2h1v1h-1v-1zM8 7h1v1H8V7zm2 0h1v1h-1V7zm2 0h1v1h-1V7zM8 5h1v1H8V5zm2 0h1v1h-1V5zm2 0h1v1h-1V5zm0-2h1v1h-1V3z"/>
    </symbol>
</svg>


<main>
    <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px;">
        <a class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
            <svg class="bi me-2" width="40" height="32">
                <use xlink:href="#kanban"/>
            </svg>
            <span class="fs-4">Nieyq</span>
        </a>
        <hr>
        <ul class="nav nav-pills flex-column mb-auto">
            <li class="nav-item">
                <a class="nav-link active" id="index_home" onclick="home()">
                    <svg class="bi me-2" width="16" height="16">
                        <use xlink:href="#home"/>
                    </svg>
                    首页
                </a>
            </li>
            <li>
                <a class="nav-link text-white" id="tchinfo" onclick="tchmgr()">
                    <svg class="bi me-2" width="16" height="16">
                        <use xlink:href="#people"/>
                    </svg>
                    教师信息
                </a>
            </li>
            <li>
                <a class="nav-link text-white" id="stuinfo" onclick="stumgr()">
                    <svg class="bi me-2" width="16" height="16">
                        <use xlink:href="#people"/>
                    </svg>
                    学生信息
                </a>
            </li>
            <li>
                <a class="nav-link text-white" id="courseinfo" onclick="coursemgr()">
                    <svg class="bi me-2" width="16" height="16">
                        <use xlink:href="#book"/>
                    </svg>
                    课程信息
                </a>
            </li>
            <li>
                <a class="nav-link text-white" id="facultyinfo" onclick="facultymgr()">
                    <svg class="bi me-2" width="16" height="16">
                        <use xlink:href="#building"/>
                    </svg>
                    院系信息
                </a>
            </li>
        </ul>
        <hr>
        <div class="dropdown">
            <a class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1"
               data-bs-toggle="dropdown" aria-expanded="false">
                <img src="/edusystem/img/i.jpg" alt="" width="32" height="32" class="rounded-circle me-2">
                <strong id="username">
                    <% User user = (User) session.getAttribute("user");
                        if (user == null) {
                            response.sendRedirect("/edusystem/login.jsp");
                            return;
                        }
                    %>
                    <%=user.getUserName()%>
                </strong>
            </a>
            <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                <li><a class="dropdown-item" onclick="userInfo()">个人信息</a></li>
                <li><a class="dropdown-item" onclick="revisePwd()">修改密码</a></li>
                <li>
                    <hr class="dropdown-divider">
                </li>
                <li><a class="dropdown-item" onclick="logout()">退出登录</a></li>
            </ul>
        </div>
    </div>
    <div class="b-example-divider"></div>
    <div id="section" class="section"></div>
</main>


<div class="modal fade" id="userInfoModel" tabindex="-1" aria-labelledby="uerInfoModelLable" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="uerInfoModelLable"></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form class="needs-validation" novalidate>
                <div class="modal-body">
                    <div class="mb-3 row">
                        <label for="infoNo" class="col-sm-2 col-form-label">管理员账号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="infoNo" id="infoNo"
                                   ria-label="管理员账号" required readonly>
                            <div class="invalid-feedback">
                                没有账号你咋登录？
                            </div>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="infoName" class="col-sm-2 col-form-label">管理员姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="infoName" id="infoName"
                                   ria-label="管理员姓名" required readonly>
                            <div class="invalid-feedback">
                                你还想匿名不成？
                            </div>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="infoMan" class="col-sm-2 col-form-label">性别</label>
                        <div class="col-sm-10">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="infoSex" id="infoMan" value="男"
                                       disabled>
                                <label class="form-check-label" for="infoMan">
                                    男
                                </label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="infoSex" id="infoWomen" value="女"
                                       disabled>
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

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-success" onclick="btnUserInfoSave()">保存</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="updatePwdModel" tabindex="-1" aria-labelledby="updatePwdModelLable" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="updatePwdModelTitle">修改密码</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form>
                <div class="modal-body">
                    <div class="mb-3 row">
                        <label for="oldPwd" class="col-sm-2 col-form-label">原密码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" blur="checkOldPwd()" name="oldPwd" id="oldPwd"
                                   ria-label="原密码" required>
                            <div class="invalid-feedback" id="oldPwdError">
                                原密码有误！
                            </div>
                        </div>
                    </div>
                    <div class="mb-3 row was-validated">
                        <label for="newPwd" class="col-sm-2 col-form-label">新密码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="newPwd" id="newPwd"
                                   ria-label="新密码" required>
                            <div class="invalid-feedback">
                                新密码不能空
                            </div>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="confirmPwd" class="col-sm-2 col-form-label">确认密码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="confirmPwd" id="confirmPwd" ria-label="确认密码"
                                   required>
                            <div class="invalid-feedback" id="confirmPwdError">
                                两次密码不一致
                            </div>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-success" onclick="btnRevisePwd()">保存</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>


<%--信息提示框--%>
<div class="modal fade" tabindex="-1" role="dialog" id="modelInfoMsg" backdrop="static">
    <div class="modal-dialog modal-sm " role="document">
        <div id="infoMsg" style="text-align: center;">
        </div>
    </div>
</div>

<script src="../dist/jquery/jquery-3.5.1.min.js"></script>
<script src="../dist/js/bootstrap.js"></script>
<script src="../dist/js/bootstrap-table.js"></script>
<script src="../dist/js/bootstrap.bundle.min.js"></script>
<script src="../dist/js/sidebars.js"></script>
<script src="../dist/js/bootstrap-table-zh-CN.js"></script>
<script src="../dist/personal-writing.js"></script>


</body>
</html>
<script>
    onload = home()
    var checkPwd = false
    var confirmPwd = false

    function btnUserInfoSave() {
        var user =
        ${sessionScope.userInfo}
        var tel = $("#infoTel").val()
        console.log(tel)
        $.ajax({
            type: "post",
            dataType: "json",
            url: "/edusystem/userInfoUpdateServlet",
            data: {"no": user.UserNo, "pwd": user.Password, "tel": tel, "role": "admin"},
            success: function (flag) {
                if (flag.res == "1") {
                    $('#userInfoModel').modal('hide');
                    model_Msg("#modelInfoMsg", "#infoMsg", "修改成功", "alert modal-sm alert-success", 1000)
                    setTimeout(function () {
                        location.reload();
                    }, 1000);
                } else {
                    model_Msg("#modelInfoMsg", "#infoMsg", "修改失败", "alert modal-sm alert-danger", 1000)
                }
            }
        })
    }

    function revisePwd() {
        $('#updatePwdModel').modal('show');
    }

    function btnRevisePwd() {
        var user = ${sessionScope.userInfo}
        var pwd = user.Password;
        var userNo = user.UserNo;
        var newPwd = document.getElementById("newPwd").value
        if(newPwd==null&&newPwd==""&&!checkPwd&&!confirmPwd){
            return
        }
        $.ajax({
            type:"post",
            dataType:"json",
            url:"/edusystem/userUpdatePwdServlet",
            data:{"userNo":userNo,"newPwd":newPwd,"oldPwd":pwd},
            success:function (flag){
                if (flag.res == "1") {
                    $('#updatePwdModel').modal('hide');
                    model_Msg("#modelInfoMsg", "#infoMsg", "修改成功,请重新登录", "alert modal-sm alert-success", 1000)
                    setTimeout(function () {
                        logout()
                    }, 1000);
                } else {
                    model_Msg("#modelInfoMsg", "#infoMsg", "修改失败", "alert modal-sm alert-danger", 1000)
                }
            }
        })

    }
    //检查原密码是否正确，后端还有一层数据库查询，在保存时，将原密码、新密码、账号一并传回去
    $( '#oldPwd' ).blur( function(){
        var user = ${sessionScope.userInfo}
        var pwd = user.Password;
        var inputOldPwd = document.getElementById("oldPwd").value
        var old = document.getElementById('oldPwd')
        var oldError = document.getElementById('oldPwdError')
        if (pwd != inputOldPwd) {
            checkPwd=false
            old.className = "form-control invalidate"
            oldError.className = "error"
        }else {
            checkPwd = true
            old.className = "form-control validate"
            oldError.className = "invalid-feedback"
        }
    } )

    $( '#confirmPwd' ).blur( function(){
        // 获取新密码
        var newPwd = document.getElementById("newPwd")
        var confirmPwd = document.getElementById("confirmPwd")

        var confirmPwd = document.getElementById('confirmPwd')
        var confirmPwdError = document.getElementById('confirmPwdError')
        if (newPwd.value != confirmPwd.value) {
            confirmPwd=false
            confirmPwd.className = "form-control invalidate"
            confirmPwdError.className = "error"
        }else {
            confirmPwd = true
            confirmPwd.className = "form-control validate"
            confirmPwdError.className = "invalid-feedback"
        }
    } )


    function userInfo() {
        $("#uerInfoModelLable").html("个人信息")
        $('#userInfoModel').modal('show');
        var user = ${sessionScope.userInfo}
            $("#infoNo").val(user.UserNo)
        $("#infoName").val(user.UserName)
        $("input[name='infoSex'][value=" + user.Sex + "]").attr("checked", true)
        $("#infoTel").val(user.Tel)

    }

    function logout() {
        $.ajax({
            type: "get",
            dataType: "json",
            url: "/edusystem/author/authorLogoutServlet",
            data: {},
            success: function (flag) {
                if (flag.status == "logout") {
                    window.location.href = "/edusystem/login.jsp"
                }
            }
        })
    }

    function clearClass() {
        $("#index_home").attr("class", "nav-link text-white")
        $("#tchinfo").attr("class", "nav-link text-white")
        $("#stuinfo").attr("class", "nav-link text-white")
        $("#courseinfo").attr("class", "nav-link text-white")
        $("#facultyinfo").attr("class", "nav-link text-white")
    }

    //首页
    function home() {
        clearClass()
        $("#index_home").attr("class", "nav-link active")
        $("#section").load("home.jsp");
    }

    //教师管理
    function tchmgr() {
        clearClass()
        $("#tchinfo").attr("class", "nav-link active")
        $("#section").load("tchmgr.jsp");
    }

    //学生管理
    function stumgr() {
        clearClass()
        $("#stuinfo").attr("class", "nav-link active")
        $("#section").load("stumgr.jsp");
    }

    //课程管理
    function coursemgr() {
        clearClass()
        $("#courseinfo").attr("class", "nav-link active")
        $("#section").load("coursemgr.jsp");
    }

    //院系管理
    function facultymgr() {
        clearClass()
        $("#facultyinfo").attr("class", "nav-link active")
        $("#section").load("facultymgr.jsp");
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
    li:hover {
        cursor: pointer;
    }

    .section {
        width: calc(100%);
        padding: 0 10px;
    }


    .invalidate {
        border-color: #dc3545;
        padding-right: calc(1.5em + 0.75rem);
        background-image: url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 12 12' width='12' height='12' fill='none' stroke='%23dc3545'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e");
        background-repeat: no-repeat;
        background-position: right calc(0.375em + 0.1875rem) center;
        background-size: calc(0.75em + 0.375rem) calc(0.75em + 0.375rem);
    }

    .hide-error {
        display: none;
    }

    .error {
        display : block;
        width: 100%;
        margin-top: 0.25rem;
        font-size: .875em;
        color: #dc3545;
    }

    .validate {
        border-color: #198754;
        padding-right: calc(1.5em + 0.75rem);
        background-image: url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 8 8'%3e%3cpath fill='%23198754' d='M2.3 6.73L.6 4.53c-.4-1.04.46-1.4 1.1-.8l1.1 1.4 3.4-3.8c.6-.63 1.6-.27 1.2.7l-4 4.6c-.43.5-.8.4-1.1.1z'/%3e%3c/svg%3e");
        background-repeat: no-repeat;
        background-position: right calc(0.375em + 0.1875rem) center;
        background-size: calc(0.75em + 0.375rem) calc(0.75em + 0.375rem);
    }

</style>