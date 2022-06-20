package sogongimms.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sogongimms.persistent.dao.LockerDAO;
import sogongimms.persistent.dto.LockerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class LockerListCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<LockerDTO> usingLockerList = new ArrayList<>();
        ArrayList<LockerDTO> availableLockerList = new ArrayList<>();
        LockerDAO lockerDAO = new LockerDAO();
        try {
            usingLockerList = lockerDAO.selectUsing();
            availableLockerList = lockerDAO.selectAvailable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("using_locker_list", usingLockerList);
        request.setAttribute("available_locker_list", availableLockerList);
    }
}
