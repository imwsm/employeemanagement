
package employee.management.system;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash extends JFrame implements ActionListener{
    
    Splash(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Employee Management System");
        heading.setBounds(120,10,1200,75);
        heading.setFont(new Font("serif",Font.BOLD,60));
        heading.setForeground(Color.red);
        add(heading);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2=i1.getImage().getScaledInstance(1100, 650, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(50,100,1050,500);
        add(image);
        JButton clickhere=new JButton("Click Here To Continue");
        clickhere.setBounds(400,400,300,70);
        clickhere.setFont(new Font("SAN_SERIF", Font.PLAIN, 24));
        clickhere.addActionListener(this);
        image.add(clickhere);
        clickhere.setBackground(Color.black);
        clickhere.setForeground(Color.white);
        setSize(1100,650);
        setLocation(140,70);
        setVisible(true);
        while(true){
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
               
            }
            heading.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
               
            }
        }
    }
    
    public static void main(String args[]){
        new Splash();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
        
        
    }
}
