<%@ include file="/WEB-INF/jsp/include.jsp" %>

<%@ attribute name="link" required="true" %>
<%@ attribute name="ahrefClasses" required="true" %>
<%@ attribute name="iconClasses" required="true" %>
<%@ attribute name="text" required="true" %>

<a class="label ${ahrefClasses}" href="${pageContext.request.contextPath}/${link}">
   <span> <i class="${iconClasses}"></i> ${text} </span>
</a>
