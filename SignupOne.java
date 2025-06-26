package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;



public class SignupOne extends JFrame implements ActionListener{
    
    long r;
    JTextField textname,textfname,textemail,textaddress,textcity,textstate,textpincode;
    JButton next;
    JRadioButton male,female,others,married,unmarried;
    JDateChooser jdate;
    
    SignupOne(){
        setLayout(null);
        
        Random ran=new Random();
        r=Math.abs((ran.nextLong()%9000L)+1000L);
        
        JLabel formno=new JLabel("APPLICATION FORMNO:"+r);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        
        JLabel personalDetails=new JLabel("page1:Personal Details");
       personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,100,400,30);
        add(personalDetails);
        
        JLabel name=new JLabel("Full Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(80,150,150,30);
        add(name);
        
         textname=new JTextField();
        textname.setFont(new Font("Raleway",Font.BOLD,16));
        textname.setBounds(300,150,400,30);
        add(textname);
        
        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(80,200,150,30);
        add(fname);
        
         textfname=new JTextField();
        textfname.setFont(new Font("Raleway",Font.BOLD,16));
        textfname.setBounds(300,200,400,30);
        add(textfname);
        
        JLabel dob=new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(80,250,150,30);
        add(dob);
        
         
         jdate=new JDateChooser();
        jdate.setBounds(300,250,400,30);
        jdate.setForeground(new Color(105,105,105));
        add(jdate);
        
        
        JLabel gender=new JLabel("Gender:");
       gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(80,300,150,30);
        add(gender);
        
         male=new JRadioButton("Male");
        male.setBounds(300,300,75,30);
        male.setBackground(Color.WHITE);
        add(male);
        
         female=new JRadioButton("Female");
        female.setBackground(Color.WHITE);
        female.setBounds(400,300,75,30);
        add(female);
        
         others=new JRadioButton("Others");
        others.setBounds(500,300,75,30);
        others.setBackground(Color.WHITE);
        add(others);
        
        ButtonGroup gendergrp=new ButtonGroup();
        gendergrp.add(male);
        gendergrp.add(female);
        gendergrp.add(others);
        
        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(80,350,150,30);
        add(email);
        
         textemail=new JTextField();
        textemail.setFont(new Font("Raleway",Font.BOLD,16));
        textemail.setBounds(300,350,400,30);
        add(textemail);
        
        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(80,400,150,30);
        add(marital);
        
         married=new JRadioButton("Married");
        married.setBounds(300,400,75,30);
        married.setBackground(Color.WHITE);
        add(married);
        
         unmarried=new JRadioButton("Unmarried");
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(400,400,100,30);
        add(unmarried);
        
        
        
        
        ButtonGroup status=new ButtonGroup();
        status.add(married);
        status.add(unmarried);
        
        
        
        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(80,450,150,30);
        add(address);
        
         textaddress=new JTextField();
        textaddress.setFont(new Font("Raleway",Font.BOLD,16));
        textaddress.setBounds(300,450,400,30);
        add(textaddress);
        
        
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(80,500,150,30);
        add(city);
        
         textcity=new JTextField();
        textcity.setFont(new Font("Raleway",Font.BOLD,16));
        textcity.setBounds(300,500,400,30);
        add(textcity);
        
        
        
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(80,550,150,20);
        add(state);
        
         textstate=new JTextField();
        textstate.setFont(new Font("Raleway",Font.BOLD,16));
        textstate.setBounds(300,550,400,30);
        add(textstate);
        
        
        JLabel pincode=new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(80,600,150,20);
        add(pincode);
        
         textpincode=new JTextField();
        textpincode.setFont(new Font("Raleway",Font.BOLD,16));
        textpincode.setBounds(300,600,400,30);
        add(textpincode);
        
        
         next=new JButton("Next>>");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,650,80,30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,800);
        setVisible(true);
        setLocation(350,20);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        String formno=""+r;
        String name=textname.getText();
        String fname=textfname.getText();
        String dob=((JTextField)jdate.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="male";
        }
        else if(female.isSelected()){
            gender="female";
        }
        else if(others.isSelected()){
            gender="others";
        }
        String email=textemail.getText();
        String marital=null;
        if(married.isSelected()){
            marital="married";
        }
        else if(unmarried.isSelected()){
            marital="unmarried";
        }
        
        String address=textaddress.getText();
        String city=textcity.getText();
        String state=textstate.getText();
        String pin=textpincode.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"name is required");
            }else {
                Conn c=new Conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.st.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
                
                
                
                                                                 
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new SignupOne();
        
    }
    
}
