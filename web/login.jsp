<%@ page import="entity.Faculty" %>
<%@ page import="java.util.List" %>
<%@ page import="service.FacultyService" %>
<%@ page import="service.impl.FacultyServiceImpl" %>
<%@ page import="service.SubjectService" %>
<%@ page import="service.impl.SubjectServiceImpl" %>
<%@ page import="entity.Subject" %>
<%@ page import="cn.hutool.json.JSONUtil" %><%--
  Created by IntelliJ IDEA.
  User: nyq
  Date: 2022/5/19
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教务管理系统登录</title>
    <link href="dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="dist/jquery/jquery-3.5.1.min.js"></script>
    <script src="dist/js/bootstrap.js"></script>
    <link href="../dist/persona-writing.css" rel="stylesheet">
</head>
<body>
<h2 class="nva">欢迎使用</h2>
<hr>
<div class="topform">
    <div class="formback">
        <div class="content">
            <form class=" needs-validation" method="post" novalidate>
                <div class="row g-3">
                    <div class="col">
                        <input type="text" name="username" id="username" class="form-control" placeholder="账号"
                               aria-label="账号" required>
                        <div class="invalid-feedback">
                            请输入账号
                        </div>
                    </div>
                    <div class="col">
                        <input type="password" name="password" id="password" class="form-control" placeholder="密码"
                               aria-label="密码" required>
                        <div class="invalid-feedback">
                            密码不能为空
                        </div>
                    </div>
                </div>
                <div class="row g-3">
                    <div class="col">
                        <input type="text" name="inputVcode" id="inputVcode" class="form-control" placeholder="验证码"
                               aria-label="验证码" required>
                        <div class="invalid-feedback" id="Vcode">
                            请输入验证码
                        </div>
                    </div>
                    <div class="col">
                        <img src="/edusystem/createCode"/>
                    </div>
                </div>
                <div class="row g-3">
                    <div class="col">
                        <button type="button" class="btn btn-success logbtn col-5 " onclick="login()">登 录</button>
                    </div>
                </div>
            </form>

            <div class="col registerbtn">
                <button type="button" class="btn btn-primary  col-5 " onclick="register()">注 册</button>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="registerModel" tabindex="-1" aria-labelledby="updatePwdModelLable" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="updatePwdModelTitle">用户注册</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form class="">

                    <div class="mb-3 row">
                        <label for="userNo" class="col-sm-2 col-form-label">学号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="userNo" id="userNo"
                                   ria-label="学号" required>
                            <div class="invalid-feedback" id="userNoNull">
                                学号不能空
                            </div>
                            <div class="invalid-feedback" id="checkUserNo">
                                该学号已存在
                            </div>
                        </div>
                    </div>
                    <div class="mb-3 row was-validated">
                        <label for="registerUserName" class="col-sm-2 col-form-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="registerUserName" id="registerUserName"
                                   ria-label="姓名" required>
                            <div class="invalid-feedback">
                                姓名不能空
                            </div>
                        </div>
                    </div>
                    <div class="mb-3 row was-validated">
                        <label for="registerTel" class="col-sm-2 col-form-label">电话号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="registerTel" id="registerTel"
                                   ria-label="电话号码" required>
                            <div class="invalid-feedback">
                                电话号码不能空
                            </div>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="registerMan" class="col-sm-2 col-form-label">性别</label>
                        <div class="col-sm-10">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="registerSex" id="registerMan"
                                       value="男"
                                       checked>
                                <label class="form-check-label" for="registerMan">
                                    男
                                </label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="registerSex" id="registerWomen"
                                       value="女"
                                >
                                <label class="form-check-label" for="registerWomen">
                                    女
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="mb-3 row">
                        <label for="registerFaculty" class="col-sm-2 col-form-label">二级学院</label>
                        <div class="col-sm-10 was-validated">
                            <select class="form-select" aria-label="选择二级学院" id="registerFaculty" name="registerFaculty"
                                    ria-label="二级学院"
                                    onchange="facultyChange(this)" required>
                                <option selected value="">选择二级学院</option>
                                <%

                                    FacultyService facultyService = new FacultyServiceImpl();
                                    SubjectService subjectService = new SubjectServiceImpl();

                                    List<Faculty> faculty = facultyService.getByAll_cache();
                                    List<Subject> subjects = subjectService.getByAll_cache();
                                    String subjectsjson = JSONUtil.toJsonStr(subjects);
                                    session.setAttribute("subjects", subjectsjson);
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
                        <label for="registerSubject" class="col-sm-2 col-form-label">所属专业</label>
                        <div class="col-sm-10 was-validated">
                            <select class="form-select" aria-label="选择专业" id="registerSubject" name="registerSubject"
                                    ria-label="所属专业" required>
                                <option selected value="">选择专业</option>
                            </select>
                            <div class="invalid-feedback">
                                所属专业不能为空
                            </div>
                        </div>
                    </div>


                    <div class="mb-3 row">
                        <label for="upassword" class="col-sm-2 col-form-label">密码</label>
                        <div class="col-sm-10 was-validated">
                            <input type="password" class="form-control" name="upassword" id="upassword"
                                   ria-label="新密码" required>
                            <div class="invalid-feedback">
                                密码不能空
                            </div>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="confirmPwd" class="col-sm-2 col-form-label">确认密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" name="confirmPwd" onblur="checkPwd()"
                                   id="confirmPwd"
                                   ria-label="确认密码"
                                   required>
                            <div class="invalid-feedback" id="confirmPwdError">
                                两次密码不一致
                            </div>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-success" onclick="btnRegister()">注 册</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%--提示信息--%>
<div class="modal fade" tabindex="-1" role="dialog" id="modelMsg" backdrop="static">
    <div class="modal-dialog modal-sm " role="document">
        <div id="mesg" style="text-align: center;">
        </div>
    </div>
</div>

</body>
</html>
<script>
    var confirmPwdCheck = false
    var confirmNoCheck = false

    function btnRegister() {
        var userNo = document.getElementById("userNo").value
        var password = document.getElementById("upassword").value
        var username = document.getElementById("registerUserName").value
        var tel = document.getElementById("registerTel").value

        let sex = $('input[name=registerSex]:checked').val();

        var facultyId = document.getElementById("registerFaculty").value
        var subjectId = document.getElementById("registerSubject").value
        $.ajax({
            method: "get",
            dataType: "json",
            url: "/edusystem/registerServlet",
            data: {
                "userno": userNo,
                "password":password,
                "username":username,
                "sex":sex,
                "subjectId":subjectId,
                "facultyId":facultyId,
                "tel":tel,
            },
            success: function (flag) {
                if (flag.res == 1) {
                    $('#registerModel').modal('hide');
                    show_msg("#modelMsg", "#mesg", "注册成功", "alert modal-sm alert-success", "1200");
                }else {
                    show_msg("#modelMsg", "#mesg", "注册失败", "alert modal-sm alert-danger", "1200");
                }
            }
        })
    }

    $('#userNo').change(function () {
        var checkUserNo = document.getElementById('checkUserNo')
        var userNo = document.getElementById('userNo')
        var userNoNull = document.getElementById('userNoNull')

        if (userNo.value == "" || userNo.value == null) {
            confirmNoCheck = false
            userNo.className = "form-control invalidate"
            userNoNull.className = "error"
            checkUserNo.className = "invalid-feedback"
            return
        } else {
            confirmNoCheck = true
            userNo.className = "form-control validate"
            userNoNull.className = "invalid-feedback"
        }
        $.ajax({
            method: "get",
            dataType: "json",
            url: "/edusystem/registerCheckServlet",
            data: {"userno": userNo.value},
            success: function (flag) {
                console.log(flag)
                if (flag.res == 1) {
                    confirmNoCheck = false
                    userNo.className = "form-control invalidate"
                    checkUserNo.className = "error"
                } else {
                    confirmNoCheck = true
                    userNo.className = "form-control validate"
                    checkUserNo.className = "invalid-feedback"
                }
            }
        })
    })

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

    function login() {
        let username = document.getElementById("username").value;
        let password = document.getElementById("password").value;
        let inputVcode = document.getElementById("inputVcode").value;
        <%--let ss = <% request.getSession().getAttribute("codes");%>--%>
        if (inputVcode.trim() == "") {
            // show_msg("#modelMsg","#mesg","验证码错误","alert modal-sm alert-danger","1200");
            // $('#inputVcode').val('');
            return;
        }
        $.ajax({
            method: "post",
            dataType: "json",
            url: "/edusystem/author/AuthorLoginServlet",
            data: {"username": username, "password": password, "inputVcode": inputVcode},
            success: function (flag) {
                console.log(flag)
                if (flag.u == "0" && flag.role == "1") {
                    window.location.href = "/edusystem/mgr/index.jsp"; // 路由跳转到管理员首页
                    // window.location.href = "/edusystem/mgr/index__.jsp"; // 路由跳转到管理员首页
                } else if (flag.u == "0" && flag.role == "2") {
                    window.location.href = "/edusystem/tch/index.jsp";
                } else if (flag.u == "0" && flag.role == "3") {
                    window.location.href = "/edusystem/stu/index.jsp";
                } else if (flag.u == "-1") {
                    show_msg("#modelMsg", "#mesg", "账号或密码有误", "alert modal-sm alert-var ", "1200");
                    // $('#inputVcode').val('');
                } else {
                    show_msg("#modelMsg", "#mesg", "验证码有误", "alert modal-sm alert-danger", "1200");
                    $('#inputVcode').val('');
                }
            }
        })


        // action="/edusystem/author/AuthorLoginServlet"
    }

    function register() {
        $('#registerModel').modal('show');

    }

    function checkPwd() {
        var upassword = document.getElementById("upassword")
        var confirmPwd = document.getElementById("confirmPwd")

        var confirmPwdIpt = document.getElementById('confirmPwd')
        var confirmPwdError = document.getElementById('confirmPwdError')
        if (upassword.value != confirmPwd.value) {
            confirmPwdCheck = false
            confirmPwdIpt.className = "form-control invalidate"
            confirmPwdError.className = "error"
        } else {
            confirmPwdCheck = true
            confirmPwdIpt.className = "form-control validate"
            confirmPwdError.className = "invalid-feedback"
        }
    }

    //设置专业过滤
    function filterCourse(val) {
        var temps_subject = [];//每次更变二级学院后清空课程
        let temps = ${sessionScope.subjects}
            console.log(temps)
        temps_subject = temps.filter(function (e) {
            return e.FacultyId === val;
        });//json数据过滤
        let obj = document.getElementById('registerSubject');
//重置下拉选项
        obj.options.length = 1;
        console.log(temps_subject)
//添加过滤后的课程
        for (let key in temps_subject) {
            let item = "<option value='" + temps_subject[key].SubjectId + "'" + ">" + temps_subject[key].SubjectName + "</option>"
            $(item).appendTo("#registerSubject");
        }
    }

    function facultyChange(val) {
        let faculty = $('#registerFaculty').val()
        filterCourse(faculty);
    }

    function show_msg(modal_div, content_div, value, style, time) {
        $(modal_div).modal({
            backdrop: "static",//点击空白处不关闭对话框
            show: true
        });
        $(modal_div).modal('show');
        $(".modal-backdrop").remove();
        $(content_div).attr("class", style);
        $(content_div).html(value)
        setTimeout(function () {
            $(modal_div).modal("hide")
        }, time);
        //
        // $('#modelMsg').modal({
        //     backdrop: "static",//点击空白处不关闭对话框
        //     show: true});
        // $('#modelMsg').modal('show');
        // $(".modal-backdrop").remove();
        // $("#mesg").attr("class", "alert alert-success");
        // $('#mesg').html('成功')
        // setTimeout(function () {
        //     $('#modelMsg').modal("hide")
        // }, 1200);
    }
</script>
<style>
    body {
        background-color: #f5f8f7;
        padding: 5rem;
        padding-left: 25%;
        padding-right: 25%;
    }

    .nva {
        text-align: center;
        padding-top: 12rem;
        padding-bottom: 2rem;
    }

    .topform {
        padding-top: 5rem;
    }

    .formback {
        border-radius: 1rem;
        padding: 2rem;
        width: 100%;
        min-height: auto;
        background-color: #ffffff;
        /* display: flex; */
    }

    .content {
        width: auto;
        height: 200px;
        margin: auto;
    }

    .form-input {
        margin: auto;
    }

    .row {
        margin-top: 0;
    }

    .logbtn {
        display: block;
        margin: 0 auto;
    }

    .registerbtn {
        text-align: center;
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
        display: block;
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