<%--
  Created by IntelliJ IDEA.
  User: songd
  Date: 2022-05-28
  Time: 오후 5:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
    int result = (Integer) request.getAttribute("result");

    if (result == 1) { %>
        <script>
            window.onload = function() {
                confirm('성공');
                location.href = '/sogongimms/LockerView/Locker/registView';
            }
        </script>
<%  } else if (result == 0) { %>
        <script>
            window.onload = function() {
                confirm('존재하지 않는 락커입니다');
                history.back();
            }
        </script>
<%  } else if (result == -1) { %>
        <script>
            window.onload = function() {
                confirm('이미 사용 중인 락커입니다');
                history.back();
            }
        </script>
<%  } %>
<html>
<head>
    <title>Start Page</title>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
</body>
</html>
