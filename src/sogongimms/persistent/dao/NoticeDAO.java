package sogongimms.persistent.dao;

import sogongimms.persistent.dto.NoticeDTO;

import java.sql.SQLException;

public class NoticeDAO {
    private DBConnection db;

    public NoticeDAO() { db = new DBConnection(); }

    public NoticeDTO select(int num) throws SQLException {
        String sql = "select * from notice where notice_num=?";
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.pst.setInt(1, num);
        db.rs = db.pst.executeQuery();
        db.rs.next();
        NoticeDTO noticeDTO = new NoticeDTO();
        noticeDTO.setNoticeNum(db.rs.getInt("notice_num"));
        noticeDTO.setTitle(db.rs.getString("title"));
        noticeDTO.setUserId(db.rs.getString("admin_id"));
        noticeDTO.setContent(db.rs.getString("content"));
        noticeDTO.setUploadDate(db.rs.getString("upload_date"));
        db.dbClose();

        return noticeDTO;
    }

    public int insert(NoticeDTO noticeDTO) throws SQLException {
        String sql = "insert into notice(title, admin_id, content, upload_date) values (?, ?, ?, ?)";
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.pst.setString(1, noticeDTO.getTitle());
        db.pst.setString(2, noticeDTO.getUserId());
        db.pst.setString(3, noticeDTO.getContent());
        db.pst.setString(4, noticeDTO.getUploadDate());
        int result = db.pst.executeUpdate();
        db.dbClose();

        return result;
    }
}
