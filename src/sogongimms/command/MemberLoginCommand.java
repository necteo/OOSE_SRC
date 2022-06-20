package sogongimms.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sogongimms.persistent.dao.UserDAO;

import java.sql.SQLException;

public class MemberLoginCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int result = 0;
        HttpSession session = request.getSession();

        String userID = null;
        if (session.getAttribute("user_id") != null) {
            userID = (String) session.getAttribute("user_id");
        }
        if (userID != null) {
            result = 10;
            request.setAttribute("result", result);
            return;
        }

        UserDAO userDAO = new UserDAO();
        try {
            result = userDAO.select(request.getParameter("user_id"), request.getParameter("user_password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result <= 2) {
            session.setAttribute("user_id", request.getParameter("user_id"));
            session.setAttribute("type", result);
        }

        request.setAttribute("result", result);
    }
}
