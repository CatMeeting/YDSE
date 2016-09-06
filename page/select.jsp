<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="header.jsp" flush="true" />
<title>編集用ページ</title>

<script type="text/javascript">
function check(){

    if (window.confirm('実行しますか？')) {
        document.frm.submit();
    } else {
        return false;
    }
}
</script>


</head>
<body>

<p>

<c:choose>
	<c:when test="${button == '編集'}">デッキを編集しました</c:when>
	<c:when test="${button == '削除'}">デッキを削除しました</c:when>
	<c:otherwise>
		<c:out value="${deckName}" />で検索しました。</br>
		検索結果は<c:out value="${deckList.size()}" />件です
	</c:otherwise>
</c:choose>

</p>


<div id = "result">

    <c:forEach var="deckList" items="${deckList}" varStatus="status">
    	<h3>
    		・<c:out value="${deckList.deckName }"/>
    	</h3>

		<form method="POST" action="/YDSE/editEnter">
			 <input type="submit" value="編集" name="button"/>
			 <input type="hidden" value="${deckList.deckID}" name="listNum">
			 <input type="hidden" value="${deckList.deckName}" name="deckNameUp">
		</form>
		<form method="POST" action="/YDSE/update" onSubmit="return check()">
			 <input type="submit" value="削除" name="button"/>
			 <input type="hidden" value="${deckList.deckID}" name="listNum">
		</form>

    	<p>登録番号＝<c:out value="${deckList.deckID}"/></p>
    </c:forEach>

</div>

<div id = "foot">


<form method="POST" action="/YDSE/edit">
	 <input type="submit" value="戻る" />
</form>
</div>

</body>
</html>