<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <ul>
            <#list users as user>
                <li>${user.name} ${user.surname} ${user.email}</li>
            </#list>
        </ul>
    </body>
</html>