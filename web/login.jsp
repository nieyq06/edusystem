<%--
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
                        <input type="text" name="username" id="username" class="form-control" placeholder="账号" aria-label="账号" required>
                        <div class="invalid-feedback">
                            请输入账号
                        </div>
                    </div>
                    <div class="col">
                        <input type="password" name="password" id="password" class="form-control" placeholder="密码" aria-label="密码" required>
                        <div class="invalid-feedback">
                            密码不能为空
                        </div>
                    </div>
                </div>
                <div class="row g-3">
                    <div class="col">
                        <input type="text" name="inputVcode" id="inputVcode"  class="form-control" placeholder="验证码" aria-label="验证码" required>
                        <div class="invalid-feedback" id="Vcode">
                            请输入验证码
                        </div>
                    </div>
                    <div class="col">
                        <img src="/edusystem/createCode" />
                    </div>
                </div>
                <div class="row g-3">
                    <div class="col">
                        <button type="button" class="btn btn-primary logbtn col-5 " onclick="login()">登 录</button>
                    </div>
                </div>
            </form>

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
    function login(){
        let username = document.getElementById("username").value;
        let password = document.getElementById("password").value;
        let inputVcode = document.getElementById("inputVcode").value;
        <%--let ss = <% request.getSession().getAttribute("codes");%>--%>
        if(inputVcode.trim()==""){
            // show_msg("#modelMsg","#mesg","验证码错误","alert modal-sm alert-danger","1200");
            // $('#inputVcode').val('');
            return;
        }
        $.ajax({
            method:"post",
            dataType:"json",
            url:"/edusystem/author/AuthorLoginServlet",
            data:{"username":username,"password":password,"inputVcode":inputVcode},
            success:function (flag){
                console.log(flag)
                if(flag.u=="0"&&flag.role=="1"){
                    // window.location.href = "/edusystem/mgr/index.jsp"; // 路由跳转到管理员首页
                    window.location.href = "/edusystem/mgr/index_.jsp"; // 路由跳转到管理员首页
                }else if(flag.u=="0"&&flag.role=="2"){
                    window.location.href = "/edusystem/tch/index.jsp";
                }else if(flag.u=="0"&&flag.role=="3"){
                    window.location.href = "/edusystem/stu/index.jsp";
                }else if(flag.u=="-1") {
                    show_msg("#modelMsg","#mesg","账号或密码有误","alert modal-sm alert-danger","1200");
                    // $('#inputVcode').val('');
                }else {
                    show_msg("#modelMsg","#mesg","验证码有误","alert modal-sm alert-danger","1200");
                    $('#inputVcode').val('');
                }
            }
        })


        // action="/edusystem/author/AuthorLoginServlet"
    }
    function test(val){
        let username = document.getElementById(val).value
        console.log("测试："+username)
    }

    function show_msg(modal_div, content_div, value, style, time) {
        $(modal_div).modal({
            backdrop: "static",//点击空白处不关闭对话框
            show: true});
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
        padding-right: 25% ;
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
</style>