package Bank;

import java.sql.*;  

public class Conn{
    Connection c;
    Statement s;
    public Conn(){  
        try{  
        	 Class.forName("com.mysql.jdbc.Driver");  
             c =DriverManager.getConnection("jdbc:mysql://localhost/bms","root","");  
            s =c.createStatement(); 
           
          
            
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  