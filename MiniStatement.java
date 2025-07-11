
package bank.management.system;
import java.awt.Color;
import javax.swing.*;
import java.sql.*;



public class MiniStatement extends JFrame {
    
    String pinnumber;
    
   MiniStatement(String pinnumber){ 
       this.pinnumber=pinnumber;
       setTitle("MiniStatement");
       setLayout(null);
       
       JLabel mini =new JLabel();
       add(mini);
       
       JLabel bank=new JLabel("SBI Bank");
       bank.setBounds(150,20,100,20);
       add(bank);
       
       JLabel card=new JLabel();
       card.setBounds(20,80,300,20);
       add(card);
       
       JLabel bal=new JLabel();
       bal.setBounds(20,400,300,20);
       add(bal);
       
        try{
            
            Conn c=new Conn();
            ResultSet rs=c.st.executeQuery("select * from login where pinnumber='"+pinnumber+"'");
            while(rs.next()){
                card.setText("CardNumber: "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
                
                
                
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
  
        try{
            
            Conn c=new Conn();
            int balance=0;
            ResultSet rs=c.st.executeQuery("select * from bank where pin='"+pinnumber+"'");
            while(rs.next()){
            mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;"+rs.getString("amount")+"<br><br><br></html>");
            
                       if(rs.getString("type").equals("deposit")){
                         balance +=Integer.parseInt(rs.getString("amount"));
                    }
                         else{
                         balance-=Integer.parseInt(rs.getString("amount"));
                         
                    }
            }
            
            bal.setText("Your Current Account Balance is RS: "+balance);
        }catch(Exception e){
                        System.out.println(e);

        }
       mini.setBounds(20,140,400,200);
       
         setSize(400,600);
         setLocation(20,20);
         getContentPane().setBackground(Color.WHITE);
         
         setVisible(true);
       
   }
    
    
    
    public static void main(String args[]){
        new MiniStatement("");
    }
    
}
