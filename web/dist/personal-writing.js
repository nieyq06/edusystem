//消息提示框
function model_Msg(msg_Model_div,msg_Content_div,value,style,time){
    $(msg_Model_div).modal({
        backdrop: "static",//点击空白处不关闭对话框
        show: true});
    $(msg_Model_div).modal('show');
    $(".modal-backdrop").remove();
    $(msg_Content_div).attr("class", style);
    $(msg_Content_div).html(value)
    setTimeout(function () {
        $(msg_Model_div).modal("hide")
    }, time);
}
//模态框
function modelDisplay(model_name,model_display){
    $(model_name).modal(model_display);
}
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



