
package javaregistration;

import java.sql.*;

public class conn {
    Connection con;
    Statement st;
    
   public  conn()
    {
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaregister?user=root&password=root&useSSL=false");
           st=con.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}

