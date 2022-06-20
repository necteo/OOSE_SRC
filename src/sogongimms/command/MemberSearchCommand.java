package sogongimms.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sogongimms.persistent.dao.MemberDAO;
import sogongimms.persistent.dto.MemberDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class MemberSearchCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String type = request.getParameter("search_type");
        String key = request.getParameter("search_keyword");
        ArrayList<MemberDTO> memberList = null;
        MemberDAO memberDAO = new MemberDAO();
        try {
            memberList = memberDAO.search(type, key);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("member_list", memberList);
    }
}
