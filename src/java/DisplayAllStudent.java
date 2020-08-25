

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DisplayAllStudent extends HttpServlet {

    static String data = "";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
      
          try {
            data = new String(Files.readAllBytes(Paths.get("E:\\Data.csv")));
            char arr[] = data.toCharArray();
            List<String> s = new ArrayList();
            StringBuilder sb = new StringBuilder("");
            for (char c : arr) {
                if (String.valueOf(c).contains("\n")) {
                    s.add(sb.toString());
                    sb = new StringBuilder("");
                } else {
                    sb.append(c);
                }
            }
            
              out.print("<html><head><style>table{border: 1px solid black;border-collapse:collapse;text-align: left;}td{width: 10%;} th{font-style:bold;}</style></head><body><br>");
              out.print("<table border=1 cellpadding=3 ");
              out.print("<tr style='text-align:center;' ><th>Student Id</th><th>Student Name</th><th>Gender</th><th>Date Of Birth</th><th>City</th><th>State</th><th>EmailId</th><th>Qualification</th><th>Stream</th></tr>");
              for (String string : s) {
                  
                String fields[] = string.split(",");
              
                out.print("<tr><td>"+fields[0]+"</td><td>"+fields[1]+"</td><td>"+fields[2]+"</td><td>"+fields[3]+"</td><td>"+fields[4]+"</td><td>"+fields[5]+"</td><td>"+fields[6]+"</td><td>"+fields[7]+"</td><td>"+fields[8]+"</td></tr>");
                out.print("\n\n");
            }
              out.print("</table></body></html>");
        } catch (Exception ex) {
            out.print(ex);
       }
    }

}
