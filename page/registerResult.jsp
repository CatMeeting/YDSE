<%@ page language="java" contentType="text/html; charset=Shift-JIS"
    pageEncoding="Shift-JIS" import="java.util.*, vo.DeckVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>�o�^����</title>
<link rel="stylesheet" href="css/table.css">

<jsp:include page="header.jsp" flush="true" />


</head>
<body>

<p>
<c:out value="${deckNameIn}" />
��Insert�����s���܂���</br>
<c:out value="${insertResult}" />
</p>
</div>

<div id = "result">

<c:if test="${insertResult == '1'}" var="flg" />

<c:if test="${flg}" >
�f�b�L��o�^���܂���
</c:if>

<c:if test="${!flg}" >
�f�b�L�̓o�^�Ɏ��s���܂���
</c:if>

</div>

<div id = "foot">

<form method="GET" action="/YDSE/registerPage">
	 <input type="submit" value="�m�F" />
</form>

</div>

</body>
</html>