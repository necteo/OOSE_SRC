package sogongimms.persistent.dao;

import sogongimms.persistent.dto.MemberDTO;
import sogongimms.persistent.dto.UserDTO;

import java.sql.SQLException;

public class UserDAO {
    private DBConnection db;

    public UserDAO() { db = new DBConnection(); }

    public int select(String userID, String userPassword) throws SQLException {
        String sql = "select * from user where id = ?";
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.pst.setString(1, userID);
        db.rs = db.pst.executeQuery();
        if (db.rs.next()) {
            if (db.rs.getString("password").equals(userPassword)) {
                int type = db.rs.getInt("type");
                db.dbClose();
                return type; // 로그인 성공, 타입은 0~2사이 정수, 0:회원, 1:강사, 2:관리자
            } else {
                db.dbClose();
                return 11; //비밀번호 불일치
            }
        }
        db.dbClose();

        return 12; //아이디가 없음.
    }

    public String select(String userID) throws SQLException {
        String sql = "select * from user where id = ?";
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.pst.setString(1, userID);
        db.rs = db.pst.executeQuery();
        db.rs.next();
        String password = db.rs.getString("password");
        db.dbClose();

        return password;
    }

    public int insert(UserDTO userDTO) throws SQLException {
        String SQL = "insert into user values (?, ?, ?)";
        db.dbConn();
        db.pst = db.conn.prepareStatement(SQL);
        db.pst.setString(1, userDTO.getId());
        db.pst.setString(2, userDTO.getPassword());
        db.pst.setInt(3, userDTO.getType());
        int result = db.pst.executeUpdate();
        db.dbClose();

        return result;
    }
}
