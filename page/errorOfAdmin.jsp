<%@ page contentType="text/html; charset=Shift_JIS" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="javax.servlet.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page isErrorPage="true"%>

<html>
    <head>
        <title>管理者のエラー</title>
        <jsp:include page="header.jsp" flush="true" />
    </head>
    <body>
        エラーが発生しました。
        管理者に問い合わせてください。</br>


		<% exception.printStackTrace(new java.io.PrintWriter(out)); %>

        <a href="/YDSE/top">トップページに戻る</a>

    </body>
</html>