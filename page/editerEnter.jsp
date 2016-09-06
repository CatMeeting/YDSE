<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>

<jsp:include page="header.jsp" flush="true" />
<title>新規デッキ登録ページ</title>

<script type="text/javascript">
function check(){
	if (document.getElementById("deckNameUp").value == "") {
    	//全て未入力だったら、エラーメッセージを表示する
    	document.getElementById("errorMessage").innerHTML = "何か入力してください";
    	return false;
    }
}
//全部の要素をクリア
function clearFormAll(f) {
	for (var i=0;i<f.length;i++){
		if(f[i].type=="text") f[i].value="";
	}
}
</script>

</head>
<body>

<c:out value="${deckNameUp}" />を変更します。</br>

<h2>変更後の情報を入力してください</h2>

<div style="color:red;" id="errorMessage">
</div>
<form method="POST" action="/YDSE/update" onSubmit="return check()">
	<input type = "hidden" value="編集" name ="button"/>
	<input type = "hidden" value="${listNum}" name="listNum">
<table border="0">
  <tr>
    <th align="right">デッキ名：</th>
    <td><input type="text" name="deckNameUp" id="deckNameUp" size="40" maxlength="20" value="${deckNameUp}" /></td>
  </tr>
  <tr>
    <td align="center" colspan="2">
      <input type="button" value="クリア" onClick="clearFormAll(this.form)" />
      <input type="submit" value="登録" />
    </td>
  </tr>
</table>
</form>


</body>
</html>