<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="p" uri="http://commonutils.cn/tld/" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>我的订单</title>
    <link rel="shortcut icon" href="../image/logo1.png" type="../image/x-icon"/>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <!-- 引入自定义css文件 style.css -->
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
    <style>
        body {
            margin-top: 20px;
            margin: 0 auto;
        }

        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }

        sbody {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f2f2f2;
        }

        .dialog {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5); /* 半透明背景 */
            z-index: 1000; /* 确保在最前面 */
        }

        .dialog-content {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            text-align: center;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .dialog button {
            margin: 10px;
            padding: 8px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
            border-radius: 4px;
        }

        .dialog button:hover {
            background-color: #0056b3;
        }
    </style>
    <script>
        function confirmSubmit() {
            var dialog = document.getElementById('confirmation-dialog');
            dialog.style.display = 'block'; // 显示确认对话框

            document.getElementById('confirm-button').addEventListener('click', function() {
                dialog.style.display = 'none'; // 隐藏对话框
                document.getElementById('submit-form').submit(); // 提交表单
            });

            document.getElementById('cancel-button').addEventListener('click', function() {
                dialog.style.display = 'none'; // 隐藏对话框
            });

            return false; // 阻止表单默认提交
        }
    </script>
</head>
<body>
<!-- 引入header.jsp -->
<jsp:include page="./header.jsp"></jsp:include>

<div id="confirmation-dialog" class="dialog">
    <div class="dialog-content">
        <p>确定要提交表单吗？</p>
        <button id="confirm-button">确定</button>
        <button id="cancel-button">取消</button>
    </div>
</div>
<div class="container">
    <div class="row">
        <div style="margin: 0 auto; margin-top: 10px; width: 900px;">
            <h2>订单列表</h2>
            <table class="table table-bordered">
                <c:forEach items="${page.rows}" var="order">
                    <tbody>
                    <tr class="success">
                        <th colspan="6">订单编号:${order.orderno}</th>
                    </tr>
                    <tr class="warning">
                        <th>景点名称</th>
                        <th>门票名称</th>
                        <th>取票编号</th>
                        <th>数量</th>
                        <th>合计</th>
                        <th>状态</th>
                    </tr>
                    <tr class="active">
                        <td width="15%">
                            <span class="subtotal">${order.ticket.scenic.name}</span>
                        </td>
                        <td width="15%">
                            <span class="subtotal">${order.ticket.name}</span>
                        </td>
                        <td width="35%">
                            <span class="subtotal">${order.ticketno}</span>
                        </td>
                        <td width="10%">
                            <span class="subtotal">${order.num}</span>
                        </td>
                        <td width="10%">
                            <span class="subtotal">${order.price}</span>
                        </td>
                        <c:if test="${order.state==2}">
                            <td><span class="subtotal">已取票</span></td>
                        </c:if>
                        <c:if test="${order.state==1}">
                            <td><span class="subtotal">未取票</span></td>
                        </c:if>
                        <c:if test="${order.state==0}">
                            <td><span class="subtotal">未付款</span>
                                <div>
                                        <%--                                    <form action="${pageContext.request.contextPath }/submitOrderInfo">--%>
                                        <%--                                        <input type="hidden" name="price" value="${order.price}">--%>
                                        <%--                                       &lt;%&ndash; <input type="hidden" name="tid" value="${order.tid}">&ndash;%&gt;--%>
                                        <%--                                        <input type="hidden" name="num" value="${order.num}">--%>
                                        <%--                                        <input type="hidden" name="name" value="${order.ticket.name}">--%>
                                        <%--                                        <input  type="submit" value="立即支付" class="btn btn-default btn-info">--%>
                                        <%--                                    </form>--%>
                                    <form id="submit-form" action="${pageContext.request.contextPath }/payForOrder"
                                          onsubmit="return confirmSubmit()">
                                        <input type="hidden" name="price" value="${order.price}">
                                            <%-- <input type="hidden" name="tid" value="${order.tid}">--%>
                                        <input type="hidden" name="orderno" value="${order.orderno}">
                                        <input type="hidden" name="ticketno" value="${order.ticketno}">
                                        <input type="submit" value="立即支付" class="btn btn-default btn-info">
                                    </form>
                                </div>
                            </td>
                        </c:if>

                    </tr>
                    </tbody>
                </c:forEach>

            </table>
        </div>
    </div>
    <%--分页插件 tld自定义标签--%>
    <div class="col-md-12 text-right" style="text-align:center">
        <p:page url="${pageContext.request.contextPath }/listOrder"/>
    </div>
</div>

<!-- 引入footer.jsp -->
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>