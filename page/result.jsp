<%@ page language="java" contentType="text/html; charset=Shift-JIS"
    pageEncoding="Shift-JIS" import="java.util.*, vo.DeckVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift-JIS">
<title>��������</title>

<link rel="stylesheet" href="css/table.css">

</head>
<body>

<div id = "head">
<h1><a href ="top">YDSE</a></h1>
<p>
<c:out value="${deckName}" />
�Ō������܂����B</br>
�������ʂ�
<c:out value="${deck.size()}" />
���ł�
</p>
</div>

<div id = "result">

    <c:forEach var="deckList" items="${deck}">
    	<h3>
    		<c:out value="${deckList.deckName }"/>
    	</h3>
    	<p>�f�b�L���e</p>
    </c:forEach>

</div>

<div id = "foot">
</br>

<form method="POST" action="/YDSE/top">
	 <input type="submit" value="�߂�" />
</form>
</div>
</body>
</html>