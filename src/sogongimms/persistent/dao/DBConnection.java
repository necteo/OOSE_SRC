package sogongimms.persistent.dao;

import java.sql.*;

public class DBConnection { // db 연결만 하는 클래스
    public Connection conn = null;
    public Statement st = null;
    public PreparedStatement pst = null;
    public ResultSet rs = null;

    public void dbConn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sogongimms?serverTimezone=Asia/Seoul&useSSL=false";
            String id = "root";
            String pwd = "root";
            conn = DriverManager.getConnection(url, id, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dbClose(){
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (pst != null) pst.close();
            if (conn != null) conn.close();
            System.out.println("Disconnection Succeeded.");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
