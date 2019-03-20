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
    <div class="n-result">
        <h3>发布成功！</h3>
        <p><a href="/show?id=${commodity.id}">[查看内容]</a><a href="/">[返回首页]</a></p>
    </div>
</div>
</body>
</html>