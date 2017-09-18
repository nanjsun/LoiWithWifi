import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import sqlOperate.GetConnectionToDatabase;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
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
        String query = request.getParameter("testId");
//        response.setContentType("/text/html");
        int testId = Integer.valueOf(query);

        GetConnectionToDatabase db = new GetConnectionToDatabase();

        String material = db.selectSql(testId);

        response.setStatus(200);
        PrintWriter writer = response.getWriter();

        if(query != null){
            writer.print(query+"\n");
            writer.print(material);

        }
        else {
            writer.print("Wrong parameter!");
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
