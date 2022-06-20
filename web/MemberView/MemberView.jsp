<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2022-05-18
  Time: 오후 7:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="sogongimms.persistent.dto.MemberDTO" %>
<%@ page import="java.util.ArrayList" %>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/MemberView/css/bootstrap.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
    <title>소공체육시설홈페이지</title>
</head>
<body>
<%
    String userID = null;
    if(session.getAttribute("user_id") != null) {
        userID = (String) session.getAttribute("user_id");
    }
%>
<nav class="navbar navbar-default">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed"
                data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                area-expanded="false">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/sogongimms/Main.jsp">소공체육시설 웹 사이트</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
            <li><a href="/sogongimms/Main.jsp">메인</a></li>
            <li  class="active"><a href="join">회원등록</a></li>
        </ul>
    <%
        if (userID == null) {
    %>
        <ul class="nav navbar-nav navbar-right">
            <li class="nav-item dropdown">
                <a class="nav-link pl-0 dropdown-toggle" href="#"
                   data-toggle="dropdown" role="button" aria-haspopup="true"
                   aria-expanded="false">접속하기<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="login">로그인</a></li>
                </ul>
            </li>
        </ul>
    <%
        } else {
    %>
        <ul class="nav navbar-nav navbar-right">
            <li class="nav-item dropdown">
                <a class="nav-link pl-0 dropdown-toggle" href="#"
                   data-toggle="dropdown" role="button" aria-haspopup="true"
                   aria-expanded="false">회원관리<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="logout">로그아웃</a></li>
                </ul>
            </li>
        </ul>
    <%
        }
    %>
    </div>
</nav>

<div class="container">
    <form method="post" action="search" class="form-inline">
        <select name="search_type">
            <option value="">::검색 유형::</option>
            <option value="1">회원이름</option>
            <option value="2">아이디</option>
            <option value="3">이메일</option>
        </select>
        <input type="text" name="search_keyword" placeholder="검색어를 입력하세요">
        <input type="submit" value="조회하기">
    </form>
    <div class="row">
        <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
        <thead>
            <tr>
                <th style="background-color: #eeeeee; text-align: center;">번호</th>
                <th style="background-color: #eeeeee; text-align: center;">아이디</th>
                <th style="background-color: #eeeeee; text-align: center;">이름</th>
                <th style="background-color: #eeeeee; text-align: center;">전화번호</th>
                <th style="background-color: #eeeeee; text-align: center;">성별</th>
                <th style="background-color: #eeeeee; text-align: center;">생일</th>
                <th style="background-color: #eeeeee; text-align: center;">이메일</th>
            </tr>
        </thead>
        <tbody>
        <%
            int num = 1;
            ArrayList<MemberDTO> memberList = (ArrayList<MemberDTO>) request.getAttribute("member_list");
            for (MemberDTO member: memberList) {
        %>
                <tr>
                    <td><%= num++ %></td>
                    <td><%= member.getId() %></td>
                    <td><%= member.getName() %></td>
                    <td><%= member.getPhone() %></td>
                    <td><%= member.getGender() %></td>
                    <td><%= member.getBirth() %></td>
                    <td><%= member.getEmail() %></td>
                </tr>
        <%
            }
        %>
        </tbody>
        </table>
    </div>
</div>


<script src = "//code.jquery.com/jquery-3.1.1.min.js"></script>
<script src = "${pageContext.request.contextPath}/MemberView/js/bootstrap.min.js"></script>
<script src = "${pageContext.request.contextPath}/MemberView/js/bootstrap.js"></script>
</body>
</html>
