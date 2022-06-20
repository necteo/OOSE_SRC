package sogongimms.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sogongimms.persistent.dao.NoticeDAO;
import sogongimms.persistent.dto.NoticeDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class NoticeCreateCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int result = 0;
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        NoticeDTO noticeDTO = new NoticeDTO();
        noticeDTO.setTitle(title);
        noticeDTO.setContent(content);
        noticeDTO.setUploadDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss")));
        noticeDTO.setUserId(request.getSession().getAttribute("user_id").toString());
        NoticeDAO noticeDAO = new NoticeDAO();
        try {
            result = noticeDAO.insert(noticeDTO);
        } catch (SQLException e) {
            e.printStackTrace();
            result = -1;
        }

        request.setAttribute("result", result);
    }
}
