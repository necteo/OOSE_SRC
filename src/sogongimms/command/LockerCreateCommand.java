package sogongimms.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sogongimms.persistent.dao.LockerDAO;
import sogongimms.persistent.dto.LockerDTO;

import java.sql.SQLException;

public class LockerCreateCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int result = 0;
        LockerDTO lockerDTO = new LockerDTO();
        lockerDTO.setLockerNo(Integer.parseInt(request.getParameter("locker_no")));

        LockerDAO lockerDAO = new LockerDAO();
        try {
           result = lockerDAO.insert(lockerDTO);
        } catch (SQLException e) {
            result = -1;
        }

        request.setAttribute("result", result);
    }
}
