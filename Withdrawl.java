
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;





public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton Withdraw,back;
    String pinnumber;
    
     Withdrawl(String pinnumber){
         this.pinnumber=pinnumber;
          setLayout(null );
          
          ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
          Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
          ImageIcon i3=new ImageIcon(i2);
          JLabel image=new JLabel(i3);
          image.setBounds(0,0,900,900);
          add(image);
          
          JLabel text=new JLabel("Enter The Amount you Want to Withdrawl");
          text.setForeground(Color.WHITE);
          text.setFont(new Font("System",Font.BOLD,12));
          text.setBounds(170,300,400,20);
            image.add(text);
            
              amount=new JTextField();
            amount.setFont(new Font("System",Font.BOLD,22));
            amount.setBounds(170,350,320,20);
            image.add(amount);
            
             Withdraw=new JButton("Withdrawl");
            Withdraw.setBounds(355,485,150,30);
            Withdraw.addActionListener(this);
            image.add(Withdraw);
            
             back=new JButton("back");
            back.setBounds(355,520,150,30);
            back.addActionListener(this);
            image.add(back);
            
            
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
         setVisible(true);



}
     
     public void actionPerformed(ActionEvent ae){
         
         if(ae.getSource()==Withdraw){
             String number=amount.getText();
             Date date=new Date();
             if(number.equals("")){
                 JOptionPane.showMessageDialog(null, "please enter the amount you want to Withdrawl");
             }else{
                 try{
                     Conn c=new Conn();
                     
                     String query="insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+number+"')";
                     c.st.executeUpdate(query);
                     JOptionPane.showMessageDialog(null,"RS"+number+"Withdraw successfully");
                     new Transactions(pinnumber).setVisible(true);
                 }
                 catch(Exception e){
                     System.out.println(e);
             }
             }
             
         }else if(ae.getSource()==back){
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
         }
     }
    
    public static void main(String args[]){
        
        new Deposit("");
        
    }
    
}

