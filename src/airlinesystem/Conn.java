package airlinesystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn{
    
    Connection c;
    Statement s;
    
    public Conn(){  
        try{  
            Class.forName("org.apache.derby.jdbc.ClientDriver");  
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/Airlines","hitesh","1022");    
            s =c.createStatement();          
        }
        catch(Exception ex){ 
            System.out.println(ex);
        }  
    }  
}  