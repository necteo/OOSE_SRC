package sogongimms.persistent.dao;

import sogongimms.persistent.dto.LectureDTO;
import sogongimms.persistent.dto.MemberDTO;
import sogongimms.persistent.dto.TeacherDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDAO {
    private DBConnection db;

    public TeacherDAO() { db = new DBConnection(); }

    public ArrayList<String> selectName(ArrayList<String> teachersId) throws SQLException {
        ArrayList<String> teacherDTOList = new ArrayList<>();
        String sql = "select name from teacher where id = ?";
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        for (String teacherId : teachersId) {
            db.pst.setString(1, teacherId);
            db.rs = db.pst.executeQuery();
            db.rs.next();
            teacherDTOList.add(db.rs.getString("name"));
        }
        db.dbClose();

        return teacherDTOList;
    }

    public ArrayList<TeacherDTO> select() throws SQLException {
        ArrayList<TeacherDTO> teacherDTOList = new ArrayList<>();
        String sql = "select * from teacher";
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.rs = db.pst.executeQuery();
        while (db.rs.next()) {
            TeacherDTO teacherDTO = new TeacherDTO();
            teacherDTO.setId(db.rs.getString("id"));
            teacherDTO.setName(db.rs.getString("name"));
            teacherDTO.setPhone(db.rs.getString("phone"));
            teacherDTO.setEmail(db.rs.getString("email"));
            teacherDTOList.add(teacherDTO);
        }
        db.dbClose();

        return teacherDTOList;
    }

    public TeacherDTO selectById(String id) throws SQLException {
        TeacherDTO teacherDTO = new TeacherDTO();
        String sql = "select * from teacher where id = ?";
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.pst.setString(1, id);
        db.rs = db.pst.executeQuery();
        while (db.rs.next()) {
            teacherDTO.setId(db.rs.getString("id"));
            teacherDTO.setName(db.rs.getString("name"));
            teacherDTO.setPhone(db.rs.getString("phone"));
            teacherDTO.setEmail(db.rs.getString("email"));
        }
        db.dbClose();

        return teacherDTO;
    }

    public int insert(TeacherDTO teacherDTO) throws SQLException {
        String SQL = "insert into teacher values (?, ?, ?, ?)";
        db.dbConn();
        db.pst = db.conn.prepareStatement(SQL);
        db.pst.setString(1, teacherDTO.getId());
        db.pst.setString(2, teacherDTO.getName());
        db.pst.setString(3, teacherDTO.getPhone());
        db.pst.setString(4, teacherDTO.getEmail());
        int result = db.pst.executeUpdate();
        db.dbClose();

        return result;
    }
}
