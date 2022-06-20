package sogongimms.persistent.dao;

import sogongimms.persistent.dto.MemberDTO;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
    private DBConnection db;

    public MemberDAO() { db = new DBConnection(); }

    public ArrayList<MemberDTO> select() throws SQLException {
        String sql = "select * from member";
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        ArrayList<MemberDTO> memberDTOList = getMemberDTOS();

        return memberDTOList;
    }

    public ArrayList<MemberDTO> search(String type, String keyword) throws SQLException {
        String colName ="";

        switch (type) {
            case "1": colName = "name";
                break;
            case "2": colName = "id";
                break;
            case "3": colName = "email";
                break;
        }

        String sql = "select * from member where " + colName + " like ?";
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.pst.setString(1, "%" + keyword + "%");
        ArrayList<MemberDTO> memberDTOList = getMemberDTOS();

        return memberDTOList;
    }

    private ArrayList<MemberDTO> getMemberDTOS() throws SQLException {
        ArrayList<MemberDTO> memberDTOList = new ArrayList<>();
        db.rs = db.pst.executeQuery();
        while (db.rs.next()) {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setId(db.rs.getString("id"));
            memberDTO.setName(db.rs.getString("name"));
            memberDTO.setPhone(db.rs.getString("phone"));
            memberDTO.setGender(db.rs.getInt("gender"));
            memberDTO.setBirth(db.rs.getString("birth"));
            memberDTO.setEmail(db.rs.getString("email"));
            memberDTOList.add(memberDTO);
        }
        db.dbClose();

        return memberDTOList;
    }

    public int insert(MemberDTO memberDTO) throws SQLException {
        String SQL = "insert into member values (?, ?, ?, ?, ?, ?)";
        db.dbConn();
        db.pst = db.conn.prepareStatement(SQL);
        db.pst.setString(1, memberDTO.getId());
        db.pst.setString(2, memberDTO.getName());
        db.pst.setString(3, memberDTO.getPhone());
        db.pst.setInt(4, memberDTO.getGender());
        db.pst.setString(5, memberDTO.getBirth());
        db.pst.setString(6, memberDTO.getEmail());
        int result = db.pst.executeUpdate();
        db.dbClose();

        return result;
    }
}
