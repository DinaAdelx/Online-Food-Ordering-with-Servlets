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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dina
 */
@WebServlet(urlPatterns = {"/homep"})
public class homep extends HttpServlet {

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
            out.println("<title>Servlet homep</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet homep at " + request.getContextPath() + "</h1>");
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
        
        String DishName;
        String DishPrice;
        String DishDescription;
        String DishPicture;
        String DishDeliveryTime;

        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/OnlineFoodOrder", "root", "root");

            String Dishes = "select * from Dish";
            PreparedStatement pstmt = con.prepareStatement(Dishes);

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html lang=\"en\">\r\n"
                    + "<head>\r\n"
                    + "    <meta charset=\"UTF-8\">\r\n"
                    + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
                    + "    <!--Style-->\r\n"
                    + "    <link rel=\"stylesheet\" href=\"style.css\">\r\n"
                    + "    <!--Font-->\r\n"
                    + "    <link href=\"https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap\" rel=\"stylesheet\">\r\n"
                    + "    <!--Icons-->\r\n"
                    + "    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\" rel=\"stylesheet\">\r\n"
                    + "    <title>Tasty Food</title>\r\n"
                    + "</head>\r\n"
                    + "<body>\r\n"
                    + "    <!--Header-->\r\n"
                    + "    <input type=\"checkbox\" id=\"cart\">\r\n"
                    + "    <label for=\"cart\" class=\"label-cart\"><span class=\"fas fa-shopping-cart\"></span></label>\r\n"
                    + "    \r\n"
                    + "    <h3 class=\"logo\">Tasty Food</h3>\r\n"
                    + "\r\n"
                    + "    <!--Side bar-->\r\n"
                    + "    <div class=\"sidebar\">\r\n"
                    + "        <div class=\"sidebar-menu\">\r\n"
                    + "            <span class=\"fas fa-search\"></span>\r\n"
                    + "            <a href=\"#\">Search</a>\r\n"
                    + "        </div>\r\n"
                    + "        <div class=\"sidebar-menu\">\r\n"
                    + "            <span class=\"fas fa-home\"></span>\r\n"
                    + "            <a href=\"#\">Home</a>\r\n"
                    + "        </div>\r\n"
                    + "        <div class=\"sidebar-menu\">\r\n"
                    + "            <span class=\"fas fa-heart\"></span>\r\n"
                    + "            <a href=\"#\">Favs</a>\r\n"
                    + "        </div>\r\n"
                    + "        <div class=\"sidebar-menu\">\r\n"
                    + "            <span class=\"fas fa-user\"></span>\r\n"
                    + "            <a href=\"#\">Profile</a>\r\n"
                    + "        </div>\r\n"
                    + "        <div class=\"sidebar-menu\">\r\n"
                    + "            <span class=\"fas fa-sliders-h\"></span>\r\n"
                    + "            <a href=\"#\">Setting</a>\r\n"
                    + "        </div>\r\n"
                    + "    </div>");
            out.println("<div class=\"dashboard\">\r\n"
                    + "        <div class=\"dashboard-banner\">\r\n"
                    + "            <img src=\"C:\\CODES\\Food Site\\IMAGES\\Banner.jpg\">\r\n"
                    + "            <div class=\"banner-promo\">\r\n"
                    + "                <h1><span>50% OFF</span>\r\n"
                    + "                Tasty Food<br>\r\n"
                    + "                Between Your Hand</h1>\r\n"
                    + "            </div>\r\n"
                    + "        </div>\r\n"
                    + "\r\n"
                    + "        <h3 class=\"dashboard-title\">Recommended Food For You</h3>\r\n"
                    + "        <div class=\"dashboard-menu\">\r\n"
                    + "            <a href=\"#\">Favorites</a>\r\n"
                    + "            <a href=\"#\">Best Seller</a>\r\n"
                    + "            <a href=\"#\">Near Me</a>\r\n"
                    + "            <a href=\"#\">Promotion</a>\r\n"
                    + "            <a href=\"#\">Top Rated</a>\r\n"
                    + "            <a href=\"#\">ALL</a>\r\n"
                    + "        </div>");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DishName = rs.getString("DishName");
                DishPrice = rs.getString("DishName");
                DishDescription = rs.getString("DishDescription");
                DishPicture = rs.getString("DishPicture");
                DishDeliveryTime = rs.getString("DishDeliveryTime");

                out.println(" <div class=\"dashboard-card\">\r\n"
                        + "    <img class=\"card-image\" src=\"" + DishPicture + "\">\r\n"
                        + "<div class=\"card-detail\">\r\n"
                        + "    <h4>" + DishName + "<span>" + DishPrice + "$</span></h4>\r\n"
                        + "    <p>" + DishDescription + " </p>\r\n"
                        + "    <p class=\"card-time\"><span class=\"fas fa-clock\"></span>" + DishDeliveryTime
                        + "</p>\r\n"
                        + "    <input type=\"checkbox\"  name=\"check\" value=\"" + DishName + "\">\r\n"
                        + "</div>\r\n"
                        + "        </div>");
            }
            out.println("</div>\r\n"
                    + "    </div>\r\n"
                    + "    \r\n"
                    + "    \r\n"
                    + "</body>\r\n"
                    + "</html>");
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        } finally {
            if (con != null)
                try {
                    con.close();
            } catch (SQLException ex) {
                Logger.getLogger(homep.class.getName()).log(Level.SEVERE, null, ex);
            }
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
