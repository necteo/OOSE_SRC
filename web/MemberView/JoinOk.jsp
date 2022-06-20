<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%  int result = (Integer) request.getAttribute("result");
    if(result == -1) { %>
        <script>
            window.onload = function() {
                confirm('이미 존재하는 아이디입니다.');
                history.back();
            }
        </script>
<%  } else { %>
        <script>
            window.onload = function() {
                confirm('회원 등록 완료')
                location.href = '/sogongimms/Main.jsp';
            }
        </script>
<%  } %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP 게시판 웹 게시판</title>
</head>
<body>
</body>
</html>