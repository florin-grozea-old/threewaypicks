<%@ include file="/WEB-INF/jsp/include.jsp" %>

<form:form class="form-horizontal" name="userForm" id="userForm" commandName="user"  method="post" action="${pageContext.request.contextPath}/admin/users/form">
    <div class="row">
        <h2>
            <div class="span4 offset1">User</div>
        </h2>

        <div class="pull-right">
            <button type="submit" class="btn btn-primary btn-large">Save</button>
            <a class="btn btn-large" href="${pageContext.request.contextPath}/admin/users">Cancel</a>
        </div>

        <div class="span10 offset1">
            May the force be with this one
        </div>
        <div class="span10 offset1">&nbsp</div>

    </div>


    <c:set var="globalError"><form:errors /></c:set>
    <threewaypicks:globalError globalError="${globalError}"/>

    <%--bet header--%>
    <div class="row">
        <div class="span10 well offset1">
            <fieldset>
                <div class="control-group span10">
                    <label class="control-label" for="userName">User</label>
                    <div class="controls">
                        <form:input path="userName" type="text" class="span2" id="userName"/>
                        <form:errors path="userName" class="help-inline"/>
                        <span class="btn btn-info" disabled="disabled" id="jsVerifyUserName">verify</span>
                    </div>
                </div>
                <div class="control-group span10">
                    <label class="control-label" for="password">Password</label>
                    <div class="controls">
                        <form:input path="password" type="password" class="span4" id="password"/>
                        <form:errors path="password" class="help-inline"/>
                    </div>
                </div>
                <div class="control-group span10">
                    <label class="control-label" for="checkPassword">Repeat Password</label>
                    <div class="controls">
                        <form:input path="checkPassword" type="password" class="span4" id="checkPassword"/>
                        <form:errors path="checkPassword" class="help-inline"/>
                    </div>
                </div>
                <div class="control-group span10">
                    <label class="control-label" for="email">Email</label>
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-envelope"></i></span>
                            <form:input path="email" type="text" class="span3" id="email"/>
                            <form:errors path="email" class="help-inline"/>
                        </div>
                        <span class="btn btn-info" disabled="disabled" id="jsVerifyEmail">verify</span>

                    </div>
                </div>
                <div class="control-group span10">
                    <label class="control-label" for="checkEmail">Repeat Email</label>
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-envelope"></i></span>
                            <form:input path="checkEmail" type="text" class="span3" id="checkEmail"/>
                        </div>
                        <form:errors path="checkEmail" class="help-inline"/>
                    </div>
                </div>
                <div class="control-group span10">
                    <label class="control-label" for="formRoles">Roles</label>
                    <div class="controls">
                        <form:input path="formRoles" type="text" class="span4" id="formRoles"/>
                        <form:errors path="formRoles" class="help-inline"/>
                        <span class="help-block">TRIAL TIPSTER ADMIN</span>
                    </div>
                </div>
            </fieldset>
        </div>
    </div><%--bet header--%>


    <c:forEach var="pick"  varStatus="count" items="${bet.pickList}">
        <threewaypicks:pickForm pickContainer="pickList" index="${count.index}"/>
    </c:forEach>

</form:form>