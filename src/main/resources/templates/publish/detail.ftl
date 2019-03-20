<!DOCTYPE html xmlns:th="http://www.thymeleaf.org">
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="_csrf" content="${_csrf.token}"/>
    <title>java</title>
    <link rel="stylesheet" href="/css/style.css"/>
</head><body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div><div class="n-head">
    <div class="g-doc f-cb">
        <#if (Session.SPRING_SECURITY_CONTEXT ??)>
            <@security.authorize access="hasAuthority('BUYER')" var="isAuthenticated">
                <div class="user">
                    买家你好，<span class="name">${Session.SPRING_SECURITY_CONTEXT.authentication.principal.username}</span>！<a href="/logout">[退出]</a>
                </div>
                <ul class="nav">
                    <li><a href="/">首页</a></li>
                    <li><a href="/account">账务</a></li>
                    <li><a href="/settleAccount">购物车</a></li>
                </ul>
            </@security.authorize>
            <@security.authorize access="hasAuthority('SELLER')" var="isAuthenticated">
                <div class="user">
                    卖家你好，<span class="name">${Session.SPRING_SECURITY_CONTEXT.authentication.principal.username}</span>！<a href="/logout">[退出]</a>
                </div>
                <ul class="nav">
                    <li><a href="/">首页</a></li>
                    <li><a href="/public">发布</a></li>
                </ul>
            </@security.authorize>
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
                <#if (commodity.isSelled == 1)>${totalNum}
                </#if>
                </span><span id="addNum" class="moreNum"><a>+</a></span></div>
            <div class="oprt f-cb">
                <#if (Session.SPRING_SECURITY_CONTEXT ??)>
                    <@security.authorize access="hasAuthority('SELLER')" var="isAuthenticated">
                        <a href="/edit?id=${commodity.id}" class="u-btn u-btn-primary">编 辑</a>
                    </@security.authorize>
                    <@security.authorize access="hasAuthority('BUYER')" var="isAuthenticated">
                        <#if (commodity.isSelled == 1)>
                            <button class="u-btn u-btn-primary" id="add" data-id="${commodity.id}" data-title="${commodity.title}" data-price="${commodity.price}">
                            继续购买
                            </button>
                            <span class="buyprice">当时购买价格：${price}</span>
                        <#else>
                            <button class="u-btn u-btn-primary" id="add" data-id="${commodity.id}" data-title="${commodity.title}" data-price="${commodity.price}">
                            加入购物车
                            </button>
                        </#if>
                    </@security.authorize>
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
<script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="/js/pageShow.js"></script>
</body>
</html>