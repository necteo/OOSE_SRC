package sogongimms.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sogongimms.persistent.dao.NoticeTitleDAO;
import sogongimms.persistent.dto.NoticeTitleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class NoticeListCommand implements Command {
    private int page_size;
    private int page_num;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        page_num = Integer.parseInt(request.getParameter("page"));
        request.setAttribute("res_notice_titles", readPageTitle());
        request.setAttribute("page_size", page_size);
    }

    private ArrayList<NoticeTitleDTO> readPageTitle() {
        try {
            NoticeTitleDAO noticeTitleDAO = new NoticeTitleDAO();
            ArrayList<NoticeTitleDTO> noticeTitleList = noticeTitleDAO.select();

            page_size = noticeTitleList.size() / 10;
            if (noticeTitleList.size() % 10 != 0) {
                page_size++;
            }

            int start = (page_num - 1) * 10;
            int end;
            if ((page_num) * 10 < noticeTitleList.size()) {
                end = start + 10;
            } else {
                end = noticeTitleList.size();
            }

            return new ArrayList<>(noticeTitleList.subList(start, end));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
