package sogongimms.persistent.dao;

import sogongimms.persistent.dto.LockerDTO;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LockerDAO {
    private DBConnection db;

    public LockerDAO() { db = new DBConnection(); }

    public ArrayList<LockerDTO> selectUsing() throws SQLException {
        ArrayList<LockerDTO> lockerDTOList = new ArrayList<>();
        String sql = "select locker_no, regist_date, due_date from locker where regist_date > 0 and due_date >= ?";  // 사용중
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.pst.setDate(1, new Date(new java.util.Date().getTime()));
        db.rs = db.pst.executeQuery();
        while (db.rs.next()) {
            LockerDTO lockerDTO = new LockerDTO();
            lockerDTO.setLockerNo(db.rs.getInt("locker_no"));
            lockerDTO.setRegistDate(db.rs.getString("regist_date"));
            lockerDTO.setDueDate(db.rs.getString("due_date"));
            lockerDTOList.add(lockerDTO);
        }
        db.dbClose();

        return lockerDTOList;
    }

    public ArrayList<LockerDTO> selectAvailable() throws SQLException {
        ArrayList<LockerDTO> lockerDTOList = new ArrayList<>();
        String sql = " select locker_no from locker where regist_date is null or due_date < ?;";   // 신청가능한거
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.pst.setDate(1, new Date(new java.util.Date().getTime()));
        db.rs = db.pst.executeQuery();
        while (db.rs.next()) {
            LockerDTO lockerDTO = new LockerDTO();
            lockerDTO.setLockerNo(db.rs.getInt("locker_no"));
            lockerDTOList.add(lockerDTO);
        }
        db.dbClose();

        return lockerDTOList;
    }

    public int insert(LockerDTO lockerDTO) throws SQLException {
        int result = 0;
        String sql = "insert into locker values(?, null, null, null)";
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.pst.setInt(1, lockerDTO.getLockerNo());
        result = db.pst.executeUpdate();
        db.dbClose();

        return result;
    }

    public int update(LockerDTO lockerDTO) throws SQLException {
        int result = 0;
        String sql = "update locker set regist_date = ?, due_date = ? where locker_no = ?";
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.pst.setDate(1, Date.valueOf(lockerDTO.getRegistDate()));
        db.pst.setDate(2, Date.valueOf(lockerDTO.getDueDate()));
        db.pst.setInt(3, lockerDTO.getLockerNo());
        result = db.pst.executeUpdate();
        db.dbClose();

        return result;
    }
}
