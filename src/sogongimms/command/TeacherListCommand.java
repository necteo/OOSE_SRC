package sogongimms.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sogongimms.persistent.dao.TeacherDAO;
import sogongimms.persistent.dto.TeacherDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherListCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<TeacherDTO> teacherList = new ArrayList<>();
        TeacherDAO teacherDAO = new TeacherDAO();
        try {
            teacherList = teacherDAO.select();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("teacher_list", teacherList);
    }
}
