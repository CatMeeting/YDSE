<%@ page language="java" contentType="text/html; charset=Shift-JIS"
    pageEncoding="Shift-JIS" import="java.util.*, vo.DeckVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>登録結果</title>
<link rel="stylesheet" href="css/table.css">

<jsp:include page="header.jsp" flush="true" />


</head>
<body>

<p>
<c:out value="${deckNameIn}" />
でInsertを実行しました</br>
<c:out value="${insertResult}" />
</p>
</div>

<div id = "result">

<c:if test="${insertResult == '1'}" var="flg" />

<c:if test="${flg}" >
デッキを登録しました
</c:if>

<c:if test="${!flg}" >
デッキの登録に失敗しました
</c:if>

</div>

<div id = "foot">

<form method="GET" action="/YDSE/registerPage">
	 <input type="submit" value="確認" />
</form>

</div>

</body>
</html>