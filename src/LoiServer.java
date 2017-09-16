import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class LoiServer extends HttpServlet {
    private int  testId;
    private String material;
    private float loi;
    private String dataSource;

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException {
        String query = request.getParameter("testId");
        response.setContentType("/text/html");
        response.setStatus(200);
        PrintWriter writer = response.getWriter();

        if(query != null){
            writer.print(query);

        }
        else {
            writer.print("Wrong");
        }

    }

}
