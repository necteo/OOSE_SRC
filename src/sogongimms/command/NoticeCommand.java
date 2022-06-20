package sogongimms.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sogongimms.persistent.dao.NoticeDAO;

import java.sql.SQLException;

public class NoticeCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int notice_num = Integer.parseInt(request.getParameter("num"));
        NoticeDAO noticeDAO = new NoticeDAO();
        try {
            request.setAttribute("res_notice", noticeDAO.select(notice_num));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
