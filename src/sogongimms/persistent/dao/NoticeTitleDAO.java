package sogongimms.persistent.dao;

import sogongimms.persistent.dto.NoticeTitleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class NoticeTitleDAO {
    private DBConnection db;

    public NoticeTitleDAO() { db = new DBConnection(); }

    public ArrayList<NoticeTitleDTO> select() throws SQLException {
        ArrayList<NoticeTitleDTO> noticeTitleDTOList = new ArrayList<>();
        String sql = "select * from notice";
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.rs = db.pst.executeQuery();
        while (db.rs.next()) {
            NoticeTitleDTO noticeTitleDTO = new NoticeTitleDTO();
            noticeTitleDTO.setNoticeNum(db.rs.getInt("notice_num"));
            noticeTitleDTO.setTitle(db.rs.getString("title"));
            noticeTitleDTO.setUserId(db.rs.getString("admin_id"));
            noticeTitleDTOList.add(noticeTitleDTO);
        }
        db.dbClose();

        return noticeTitleDTOList;
    }
}
