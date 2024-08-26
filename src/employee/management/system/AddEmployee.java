
package employee.management.system;

import java.util.*;
import java.awt.Color;
import java.awt.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class AddEmployee extends JFrame implements ActionListener{
    Random ran=new Random();
    int number=ran.nextInt(999999);
    JButton add,back;
    JTextField tfname, tffname,tfsalary,tfaddress,tfphone,tfemail,tfdesignation,tfaadhar;
    JDateChooser dcdob;
    JComboBox  cbeducation;
    JLabel lblempid;
    
    public AddEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading=new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("san serif",Font.BOLD,25));
        add(heading);
        
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(100,150,150,30);
        labelname.setFont(new Font("san serif",Font.PLAIN,20));
        add(labelname);
        
        tfname=new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        
        JLabel labelfname=new JLabel("Father's Name");
        labelfname.setBounds(420,150,150,30);
        labelfname.setFont(new Font("san serif",Font.PLAIN,20));
        add(labelfname);
        
        tffname=new JTextField();
        tffname.setBounds(560,150,150,30);
        add(tffname);
        
         JLabel dob=new JLabel("Enter DOB");
        dob.setBounds(100,200,150,30);
        dob.setFont(new Font("san serif",Font.PLAIN,20));
        add(dob);
        
        dcdob=new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);
        
        JLabel labelsalary=new JLabel("Salary");
        labelsalary.setBounds(450,200,150,30);
        labelsalary.setFont(new Font("san serif",Font.PLAIN,20));
        add(labelsalary);
        
        tfsalary=new JTextField();
        tfsalary.setBounds(560,200,150,30);
        add(tfsalary);
        
        JLabel labeladdress=new JLabel("Address");
        labeladdress.setBounds(100,250,150,30);
        labeladdress.setFont(new Font("san serif",Font.PLAIN,20));
        add(labeladdress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        JLabel labelphone=new JLabel("Phone");
        labelphone.setBounds(450,250,150,30);
        labelphone.setFont(new Font("san serif",Font.PLAIN,20));
        add(labelphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(560,250,150,30);
        add(tfphone);
        
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(100,300,150,30);
        labelemail.setFont(new Font("san serif",Font.PLAIN,20));
        add(labelemail);
        
        tfemail=new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        JLabel labeleducation=new JLabel("Highest Education");
        labeleducation.setBounds(390,300,150,30);
        labeleducation.setFont(new Font("san serif",Font.PLAIN,19));
        add(labeleducation);
        String courses[]={"BBA","BCA","BSC","BTECH","MBA","MCA","PhD","..."};
        
        cbeducation=new JComboBox(courses);
        cbeducation.setBackground(Color.white);
        cbeducation.setBounds(560,300,150,30);
        add(cbeducation);
        
        JLabel labeldesignation=new JLabel("Designation");
        labeldesignation.setBounds(100,350,150,30);
        labeldesignation.setFont(new Font("san serif",Font.PLAIN,20));
        add(labeldesignation);
        
        tfdesignation=new JTextField();
        tfdesignation.setBounds(210,350,150,30);
        add(tfdesignation);
        
        JLabel labelaadhar=new JLabel("Aadhar Number");
        labelaadhar.setBounds(400,350,150,30);
        labelaadhar.setFont(new Font("san serif",Font.PLAIN,20));
        add(labelaadhar);
        
        tfaadhar=new JTextField();
        tfaadhar.setBounds(560,350,150,30);
        add(tfaadhar);
        
         JLabel labelempid=new JLabel("Employee ID");
        labelempid.setBounds(100,400,150,30);
        labelempid.setFont(new Font("san serif",Font.PLAIN,20));
        add(labelempid);
        
        lblempid=new JLabel(""+number);
        lblempid.setBounds(220,400,150,30);
        lblempid.setFont(new Font("san serif",Font.BOLD,20));
        lblempid.setBackground(Color.BLACK);
        lblempid.setForeground(Color.RED);
        add(lblempid);
        
        add=new JButton("Add Details");
        add.setBounds(220,460,150,40);
         add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back=new JButton("Back");
        back.setBounds(430,460,150,40);
         back.addActionListener(this);
         back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(850,600);
        setLocation(300,100);
        setVisible(true);
    }
    
    
    
    public static void main(String args[]){
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add){
            String name=tfname.getText();
            String fname=tffname.getText();
            String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary=tfsalary.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText(); 
            String education=(String)cbeducation.getSelectedItem(); 
            String designation=tfdesignation.getText(); 
            String aadhar=tfaadhar.getText();     
            String empID=lblempid.getText(); 
         
            try{
                Conn conn=new Conn();
                String query="insert into employee  values ('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empID+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Inserted Successfully");
                setVisible(false);
                new Home();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Home();
        }
        
    }
    
}
