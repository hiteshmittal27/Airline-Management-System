package airlinesystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JFrame f = new JFrame("Login");
    JLabel title, user, pswrd;
    JTextField tuser;
    JPasswordField tpswrd;
    JButton blogin, bclr;
    
    public Login(){
        
        title = new JLabel("Login");
        user = new JLabel("Username");
        pswrd = new JLabel("Password");
        tuser = new JTextField("");
        tpswrd = new JPasswordField("");
        blogin = new JButton("Login");
        bclr = new JButton("Clear");
        title.setFont(new Font("algerian",Font.BOLD, 80));
        title.setBounds(305,10,300,100);
        user.setBounds(50,170,100,35);
        tuser.setBounds(180,170,170,35);
        pswrd.setBounds(50,240,100,35);
        tpswrd.setBounds(180,240,170,35);
        blogin.setBounds(70,330,80,40);
        bclr.setBounds(220,330,80,40);
        f.add(title);
        f.add(user);
        f.add(pswrd);
        f.add(tuser);
        f.add(tpswrd);
        f.add(blogin);
        f.add(bclr);
        blogin.addActionListener(this);
        bclr.addActionListener(this);
        f.getContentPane().setBackground(Color.LIGHT_GRAY);
        f.setLayout(null);
        f.setSize(860,520);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == blogin){
            String user = tuser.getText();
            String pswrd = tpswrd.getText();
            try{
                Conn c = new Conn();    
                String query = "select * from APP.Login where username = '" + user + "' and password = '" + pswrd + "'";
                
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    new Homepage();
                    f.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Details");
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }   
        }
        else if(e.getSource() == bclr){
            tuser.setText("");
            tpswrd.setText("");
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}
