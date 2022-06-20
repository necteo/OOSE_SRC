package sogongimms.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sogongimms.persistent.dao.TeacherDAO;
import sogongimms.persistent.dao.UserDAO;
import sogongimms.persistent.dto.TeacherDTO;
import sogongimms.persistent.dto.UserDTO;

import java.sql.SQLException;

public class TeacherCreateCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        UserDTO userDTO = new UserDTO();
        TeacherDTO teacherDTO = new TeacherDTO();

        userDTO.setId(request.getParameter("id"));
        userDTO.setPassword(request.getParameter("password"));
        userDTO.setType(1);

        teacherDTO.setId(request.getParameter("id"));
        teacherDTO.setPassword(request.getParameter("password"));
        teacherDTO.setName(request.getParameter("name"));
        teacherDTO.setPhone(request.getParameter("phone"));
        teacherDTO.setEmail(request.getParameter("email"));

        int result = 0;
        UserDAO userDAO = new UserDAO();
        TeacherDAO teacherDAO = new TeacherDAO();
        try {
            result = userDAO.insert(userDTO);
            result = teacherDAO.insert(teacherDTO);
        } catch (SQLException e) {
            result = -1;
        }

        request.setAttribute("result", result);
    }
}
