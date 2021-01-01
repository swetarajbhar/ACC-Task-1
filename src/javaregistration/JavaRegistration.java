
package javaregistration;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JavaRegistration extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t6;
    JPasswordField t4,t5;
    JButton b1;
    JComboBox c1;
    
    public JavaRegistration() {
        l8=new JLabel("REGISTRATION FORM");
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("serif",Font.PLAIN,30));
        l8.setBounds(240,0,350,50);
        add(l8);
        
        l1=new JLabel("Enter First Name : ");
        l1.setBounds(200,70,200,30);
        add(l1);
        
        t1=new JTextField();
        t1.setBounds(380, 70, 200, 30);
        add(t1);
        
        l2=new JLabel("Enter Last Name : ");
        l2.setBounds(200,110,200,30);
        add(l2);
        
        t2=new JTextField();
        t2.setBounds(380, 110, 200, 30);
        add(t2);
        
        l3=new JLabel("Select Course : ");
        l3.setBounds(200,150,200,30);
        add(l3);
        
        String s1[]={"Select","MCA","MMS","MBA","PGDM"};
        c1=new JComboBox(s1);
        c1.setBackground(Color.WHITE);
        c1.setBounds(380,150,200,30);
        add(c1);
       
        
        l4=new JLabel("Enter Email Id : ");
        l4.setBounds(200,190,200,30);
        add(l4);
        
        t3=new JTextField();
        t3.setBounds(380, 190, 200, 30);
        add(t3);
        
        l5=new JLabel("Enter Password");
        l5.setBounds(200,230,200,30);
        add(l5);
        
        t4=new JPasswordField();
        t4.setBounds(380, 230, 200, 30);
        add(t4);
        
        l6=new JLabel("Enter Confirm Password : ");
        l6.setBounds(200,270,200,30);
        add(l6);
        
        t5=new JPasswordField();
        t5.setBounds(380, 270, 200, 30);
        add(t5);
        
        b1=new JButton("Sign Up");
        b1.setBounds(320,340,180,30);
        add(b1);
        b1.addActionListener(this);
        
        setBounds(180,150,800,500);
        setLayout(null);
        setVisible(true);
    }

   public void actionPerformed(ActionEvent ae)
   {
       String fname=t1.getText();
       String lname=t2.getText();
       String course=c1.getSelectedItem().toString();
       String email=t3.getText();
       String pass= new String(t4.getPassword());
       String cpass=new String(t5.getPassword());
       if(pass.equals(cpass))
       {
           pass=cpass;
           try
            {
                conn c=new conn();
                String query="insert into student(firstName,lastName,course,email,password) values ('"+fname+"','"+lname+"','"+course+"','"+email+"','"+pass+"')";
                 c.st.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"Registration Successful");
                 t1.setText("");
                 t2.setText("");
                 c1.setSelectedIndex(0);
                 t3.setText("");
                 t4.setText("");
                 t5.setText("");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
       }
       else
       {
           JOptionPane.showMessageDialog(null, "Password Must Match");
            t4.setText("");
            t5.setText("");
       }
       
   }
    
    
    public static void main(String[] args) {
        
        new JavaRegistration();
    }
    
}
