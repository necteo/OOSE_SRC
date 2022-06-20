<%--
  Created by IntelliJ IDEA.
  User: S
  Date: 2022-06-08
  Time: 오후 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int result = (Integer) request.getAttribute("result");

    if (result == -1) { %>
        <script>
            window.onload = function() {
                confirm('실패');
                history.back();
            }
        </script>
<%  } else { %>
        <script>
            window.onload = function() {
                confirm('성공');
                location.href = "listView";
            }
        </script>
<%  } %>
<html>
  <head>
    <title>강습 등록 확인</title>
  </head>
<body>
</body>
</html>
