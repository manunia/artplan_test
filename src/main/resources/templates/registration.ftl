<#import "commons/common.ftl" as c>
<#import "commons/login.ftl" as l>
<@c.page>

<h5 class="mb-1">Add new user</h5>
<div class="alert-warning">
    ${message?ifExists}
</div>
<@l.login "/registration" true/>
</@c.page>