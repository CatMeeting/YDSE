<%@ page language="java" contentType="text/html; charset=Shift-JIS"
    pageEncoding="Shift-JIS" import="java.util.*, vo.DeckVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift-JIS">
<title>��������</title>


</head>
<body>

<c:out value="${deckName}" />
�Ō������܂����B</br>
�������ʂ�
<c:out value="${deck.size()}" />
���ł�

<table border=1>

    <c:forEach var="deckList" items="${deck}">
    	<tr><td>
    		<c:out value="${deckList.deckName }"/>
    	</td></tr>
    </c:forEach>

</table>


<a href ="top">�g�b�v�֖߂�</a>

</body>
</html>