<%@ page import="java.util.ArrayList" %>
<%@ page import="sogongimms.persistent.dto.SalesDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<SalesDTO> salesList = (ArrayList<SalesDTO>) request.getAttribute("sales_list");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/SalesView/sales.css" />
    <title>소공스포츠센터</title>
</head>
<body>
    <nav class="sidebar">
        <h1 class="center-name">소공체육센터</h1>
        <div class="profile-box">
            <div class="profile__user-img"></div>
            <span class="profile__user-name">관리자</span>
        </div>
        <div class="menu-container">
            <span class="sales-menu-title">통계</span>
            <ul class="menu-list">
                <li class="menu-item">
                    <a href="createView"> - 매출관리</a>
                </li>
            </ul>
        </div>
    </nav>
    <main>
        <div class="main-container">
            <header>
                <div class="title-container">
                    <h2 class="menu-super-title">통계</h2>
                    <h3 class="menu-sub-title">매출 관리</h3>
                </div>
                <button onclick="location.href = '/sogongimms/Main.jsp'" class="exit-btn">나가기</button>
            </header>
            <div class="listtop">
                <form action="sales" method="post">
                    <select class="sales" name="type">
                        <option value="none" selected>선택</option>
                        <option value="lecture">강습별</option>
                        <option value="period">기간별</option>
                    </select>
                    <input type="text" name="text">
                    <input type="submit" class="selectKind" value="조회">
                </form>
            </div>
            <table class="sale-list">
                <thead>
                <tr>
                    <th>결제번호</th>
                    <th>강습명</th>
                    <th>금액</th>
                    <th>날짜</th>
                    <th>결제방법</th>
                    <th>아이디</th>
                </tr>
                </thead>
                <tbody>
                <%
                    if (salesList != null) {
                        for (int i = 0; i < salesList.size(); i++) {
                %>
                <tr>
                    <td><%= salesList.get(i).getPaymentNum() %></td>
                    <td><%= salesList.get(i).getLectureName() %></td>
                    <td><%= salesList.get(i).getPaymentAccount() %></td>
                    <td><%= salesList.get(i).getPaymentDate() %></td>
                    <td><%= salesList.get(i).getPaymentMethod() %></td>
                    <td><%= salesList.get(i).getMemberId() %></td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </main>
</body>
</html>

