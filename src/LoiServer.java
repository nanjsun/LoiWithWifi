import sqlOperate.SelectToDb;
import sqlOperate.InsertToDb;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.NumberFormatException;
//import

public class LoiServer extends HttpServlet {
//    private int  testId;
//    private String material;
//    private float loi;
//    private String dataSource;

    @Override
    public void doGet (HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException {
        String material = null;
        float LOI = 0;
        String data_source_from = null;
        String method = null;
        int testId = 0;
        material = request.getParameter("material");
        data_source_from = request.getParameter("data_source_from");

        try {
            testId = Integer.valueOf(request.getParameter("testId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            testId = 999;
//            System.out.println("Please input teseId in format of testId=xx");
        }
        ;
        method = request.getParameter("method");
        PrintWriter writer = response.getWriter();
        response.setStatus(200);
        response.setContentType("/text/html");
        writer.print("/n method:-->"+method + testId +material + data_source_from);
        switch (method) {
            case "select":
                SelectToDb db = new SelectToDb();
                material = db.selectSql(testId);
                if(testId != 0){
                    writer.print(testId+"\n");
                    writer.print(material);
                }
                else {
                    writer.print("select---->Wrong testId!");
                }
                break;
            case "insert":
                InsertToDb insertDb = new InsertToDb();
                material = request.getParameter("material");
                LOI = Float.parseFloat(request.getParameter("LOI"));
                data_source_from = request.getParameter("data_source_from");
                int insertResult = insertDb.insertSql(testId, material, LOI, data_source_from);
                writer.print(String.valueOf(insertResult));
                break;
            default:
                writer.print("\n method-->Wrong parameter!");
                break;
        }
    }

//    @Override
    public void doPost (HttpServletResponse response,
                       HttpServletRequest request)
        throws IOException, ServletException {
        String testId = request.getParameter("testId");
        float LOI = Float.valueOf(request.getParameter("Loi"));
        String opertion = request.getParameter("operation");
        switch (opertion){
            case "upload":
        }
    }
}
