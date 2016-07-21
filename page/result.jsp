<%@ page language="java" contentType="text/html; charset=Shift-JIS"
    pageEncoding="Shift-JIS" import="java.util.*, vo.DeckVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift-JIS">
<title>検索結果</title>


</head>
<body>

<c:out value="${deckName}" />
で検索しました。</br>
検索結果は
<c:out value="${deck.size()}" />
件です

<table border=1>

    <c:forEach var="deckList" items="${deck}">
    	<tr><td>
    		<c:out value="${deckList.deckName }"/>
    	</td></tr>
    </c:forEach>

</table>


<a href ="top">トップへ戻る</a>

</body>
</html>