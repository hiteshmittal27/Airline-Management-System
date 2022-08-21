package airlinesystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CancelTicket extends JFrame implements ActionListener {
    
    JFrame f = new JFrame();
    JLabel title, ticketno, passport, flightno, date;
    JTextField tticketno, tpassport, tflightno, tdate;
    JButton bfetch, bcancel, bclr;
    
    CancelTicket(){
        title = new JLabel("Cancel Ticket");
        ticketno = new JLabel("Ticket No.");
        passport = new JLabel("Passport No.");
        flightno = new JLabel("Flight No.");
        date = new JLabel("Cancellation Date");
        tticketno = new JTextField();
        tpassport = new JTextField();
        tpassport.setEditable(false);
        tflightno = new JTextField();
        tflightno.setEditable(false);
        tdate = new JTextField();
        bfetch = new JButton("Fetch");
        bcancel = new JButton("Cancel Ticket");
        bclr = new JButton("Clear");
        title.setFont(new Font("algerian",Font.BOLD, 90));
        title.setBounds(115,15,600,70);
        ticketno.setBounds(50,140,100,30);
        tticketno.setBounds(180,140,170,30);
        bfetch.setBounds(135,190,120,40);
        passport.setBounds(50,250,100,30);
        tpassport.setBounds(180,250,170,30);
        flightno.setBounds(50,300,100,30);
        tflightno.setBounds(180,300,170,30);
        date.setBounds(50,350,100,30);
        tdate.setBounds(180,350,170,30);
        bcancel.setBounds(60,415,120,40);
        bclr.setBounds(210,415,120,40);
        f.add(title);
        f.add(ticketno);
        f.add(tticketno);
        f.add(passport);
        f.add(tpassport);
        f.add(flightno);
        f.add(tflightno);
        f.add(date);
        f.add(tdate);
        f.add(bfetch);
        f.add(bcancel);
        f.add(bclr);
        bfetch.addActionListener(this);
        bcancel.addActionListener(this);
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
        
        String ticketno = tticketno.getText();
        if(e.getSource() == bfetch){
            try{
                Conn c = new Conn();
                String query1 = "Select passportNo, flightNo from APP.Ticket where ticketNo = '" + ticketno + "'";
                ResultSet rs1 = c.s.executeQuery(query1);
                if(rs1.next()){
                    tpassport.setText(rs1.getString("passportNo"));
                    tflightno.setText(rs1.getString("flightNo"));
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Details");
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }        
        else if(e.getSource() == bcancel){
            
            String passport = tpassport.getText();
            String flightno = tflightno.getText();
            String date = tdate.getText();
        
            try{
                Conn c = new Conn();
                String query2 = "insert into APP.Cancel values('" + ticketno + "','" + passport + "','" + flightno + "','" + date + "')";
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Ticket Cancelled");
                setVisible(false);
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