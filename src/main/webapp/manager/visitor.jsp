<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="p" uri="http://commonutils.cn/tld/" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>保定旅行咨询网</title>
    <link rel="shortcut icon" href="../image/logo1.png" type="image/x-icon"/>
    <!-- Bootstrap Core CSS -->
    <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet">
    <!-- DataTables CSS -->
    <link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="<%=basePath%>css/boot-crm.css" rel="stylesheet" type="text/css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery -->
    <script src="<%=basePath%>js/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=basePath%>js/metisMenu.min.js"></script>
    <!-- DataTables JavaScript -->
    <script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
    <script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="<%=basePath%>js/sb-admin-2.js"></script>
</head>
<body>
<div id="wrapper">
    <!-- 引入navigation.jsp -->
    <jsp:include page="navigation.jsp"></jsp:include>
    <!-- 操作面板 -->
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12" style="height:15px">
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="panel panel-default">
            <div class="panel-body">
                <form class="form-inline" action="${pageContext.request.contextPath }/manageVisitor" method="post">
                    <div class="form-group">
                        <label for="name">用户名</label>
                        <input type="text" class="form-control" id="name" value="${name }" name="name">
                    </div>
                    <button type="submit" class="btn btn-primary">查询</button>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">用户信息列表</div>
                    <!-- /.panel-heading -->
                    <table class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th>用户名</th>
                            <th>姓名</th>
                            <th>邮箱</th>
                            <th>性别</th>
                            <th>生日</th>
                            <th>激活状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.rows}" var="row">
                            <tr>
                                <td>${row.username}</td>
                                <td>${row.name}</td>
                                <td>${row.email}</td>
                                <td>${row.sex}</td>
                                <td>${row.birthday}</td>
                                <c:if test="${row.state==1}">
                                    <td><p style="color: green">未禁用</p></td>
                                </c:if>
                                <c:if test="${row.state==0}">
                                    <td><p style="color: red">禁用中</p></td>
                                </c:if>
                                    <%--                                        <c:if test="${row.state==2}">--%>
                                    <%--                                            <td>禁用</td>--%>
                                    <%--                                        </c:if>--%>
                                    <%--                                        <c:if test="${row.state==2}">--%>
                                    <%--                                            <td>禁用</td>--%>
                                    <%--                                        </c:if>--%>

                                <c:if test="${row.state==1}">
                                    <td>
                                        <a href="#" class="btn btn-primary btn-xs"
                                           onclick="updateState('${row.userid}')">禁用</a>
                                    </td>
                                </c:if>
                                <c:if test="${row.state==0}">
                                    <td>
                                        <a href="#" class="btn btn-primary btn-xs"
                                           onclick="updateState1('${row.userid}')">取消禁用</a>
                                    </td>
                                </c:if>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="col-md-12 text-right" style="text-align:center">
                        <p:page url="${pageContext.request.contextPath }/manageVisitor"/>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
    </div>
</div>
</body>

<script type="text/javascript">
    function updateState(id) {
        if (confirm('您确定要禁用该用户吗?')) {
            $.post("<%=basePath%>/updateUserState", {"id": id}, function (data) {
                alert("禁用指定用户成功！");
                window.location.reload();
            });
        }
    }

    function updateState1(id) {
        if (confirm('您确定要禁用该用户吗?')) {
            $.post("<%=basePath%>/updateUserState1", {"id": id}, function (data) {
                alert("禁用指定用户成功！");
                window.location.reload();
            });
        }
    }
</script>
</html>
