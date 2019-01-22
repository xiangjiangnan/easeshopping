<!DOCTYPE html xmlns:th="http://www.thymeleaf.org">
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="_csrf" content="${_csrf.token}"/>
    <title>java</title>
    <link rel="stylesheet" href="/css/style.css"/>
</head><body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div><div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
            卖家你好，<span class="name">${Session.SPRING_SECURITY_CONTEXT.authentication.principal.username}</span>！<a href="/logout">[退出]</a>
        </div>
        <ul class="nav">
            <li><a href="/">首页</a></li>
            <li><a href="/public">发布</a></li>
        </ul>
    </div>
</div><div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>内容发布</h2>
    </div>
    <div class="n-public">
        <form class="m-form m-form-ht" id="form" method="post" action="/publicSubmit" onsubmit="return false;" autocomplete="off">
            <input type = "hidden" name = "${_csrf.parameterName}"  value = "${_csrf.token}" />
            <div class="fmitem">
                <label class="fmlab">标题：</label>
                <div class="fmipt">
                    <#if (commodity ??)>
                        <input class="u-ipt ipt" name="title" id = "title" value = "${commodity.title}" autofocus placeholder="2-80字符"/>
                    <#else>
                        <input class="u-ipt ipt" name="title" autofocus placeholder="2-80字符"/>
                    </#if>
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">摘要：</label>
                <div class="fmipt">
                    <#if (commodity ??)>
                        <input class="u-ipt ipt" name="summary" id = "summary" value = "${commodity.remark}" placeholder="2-140字符"/>
                    <#else>
                        <input class="u-ipt ipt" name="summary" id = "summary" placeholder="2-140字符"/>
                    </#if>
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">图片：</label>
                <div class="fmipt" id="uploadType">
                    <input name="pic" type="radio" value="url" checked /> 图片地址
                    <input name="pic" type="radio" value="file" /> 本地上传
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab"></label>
                <div class="fmipt" id="urlUpload">
                    <input class="u-ipt ipt"  name="image" placeholder="图片地址"/>
                </div>
                <div class="fmipt" id="fileUpload"  style="display:none">
                    <input class="u-ipt ipt" name="file" type="file" id="fileUp"/>
                    <button class="u-btn u-btn-primary" id="upload">上传</button>
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">正文：</label>
                <div class="fmipt">
                    <#if (commodity ??)>
                        <textarea class="u-ipt" name="detail" id= "detail" rows="10" placeholder="2-1000个字符">${commodity.content}</textarea>
                    <#else>
                        <textarea class="u-ipt" name="detail" id= "detail" rows="10" placeholder="2-1000个字符"></textarea>
                    </#if>
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">价格：</label>
                <div class="fmipt">
                    <#if (commodity ??)>
                        <input class="u-ipt price" id= "price" value= "${commodity.price}" name="price"/>元
                    <#else>
                        <input class="u-ipt price" id= "price" name="price"/>元
                    </#if>
                </div>
            </div>
            <div class="fmitem fmitem-nolab fmitem-btn">
                <div class="fmipt">
                    <button type="submit" class="u-btn u-btn-primary u-btn-lg">发 布</button>
                </div>
            </div>
        </form>
        <span class="imgpre"><img src="" alt="" id="imgpre"></span>
    </div>
</div>
<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div>
<script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="/js/public.js"></script>
</body>
</html>