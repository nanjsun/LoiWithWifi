package sqlOperate;

import java.sql.*;
import java.util.ArrayList;


public class SelectToDb {
    private final static String DB_URL = "jdbc:mysql://107.172.101.46:3306/LoiWithWifi";
    private final static String USER = "root";
    private final static String PASS = "000";
    private final static String DB_NAME = "LoiWithWifi";
    private final static String TABLE_NAME = "test_data";
    private String[] selectResult = new String[5];

    public String[] selectSql(int testId) {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Load Mysql Driver Success!");
        }catch (ClassNotFoundException e1) {
            System.out.println("Can Not Find Mysql Driver!");
            e1.printStackTrace();
        }
        String material = null;
        float LOI;
        String dataSourceFrom;

        Connection conn;
        Statement stmt;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM " + DB_NAME + "." + TABLE_NAME + " WHERE testId=" + testId;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                material = rs.getString("material");
                LOI = rs.getFloat("LOI");
                dataSourceFrom = rs.getString("dataSourceFrom");
//                System.out.println("material:"+material);
//                System.out.println("LOI:"+LOI);
//                System.out.println("dataSourceFrom:"+dataSourceFrom);
                selectResult[0] = String.valueOf(testId);
                selectResult[1] = material;
                selectResult[2] = String.valueOf(LOI);
                selectResult[3] = dataSourceFrom;
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return selectResult;
    }
}
