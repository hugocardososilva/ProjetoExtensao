<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<c:if test="${sessionScope.condomino == null }">
<c:redirect url="/index.jsp"></c:redirect>
</c:if>
