import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class login extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String cid=null;
            String un=null;
            String pw=null;
           String s1=request.getParameter("t1");
        String s2=request.getParameter("t2");
       
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dushmant");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from register");
            while(rs.next()){
            un=rs.getString(3);
            cid=rs.getString(9);
            
            pw=rs.getString(4);
            }
            HttpSession ck=request.getSession();
          ck.setAttribute("user",cid);
          if(s1.equalsIgnoreCase(un))
          {
           RequestDispatcher rd=request .getRequestDispatcher("foods.html");
           rd.forward(request,response);
          }
          
        }
        catch(ClassNotFoundException | SQLException e){}
        }
    }
}