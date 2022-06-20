package sogongimms.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sogongimms.persistent.dao.SalesDAO;
import sogongimms.persistent.dto.SalesDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class SalesCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<SalesDTO> salesList = new ArrayList<>();
        SalesDAO salesDAO = new SalesDAO();
        try {
            salesList = salesDAO.select();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("sales_list", salesList);
    }
}
