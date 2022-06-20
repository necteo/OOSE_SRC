package sogongimms.persistent.dao;

import sogongimms.persistent.dto.SalesDTO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalesDAO {
    private DBConnection db;

    public SalesDAO() { db = new DBConnection(); }

    public ArrayList<SalesDTO> select() throws SQLException {
        ArrayList<SalesDTO> salesDTOList = new ArrayList<>();
        String sql = "select * from sales";
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.rs = db.pst.executeQuery();
        while (db.rs.next()) {
            SalesDTO salesDTO = new SalesDTO();
            salesDTO.setPaymentNum(db.rs.getInt("payment_num"));
            salesDTO.setLectureName(db.rs.getString("lecture_name"));
            salesDTO.setPaymentAccount(db.rs.getInt("payment_account"));
            salesDTO.setPaymentDate(db.rs.getDate("payment_date"));
            salesDTO.setPaymentMethod(db.rs.getString("payment_method"));
            salesDTO.setMemberId(db.rs.getString("member_id"));
            salesDTOList.add(salesDTO);
        }
        db.dbClose();

        return salesDTOList;
    }

//    public ArrayList<SalesDTO> selectKind(String type, String keyword) throws SQLException{
//        SalesDTO salesDTO = new SalesDTO();
//        String coName = "";
//        try {
//            String colName="";
//            switch(type) {
//                case "1": colName="lecture_name";
//                    break;
//                case "2": colName="payment_date";
//                    break;
//            }
//
//            db.dbConn();
//            String sql = "select * from sales where" + colName + "like ?";
//            System.out.println(sql);
//            db.pst = db.conn.prepareStatement(sql);
//            db.pst.setString(1, "%" + keyword + "%");
//            db.rs = db.pst.executeQuery();
//
//            while (db.rs.next()) {
//                salesDTO .setPaymentNum(db.rs.getInt("payment_num"));
//                salesDTO .setLecturename(db.rs.getString("lecture_name"));
//                salesDTO .setPaymentAccount(db.rs.getInt("payment_account"));
//                salesDTO .setPaymentDate(db.rs.getDate("payment_date"));
//                salesDTO .setPaymentMethod(db.rs.getString("payment_method"));
//                salesDTO .setMemberId(db.rs.getString("member_id"));
//            }
//            return select();
//
//
//        }finally {
//            db.dbClose();
//        }
//    }
//    public ArrayList<SalesDTO> getList (String keyword, String type) throws SQLException{
//        ArrayList<SalesDTO> list = null;
//        String sql = "";
//        if(type.equals("강습별")){
//            sql = "select * from sales where" + type + "like ?";
//        } else if (type.equals("기간별")) {
//            sql = "select * from sales where" + type + "like ?";
//        }
//        db.dbConn();
//        db.pst = db.conn.prepareStatement(sql);
//        db.pst.setString(1, "%" + keyword + "%");
//        db.rs = db.pst.executeQuery();
//        list = new ArrayList<SalesDTO>();
//        while(db.rs.next()){
//            SalesDTO salesDTO = new SalesDTO(
//                db.rs.getInt(1),
//                db.rs.getString(2),
//                db.rs.getInt(3),
//                db.rs.getDate(4),
//                db.rs.getString(5),
//                db.rs.getString(6)
//            );
//            list.add(salesDTO);
//        }
//        return list;
//    }

    public ArrayList<SalesDTO> getSearch(String type, String text) throws SQLException {
        ArrayList<SalesDTO> list = new ArrayList<>();
        String sql = "select * from sales where " + type;
        try {
            if(text != null && !text.equals("")) {
                sql += " like '%" + text + "%'";
            }
            db.dbConn();
            db.pst = db.conn.prepareStatement(sql);
            db.rs = db.pst.executeQuery();
            while(db.rs.next()){
                SalesDTO salesDTO = new SalesDTO();
                salesDTO.setPaymentNum(db.rs.getInt(1));
                salesDTO.setLectureName(db.rs.getString(2));
                salesDTO.setPaymentAccount(db.rs.getInt(3));
                salesDTO.setPaymentDate(db.rs.getDate(4));
                salesDTO.setPaymentMethod(db.rs.getString(5));
                salesDTO.setMemberId(db.rs.getString(6));
                list.add(salesDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


//    public ArrayList<SalesDTO> find(String type, String keyword) throws SQLException {
//        String colName = "";
//        switch (type){
//            case "1" : colName = "lecture_name";
//                break;
//            case "2" : colName = "payment_date";
//                break;
//        }
//
//        db.dbConn();
//        String find = "select * from sales where" + colName + "like ?";
//
//        db.pst = db.conn.prepareStatement(find);
//        db.pst.setString(1, "%" + keyword + "%");
//        db.rs = db.pst.executeQuery();
//
//        return null;
//    }

    public int insert(SalesDTO salesDTO) throws SQLException {
        String sql = "insert into sales values (?, ?, ?, ?, ?, ?)";
        db.dbConn();
        db.pst = db.conn.prepareStatement(sql);
        db.pst.setInt(1, salesDTO.getPaymentNum());
        db.pst.setString(2, salesDTO.getLectureName());
        db.pst.setInt(3, salesDTO.getPaymentAccount());
        db.pst.setDate(4, (Date) salesDTO.getPaymentDate());
        db.pst.setString(5, salesDTO.getPaymentMethod());
        db.pst.setString(6, salesDTO.getMemberId());
        int result = db.pst.executeUpdate();
        db.dbClose();

        return result;
    }
}
