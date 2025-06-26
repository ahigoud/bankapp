
package bank.management.system;
import java.sql.*;


public class Conn {
    
    Connection con;
    Statement st;
    
    public Conn(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","akhil");
            st=con.createStatement();
            
        }
        
        catch(Exception e){
               System.out.println(e);
               

        }
    
    }
}
