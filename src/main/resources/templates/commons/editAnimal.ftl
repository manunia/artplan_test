<h5 class="mb-1">Editor</h5>
<div class="alert-warning">
    ${message?ifExists}
</div>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="post">
            <input type="text" class="form-control my-2" name="name" placeholder="имя животного">
            <input type="text" class="form-control my-2" name="type" placeholder="тип животного">
            <select class="form-control my-2" name="gender">
                <option selected disabled>пол</option>
                <option value="м">м</option>
                <option value="ж">ж</option>
            </select>
            <input class="form-control my-2" type="date" name="birthDate" placeholder="дата рождения животного">
            <input class="form-control my-2" type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input class="form-control my-2" type="hidden" name="id" value="<#if animal??>${animal.id}</#if>"/>
            <button class="btn btn-info my-2" type="submit">Сохранить</button>
        </form>
    </div>
</div>