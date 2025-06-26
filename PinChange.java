package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener{
    
    
    JButton change,back;
    JPasswordField pinfield,repinfield;
    JLabel text,pin,repin;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
          text=new JLabel("CHANGE YOUR PIN ");
         text.setFont(new Font("System",Font.BOLD,16));
         text.setForeground(Color.WHITE);
         text.setBounds(250,280,500,35);
         image.add(text);
         
          pin=new JLabel("ENTR NEW PIN ");
         pin.setFont(new Font("System",Font.BOLD,16));
         pin.setForeground(Color.WHITE);
         pin.setBounds(165,320,180,25);
         image.add(pin);
         
          pinfield=new JPasswordField();
         pinfield.setFont(new Font("System",Font.BOLD,16));
         pinfield.setBounds(330,320,180,25);
         image.add(pinfield);
         
         
         
          repin=new JLabel("RE ENTER NEW PIN ");
         repin.setFont(new Font("System",Font.BOLD,16));
         repin.setForeground(Color.WHITE);
         repin.setBounds(165,360,180,25);
         image.add(repin);
         
          repinfield=new JPasswordField();
         repinfield.setFont(new Font("Raleway",Font.BOLD,16));
         repinfield.setBounds(330,360,180,25);
         image.add(repinfield);
         
          change=new JButton("CHANGE");
         change.setBounds(335,435,150,30);
         change.addActionListener(this);
         image.add(change);
        
          back=new JButton("BACK");
         back.setBounds(335,480,150,30);
         back.addActionListener(this);
         image.add(back);
        
         setSize(900,900);
         setLocation(300,0);
         setUndecorated(true);
         setVisible(true);
        
    }
    
    
    public void  actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
        try{
            
            String npin=pinfield.getText();
            String rpin=repinfield.getText();
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter new PIN ");
                return;
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"please re enter  new PIN ");
                return;
            }
            
            Conn c=new Conn();
            String query1="update bank set pin='"+rpin+"'where pin='"+pinnumber+"'";
             String query2="update login set pinnumber='"+rpin+"'where pinnumber='"+pinnumber+"'";
              String query3="update signupthree set pinnumber='"+rpin+"'where pinnumber='"+pinnumber+"'";
              
              JOptionPane.showMessageDialog(null,"Your pin has been changed ");

              
              c.st.executeUpdate(query1);
              c.st.executeUpdate(query2);
              c.st.executeUpdate(query3);
              
              setVisible(false);
              new Transactions(rpin).setVisible(true);

            
        }catch(Exception e){
            System.out.println(e);
        }
        }
        else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        
        new PinChange("");
    }
    
}
