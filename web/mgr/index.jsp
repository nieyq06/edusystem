<%--
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
</head>
<body><div id="header">
    <h1> ~管理员页面~</h1>
</div>

<div id="nav">
    <ul>
        <li onclick="home()">首页</li>
        <li onclick="tchmgr()">教师信息管理</li>
        <li onclick="stumgr()">学生信息管理</li>
        <li onclick="coursemgr()">课程信息管理</li>
        <li onclick="titlemgr()">职称信息管理</li>
        <li onclick="facultymgr()">院系信息管理</li>
        <li onclick="classlocamgr()">授课地点管理</li>
        <li onclick="changepwd()">修改密码</li>
    </ul>
</div>
<div id="section">

</div>
<script src="../dist/jquery/jquery-3.5.1.min.js"></script>
<script src="../dist/js/bootstrap.js"></script>
<script src="../dist/js/bootstrap-table.js"></script>
<script src="../dist/js/bootstrap-table-zh-CN.js"></script>
<script src="../dist/personal-writing.js"></script>


</body>
</html>
<script>

    onload(home())

    // //首页
    // function home(){
    //     $("#section").load("home.jsp");
    // }
    // //教师管理
    // function tchmgr(){
    //     $("#section").load("tchmgr.jsp");
    // }
    // //学生管理
    // function stumgr(){
    //     $("#section").load("stumgr.jsp");
    // }
    // //课程管理
    // function coursemgr(){
    //     $("#section").load("coursemgr.jsp");
    // }
    // //职称管理
    // function titlemgr(){
    //     $("#section").load("titlemgr.jsp");
    // }
    // //院系管理
    // function facultymgr(){
    //     $("#section").load("facultymgr.jsp");
    // }
    // //授课地点管理
    // function classlocamgr(){
    //     $("#section").load("classlocamgr.jsp");
    // }
    // //修改密码
    // function changepwd(){
    //     $("#section").load("home.jsp");
    // }
</script>
<style>
    html,
    body {
        height: 100%;
        margin: 0;
        /* 需要清除body自带的外边距 */
    }
    #header {
        background-color: rgb(11, 31, 43);
        color: white;
        text-align: center;
        height: 65px;
        padding: 5px;
    }

    #nav {
        line-height: 30px;
        background-color: #eeeeee;
        height: calc(100% - 65px);
        width: 150px;
        float: left;
        padding: 5px;
    }
    ul>li{
        list-style: none;
        padding-top: 5px;
    }
    li:hover{
        cursor: pointer;
    }

</style>