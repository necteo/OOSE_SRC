package sogongimms.persistent.dao;

import sogongimms.persistent.dto.LectureDTO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class LectureDateDAO {
    private DBConnection db;

    public LectureDateDAO() { db = new DBConnection(); }

    public String select(int lectureCode) throws SQLException {   // db에서 읽어옴
        String result = "";
        String sql = "select * from lecture_date where lecture_code=?";
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.pst.setInt(1, lectureCode);
        db.rs = db.pst.executeQuery();
        db.rs.next();
        String start = db.rs.getString("start_time");
        String end = db.rs.getString("end_time");
        result = start + "," + end;
        db.dbClose();

        return result;
    }

    public int insert(int lectureCode, ArrayList<String> dateInfo, String[] timeInfo) throws SQLException {
        int result = 0;
        String sql = "insert into lecture_date values (?, ?, ?, ?)";
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.pst.setInt(1, lectureCode);
        db.pst.setString(3, timeInfo[0]);   // start_time
        db.pst.setString(4, timeInfo[1]);   // end_time
        for (String date: dateInfo) {
            db.pst.setString(2, date);
            result = db.pst.executeUpdate();
        }
        db.dbClose();

        return result;
    }
}
