package sogongimms.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sogongimms.persistent.dao.MemberDAO;
import sogongimms.persistent.dto.MemberDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class MemberListCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<MemberDTO> memberList = null;
        MemberDAO memberDAO = new MemberDAO();
        try {
            memberList = memberDAO.select();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("member_list", memberList);
    }
}
