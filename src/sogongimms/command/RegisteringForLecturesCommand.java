package sogongimms.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sogongimms.persistent.dao.LectureDAO;
import sogongimms.persistent.dao.LectureDateDAO;
import sogongimms.persistent.dao.TakingLecturesDAO;
import sogongimms.persistent.dto.TakingLecturesDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class RegisteringForLecturesCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int result = 0;
        String memberId = request.getSession().getAttribute("user_id").toString();
        try {
            int lectureCode = Integer.parseInt(request.getParameter("register"));
            TakingLecturesDTO takingLecturesDTO = new TakingLecturesDTO(memberId, lectureCode);
            TakingLecturesDAO takingLecturesDAO = new TakingLecturesDAO();
            ArrayList<Integer> takingLectures = takingLecturesDAO.select(memberId);
            LectureDAO lectureDAO = new LectureDAO();
            LectureDateDAO lectureDateDAO = new LectureDateDAO();
            String[] ws = lectureDAO.select(lectureCode).getWeeks().split(", ");    // 선택한 강습 요일
            String[] ts = lectureDateDAO.select(lectureCode).split(",");            // 선택한 강습 시각
            for (int takingLecture: takingLectures) {   // 수강 중인 강습 중에서
                String weeks = lectureDAO.select(takingLecture).getWeeks(); // 요일과
                String[] times = lectureDateDAO.select(takingLecture).split(",");   // 시각이
                boolean isDupWeek = false;
                for (String w: ws) {
                    if (weeks.indexOf(w) != -1) {
                        isDupWeek = true;   // 요일이 겹치는지
                    }
                }
                if (isDupWeek) {    // 요일이 겹치면
                    String[] st = ts[0].split(":"); // 시작시각 시, 분
                    String[] et = ts[1].split(":"); // 종료시각 시, 분
                    if (Integer.parseInt(times[0].split(":")[0]) <= Integer.parseInt(st[0]) &&
                            Integer.parseInt(times[1].split(":")[0]) > Integer.parseInt(st[0])) {
                        result = -4;
                        break;
                    } else if (Integer.parseInt(times[0].split(":")[0]) < Integer.parseInt(et[0]) &&
                            Integer.parseInt(times[1].split(":")[0]) >= Integer.parseInt(et[0])) {
                        result = -4;
                        break;
                    }
                }
            }
            if (result == 0) {
                result = takingLecturesDAO.insert(takingLecturesDTO);
            }
        } catch (SQLException e) {
            result = -1;
        } catch (NullPointerException e) {
            result = -2;
        } catch (NumberFormatException e) {
            result = -3;
        }

        request.setAttribute("result", result);
    }
}
