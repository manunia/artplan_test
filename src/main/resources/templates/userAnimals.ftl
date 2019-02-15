<#import "commons/common.ftl" as c>

<@c.page>
<#if isCurrentUser>
    <#include "commons/editAnimal.ftl" />
</#if>

<#include "commons/animalsList.ftl" />

</@c.page>