
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

public class SearchStudentById extends HttpServlet {

    static String data = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String Studentid = request.getParameter("stdId");
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

            for (String string : s) {
                String fields[] = string.split(",");
                if (Studentid.trim().equals(fields[0].trim())) {
                    out.print("<html><head><style>table{border: 1px solid black;border-collapse:collapse;text-align: left;}td{width: 20%;}</style></head><body><br>");
                    out.print("<table border=1 cellpadding=3 ");
                    out.print("<tr><td><b>Student Id</b></td><td>" + fields[0] + "</td></tr>");
                    out.print("<tr><td><b>Student Name</b></td><td>" + fields[1] + "</td></tr>");
                    out.print("<tr><td><b>Gender</b></td><td>" + fields[2] + "</td></tr>");
                    out.print("<tr><td><b>DateOfBirth</b></td><td>" + fields[3] + "</td></tr>");
                    out.print("<tr><td><b>City</b></td><td>" + fields[4] + "</td></tr>");
                    out.print("<tr><td><b>State</b></td><td>" + fields[5] + "</td></tr>");
                    out.print("<tr><td><b>EmailId</b></td><td>" + fields[6] + "</td></tr>");
                    out.print("<tr><td><b>Qualification</b></td><td>" + fields[7] + "</td></tr>");
                    out.print("<tr><td><b>Stream</b></td><td>" + fields[8] + "</td></tr>");

                    out.print("</table>");
                    out.print("</body></html>");
                }
                out.print("\n\n");
            }
        } catch (IOException ex) {
            out.print(ex);
        }
    }
}
