package airlinesystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BookTicket extends JFrame implements ActionListener {
    
    JFrame f = new JFrame();
    JLabel title, ticketno, passport, flightno, date;
    JTextField tticketno, tpassport, tflightno, tdate;
    JButton bbook, bclr;
    
    BookTicket(){
        title = new JLabel("Book Ticket");
        ticketno = new JLabel("Ticket No.");
        passport = new JLabel("Passport No.");
        flightno = new JLabel("Flight No.");
        date = new JLabel("Journey Date");
        tticketno = new JTextField();
        tpassport = new JTextField();
        tflightno = new JTextField();
        tdate = new JTextField();
        bbook = new JButton("Book Ticket");
        bclr = new JButton("Clear");
        title.setFont(new Font("algerian",Font.BOLD, 90));
        title.setBounds(140,15,600,70);
        ticketno.setBounds(50,170,100,30);
        tticketno.setBounds(180,170,170,30);
        passport.setBounds(50,220,100,30);
        tpassport.setBounds(180,220,170,30);
        flightno.setBounds(50,270,100,30);
        tflightno.setBounds(180,270,170,30);
        date.setBounds(50,320,100,30);
        tdate.setBounds(180,320,170,30);
        bbook.setBounds(60,390,120,40);
        bclr.setBounds(210,390,120,40);
        f.add(title);
        f.add(ticketno);
        f.add(tticketno);
        f.add(passport);
        f.add(tpassport);
        f.add(flightno);
        f.add(tflightno);
        f.add(date);
        f.add(tdate);
        f.add(bbook);
        f.add(bclr);
        bbook.addActionListener(this);
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
        
        if(e.getSource() == bbook){
            String ticketno = tticketno.getText();
            String passport = tpassport.getText();
            String flightno = tflightno.getText();
            String date = tdate.getText();
        
            try{
                Conn c = new Conn();
                String query1 = "Select * from APP.Flight where flightNo = '" + flightno + "'";
                ResultSet rs = c.s.executeQuery(query1);
                if(!rs.next()){
                    JOptionPane.showMessageDialog(null,"Invalid Details");  
                }
                else{
                    String query2 = "insert into APP.Ticket values('" + ticketno + "','" + passport + "','" + flightno + "','" + date + "')";
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Ticket Booked");
                    setVisible(false);              
                }
            }   
            catch(Exception ex){
                ex.printStackTrace();
            }            
        }
        else if(e.getSource() == bclr){
            tticketno.setText("");
            tpassport.setText("");
            tflightno.setText("");
            tdate.setText("");
        }
    }
}