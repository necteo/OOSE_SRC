package sogongimms.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sogongimms.persistent.dao.LectureDAO;
import sogongimms.persistent.dao.LectureDateDAO;
import sogongimms.persistent.dao.TakingLecturesDAO;
import sogongimms.persistent.dao.TeacherDAO;
import sogongimms.persistent.dto.LectureDTO;
import sogongimms.persistent.dto.LectureListDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class TakingLectureListCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<LectureListDTO> lectureListList = new ArrayList<>();
        String memberId = request.getSession().getAttribute("user_id").toString();
        try {
            TakingLecturesDAO takingLecturesDAO = new TakingLecturesDAO();
            ArrayList<Integer> takingLectures = takingLecturesDAO.select(memberId);
            LectureDAO lectureDAO = new LectureDAO();
            ArrayList<LectureDTO> lectureList = new ArrayList<>();
            for (int takingLecture: takingLectures) {
                lectureList.add(lectureDAO.select(takingLecture));
            }
            TeacherDAO teacherDAO = new TeacherDAO();
            ArrayList<String> teachersId = new ArrayList<>();
            for (LectureDTO lectureDTO: lectureList) {
                teachersId.add(lectureDTO.getTeacherId());
            }
            ArrayList<String> teachers = teacherDAO.selectName(teachersId);
            for (int i = 0; i < lectureList.size(); i++) {
                LectureDTO lect = lectureList.get(i);
                LectureDateDAO lectureDateDAO = new LectureDateDAO();
                String time = lectureDateDAO.select(lect.getLectureCode());
                lectureListList.add(new LectureListDTO(lect, teachers.get(i), time.split(",")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // attribute 에 객체 저장
        request.setAttribute("lect_list", lectureListList);
    }
}
