/*
 view the specific record from the database
 */
package studentregistrationdetail;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateStudetail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewStudentreg</title>");
            out.println("</head>");
             out.println("<style>");
             out.println("body{background-color:lightblue;"
                    + "color:darkblue;"
                    + "font-style:italic;"
                    + "text-align:center;"
                    + "font-size:30px;}");
            out.println("h1{color:darkred;"
                    + "font-family:sans-serif;"
                    + "text-align:center;"
                    + "font-size:40px;}");
             out.println("</style>");
            out.println("<body>");
            out.println("<h1>view student details:</h1>");
            //jdbc part
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentreg", "root", "root");
            Statement stmt = con.createStatement();
            int sid = Integer.parseInt(request.getParameter("id"));
            String updata=request.getParameter("updatedetails");
            String upfield=request.getParameter("updatefield");
           boolean flag=false;
            if(updata.equals("name"))
            {
               String sqlselect = "update studentreg.studreg set name='"+upfield+"'where id='" + sid + "'";
               int i= stmt.executeUpdate(sqlselect);
               if(i>0)
               {
                   out.println("Record Updated");
                   flag=true;
               }
            }
            if(updata.equals("Dob"))
            {
                 String sqlselect = "update studentreg.studreg set Dob='"+upfield+"'where id='" + sid + "'";
               int i= stmt.executeUpdate(sqlselect);
               if(i>0)
               {
                   out.println("Record Updated");
                   flag=true;
               }
            }
            if(updata.equals("gender"))
            {
                 String sqlselect = "update studentreg.studreg set gender='"+upfield+"'where id='" + sid + "'";
               int i= stmt.executeUpdate(sqlselect);
               if(i>0)
               {
                   out.println("Record Updated");
                   flag=true;
               }
            }
             if(updata.equals("email"))
            {
                 String sqlselect = "update studentreg.studreg set email='"+upfield+"'where id='" + sid + "'";
               int i= stmt.executeUpdate(sqlselect);
               if(i>0)
               {
                   out.println("Record Updated");
                   flag=true;
               }
            }
           if(updata.equals("address"))
            {
                 String sqlselect = "update studentreg.studreg set address='"+upfield+"'where id='" + sid + "'";
               int i= stmt.executeUpdate(sqlselect);
               if(i>0)
               {
                   out.println("Record Updated");
                   flag=true;
               }
            }
           if(updata.equals("school"))
            {
                 String sqlselect = "update studentreg.studreg set school='"+upfield+"'where id='" + sid + "'";
               int i= stmt.executeUpdate(sqlselect);
               if(i>0)
               {
                   out.println("Record Updated");
                   flag=true;
               }
            }
             if(updata.equals("number"))
            {
                 String sqlselect = "update studentreg.studreg set number='"+upfield+"'where id='" + sid + "'";
               int i= stmt.executeUpdate(sqlselect);
               if(i>0)
               {
                   out.println("Record Updated");
                   flag=true;
               }
            }
         if(updata.equals("course"))
            {
                 String sqlselect = "update studentreg.studreg set course='"+upfield+"'where id='" + sid + "'";
               int i= stmt.executeUpdate(sqlselect);
               if(i>0)
               {
                   out.println("Record Updated");
                   flag=true;
               }
            }
            if(updata.equals("department"))
            {
                 String sqlselect = "update studentreg.studreg set department='"+upfield+"'where id='" + sid + "'";
               int i= stmt.executeUpdate(sqlselect);
               if(i>0)
               {
                   out.println("Record Updated");
                   flag=true;
               }
            }
            if(updata.equals("mobileno"))
            {
                 String sqlselect = "update studentreg.studreg set mobileno='"+upfield+"'where id='" + sid + "'";
               int i= stmt.executeUpdate(sqlselect);
               if(i>0)
               {
                   out.println("Record Updated");
                   flag=true;
               }
            }
            if(flag=true)
            {
                 out.println("<script>alert('Record Updated!');</script>");
            }
            else
            {
                out.println("<script>alert('Record Not Found/Not Updated!');</script>");
            }
             stmt.close();
            con.close();
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ViewStudentreg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ViewStudentreg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
