
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton b1,b2,b3,b4;
    JCheckBox c1,c2,c3,c4,c5;
    JButton submit,cancel;
    String formno;
    
    SignupThree(String formno){
        this.formno=formno;
        setLayout(null);
        JLabel l1=new JLabel("Page No:2 Accounts Details");
        l1.setFont(new Font("Raleway",Font.BOLD,26));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type=new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,25));
        type.setBounds(100,140,200,30);
        add(type);
        
        
        
        
        
        
        b1=new JRadioButton("Savings Account");
        b1.setFont(new Font("Raleway",Font.BOLD,16));
        b1.setBackground(Color.WHITE);
        b1.setBounds(100,180,250,30);
        add(b1);
        
        
        b2=new JRadioButton("Fixed Deposit Account");
        b2.setFont(new Font("Raleway",Font.BOLD,16));
        b2.setBackground(Color.WHITE);
        b2.setBounds(350,180,250,30);
        add(b2);
        
        b2=new JRadioButton("current Account");
        b2.setFont(new Font("Raleway",Font.BOLD,16));
        b2.setBackground(Color.WHITE);
        b2.setBounds(100,220,250,30);
        add(b2);
        
        b2=new JRadioButton("Reccuring Deposite Account");
        b2.setFont(new Font("Raleway",Font.BOLD,16));
        b2.setBackground(Color.WHITE);
        b2.setBounds(350,220,250,30);
        add(b2);
        
        ButtonGroup grpaccnt=new ButtonGroup();
        grpaccnt.add(b1);
        grpaccnt.add(b2);
        grpaccnt.add(b3);
        grpaccnt.add(b4);
        
        
        JLabel card=new JLabel("Card No:");
        card.setFont(new Font("Raleway",Font.BOLD,25));
        card.setBounds(100,300,200,30);
        add(card);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-5555");
        number.setFont(new Font("Raleway",Font.BOLD,25));
        number.setBounds(330,300,350,30);
        add(number);
        
        JLabel carddeatil=new JLabel("Your 16-digit card number:");
        carddeatil.setFont(new Font("Raleway",Font.BOLD,12));
        carddeatil.setBounds(100,330,300,20);
        add(carddeatil);
        
        JLabel pin=new JLabel("Pin:");
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        JLabel pindetails=new JLabel("your 4-digit password:");
        pindetails.setFont(new Font("Raleway",Font.BOLD,12));
        pindetails.setBounds(100,400,200,30);
        add(pindetails);
        
        JLabel pinnumber=new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway",Font.BOLD,25));
        pinnumber.setBounds(330,370,350,30);
        add(pinnumber);
        
        JLabel service=new JLabel("Services required:");
        service.setFont(new Font("Raleway",Font.BOLD,22));
        service.setBounds(100,450,200,30);
        add(service);
        
        
         c1=new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBackground(Color.WHITE);
        c1.setBounds(130,500,200,30);
        add(c1);
        
        c2=new JCheckBox("Internate banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBackground(Color.WHITE);
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3=new JCheckBox("Mobilebanking");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBackground(Color.WHITE);
        c3.setBounds(130,550,200,30);
        add(c3);
        
        c4=new JCheckBox("ChequeBook");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBackground(Color.WHITE);
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5=new JCheckBox("I here by declare that all the entered details are correct as per my knowledge");
        c5.setFont(new Font("Raleway",Font.BOLD,12));
        c5.setBackground(Color.WHITE);
        c5.setBounds(100,680,600,20);
        add(c5);
        
        submit =new JButton("sumbit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,12));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
         cancel =new JButton("cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,12));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);

        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
        
        
        setSize(850,820);
        setVisible(true);
        setLocation(320,0);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==submit){
            String accountType="";
            if(b1.isSelected()){                 
                accountType="Savings Account";
                
            }else if(b2.isSelected()){
                accountType="Fixed Deposit Account";
            }else if(b3.isSelected()){
                accountType="current Account";
            }
            else if(b4.isSelected()){
                accountType="Reccuring Deposite Account";
            }
            Random r=new Random();
            String cardnumber=""+Math.abs((r.nextLong()%90000000L)+5040936000000000L);
            String pinnumber=""+Math.abs((r.nextLong()%9000L)+1000L);
            
            String facility="";
            if(c1.isSelected()){
                facility+="ATM CARD";
            }else if(c2.isSelected()){
                facility+="Internate banking";
            }else if(c3.isSelected()){
                facility+="Mobilebanking";
            }else if(c3.isSelected()){
                facility+="ChequeBook";
            }
            try{
                if(accountType.equals("")){
                JOptionPane.showMessageDialog(null,"Account Type required");
                
            }
                else{
                    Conn c=new Conn();
                
                    String query="insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";

                    c.st.executeUpdate(query);
                    c.st.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null,"cardnumber:"+cardnumber+"\n pin:"+pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                }
                
                
            }
            catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
            
            
            
        }
        
    }
    
    public static void main(String args[]){
        new SignupThree("");
        
    }
    
}
