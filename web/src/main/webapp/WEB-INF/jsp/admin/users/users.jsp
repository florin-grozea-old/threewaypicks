<%@ include file="/WEB-INF/jsp/include.jsp" %>

<table class="table table-condensed">


    <thead>
    <tr>
        <th>#</th>
        <th>User</th>
        <th>E-mail</th>
        <th>Roles</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td class="span2">${user.id}</td>
            <td class="span2">${user.userName}</td>
            <td class="span2">${user.email}</td>
            <td class="span2">${user.roles}</td>
            <td class="span1"></td>
        </tr>
    </c:forEach>
    </tbody>
</table>