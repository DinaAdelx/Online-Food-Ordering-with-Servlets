/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


/**
 *
 * @author Dina
 */
@WebServlet(urlPatterns = {"/register"})
public class register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet register</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet register at " + request.getContextPath() + "</h1>");
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
              String f= request.getParameter("cFirstName");
              String l = request.getParameter("cLastName");
              String e= request.getParameter("cEmail");
              String h= request.getParameter("cHomeAddress");
              String p= request.getParameter("cConfirmPassword");
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        PrintWriter out=response.getWriter();
        
        
        Connection con=null;
        
        
              int id = GenerateRanadom();
              
       
        //String dc=request.getParameter("discountcode");
                
        //String i = Integer.toString(GenerateRanadom());
        
          
           try {
               
            int updated =0 ;
            
            con =  DriverManager.getConnection("jdbc:derby://localhost:1527/OnlineFoodOrder","root", "root");
            
            PreparedStatement pstmt = con.prepareStatement("insert into Customer values(? , ? , ? , ? , ? , ? )" );
                        pstmt.setInt(1, GenerateRanadom());
                        pstmt.setString(2, f);
                        pstmt.setString(3, l);
                        pstmt.setString(4, e);
                        pstmt.setString(5, h);
                        pstmt.setString(6, p);
                        
                        
                        
                        //updated =  stmt.executeUpdate("insert into Customer values ('"+id+"','"+f+"','"+l+"','"+e+"','"+p+"','"+h+"')");  
                        updated = pstmt.executeUpdate();
                        
                          if(updated > 0)
                          {
                             request.getRequestDispatcher("Home.html").include(request, response);
                          }
                          
           } 
           
         catch (SQLException el) {
           out.println("Sorry Try again later" +f +l +e +h +p);
           
        }
           finally{
			try {
				con.close();
			} catch (SQLException el) {
				el.printStackTrace();
			}
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>// </editor-fold>// </editor-fold>// </editor-fold>
     public int GenerateRanadom()
    {
        Random dice = new Random();
        int number = dice.nextInt(1000);
        return number;
        
    }
}
