package airlinesystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Ticket extends JFrame implements ActionListener {
   
    JFrame f = new JFrame("See Ticket");
    JLabel title, ticketno, name, flightno, src, dest, date, dtime, atime;
    JTextField tticketno, tname, tflightno, tsrc, tdest, tdate, tdtime, tatime;
    JButton bsee, bclr;
    
    Ticket(){
        title = new JLabel("See Ticket");
        ticketno = new JLabel("Ticket No.");
        name = new JLabel("Customer's Name");
        flightno = new JLabel("Flight No.");
        src = new JLabel("Source");
        dest = new JLabel("Destination");
        date = new JLabel("Journey Date");
        dtime = new JLabel("Departure Time");
        atime = new JLabel("Arrival Time");
        tticketno = new JTextField();
        tname = new JTextField();
        tname.setEditable(false);
        tflightno = new JTextField();
        tflightno.setEditable(false);
        tsrc = new JTextField();
        tsrc.setEditable(false);
        tdest = new JTextField();
        tdest.setEditable(false);
        tdate = new JTextField();
        tdate.setEditable(false);
        tdtime = new JTextField();
        tdtime.setEditable(false);
        tatime = new JTextField();
        tatime.setEditable(false);
        bsee = new JButton("See Ticket");
        bclr = new JButton("Clear");
        title.setFont(new Font("algerian",Font.BOLD, 90));
        title.setBounds(170,15,500,70);
        ticketno.setBounds(50,140,100,30);
        tticketno.setBounds(180,140,170,30);
        bsee.setBounds(135,190,120,40);
        name.setBounds(50,250,100,30);
        tname.setBounds(180,250,170,30);
        flightno.setBounds(50,300,100,30);
        tflightno.setBounds(180,300,170,30);
        src.setBounds(50,350,100,30);
        tsrc.setBounds(180,350,170,30);
        dest.setBounds(50,400,100,30);
        tdest.setBounds(180,400,170,30);
        date.setBounds(50,450,100,30);
        tdate.setBounds(180,450,170,30);
        dtime.setBounds(50,500,100,30);
        tdtime.setBounds(180,500,170,30);
        atime.setBounds(50,550,100,30);
        tatime.setBounds(180,550,170,30);
        bclr.setBounds(135,605,120,40);
        f.add(title);
        f.add(ticketno);
        f.add(tticketno);
        f.add(name);
        f.add(tname);
        f.add(flightno);
        f.add(tflightno);
        f.add(src);
        f.add(tsrc);
        f.add(dest);
        f.add(tdest);
        f.add(date);
        f.add(tdate);
        f.add(dtime);
        f.add(tdtime);
        f.add(atime);
        f.add(tatime);
        f.add(bsee);
        f.add(bclr);
        bsee.addActionListener(this);
        bclr.addActionListener(this);
        f.getContentPane().setBackground(Color.LIGHT_GRAY);
        f.setLayout(null);
        f.setSize(860,710);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == bsee){
            String ticketno = tticketno.getText();
        
            try{
                Conn c = new Conn();
                String query1 = "select * from APP.Ticket where ticketNo = '" + ticketno + "'";
                ResultSet rs1 = c.s.executeQuery(query1);
                if(rs1.next()){
                    tflightno.setText(rs1.getString("flightNo"));
                    tdate.setText(rs1.getString("date"));
                    String flightno = rs1.getString("flightNo");
                    String passportno = rs1.getString("passportNo");
                    String query2 = "select * from APP.Customer where passportNo = '" + passportno + "'";
                    ResultSet rs2 = c.s.executeQuery(query2);
                    if(rs2.next()){
                        tname.setText(rs2.getString("name"));
                    }
                    String query3 = "select * from APP.Flight where flightNo = '" + flightno + "'";
                    ResultSet rs3 = c.s.executeQuery(query3);
                    if(rs3.next()){
                        tsrc.setText(rs3.getString("src"));
                        tdest.setText(rs3.getString("dest"));
                        tdtime.setText(rs3.getString("dtime"));
                        tatime.setText(rs3.getString("atime"));
                                        
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Details");                
                }
            }   
            catch(Exception ex){
                ex.printStackTrace();
            }            
        }
        else if(e.getSource() == bclr){
            tticketno.setText("");
            tname.setText("");
            tflightno.setText("");
            tsrc.setText("");
            tdest.setText("");
            tdtime.setText("");
            tdate.setText("");
            tatime.setText("");
        }
    }
    
}