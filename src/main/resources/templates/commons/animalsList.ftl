<#include "security.ftl">

<h5 class="mb-1">Список животных</h5>

<#list animals?ifExists as animal>
<div class="card">
    <div class="card-body">
        <span>Имя животного: ${animal.name}</span><br>
        <i>Тип животного: ${animal.type}</i><br>
        <span>Пол: ${animal.gender}</span><br>
        <span>Дата рождения животного: ${animal.birthDate}</span><br>
        <strong>Имя владельца: ${animal.ownerName}</strong><br>
        <#if animal.owner.id == currentUserId>
            <a class="btn btn-info ml-2" href="/user-animals/${animal.owner.id}?animal=${animal.id}">
                Edit
            </a>

            <button class="btn btn-info ml-2" type="submit" value="/user-animals/${animal.owner.id}?animal=${animal.id}">X</button>
        </#if>
    </div>
</div>
<#else>
No any animal
</#list>