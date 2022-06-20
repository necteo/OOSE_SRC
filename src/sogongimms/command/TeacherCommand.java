package sogongimms.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sogongimms.persistent.dao.TeacherDAO;
import sogongimms.persistent.dao.UserDAO;
import sogongimms.persistent.dto.TeacherDTO;
import sogongimms.persistent.dto.UserDTO;

import java.sql.SQLException;

public class TeacherCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        String password = "";
        TeacherDTO teacherDTO = new TeacherDTO();
        UserDAO userDAO = new UserDAO();
        TeacherDAO teacherDAO = new TeacherDAO();
        try {
            password = userDAO.select(id);
            teacherDTO = teacherDAO.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("password", password);
        request.setAttribute("teacher", teacherDTO);
    }
}
