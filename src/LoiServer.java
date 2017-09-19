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
        String dataSourceFrom = null;
        String method = null;
        int testId = 0;
        material = request.getParameter("material");
        dataSourceFrom = request.getParameter("dataSourceFrom");
        String[] selectResult = new String[5];

        try {
            testId = Integer.valueOf(request.getParameter("testId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            testId = 999;
        }
        ;
        method = request.getParameter("method");
        PrintWriter writer = response.getWriter();
        response.setStatus(200);
        response.setContentType("/text/html");
        switch (method) {
            case "select":
                SelectToDb db = new SelectToDb();
                selectResult = db.selectSql(testId);
                material = selectResult[1];

                writer.print(selectResult[0]+ ":" +selectResult[1]+ ":" + selectResult[2]+ ":"+selectResult[3]);
                break;
            case "insert":
                InsertToDb insertDb = new InsertToDb();
                material = request.getParameter("material");
                LOI = Float.parseFloat(request.getParameter("LOI"));
                dataSourceFrom = request.getParameter("dataSourceFrom");
                int insertResult = insertDb.insertSql(testId, material, LOI, dataSourceFrom);
                writer.print(String.valueOf(insertResult));
                break;
            default:
                writer.print("\n -->Wrong method!");
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
