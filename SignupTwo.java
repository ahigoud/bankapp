 package bank.management.system;
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;



public class SignupTwo extends JFrame implements ActionListener{
    
   
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    
    JComboBox religion,category,income,occupation,educational;
    String formno;
    
    SignupTwo(String formno){
        
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICTION-FORM PAGE2");
        
        
        
        
        JLabel additonalDetails=new JLabel("page2:Additonal Details");
       additonalDetails.setFont(new Font("Raleway",Font.BOLD,22));
       additonalDetails.setBounds(260,100,400,30);
        add(additonalDetails);
        
    
        JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(80,150,150,30);
        add(name);
        
        
        String valReligion[]={"Hindu","Muslim","sikh","cristian","others"};
          religion=new JComboBox(valReligion);
         religion.setBounds(300,150,400,30);
         religion.setBackground(Color.WHITE);
        add(religion);
        
         
        
        JLabel fname=new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(80,200,150,30);
        add(fname);
        
        String valCategory[]={"General","BC","SC","ST","OBC","others"};
          category=new JComboBox(valCategory);
         category.setBounds(300,200,400,30);
         category.setBackground(Color.WHITE);
        add(category);
        
         
        
        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(80,250,150,30);
        add(dob);
        
        String incomeMoney[]={"null","<1,50,000","<2,50,000","<5,00,000","upto-10,00,000"};
          income=new JComboBox(incomeMoney);
         income.setBounds(300,250,400,30);
         income.setBackground(Color.WHITE);
        add(income);
        
        
        JLabel gender=new JLabel("Educational");
       gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(80,300,150,30);
        add(gender);
        
         
        
        
        
        JLabel email=new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(80,330,150,30);
        add(email);
        
        String educationalValues[]={"Not a graduate","Graduated","Post graduatede","Doctrate","Others"};
          educational=new JComboBox(educationalValues);
         educational.setBounds(300,330,400,30);
         educational.setBackground(Color.WHITE);
        add(educational);
        
         
        
        JLabel marital=new JLabel("Occupation:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(80,400,150,30);
        add(marital);
        
        String occupationValues[]={"Salaried","Self employed","Business","Student","Retired","Others"};
          occupation=new JComboBox(occupationValues);
         occupation.setBounds(300,400,400,30);
         occupation.setBackground(Color.WHITE);
        add(occupation);
   
        
        
        
        JLabel address=new JLabel("PAN number:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(80,450,150,30);
        add(address);
        
         pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,16));
        pan.setBounds(300,450,400,30);
        add(pan);
        
        
        JLabel city=new JLabel("Aadhar number:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(80,500,180,30);
        add(city);
        
         aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,16));
        aadhar.setBounds(300,500,400,30);
        add(aadhar);
        
        
        
        JLabel state=new JLabel("Senior citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(80,550,180,20);
        add(state);
        
        
        syes = new JRadioButton("yes");
        syes.setBounds(300,550,75,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("no");
        sno.setBounds(400,550,75,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        
        ButtonGroup status = new ButtonGroup();
        status.add(syes);
        status.add(sno);
        
        
         
        
        JLabel pincode=new JLabel("Existing account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(80,600,180,30);
        add(pincode);
        
        
        eyes = new JRadioButton("yes");
        eyes.setBounds(300,600,75,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("no");
        eno.setBounds(400,600,75,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        
        ButtonGroup status1 = new ButtonGroup();
        status1.add(eyes);
        status1.add(eno);
     
        
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
        
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)educational.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected()){
            seniorcitizen="yes";
        }
        else if(syes.isSelected()){
            seniorcitizen="no";
        }
        
        String existingaccount=null;
        if(eyes.isSelected()){
            existingaccount="yes";
        }
        else if(eno.isSelected()){
            existingaccount="no";
        }
        
        String span=pan.getText();
        String saadhar=aadhar.getText();
        
        try{
                Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.st.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new SignupTwo("");
        
    }
    
}

