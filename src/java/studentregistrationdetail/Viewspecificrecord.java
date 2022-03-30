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

public class Viewspecificrecord extends HttpServlet {

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
                    + "font-size:20px;}");
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
            String sqlselect = "select * from studentreg.studreg where id='" + sid + "'";
            ResultSet rs = stmt.executeQuery(sqlselect);
            out.println("<table border=2px>");
            out.println("<tr>");
            out.println("<th>" + "id" + "</th>");
            out.println("<th>" + "name" + "</th>");
            out.println("<th>" + "Dob" + "</th>");
            out.println("<th>" + "gender" + "</th>");
            out.println("<th>" + "email id" + "</th>");
            out.println("<th>" + "address" + "</th>");
            out.println("<th>" + "school" + "</th>");
            out.println("<th>" + "12th/PUC" + "</th>");
            out.println("<th>" + "course" + "</th>");
            out.println("<th>" + "department" + "</th>");
            out.println("<th>" + "mobile number" + "</th></tr>");
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt(1) + "</td>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getString(3) + "</td>");
                out.println("<td>" + rs.getString(4) + "</td>");
                out.println("<td>" + rs.getString(5) + "</td>");
                out.println("<td>" + rs.getString(6) + "</td>");
                out.println("<td>" + rs.getString(7) + "</td>");
                out.println("<td>" + rs.getString(8) + "</td>");
                out.println("<td>" + rs.getString(9) + "</td>");
                out.println("<td>" + rs.getString(10) + "</td>");
                out.println("<td>" + rs.getString(11) + "</td></tr>");
            }
           
            out.println("</table>");
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
