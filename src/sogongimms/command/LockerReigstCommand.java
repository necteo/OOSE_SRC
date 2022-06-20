package sogongimms.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sogongimms.persistent.dto.LockerDTO;
import sogongimms.persistent.dao.LockerDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class LockerReigstCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int result = 0;
        boolean isLockerExist = false;
        ArrayList<LockerDTO> lockerList = new ArrayList<>();
        LockerDTO lockerDTO = new LockerDTO();
        lockerDTO.setLockerNo(Integer.parseInt(request.getParameter("locker_no")));
        lockerDTO.setMemberId(request.getParameter("member_id"));
        lockerDTO.setRegistDate(request.getParameter("regist_date"));
        lockerDTO.setDueDate(request.getParameter("due_date"));

        // locker Exist Check
        LockerDAO lockerDAO = new LockerDAO();
        try {
            lockerList = lockerDAO.selectAvailable();    // locker 전부 읽어옴
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (LockerDTO locker : lockerList){
            if (lockerDTO.getLockerNo() == locker.getLockerNo()) {  // no가 일치하는 locker가 있고
                if (locker.getRegistDate() == null) {  // 설정된 기간이 없으면
                    try {
                        result = lockerDAO.update(lockerDTO);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {    // 설정된 기간이 이미 있어서 중복 등록이면
                    result = -1;
                }
                isLockerExist = true;  // locker가 있음
            }
        }
        if (!isLockerExist) {   // locker 없으면
            result = 0;
        }

        request.setAttribute("result", result);
    }
}
