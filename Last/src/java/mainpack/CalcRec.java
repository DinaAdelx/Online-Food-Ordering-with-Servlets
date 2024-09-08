/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author Dina
 */
public class CalcRec {
    
    //generate random 
    public int GenerateRanadom()
    {
        Random dice = new Random();
        int number = dice.nextInt(1000);
        return number;
        
    }

    public CalcRec() {
    }
    
    
     Connection con;
    
   
    //fuunction to calculate the price 
    
    public int CalculateRec(String s[]) throws ClassNotFoundException, SQLException
    {
        int sum = 0;
        try {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con = DriverManager.getConnection("jdbc:derby://localhost:1527/OnlineFoodOrder","root", "root");
          
        for (int i = 0 ; i < s.length ; i++)
        {
            PreparedStatement ptsmt = con.prepareStatement("select DishPrice from Dish where DishName= ? ");
            ptsmt.setString(1,s[i]);
            ResultSet result = ptsmt.executeQuery();
            
            while(result.next())
            {
                int n = result.getInt("DishPrice");
                sum= sum + n;
            }
       
        }
            
        }
        catch (Exception e)
        {
            
        }
         
       
         finally {
            try
            {
                con.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        return sum;
    }
    
    // get the customer Adress
public String returnAddress(int id )
{
    String add = null;
        try {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con = DriverManager.getConnection("jdbc:derby://localhost:1527/OnlineFoodOrder","root", "root");
          
            PreparedStatement ptsmt = con.prepareStatement("select HomeAddress from Customer where CustomerID= ? ");
            ptsmt.setInt(1,id);
            ResultSet result = ptsmt.executeQuery();
            
            while(result.next())
            {
                 add = result.getString("HomeAddress");
               
            }
       
        
            
        }
        catch (Exception e)
        {
            
        }
         
       
         finally {
            try
            {
                con.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        return add;
    
}

// Customer full name 

public void InsertInTable(int ID , String add , int Price)
{
    int updated =  0;
    
        try {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con = DriverManager.getConnection("jdbc:derby://localhost:1527/OnlineFoodOrder","root", "root");
          
            PreparedStatement ptsmt = con.prepareStatement("insert into CustomerOrder values ( ? , ? , ? , ? ) ");
            ptsmt.setInt(1,GenerateRanadom());
            ptsmt.setString(2, add);
            ptsmt.setInt(3, Price);
            ptsmt.setInt(4, ID);
            ResultSet result = ptsmt.executeQuery();
            
            updated = ptsmt.executeUpdate();
                        
                         
       
        
            
        }
        catch (Exception e)
        {
            
        }
         
       
         finally {
            try
            {
                con.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
      
    
}

}
   
            
    
    
    
    

