package sogongimms.persistent.dao;

import sogongimms.persistent.dto.LectureDTO;
import sogongimms.persistent.dto.TakingLecturesDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class TakingLecturesDAO {
    private DBConnection db;

    public TakingLecturesDAO() { db = new DBConnection(); }

    public ArrayList<Integer> select(String memberId) throws SQLException {
        String sql = "select lecture_code from taking_lectures where member_id = ?";
        ArrayList<Integer> lectureCodeList = new ArrayList<>();
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.pst.setString(1, memberId);
        db.rs = db.pst.executeQuery();
        while (db.rs.next()) {
            lectureCodeList.add(db.rs.getInt("lecture_code"));
        }
        db.dbClose();

        return lectureCodeList;
    }

    public int insert(TakingLecturesDTO takingLecturesDTO) throws SQLException {
        String sql = "insert into taking_lectures values (?, ?)";
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.pst.setString(1, takingLecturesDTO.getMemberId());
        db.pst.setInt(2, takingLecturesDTO.getLectureCode());
        int result = db.pst.executeUpdate();
        db.dbClose();

        return result;
    }
}
