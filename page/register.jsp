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
	if (document.getElementById("deckNameIn").value == "") {
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

<h2>
<a href="top">・トップページへ</a>
<a href="edit">・編集ページへ</a>
</h2>

<h2>追加したい情報を入力してください</h2>

<div style="color:red;" id="errorMessage">
</div>
<form method="POST" action="/YDSE/insert" onSubmit="return check()">

<table border="0">
  <tr>
    <th align="right">デッキ名：</th>
    <td><input type="text" name="deckNameIn" id="deckNameIN" size="40" maxlength="20" value="${deckNameIn}" /></td>
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