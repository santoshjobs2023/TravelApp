import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class register extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
 String s=String.valueOf(new Random().nextInt(1000));
 String ss="cus"+s;
           String s1=request.getParameter("t1");
        String s2=request.getParameter("t2");
        String s3=request.getParameter("t3");
        String s4=request.getParameter("t4");
        String s5=request.getParameter("t5");
        String s6=request.getParameter("t6");
         String s7=request.getParameter("t7");
        String s8=request.getParameter("t8");
        try
        {
             Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dushmant");
            PreparedStatement st=con.prepareStatement("insert into REGISTER values(?,?,?,?,?,?,?,?,?)");
            st.setString(1,s1);
            st.setString(2,s2);
            st.setString(3,s3);
            st.setString(4,s4);
            st.setString(5,s5);
            st.setString(6,s6);
             st.setString(7,s7);
            st.setString(8,s8);
             st.setString(9,ss);
            int i=st.executeUpdate();
            out.print("YOU ARE SUCESSFULLY REGISTERED");
        }
        catch(ClassNotFoundException | SQLException e){}
        }
    }
}