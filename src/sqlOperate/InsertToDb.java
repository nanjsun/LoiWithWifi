package sqlOperate;

import java.sql.*;


public class InsertToDb {
    private final static String DB_URL = "jdbc:mysql://107.172.101.46:3306/LoiWithWifi";
    private final static String USER = "root";
    private final static String PASS = "000";
    private final static String DB_NAME = "LoiWithWifi";
    private final static String TABLE_NAME = "test_data";

    public int insertSql(int testId, String material, Float LOI, String data_source_from) {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Load Mysql Driver Success!");
        }catch (ClassNotFoundException e1) {
            System.out.println("Can Not Find Mysql Driver!");
            e1.printStackTrace();
        }

        Connection conn;
        Statement stmt;
        int rs = 0;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "INSERT INTO `LoiWithWifi`.`test_data` (`test_id`, `material`, `LOI`, `date_source_from`) VALUES ('" +
                    testId + "', '" + material + "', '" + LOI + "', '" + data_source_from + "')";

            System.out.println(sql);
            rs = stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
}
