<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<c:if test="${sessionScope.admin == null }">
<c:redirect url="/admin/login-redirect.jsp"/>
</c:if>
