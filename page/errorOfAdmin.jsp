<%@ page contentType="text/html; charset=Shift_JIS" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="javax.servlet.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page isErrorPage="true"%>

<html>
    <head>
        <title>�Ǘ��҂̃G���[</title>
        <jsp:include page="header.jsp" flush="true" />
    </head>
    <body>
        �G���[���������܂����B
        �Ǘ��҂ɖ₢���킹�Ă��������B</br>


		<% exception.printStackTrace(new java.io.PrintWriter(out)); %>

        <a href="/YDSE/top">�g�b�v�y�[�W�ɖ߂�</a>

    </body>
</html>