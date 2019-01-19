<!DOCTYPE html xmlns:th="http://www.thymeleaf.org">
<html>
<head>
    <meta charset="utf-8"/>
    <title>java</title>
    <link rel="stylesheet" href="/css/style.css"/>
</head><body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div><div class="n-head">
    <div class="g-doc f-cb">
        <#if (user ??)>
            <#if (user.username == "buyer")>
                <div class="user">
                    买家你好，<span class="name">${user.username}</span>！<a href="/logout">[退出]</a>
                </div>
                <ul class="nav">
                    <li><a href="/">首页</a></li>
                    <li><a href="/account">账务</a></li>
                    <li><a href="/settleAccount">购物车</a></li>
                </ul>
            <#else>
                <div class="user">
                    卖家你好，<span class="name">${user.username}</span>！<a href="/logout">[退出]</a>
                </div>
                <ul class="nav">
                    <li><a href="/">首页</a></li>
                    <li><a href="/public">发布</a></li>
                </ul>
            </#if>
        <#else>
            <div class="user">
                请<a href="/login">[登录]</a>
            </div>
                <ul class="nav">
                <li><a href="/">首页</a></li>
            </ul>
        </#if>
    </div>
</div><div class="g-doc">
    <div class="n-show f-cb" id="showContent">
        <div class="img"><img src="${commodity.picture}" alt="${commodity.title}" ></div>
        <div class="cnt">
            <h2>${commodity.title}</h2>
            <p class="summary">${commodity.remark}</p>
            <div class="price">
                <span class="v-unit">¥</span><span class="v-value">${commodity.price}</span>
            </div>
            <div class="num">购买数量：<span id="plusNum" class="lessNum"><a>-</a></span><span class="totalNum" id="allNum">
                <#if (commodity.isSelled == 1)>
                    ${totalNum}
                </#if>
                </span><span id="addNum" class="moreNum"><a>+</a></span></div>
            <div class="oprt f-cb">
                <#if (user ??)>
                    <#if (user.username == "seller")>
                        <a href="/edit?id=${commodity.id}" class="u-btn u-btn-primary">编 辑</a>
                    <#else>
                        <button class="u-btn u-btn-primary" id="add" data-id="${commodity.id}" data-title="${commodity.title}" data-price="${commodity.price}">
                        加入购物车
                        </button>
                        <#if (commodity.isSelled == 1)>
                            <!--<span class="u-btn u-btn-primary z-dis">已购买</span>-->
                            <span class="buyprice">当时购买价格：${price}</span>
                        <#else>
                        </#if>
                    </#if>
                </#if>
            </div>
        </div>
    </div>
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>详细信息</h2>
    </div>
    <div class="n-detail">
        ${commodity.content}
    </div>
</div>
<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div>
<script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="/js/pageShow.js"></script>
</body>
</html>