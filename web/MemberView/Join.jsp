<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2022-05-18
  Time: 오후 7:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/MemberView/css/bootstrap.css">
<!DOCTYPE html>
<html>
<head>
    <title>소공체육시설홈페이지</title>
</head>
<body>
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
                <li><a href="lists">회원조회</a></li>
            </ul>

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
        </div>
    </nav>

    <div class="container">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <div class="jumbotron" style="padding-top: 20px">
                <form name="member_join" action="joinOk" method="post" onsubmit="return chkSubmit()">
                    <h3 style="text-align: center">회원가입 화면 </h3>
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="아이디" name="user_id" maxlength="10">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="비밀번호" name="user_password" maxlength="20">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="이름" name="user_name" maxlength="20">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="전화번호" name="user_phone" maxlength="20">
                    </div>
                    <div class="form-group" style="text-align: center;">
                        <div class="btn-group" data-toggle="buttons">
                            <label class="btn btn-primary active">
                                <input type="radio" name="user_gender" autocomplete="off" value="0" checked>남자
                            </label>
                            <label class="btn btn-primary">
                                <input type="radio" name="user_gender" autocomplete="off" value="1">여자
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="생일(00000000)" name="user_birth" maxlength="8">
                    </div>
                    <div class="form-group">
                        <input type="email" class="form-control" placeholder="이메일" name="user_email" maxlength="50">
                    </div>
                    <input type="submit" class="btn btn-primary form-control" value="회원가입">
                </form>
            </div>
        </div>
    </div>

<script>
    function chkSubmit() {
        const memberJoin = document.forms['member_join'];
        const userId = memberJoin['user_id'].value.trim();
        const userPassword = memberJoin['user_password'].value.trim();
        if (userId == '' || userPassword == '') {
            alert("입력이 안 된 사항이 있습니다.");
            memberJoin['user_id'].focus();
            return false;
        } else if (userPassword.length < 4 || userPassword.length > 12) {
            alert('비밀번호를 4~12자까지 입력해주세요.');
            memberJoin['user_password'].focus();
            return false;
        }
        return true;
    }
</script>
<script src="//code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/MemberView/js/bootstrap.min.js"></script>
</body>
</html>
