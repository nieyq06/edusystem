<%--
  Created by IntelliJ IDEA.
  User: nyq
  Date: 2022/5/18
  Time: 0:20
  Introduction: 首页
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <div class="row row-cols-1 row-cols-md-3 g-4">
      <div class="col">
          <div class="card">
              <div class="row g-0">
                  <div class="col-md-4 img-centent">
                      <img src="/edusystem/img/mgrindex/student.png" class="img-fluid rounded-start" alt="学生">
                  </div>
                  <div class="col-md-8">
                      <div class="card-body card-content">
                          <h5 class="card-title text-muted">学生</h5>
                          <h5 class="card-text text-muted">555</h5>
                      </div>
                  </div>
              </div>
          </div>
      </div>

      <div class="col">
          <div class="card">
              <div class="row g-0">
                  <div class="col-md-4 img-centent">
                      <img src="/edusystem/img/mgrindex/teacher.png" class="img-fluid rounded-start" alt="教师">
                  </div>
                  <div class="col-md-8">
                      <div class="card-body card-content">
                          <h5 class="card-title text-muted">教师</h5>
                          <h5 class="card-text text-muted">23</h5>
                      </div>
                  </div>
              </div>
          </div>
      </div>
      <div class="col">
          <div class="card">
              <div class="row g-0">
                  <div class="col-md-4 img-centent">
                      <img src="/edusystem/img/mgrindex/faculty.png" class="img-fluid rounded-start" alt="院系">
                  </div>
                  <div class="col-md-8">
                      <div class="card-body card-content">
                          <h5 class="card-title text-muted">院系</h5>
                          <h5 class="card-text text-muted">6</h5>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </div>

  <div class="row row-cols-1 row-cols-md-2 g-4">
      <div class="col">
          <div class="card">
              <div class="row g-0">
                  <div class="col-md-12">
                      <table class="table table-hover">
                          <thead>
                          <tr style="text-align: center" class="text-muted card-title" >

                              <th data-field="#" style="width: 50px">#</th>
                              <th data-sortable="true" data-field="userName">姓名</th>
                              <th data-sortable="true" data-field="facultyName">学院</th>
                              <th data-sortable="true" data-field="status">状态</th>
                              <th data-sortable="true" data-field="role">身份</th>
                          </tr>
                          </thead>
                          <tbody class="text-muted" style="text-align: center">
                          <tr><td colspan="5">暂无数据</td></tr>

                          </tbody>
                      </table>
                  </div>
              </div>
          </div>
      </div>
  </div>

  </body>
</html>

<style>
    .card-content {
        float: right;
    }
    .row {
        margin-top: 0;
    }
    .img-centent{
        text-align: center;
        margin: auto;
    }
</style>