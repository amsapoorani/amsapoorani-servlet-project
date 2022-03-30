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

public class DeleteSpecificServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<style>");
            out.println("body{background-color:lightblue;"
                    + "color:darkblue;"
                    + "font-style:italic;"
                    + "text-align:center;"
                    + "font-size:20px;}");
            out.println("h1{color:darkred;"
                    + "font-family:sans-serif;"
                    + "text-align:center;"
                    + "font-size:40px;}");
            out.println("");
            out.println("</style>");
            out.println("<title>Servlet ViewStudentreg</title>");            
            out.println("</head>");
            out.println("<body>");
             out.println("<h1>View Student Details:</h1>");
            //jdbc part
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentreg","root","root");
            Statement stmt=con.createStatement();
            int sid=Integer.parseInt(request.getParameter("id"));
            String sqlselect="delete from studentreg.studreg where id='"+sid+"'";
            int i=stmt.executeUpdate(sqlselect);
            if(i>0)
            {
               out.println("Recod Deleted Successfully!");
            }
           else
            {
               out.println("Record Not Found !");
            }
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
