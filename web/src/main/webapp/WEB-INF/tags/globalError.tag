<%@ include file="/WEB-INF/jsp/include.jsp" %>

<%@ attribute name="globalError" required="true" %>

<c:if test="${not empty globalError}">
    <div class="alert alert-error fade in">
        <a class="close" data-dismiss="alert" href="#">&times;</a>
        <strong>Error!</strong> ${globalError}
    </div>
</c:if>