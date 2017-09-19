package sqlOperate;

public class insertSqlTest {
    public static void main(String[] args) {
        InsertToDb insertDb = new InsertToDb();

        String material = "material_test";
        float LOI = 19;
        String data_source_from = "seu_test";
        int testId = 12;

        int insertResult = insertDb.insertSql(testId, material, LOI, data_source_from);

        System.out.println(String.valueOf(insertResult));
    }
}
