<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<style>
    .div-head1 {
        width: 200%;
        height: 50px;
        line-height: 50px;
        margin-left: -50px;
        background: #a5291f;
    }

    .div-head2 {
        margin-top: 0px;
        margin-left: -50px;
    }

    .div-head3-left {
        margin-left: 1050px;
        font-size: 17px;
    }
    .div-head3-right{
        margin-left:-800px;
        margin: auto;
        width: 100px;
    }

    .ul-li-p {
        color: #a5291f;
        font-size: 40px;
        font-weight: bold;
        font-family: 宋体
    }
</style>
<div class="container-fluid">
    <%--<div class="col-md-1" style="padding-top: 4px">
        <img style="height: 50px;width: 110px" src="../image/logo1.png" />
    </div>
    <div class="col-md-4" style="padding-left: 0px;padding-top: 4px">
        <img src="../image/bdlogo.png" />
    </div>--%>
    <div class="div-head1">
        <div class="div-head3-left">
            <ol class="list-inline">
                <c:if test="${empty sessionScope.user }">
                    <li style="margin-left:180px;"><a href="${pageContext.request.contextPath }/loginPage"><p
                            style="color: #52d51b;">登录</p></a></li>
                    <li>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</li>
                    <li><a href="${pageContext.request.contextPath }/registerPage"><p style="color: #a403f5;">注册</p>
                    </a>
                    </li>
                </c:if>
                <c:if test="${!empty sessionScope.user }">
                    <li style="color:red;margin-left:120px;">欢迎您，${user.username }</li>
                    <li><a href="${pageContext.request.contextPath }/logout">退出</a></li>
                </c:if>
            </ol>
        </div>
    </div>
    <%--<div class="col-md-4 " style="padding-left:20px;padding-top:20px;font-size: 17px;float: right">
        <ol class="list-inline">
            <c:if test="${empty sessionScope.user }">
                <li style="margin-left:180px;"><a href="${pageContext.request.contextPath }/loginPage"><p
                        style="color: #3c763d">登录</p></a></li>
                <li><a href="${pageContext.request.contextPath }/registerPage"><p style="color:blue">注册</p></a>
                </li>
            </c:if>
            <c:if test="${!empty sessionScope.user }">
                <li style="color:red;margin-left:120px;">欢迎您，${user.username }</li>
                <li><a href="${pageContext.request.contextPath }/logout">退出</a></li>
            </c:if>
        </ol>
    </div>--%>
    <div class="div-head2" <%--class="col-md-1"--%>>
        <img <%--style="margin-left:-40px"--%> src="../image/head2.png">
    </div>
    <%--    <div style="width: 200%;--%>
    <%--    height: 50px;--%>
    <%--    line-height: 50px;--%>
    <%--    margin-left: -50px;--%>
    <%--    background: #B3100f;"></div>--%>
    <%--    <div class="col-md-3">--%>
    <%--        &lt;%&ndash;<img src="image/logor.png" />&ndash;%&gt;--%>
    <%--    </div>--%>
    <%--<div class="col-md-4" style="padding-left:20px;padding-top:20px;font-size: 17px;float: right;">
        <ol class="list-inline">
            <c:if test="${empty sessionScope.user }">
                <li style="margin-left:180px;"><a href="${pageContext.request.contextPath }/loginPage"><p
                        style="color: #3c763d">登录</p></a></li>
                <li><a href="${pageContext.request.contextPath }/registerPage"><p style="color:blue">注册</p></a></li>
            </c:if>
            <c:if test="${!empty sessionScope.user }">
                <li style="color:red;margin-left:120px;">欢迎您，${user.username }</li>
                <li><a href="${pageContext.request.contextPath }/logout">退出</a></li>
            </c:if>
        </ol>
    </div>--%>
</div>
<!-- 导航条 -->
<div class="container-fluid" style="margin-top: 35px;border: none">
    <nav class="navbar navbar-inverse" style="background-color: #ffffff;border: none">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <%--<a class="navbar-brand" href="#">首页</a>--%>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav" style="margin-left: 100px">
                    <li style=" border-bottom: 1px solid #bb4242; /* 设置底部边框 */
           "><a href="${pageContext.request.contextPath }/user"><p
                    class="ul-li-p">|网站首页 |</p></a>
                    </li>
                    <li style=" border-bottom: 1px solid #ff0000;"><a
                            href="${pageContext.request.contextPath }/getScenicPageForUser"><p
                            class="ul-li-p">红色景点 |</p></a>
                    </li>
                    <li style=" border-bottom: 1px solid #ff0000;"><a
                            href="${pageContext.request.contextPath }/getFoodPageForUser"><p
                            class="ul-li-p">红色美食 |</p></a>
                    </li>
                    <li style=" border-bottom: 1px solid #ff0000;"><a
                            href="${pageContext.request.contextPath }/userInfoPage"><p
                            class="ul-li-p">个人信息 |</p></a>
                    </li>
                    <li style=" border-bottom: 1px solid #ff0000;"><a
                            href="${pageContext.request.contextPath }/listOrder"><p
                            class="ul-li-p">我的订单</p></a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>