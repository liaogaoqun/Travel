<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>消息轮播</title>
    <style>
        .carousel-container {
            width: 890px;
            height: 40px;
            overflow: hidden;
            position: relative;
            border: 1px solid #ccc;
        }

        .carousel-content {
            white-space: nowrap;
            position: absolute;
            animation: scrollLeft 20s linear infinite; /* 调整动画速度和持续时间 */
        }

        .carousel-item {
            display: inline-block;
            width: 890px;
            height: 40px;
            line-height: 40px;
            text-align: center;
            background-color: #f1f1f1;
            margin-right: 10px; /* 消息之间的间距 */
            border-right: 1px solid #ddd; /* 右边框线 */
        }

        @keyframes scrollLeft {
            0% {
                transform: translateX(100%);
            }
            100% {
                transform: translateX(-100%);
            }
        }
    </style>
</head>
<body>

<div class="carousel-container">
    <div class="carousel-content" id="carousel-content">
        <div class="carousel-item">消息 1</div>
        <div class="carousel-item">消息 2</div>
        <div class="carousel-item">消息 3</div>
        <div class="carousel-item">消息 4</div>
    </div>
</div>

<script>
    document.addEventListener("DOMContentLoaded", function() {
        const carouselContent = document.getElementById('carousel-content');
        const carouselItems = carouselContent.getElementsByClassName('carousel-item');
        const totalWidth = carouselItems.length * (890 + 10); // 每条消息宽度 + 右边距

        carouselContent.style.width = `${totalWidth}px`;

        // 动态调整动画时间
        const animationDuration = 20 * carouselItems.length; // 20s 是动画总时间
        carouselContent.style.animationDuration = `${animationDuration}s`;
    });
</script>

</body>
</html>
