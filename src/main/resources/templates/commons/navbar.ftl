<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Pets Shop</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <#if user??>
            <li class="nav-item">
                <a class="nav-link" href="/main">All animals</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user-animals/${currentUserId}">My animals</a>
            </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3"><#if user??>${name}<#else>Login, please</#if></div>
        <@l.logout />

    </div>
</nav>