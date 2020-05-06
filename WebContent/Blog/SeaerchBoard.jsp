<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
<c:forEach items="${arrList }" var="arr">
<tr>
	<td>${arr.filename }</td>
	<td>${arr.title }</td>
	<td>${arr.description }</td>
	<td>${arr.writer }</td>
</tr>
</c:forEach>
</table>