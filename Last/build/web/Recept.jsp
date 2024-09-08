<%-- 
    Document   : Recept
    Created on : May 15, 2022, 8:46:13 PM
    Author     : Dina
--%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


        
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="s" class="mainpack.CalcRec" scope="session">
     <jsp:setProperty property="*" name="s" ></jsp:setProperty>
         </jsp:useBean>
        
       
         
         
          
        <% String check[] = request.getParameterValues("check");
        
        //System.out.println(check);
             int userid = (Integer) session.getAttribute("ID");
             String add = s.returnAddress(userid);
             if( s.CalculateRec(check) != 0 )
                {
                 int res = s.CalculateRec(check); %>
                 <table border="2">
                     <tr><td> your total price </td><td> <% out.print(res); %></td>  </tr>
                     <tr><td> Customer Address </td> <td> <% out.print(add); %></td></tr>
                 </table>
                 
               <%  }
                else
                {%>
                <jsp:include page="index.html"></jsp:include>  
              
               <% }%>
     
        
    </body>
</html>
