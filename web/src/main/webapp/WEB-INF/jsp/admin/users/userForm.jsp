<%@ include file="/WEB-INF/jsp/include.jsp" %>

<form:form class="form-horizontal" name="userForm" id="userForm" commandName="user"  method="post" action="${pageContext.request.contextPath}/admin/users/form">
    <div class="row">
        <h2>
            <div class="span4 offset1">User</div>
        </h2>

        <div class="pull-right">
            <button type="submit" class="btn btn-primary btn-large">Save</button>
            <button class="btn btn-large">Cancel</button>
        </div>

        <div class="span10 offset1">
            User form...
        </div>
        <div class="span10 offset1">&nbsp</div>

    </div>


    <%--Global errors--%>
    <c:if test="${org.springframework.validation.BindingResult.user}==0">
        <div class="alert alert-error fade in">
            <a class="close" data-dismiss="alert" href="#">&times;</a>
            <strong>Error!</strong> Best check yo self, you're not looking too good.
        </div>
    </c:if>

    <form:errors />

    <%--bet header--%>
    <div class="row">
        <div class="span10 well offset1">
            <fieldset>
                <div class="control-group span10">
                    <label class="control-label" for="userName">User</label>
                    <div class="controls">
                        <form:input path="userName" type="text" class="span2" id="userName"/>
                        <form:errors path="userName" class="help-inline"/>
                    </div>
                </div>
                <div class="control-group span10">
                    <label class="control-label" for="password">Password</label>
                    <div class="controls">
                        <form:input path="password" type="text" class="span4" id="password"/>
                        <form:errors path="password" class="help-inline"/>
                    </div>
                </div>
                <div class="control-group span10">
                    <label class="control-label" for="checkPassword">Repeat Password</label>
                    <div class="controls">
                        <form:input path="checkPassword" type="text" class="span4" id="checkPassword"/>
                        <form:errors path="checkPassword" class="help-inline"/>
                    </div>
                </div>
                <div class="control-group span10">
                    <label class="control-label" for="email">Email</label>
                    <div class="controls">
                        <form:input path="email" type="text" class="span3" id="email"/>
                        <form:errors path="email" class="help-inline"/>
                    </div>
                </div>
                <div class="control-group span10">
                    <label class="control-label" for="checkEmail">Repeat Email</label>
                    <div class="controls">
                        <form:input path="checkEmail" type="text" class="span3" id="checkEmail"/>
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