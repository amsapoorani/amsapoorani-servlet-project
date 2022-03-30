/*
 student registration form 
 */
package studentregistrationdetail;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Class.forName;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Studentsreg extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
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
                    + "font-size:30px;}");
            out.println("h1{color:darkred;"
                    + "font-family:sans-serif;"
                    + "text-align:center;"
                    + "font-size:40px;}");
             out.println("</style>");
            out.println("<title>Servlet Studentsreg</title>");
            out.println("</head>");
            out.println("<body>");
            String name = null;
            int id=Integer.parseInt(request.getParameter("id"));
            name = request.getParameter("sname");
            String Dob = request.getParameter("sdob");
            String gender = request.getParameter("gender");
            String email = request.getParameter("smail");
            String address = request.getParameter("saddress");
            String school = request.getParameter("sschool");
            String number = request.getParameter("snumber");
            String course = request.getParameter("select");
            String department = request.getParameter("department");
            String mobileno = request.getParameter("mobilenumber");
            out.println("<table border=2px>");
            out.println("<tr><th>");
            out.println("name" + "</th>");
            out.println("<td>" + name + "</td></tr>");
            out.println("<tr><th>");
            out.println("Dob" + "</th>");
            out.println("<td>" + Dob + "</td></tr>");
            out.println("<tr><th>");
            out.println("gender" + "</th>");
            out.println("<td>");
            if (gender == null) {
                out.println("<p>MISSING</p>");
            } else if (gender.equals("male")) {
                out.println("<p>male</p>");
            } else {
                out.println("<p>female</p>");
            }
            out.println("</td></tr>");
            out.println("<tr><th>");
            out.println("email id" + "</th>");
            out.println("<td>" + email + "</td></tr>");
            out.println("<tr><th>");
            out.println("address" + "</th>");
            out.println("<td>" + address + "</td></tr>");
            out.println("<tr><th>");
            out.println("school" + "</th>");
            out.println("<td>" + school + "</td></tr>");
            out.println("<tr><th>");
            out.println("12th/PUC" + "</th>");
            out.println("<td>" + number + "</td></tr>");
            out.println("<tr><th>");
            out.println("course" + "</th>");
            out.println("<td>" + course + "</td></tr>");
            out.println("<tr><th>");
            out.println("department" + "</th>");
            out.println("<td>" + department + "</td></tr>");
            out.println("<tr><th>");
            out.println("mobile number" + "</th>");
            out.println("<td>" + mobileno + "</td></tr>");
            out.println("</table>");
            //jdbc part
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentreg","root","root");
            Statement stmt=con.createStatement();
            String sqlinsert="insert into studentreg.studreg values('"+id+"','"+name+"','"+Dob+"','"+gender+"','"+email+"','"+address+"','"+school+"','"+number+"','"+course+"','"+department+"','"+mobileno+"')";
            int i=stmt.executeUpdate(sqlinsert);
            if(i>0)
            {
                 out.println("<b>registration successfully</b>");
            }
            else 
            {
                out.println("<b>not insert the record</b>");
            }
            con.close();
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Studentsreg.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Studentsreg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Studentsreg.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Studentsreg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
