<%--
  Created by IntelliJ IDEA.
  User: S
  Date: 2022-05-25
  Time: 오후 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int result = (Integer) request.getAttribute("result");

    if (result == -1) { %>
        <script>
            window.onload = function() {
                confirm('회원이 아니거나 이미 신청한 강습입니다');
                history.back();
            }
        </script>
<%  } else if (result == -2) { %>
        <script>
            window.onload = function() {
                confirm('로그인이 필요합니다');
                location.href = "/sogongimms/MemberView/Member/login";
            }
        </script>
<%  } else if (result == -3) { %>
        <script>
            window.onload = function() {
                confirm('하나 이상의 강습을 선택해주세요');
                history.back();
            }
        </script>
<%  } else if (result == -4) { %>
        <script>
            window.onload = function() {
                confirm('시간이 중복되는 강습을 수강 중입니다');
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
    <title>수강 신청 화면</title>
</head>
<body>
</body>
</html>
