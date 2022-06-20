package sogongimms.persistent.dao;

import sogongimms.persistent.dto.LectureDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class LectureDAO {
    private DBConnection db;

    public LectureDAO() { db = new DBConnection(); }

    public ArrayList<LectureDTO> select(String filter, String keyword) throws SQLException {  // db에서 읽어옴
        ArrayList<LectureDTO> lectureDTOList = new ArrayList<>();
        String sql;
        if (filter.isBlank() && keyword.isBlank()) {
            sql = "select * from lecture";
        } else {
            switch (filter) {
                case "1": filter = "lecture_name";
                    break;
                case "2": filter = "sports";
                    break;
            }
            sql = "select * from lecture where " + filter + " like '%" + keyword + "%'";
        }
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.rs = db.pst.executeQuery();
        while (db.rs.next()) {
            LectureDTO lectureDTO = new LectureDTO();
            lectureDTO.setLectureCode(db.rs.getInt("lecture_code"));
            lectureDTO.setLectureName(db.rs.getString("lecture_name"));
            lectureDTO.setCapacity(db.rs.getInt("capacity"));
            lectureDTO.setTeacherId(db.rs.getString("teacher_id"));
            lectureDTO.setSports(db.rs.getString("sports"));
            lectureDTO.setGender(db.rs.getInt("gender"));
            lectureDTO.setLocation(db.rs.getInt("location"));
            lectureDTO.setWeeks(db.rs.getString("weeks"));
            lectureDTOList.add(lectureDTO);
        }
        db.dbClose();

        return lectureDTOList;
    }

    public LectureDTO select(int lectureCode) throws SQLException {
        LectureDTO lectureDTO = new LectureDTO();
        String sql = "select * from lecture where lecture_code = ?";
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.pst.setInt(1, lectureCode);
        db.rs = db.pst.executeQuery();
        if (db.rs.next()) {
            lectureDTO.setLectureCode(db.rs.getInt("lecture_code"));
            lectureDTO.setLectureName(db.rs.getString("lecture_name"));
            lectureDTO.setCapacity(db.rs.getInt("capacity"));
            lectureDTO.setTeacherId(db.rs.getString("teacher_id"));
            lectureDTO.setSports(db.rs.getString("sports"));
            lectureDTO.setGender(db.rs.getInt("gender"));
            lectureDTO.setLocation(db.rs.getInt("location"));
            lectureDTO.setWeeks(db.rs.getString("weeks"));
        }
        db.dbClose();

        return lectureDTO;
    }

    public int insert(LectureDTO lectureDTO) throws SQLException {
        String sql = "insert into lecture(lecture_name, capacity, teacher_id, sports, gender, location, weeks)" +
                " values (?, ?, ?, ?, ?, ?, ?)";
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.pst.setString(1, lectureDTO.getLectureName());
        db.pst.setInt(2, lectureDTO.getCapacity());
        db.pst.setString(3, lectureDTO.getTeacherId());
        db.pst.setString(4, lectureDTO.getSports());
        db.pst.setInt(5, lectureDTO.getGender());
        db.pst.setInt(6, lectureDTO.getLocation());
        db.pst.setString(7, lectureDTO.getWeeks());
        int result = db.pst.executeUpdate();
        db.dbClose();

        return result;
    }
}
