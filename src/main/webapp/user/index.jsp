<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>红色旅游</title>
    <link rel="shortcut icon" href="../image/logo1.png" type="../image/x-icon"/>
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css"/>
    <link href="../css/styles.css" rel="stylesheet" type="text/css"/>
    <link href="../css/common.css" rel="stylesheet" type="text/css"/>
    <script src="../js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
</head>
<style>
    .my-custom-btn {
        color: grey; /* 设置按钮文本颜色为灰色 */
    }

</style>
<body>
<style>
    .my-custom-btn {
        color: grey; /* 设置按钮文本颜色为灰色 */
    }

    .newMove-title {
        float: left;
        font-size: 14px;
        color: #ffffff;
        width: 80px;
        text-align: center;
        /*margin: 0px auto;*/
        margin-top: 0px;
        padding: 5px 5px 5px 5px;
        border-left: 1px solid #aaaaaa;
        border-top: 1px solid #aaaaaa;
        border-bottom: 1px solid #aaaaaa;
        background-color: rgba(179, 16, 15, 1);
        height: 30px;
        line-height: 22px;
    }

    .newDiv {
        width: 980px;
        margin: 0 auto;
    }

    .body {
        /*width: 1000px;*/
        /*margin: 0 auto;*/
        width: 893px;
        height: 30px;
        margin-top: 0px;
        overflow: hidden;
        position: relative;
        border: 1px solid #ccc;
        float: right;

    }

    .newMove-body {

        white-space: nowrap;
        position: absolute;
        animation: scrollLeft 50s linear infinite; /* 调整动画速度和持续时间 */
    }

    .newMove-manage {
        display: inline-block;
        width: 400px;
        height: 30px;
        font-size: 18px;
        font-weight: bold;
        line-height: 30px;
        text-align: center;
        /*background-color: #f1f1f1;*/
        margin-right: 10px; /* 消息之间的间距 */
        /*border-right: 1px solid #ddd; !* 右边框线 *!*/
    }

    @keyframes scrollLeft {
        0% {
            transform: translateX(100%);
        }
        100% {
            transform: translateX(-100%);
        }
    }

    .z-da4 {
        padding-left: 9px;
    }

    .stop {
        height: 40px;
        overflow: hidden;
        margin-bottom: 15px;
        width: 100%;
        height: 40%;
        background: #fcf7e4;
        box-shadow: 0px 8px 23px 1px rgba(0, 0, 0, 0.26);
    }

    .day1 {
        overflow: hidden;
    }

    .day1 p {
        height: 64px;
        overflow: hidden;
    }

    .z-da4 ul li {
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }

    .z-da4 ul li a {
        color: #010101;
        font-size: 15px;
        line-height: 35px;
    }

    .stop h1 {
        font-size: 19px;
        font-family: "Microsoft Yahei";
        color: #B3100f;
        line-height: 42px;
        margin-left: 20px;
        float: left;
        cursor: pointer;
    }

    .stop a {
        font-size: 12px;
        font-family: "Microsoft Yahei"
        color: rgba(95, 95, 95, 1);
        line-height: 42px;
        float: right;
        margin-right: 10px;
    }

    .day1 p a {
        font-size: 14px;
        color: #010101;
        word-break: break-all;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 3;
        overflow: hidden;
        text-align: justify;
        margin-top: 5px;
    }

    .day1 p {
        height: 64px;
        overflow: hidden;
    }

    .day1 hr {
        color: #BBC2CF;
    }

    .day1 a h1 {
        color: rgba(179, 16, 15, 1);
    }

    .day1 img {
        width: 133px;
        height: 84px;
        float: left;
        margin-right: 5px;
    }

    .day1 h1 {
        font-size: 15px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }
</style>
<div class="container-fluid">
    <!-- 引入header.jsp -->
    <jsp:include page="header.jsp"></jsp:include>
    <%--滚动新闻--%>
    <div class="newDiv">
        <%--滚动新闻--%>
        <div class="newMove-title">
            滚动新闻
        </div>
        <div class="body">
            <%--<div class="newMove-title">
                滚动新闻
            </div>--%>
            <div class="newMove-body " id="newMove-body ">
                <a class="newMove-manage" href="../html/story1.html" target="_blank">· 看图学习丨保护好运用好红色资源
                    总书记有深意</a>
                <a class="newMove-manage" href="../html/story2.html" target="_blank">·
                    习近平考察的这所学校，是中国革命的“红色摇篮”</a>
                <a class="newMove-manage" href="../html/story3.html" target="_blank">· 用好红色资源 传承红色基因</a>
                <a class="newMove-manage" href="../html/story4.html" target="_blank">·
                    把自然风光和人文风情转化为旅游业的持久魅力</a>
                <a class="newMove-manage" href="../html/story5.html" target="_blank">· 传承红色基因 守好红色江山</a>
            </div>
        </div>
    </div>
    <div>
        <br/><br/>
    </div>
    <!-- 轮播图 -->
    <div class="container-fluid">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- 轮播图的中的小点 -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0"
                    class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>
            <!-- 轮播图的轮播图片 -->
            <div class="carousel-inner" role="listbox">
                <div class="item active" style="height:400px;">
                    <a href="../html/bdstory1.html" target="_blank">
                        <img src="../image/轮换图1.png">
                    </a>
                    <div class="carousel-caption">
                        <!-- 轮播图上的文字 -->
                        <%--<img src="../image/lbw.png">--%>
                        <a href="../html/bdstory1.html" target="_blank"
                           style="margin-left: 0px;color:white;font-size: 40px;">
                            创新文旅融合传承红色文化
                        </a>
                    </div>
                </div>

                <div class="item" style="height:400px;">
                    <a href="../html/bdstory2.html" target="_blank">
                        <img src="../image/轮换图2.png">
                    </a>
                    <div class="carousel-caption">
                        <!-- 轮播图上的文字 -->
                        <%--<img src="../image/lbw.png">--%>
                        <a href="../html/bdstory2.html" target="_blank"
                           style="margin-left: 0px;color:white;font-size: 40px;">
                            讲好有温度有特色的红色故事
                        </a>
                    </div>
                </div>
                <div class="item" style="height:400px;">
                    <a href="../html/bdstory3.html" target="_blank">
                        <img src="../image/轮换图3.png">
                    </a>
                    <div class="carousel-caption">
                        <!-- 轮播图上的文字 -->
                        <%--<img src="../image/lbw.png">--%>
                        <a href="../html/bdstory3.html" target="_blank"
                           style="margin-left: 0px;color:white;font-size: 40px;">
                            用心用情讲述好英烈故事
                        </a>
                    </div>
                </div>
            </div>

            <!-- 上一张 下一张按钮 -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button"
               data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button"
               data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>


    <!-- 景点门票 -->
    <div class="container-fluid" style="padding-left: 0px">
        <div class="col-md-12" style="height:20px;">
        </div>
        <%--景点前三名列表--%>
        <div class="col-md-8" style="width:1030px; padding-left: 0px">
            <div class="mf_box">
                <div class="mf_tit clearfix" style="background-color: #fbf7e6">
                    <span>景点预约</span>
                </div>
                <%--下面是固定的数据，需要从数据库查--%>
                <div class="js_wrap claerdix">
                    <p>&nbsp;</p>
                    <c:forEach items="${list}" var="scenic">
                        <div class="js_con clearfix">
                            <div class="js_l">
                                <a href="#"><img src="../${scenic.img}"></a>
                            </div>
                            <div class="js_c">
                                <p>
                                    <b>【${scenic.name}】</b>
                                </p>
                                <p>&nbsp;&nbsp;<font style="color: #9d9d9d">景点主题：</font>
                                        ${scenic.theme}</p>
                                <p>&nbsp;&nbsp;<font style="color: #9d9d9d">景点地址：</font>
                                        ${scenic.address}</p>
                                <p>&nbsp;&nbsp;<font style="color: #9d9d9d">景点特色：</font>
                                        ${scenic.message}</p>
                                <p>&nbsp;&nbsp;<font style="color: #9d9d9d">景点热度：</font>
                                        ${scenic.hot}</p>
                            </div>
                            <c:choose>
                                <c:when test="${scenic.state==1}">
                                    <div class="js_r">
                                        <p>&nbsp;</p>
                                            <%--                                        <p>--%>
                                            <%--                                            <span class="fn_o">已售</span><b>${scenic.sales}</b>--%>
                                            <%--                                            <span class="fn_o">张</span>--%>
                                            <%--                                        </p>--%>
                                        <a href="${pageContext.request.contextPath }/getScenicTById?id=${scenic.id}"
                                           class="btn btn-default btn-info">查看预约</a>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="js_r">
                                        <a class="btn btn-default btn-info my-custom-btn">暂未开放</a>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="col-md-4 column" style="width:260px;">
            <div class="clumn" style="width:260px;border:1px solid #E8E8E8">
                <div class="clumn_tit t01" style="background-color: #fbf7e6">
                    <span>全国红色景点地区</span>
                </div>
                <div class="clumn _con" >
                    <ul class="clu_ul page_ul">
                        <li style="height: 3px"><a href="#" style="height: 3px">&nbsp;</a></li>
                        <li>
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=新市区">新市区</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=北市区">北市区</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=南市区">南市区</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=满城县">满城县</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=清苑县">清苑县</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=涞水县">涞水县</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=阜平县">阜平县</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=徐水县">徐水县</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=定兴县">定兴县</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=高阳县">高阳县</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=容城县">容城县</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=来源县">涞源县</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=望都县">望都县</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=安新县">安新县</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=曲阳县">曲阳县</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=易县">易县</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=博野县">顺平县</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=新市区">博野县</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=涿州市">涿州市</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=蠡县">蠡县</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=定州市">定州市</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=安国市">安国市</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=高碑店">高碑店</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=雄县">雄县 </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-md-4 column" style="width:260px;border:1px solid #E8E8E8">

            </div>
        </div>
    </div>
    <br/>
    <br/>
    <br/>
    <%--专题报告--%>
    <div class="z-da4">
        <div class="stop">
            <h1>专题报道</h1>
            <a href="https://www.redtourism.com.cn/ztch/node_510.html">更多&gt;&gt;</a>

        </div>

        <div class="day1">
            <a href="http://www.redtourism.com.cn/ztch/node_1811.html" target="_blank"> <img
                    src="http://www.redtourism.com.cn/ztch/pic/2023-06/29/144466_467f2772-9214-452d-85f2-59d4e8c8ab58.png"></a>
            <a href="http://www.redtourism.com.cn/ztch/node_1811.html" target="_blank"><h1>【专题】红色旅游融合发展重实践
                革命老区再建新功展风采</h1></a>
            <p><a href="http://www.redtourism.com.cn/ztch/node_1811.html" target="_blank">为贯彻党的二十大关于“用好红色资源”“传承红色基因、赓续红色血脉”的部署要求，文化和旅游部启动了全国红色旅游融合发展试点建设工作，并于去年12月发布了10家全国红色旅游融合发展试点单位名单。经过半年多的创新实践，试点单位在融合发展建设中都做了哪些工作？成效如何？本专题对各试点单位的工作实效进行综合报道。</a>
            </p>
            <hr>
        </div>
        <div class="day1">
            <a href="http://www.redtourism.com.cn/ztch/node_1453.html" target="_blank"> <img
                    src="http://www.redtourism.com.cn/ztch/pic/2022-05/11/123604_t1_(6X0X600X334)3e08cb83-ee27-44c2-a63d-53a7759f1dc2.png"></a>
            <a href="http://www.redtourism.com.cn/ztch/node_1453.html" target="_blank"><h1>
                【专题】聚焦长征国家文化公园建设</h1></a>
            <p><a href="http://www.redtourism.com.cn/ztch/node_1453.html" target="_blank">长征是人类历史上的伟大壮举，是20世纪最能影响世界前途的重要事件之一。通过长征国家文化公园建设，整合长征沿线具有突出意义、重要影响、重大主题的文物和文化资源，对于充分用好红色资源，发扬红色传统，传承红色基因，具有重大而深远的意义。自长征国家文化公园建设工作启动以来，沿线各省份落实落细各项要求，组织编制有关规划，推动实施文旅融合工程，充分利用红色资源讲好长征故事，着力将长征国家文化公园建设成为呈现长征文化，弘扬长征精神，赓续红色血脉的精神家园。</a>
            </p>
            <hr>
        </div>
        <div class="day1">
            <a href="http://www.redtourism.com.cn/ztch/node_1371.html" target="_blank"> <img
                    src="http://www.redtourism.com.cn/ztch/pic/2022-01/18/118029_t1_(0X0X600X338)608f4eb6-b1bb-452d-b329-048d41639085.jpg"></a>
            <a href="http://www.redtourism.com.cn/ztch/node_1371.html" target="_blank"><h1>
                【专题】“红色文旅年华”访谈录</h1></a>
            <p><a href="http://www.redtourism.com.cn/ztch/node_1371.html" target="_blank">为庆祝中国共产党成立100周年，文化和旅游部机关党委、离退休干部局联合策划推出“红色文旅年华”访谈活动。活动邀请文化和旅游部机关、直属单位离退休党员干部代表，作为历史的见证者和参与者进行访谈，呈现文化和旅游事业的重大历史事件、重要决策部署、重点发展变化，回顾奋进历程、总结发展经验，大力唱响共产党好、社会主义好、改革开放好、伟大祖国好、各族人民好的时代主旋律。</a>
            </p>
            <hr>
        </div>
        <div class="day1">
            <a href="http://www.redtourism.com.cn/ztch/node_1286.html" target="_blank"> <img
                    src="http://www.redtourism.com.cn/ztch/pic/2021-11/10/114767_t1_(0X0X599X337)db06305d-3b6c-4ee1-89f8-c2293df07b75.jpg"></a>
            <a href="http://www.redtourism.com.cn/ztch/node_1286.html" target="_blank"><h1>红星照耀百年路
                数字文旅新征程</h1></a>
            <p><a href="http://www.redtourism.com.cn/ztch/node_1286.html" target="_blank">专题聚合国内多个红色旅游目的地发展成功经验，以企业为桥梁，从行业角度汇总红色旅游发展模型，为各地红色旅游目的地发展、融合、转型、升级提供可行性参考意见，助力红色旅游高质量发展。</a>
            </p>
            <hr>
        </div>


        <ul>

            <li><a href="http://www.redtourism.com.cn/ztch/node_2004.html"
                   target="_blank">【专题】第四届全国红色故事讲解员大赛</a></li>
            <li><a href="http://www.ctnews.com.cn/zt/node_1335.html"
                   target="_blank">【专题】学习宣传贯彻十九届六中全会精神</a></li>
            <li><a href="http://www.redtourism.com.cn/ztch/node_1496.html"
                   target="_blank">【专题】红色讲解员进校园活动</a></li>
            <li><a href="http://www.redtourism.com.cn/ztch/node_1298.html "
                   target="_blank">【专题】“建党百年红色旅游精品线路”广西采风活动</a></li>

        </ul>
    </div>

</div>
</div>

<!-- 热门推荐 -->
<div class="clumn"
     style="width:1280px;border:1px solid #E8E8E8;margin-top: 30px;margin-left: 15px">
    <div class="clumn_tit t01" style="background-color: #fbf7e6">
        <span>红色美食推荐</span><a
            href="${pageContext.request.contextPath }/getFoodPageForUser">更多</a>
    </div>
    <div class="container-fluid" style="padding-top: 15px">
        <%--下面是固定的数据，需要从数据库查--%>
        <div class="col-md-12">
            <c:forEach items="${listFood}" var="food">
                <div class="col-md-4 column">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="thumbnail">
                                <img alt="index_discount_hangzhoutotai"
                                     src="../${food.img}"/>
                                <div class="caption">
                                    <p>
                                        <b>【${food.name}】</b>
                                    </p>
                                    <p>&nbsp;&nbsp;<font
                                            style="color: #9d9d9d">美食介绍：</font>
                                            ${food.message}</p>
                                    <p>&nbsp;&nbsp;<font
                                            style="color: #9d9d9d">推荐餐馆：</font>
                                            ${food.address}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<!-- 井冈山宣传图 -->
<div class="container-fluid" style="margin-top:30px;">
    <img src="../image/过场图.png" width="100%"/>
</div>
<!-- 引入footer.jsp -->
<jsp:include page="footer.jsp"></jsp:include>
</div>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        const carouselContent = document.getElementById('newMove-body');
        const carouselItems = carouselContent.getElementsByClassName('newMove-manage');
        const totalWidth = carouselItems.length * (893 + 10); // 每条消息宽度 + 右边距

        carouselContent.style.width = `${totalWidth}px`;

        // 动态调整动画时间
        const animationDuration = 50 * carouselItems.length; // 20s 是动画总时间
        carouselContent.style.animationDuration = `${animationDuration}s`;
    });
</script>
</body>
</html>