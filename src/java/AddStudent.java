

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddStudent extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        int Studentid=Integer.parseInt(request.getParameter("StdID"));
        String Studentname=request.getParameter("Stdname");
        String Gender=request.getParameter("gen");
        String Dateofbirth=request.getParameter("birthday");
        String City=request.getParameter("city");
        String State=request.getParameter("state");
        String Emailid=request.getParameter("email");
        String Qualification=request.getParameter("qua");
        String Stream=request.getParameter("stream");
        
         entry(Studentid,Studentname,Gender,Dateofbirth,City,State,Emailid,Qualification,Stream);
         out.print("Data Added Successfully");
         
         
        
     }

     static void entry(int ID,String Studentname,String Gender,String Dateofbirth,String City,String State,String Emailid,String Qualification, String Stream){
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter("E:\\Data.csv",true));
            bw.append(ID+","+Studentname+","+Gender+","+Dateofbirth+","+City+","+State+","+Emailid+","+Qualification+","+Stream);
            bw.newLine();
            bw.close();
           
            
        } catch (Exception ex) {
            System.out.println("exeption");
        }
    }
   

}
