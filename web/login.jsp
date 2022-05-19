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
            <form action="/edusystem/author/AuthorLoginServlet" class=" needs-validation" method="post" novalidate>
                <div class="row g-3">
                    <div class="col">
                        <input type="text" name="username" class="form-control" placeholder="账号" aria-label="账号" required>
                        <div class="invalid-feedback">
                            请输入账号
                        </div>
                    </div>
                    <div class="col">
                        <input type="password" name="password" class="form-control" placeholder="密码" aria-label="密码" required>
                        <div class="invalid-feedback">
                            密码不能为空
                        </div>
                    </div>
                </div>
                <div class="row g-3">
                    <div class="col">
                        <input type="text" name="inputVcode" class="form-control" placeholder="验证码" aria-label="验证码" required>
                        <div class="invalid-feedback">
                            请输入验证码
                        </div>
                    </div>
                    <div class="col">
                        <img src="/edusystem/createCode" />
                    </div>
                </div>
                <div class="row g-3">
                    <div class="col">
                        <button type="submit" class="btn btn-primary logbtn col-5 ">登 录</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>

</body>
</html>
<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
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