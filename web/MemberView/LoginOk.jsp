<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2022-05-18
  Time: 오후 7:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
    int result = (Integer) request.getAttribute("result");
    if (result <= 2) { %>
        <script>
            location.href = '/sogongimms/Main.jsp';
        </script>
<%  } else if (result == 10) { %>
        <script>
            window.onload = function() {
                confirm('이미 로그인이 되어있습니다.');
                location.href = '/sogongimms/Main.jsp';
            }
        </script>
<%  } else if (result == 11) { %>
        <script>
            window.onload = function() {
                confirm('비밀번호가 틀립니다.');
                location.href = 'login';
            }
        </script>
<%  } else if (result == 12) { %>
        <script>
            window.onload = function() {
                confirm('존재하지 않는 아이디입니다.');
                location.href = 'login';
            }
        </script>
<%  } else { %>
        <script>
            window.onload = function() {
                confirm('데이터베이스 오류가 발생했습니다.');
                location.href = 'login';
            }
        </script>
<%  } %>
<html>
<head>
    <title>소공체육시설홈페이지</title>
</head>
<body>
</body>
</html>
