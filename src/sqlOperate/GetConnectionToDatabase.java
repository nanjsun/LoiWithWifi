package sqlOperate;

import java.sql.*;


public class GetConnectionToDatabase {
    private final static String DB_URL = "jdbc:mysql://107.172.101.46:3306/LoiWithWifi";
    private final static String USER = "root";
    private final static String PASS = "000";
    private final static String DB_NAME = "LoiWithWifi";
    private final static String TABLE_NAME = "test_data";

    public String selectSql(int testId) {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Load Mysql Driver Success!");
        }catch (ClassNotFoundException e1) {
            System.out.println("Can Not Find Mysql Driver!");
            e1.printStackTrace();
        }
        String material = null;
        float LOI;
        String date_source_from;

        Connection conn;
        Statement stmt;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM " + DB_NAME + "." + TABLE_NAME + " WHERE test_id=" + testId;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                material = rs.getString("material");
                LOI = rs.getFloat("LOI");
                date_source_from = rs.getString("date_source_from");
                System.out.println("material:"+material);
                System.out.println("LOI:"+LOI);
                System.out.println("date_source_from:"+date_source_from);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return material;
    }
}
