package airlinesystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JFrame f = new JFrame("Add Customer Details");
    JLabel title, name, gender, add, nation, phone, passport;
    JTextField tname, tadd, tnation, tphone, tpassport;
    JRadioButton male, female;
    JButton badd, bclr;
    ButtonGroup bg;
    
    AddCustomer(){
        title = new JLabel("Add Customer Details");
        name = new JLabel("Name");
        gender = new JLabel("Gender");
        add = new JLabel("Address");
        nation = new JLabel("Nationality");
        phone = new JLabel("Phone No.");
        passport = new JLabel("Passport No.");
        tname = new JTextField();
        tadd = new JTextField();
        tnation = new JTextField();
        tphone = new JTextField();
        tpassport = new JTextField();
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        badd = new JButton("Add Customer");
        bclr = new JButton("Clear");
        bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        title.setFont(new Font("algerian",Font.BOLD, 60));
        title.setBounds(80,15,700,60);
        name.setBounds(50,120,100,30);
        tname.setBounds(180,120,170,30);
        gender.setBounds(50,165,100,30);
        male.setBackground(Color.LIGHT_GRAY);
        male.setBounds(180,165,80,30);
	female.setBackground(Color.LIGHT_GRAY);
        female.setBounds(260,165,80,30);
        add.setBounds(50,210,100,30);
        tadd.setBounds(180,210,170,30);
        nation.setBounds(50,255,100,30);
        tnation.setBounds(180,255,170,30);
        phone.setBounds(50,300,100,30);
        tphone.setBounds(180,300,170,30);
        passport.setBounds(50,345,100,30);
        tpassport.setBounds(180,345,170,30);
        badd.setBounds(60,410,120,40);
        bclr.setBounds(210,410,120,40);
        f.add(title);
        f.add(name);
        f.add(tname);
        f.add(gender);
        f.add(male);
        f.add(female);
        f.add(add);
        f.add(tadd);
        f.add(nation);
        f.add(tnation);
        f.add(phone);
        f.add(tphone);
        f.add(passport);
        f.add(tpassport);
        f.add(badd);
        f.add(bclr);
        badd.addActionListener(this);
        bclr.addActionListener(this);
        f.getContentPane().setBackground(Color.LIGHT_GRAY);
        f.setLayout(null);
        f.setSize(860,520);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == badd){
            String name = tname.getText();
            String gender = null;
            String add = tadd.getText();
            String nation = tnation.getText();
            String phone = tphone.getText();
            String passport = tpassport.getText();
            if(male.isSelected()){
                gender = "male";
            }
            else if(female.isSelected()){
                gender = "female";
            }
            try{
                Conn c = new Conn();
                String query1 = "Select * from APP.Customer where passportNo = '" + passport + "'";
                ResultSet rs = c.s.executeQuery(query1);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"Customer Details Already Exists");
                }
                else{
                    String query2 = "insert into APP.Customer values('" + passport + "','" + name + "','" + gender + "','" + add + "','" + nation + "'," + phone + ")";
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                    setVisible(false);                
                }
            }   
            catch(Exception ex){
                ex.printStackTrace();
            }
            
        }
        else if(e.getSource() == bclr){
            tname.setText("");
            bg.clearSelection();
            tadd.setText("");
            tnation.setText("");
            tphone.setText("");
            tpassport.setText("");
            
        }
        
    }
    
}
