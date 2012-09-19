<%@ include file="/WEB-INF/jsp/include.jsp" %>

<%@ attribute name="link" required="true" %>
<%@ attribute name="spanClasses" required="true" %>
<%@ attribute name="iconClasses" required="true" %>
<%@ attribute name="text" required="true" %>

<a href="${pageContext.request.contextPath}/${link}">
   <span class="label ${spanClasses}"> <i class="${iconClasses}"></i> ${text} </span>
</a>
