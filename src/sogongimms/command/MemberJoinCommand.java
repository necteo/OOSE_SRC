package sogongimms.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sogongimms.persistent.dao.MemberDAO;
import sogongimms.persistent.dao.UserDAO;
import sogongimms.persistent.dto.MemberDTO;
import sogongimms.persistent.dto.UserDTO;

import java.sql.SQLException;

public class MemberJoinCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        UserDTO userDTO = new UserDTO();
        MemberDTO memberDTO = new MemberDTO();

        userDTO.setId(request.getParameter("user_id"));
        userDTO.setPassword(request.getParameter("user_password"));
        userDTO.setType(0);

        memberDTO.setId(request.getParameter("user_id"));
        memberDTO.setName(request.getParameter("user_name"));
        memberDTO.setPhone(request.getParameter("user_phone"));
        memberDTO.setGender(Integer.parseInt(request.getParameter("user_gender")));
        memberDTO.setBirth(request.getParameter("user_birth"));
        memberDTO.setEmail(request.getParameter("user_email"));

        int result = 0;
        UserDAO userDAO = new UserDAO();
        MemberDAO memberDAO = new MemberDAO();
        try {
            result = userDAO.insert(userDTO);
            result = memberDAO.insert(memberDTO);
        } catch (SQLException e) {
            result = -1;
        }

        request.setAttribute("result", result);
    }
}
