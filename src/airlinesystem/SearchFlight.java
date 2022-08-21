package airlinesystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SearchFlight extends JFrame implements ActionListener {
    
    JFrame f = new JFrame("Search Flight");
    JLabel title, src, dest, flightno, dtime, atime, price;
    JTextField tsrc, tdest, tflightno, tdtime, tatime, tprice;
    JButton bsrch, bclr;
    
    SearchFlight(){
        title = new JLabel("Search Flight");
        src = new JLabel("Source");
        dest = new JLabel("Destination");
        flightno = new JLabel("Flight No.");
        dtime = new JLabel("Departure Time");
        atime = new JLabel("Arrival Time");
        price = new JLabel("Price");
        tsrc = new JTextField();
        tdest = new JTextField();
        tflightno = new JTextField();
        tdtime = new JTextField();
        tatime = new JTextField();
        tprice = new JTextField();
        tflightno.setEditable(false);
        tdtime.setEditable(false);
        tatime.setEditable(false);
        tprice.setEditable(false);
        bsrch = new JButton("Search Flight");
        bclr = new JButton("Clear");
        title.setFont(new Font("algerian",Font.BOLD, 80));
        title.setBounds(130,5,600,100);
        src.setBounds(30,150,70,30);
        tsrc.setBounds(100,150,120,30);
        dest.setBounds(250,150,70,30);
        tdest.setBounds(350,150,120,30);
        bsrch.setBounds(520,145,120,40);
        bclr.setBounds(680,145,120,40);
        flightno.setBounds(70,210,170,30);
        dtime.setBounds(260,210,170,30);
        atime.setBounds(450,210,170,30);
        price.setBounds(640,210,170,30);
        tflightno.setBounds(70, 270, 170, 30);
        tdtime.setBounds(260, 270, 170, 30);
        tatime.setBounds(450, 270, 170, 30);
        tprice.setBounds(640, 270, 170, 30);
        f.add(title);
        f.add(src);
        f.add(dest);
        f.add(flightno);
        f.add(dtime);
        f.add(atime);
        f.add(price);
        f.add(tsrc);
        f.add(tdest);
        f.add(tflightno);
        f.add(tdtime);
        f.add(tatime);
        f.add(tprice);
        f.add(bsrch);
        f.add(bclr);
        bsrch.addActionListener(this);
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
        
        if(e.getSource() == bsrch){
            try{
                String src = tsrc.getText();
                String dest = tdest.getText();
                Conn c = new Conn();
                String query = "select flightno, dtime, atime, price from APP.Flight where src = '" + src + "' and dest = '" + dest + "'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    tflightno.setText(rs.getString("flightNo"));
                    tdtime.setText(rs.getString("dtime"));
                    tatime.setText(rs.getString("atime"));
                    tprice.setText(rs.getString("price"));
                }
                else{
                    JOptionPane.showMessageDialog(null,"No Flights Available");
                }
                
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else if(e.getSource() == bclr){
            tsrc.setText("");
            tdest.setText("");
            tflightno.setText("");
            tdtime.setText("");
            tatime.setText("");
            tprice.setText("");
        }
    }
    
}