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
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <div class="tab">
            <ul>
                <#if (Session.SPRING_SECURITY_CONTEXT ??)>
                    <@security.authorize access="hasAnyAuthority('BUYER')" var="isAuthenticated">
                        <#if type ??>
                            <li class=""><a href="/">所有内容</a></li>
                            <li class="z-sel"><a href="/?type=1">未购买的内容</a></li>
                        <#else>
                            <li class="z-sel"><a href="/">所有内容</a></li>
                            <li class=""><a href="/?type=1">未购买的内容</a></li>
                        </#if>
                    </@security.authorize>
                <#else>
                    <li class="z-sel"><a href="/">所有内容</a></li>
                </#if>
            </ul>
        </div>
    </div>
    <div class="n-plist">
        <ul class="f-cb" id="plist">
            <#if (list??)>
                <#list list as commodity>
                    <li id="p-${commodity.id}">
                        <a href="/show?id=${commodity.id}" class="link">
                            <div class="img"><img src="${commodity.picture}" alt="${commodity.title}"></div>
                                <h3>${commodity.title}</h3>
                            <div class="price">
                                <span class="v-unit">¥</span><span class="v-value">${commodity.price}</span>
                                <#if (Session.SPRING_SECURITY_CONTEXT ??)>
                                    <#if (commodity.isSelled == 1)>
                                        <@security.authorize access="hasAnyAuthority('SELLER')" var="isAuthenticated">
                                            <span class = "v-unit-right"><b>共售出：</span><span class="v-value-right">${commodity.selledQuantity}</b></span>
                                        </@security.authorize>
                                    </#if>
                                </#if>
                            </div>
                            <#if (Session.SPRING_SECURITY_CONTEXT ??)>
                                <#if (commodity.isSelled == 1)>
                                    <@security.authorize access="hasAnyAuthority('BUYER')" var="isAuthenticated">
                                        <span class="had"><b>已购买</b></span>
                                    </@security.authorize>
                                    <@security.authorize access="hasAnyAuthority('SELLER')" var="isAuthenticated">
                                    <span class="had"><b>已售出</b></span>
                                    </@security.authorize>
                                </#if>
                            </#if>
                        </a>
                        <#if (Session.SPRING_SECURITY_CONTEXT ??)>
                            <#if (commodity.isSelled == 0)>
                                <@security.authorize access="hasAnyAuthority('SELLER')" var="isAuthenticated">
                                    <span class="u-btn u-btn-normal u-btn-xs del" data-del="${commodity.id}">删除</span>
                                </@security.authorize>
                            </#if>
                        </#if>
                    </li>
                </#list>
            </#if>
        </ul>
    </div>
</div>
<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div><script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="/js/pageIndex.js"></script>
</body>
</html>