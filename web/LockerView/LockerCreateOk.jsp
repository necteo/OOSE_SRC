<%--
  Created by IntelliJ IDEA.
  User: songd
  Date: 2022-05-28
  Time: 오후 5:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8");%>
<%
    int result;

    result = (Integer) request.getAttribute("result");
    if (result == -1) { %>
        <script>
            window.onload = function() {
                confirm('이미 존재하는 번호입니다');
                history.back();
            }
        </script>
<%  } else { %>
        <script>
            window.onload = function() {
                confirm('성공');
                location.href = 'createView';
            }
        </script>
<%  } %>
<html>
<head>
    <title>Start Page</title>
</head>
<body>
</body>
</html>
