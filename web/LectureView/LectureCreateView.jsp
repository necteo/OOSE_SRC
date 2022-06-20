<%--
  Created by IntelliJ IDEA.
  User: S
  Date: 2022-05-25
  Time: 오후 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        * { margin: 2px 0 2px 2px; }
        label { display:flex; }
        div label { display: inline; }
        input { margin-left: 10px; }
        div input { margin-right: 5px; box-sizing: border-box; }
        div > input { width: 105px;}
        select { margin-left: 10px; }
    </style>
    <title>강습 등록 화면</title>
</head>
<body>
    <form name="create" action="create" method="post" onsubmit="return chkSubmit()">
        <label>강습명<input type="text" name="lect_name"></label>
        <label>강사아이디<input type="text" name="teacher"></label>
        <label>종목<input type="text" name="sports"></label>
        <div>
            성별
            <label><input type="checkbox" name="gender" value="0">남자</label>
            <label><input type="checkbox" name="gender" value="1">여자</label>
        </div>
        <label>센터명
            <select name="location">
                <option value="0">소공체육센터</option>
                <option value="1">두번째체육센터</option>
                <option value="2">세번째체육센터</option>
                <option value="3">네번째체육센터</option>
            </select>
        </label>
        <label>정원<input type="number" name="capacity" size="1" maxlength="4">명</label>
        <div>
            요일
            <label><input type="checkbox" name="weeks" value="일">일</label>
            <label><input type="checkbox" name="weeks" value="월">월</label>
            <label><input type="checkbox" name="weeks" value="화">화</label>
            <label><input type="checkbox" name="weeks" value="수">수</label>
            <label><input type="checkbox" name="weeks" value="목">목</label>
            <label><input type="checkbox" name="weeks" value="금">금</label>
            <label><input type="checkbox" name="weeks" value="토">토</label>
        </div>
        <div>강습 시작일
            <input type="date" name="start_date" value="2022-06-13" min="2022-01-01" max="2023-12-31">
        </div>
        <div>강습 종료일
            <input type="date" name="end_date" value="2022-07-13" min="2022-01-01" max="2023-12-31">
        </div>
        <div>강습 시작 시각
            <input type="time" name="start_time" value="10:00">
        </div>
        <div>강습 종료 시각
            <input type="time" name="end_time" value="12:00">
        </div>
        <input type="submit" value="등록">
    </form>
    <a href="/sogongimms/Main.jsp">메인으로 돌아가기</a>

    <script>
        function chkSubmit() {
            const createLecture = document.forms['create'];
            const lectName = createLecture['lect_name'].value.trim();
            const teacher = createLecture['teacher'].value.trim();
            const sports = createLecture['sports'].value.trim();
            const capacity = createLecture['capacity'].value.trim();
            if (lectName == '' || teacher == '' || sports == '' || capacity == '') {
                alert("입력이 안 된 사항이 있습니다.")
                return false;
            }
            const startDate = createLecture['start_date'].value.trim();
            const endDate = createLecture['end_date'].value.trim();
            const startTime = createLecture['start_time'].value.trim();
            const endTime = createLecture['end_time'].value.trim();
            if (startDate > endDate) {
                alert('기간이 올바르지 않습니다.');
                return false;
            }
            if (startTime > endTime) {
                alert('시간이 올바르지 않습니다.');
                return false;
            }
            return true;
        }
    </script>
</body>
</html>
