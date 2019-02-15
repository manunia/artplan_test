<#import "commons/common.ftl" as c>

<@c.page>

<h5 class="mb-1">Поиск</h5>

<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" class="form-inline" action="/main">
            <input type="text" name="filter" value="${filter?ifExists}">
            <button class="btn btn-info ml-2" type="submit">Найти</button>
        </form>
    </div>
</div>

<#include "commons/editAnimal.ftl" />
<#include "commons/animalsList.ftl" />
</@c.page>