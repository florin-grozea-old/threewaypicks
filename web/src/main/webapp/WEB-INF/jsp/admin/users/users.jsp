<%@ include file="/WEB-INF/jsp/include.jsp" %>

<h2>
    <div class="span4 offset1">User</div>

</h2>

<div class="pull-right">
    <a class="btn btn-large btn-primary" href="${pageContext.request.contextPath}/admin/users/form">Add new</a>
</div>

<div class="span10 offset1">
    all users around here.
</div>
<div class="span10 offset1">&nbsp</div>

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
            <td class="span1">
                <threewaypicks:actionLabel link="#" spanClasses="label-info" iconClasses="icon-pencil icon-white" text="edit"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>