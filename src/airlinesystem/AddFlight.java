package airlinesystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddFlight extends JFrame implements ActionListener {
   
    JFrame f = new JFrame("Add Flight Details");
    JLabel title, no, src, dest, dtime, atime, price;
    JTextField tno, tsrc, tdest, tdtime, tatime, tprice;
    JButton badd, bclr;
    
    AddFlight(){
        title = new JLabel("Add Flight Details");
        no = new JLabel("Flight No.");
        src = new JLabel("Source");
        dest = new JLabel("Destination");
        dtime = new JLabel("Departure Time");
        atime = new JLabel("Arrival Time");
        price = new JLabel("Price");
        tno = new JTextField();
        tsrc = new JTextField();
        tdest = new JTextField();
        tdtime = new JTextField();
        tatime = new JTextField();
        tprice = new JTextField();
        badd = new JButton("Add Flight");
        bclr = new JButton("Clear");
        title.setFont(new Font("algerian",Font.BOLD, 60));
        title.setBounds(145,15,600,80);
        no.setBounds(50,120,100,30);
        tno.setBounds(180,120,170,30);
        src.setBounds(50,165,100,30);
        tsrc.setBounds(180,165,170,30);
        dest.setBounds(50,210,100,30);
        tdest.setBounds(180,210,170,30);
        dtime.setBounds(50,255,100,30);
        tdtime.setBounds(180,255,170,30);
        atime.setBounds(50,300,100,30);
        tatime.setBounds(180,300,170,30);
        price.setBounds(50,345,100,30);
        tprice.setBounds(180,345,170,30);
        badd.setBounds(60,410,120,40);
        bclr.setBounds(210,410,120,40);
        f.add(title);
        f.add(no);
        f.add(tno);
        f.add(src);
        f.add(tsrc);
        f.add(dest);
        f.add(tdest);
        f.add(dtime);
        f.add(tdtime);
        f.add(atime);
        f.add(tatime);
        f.add(price);
        f.add(tprice);
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
            String no = tno.getText();
            String src = tsrc.getText();
            String dest = tdest.getText();
            String dtime = tdtime.getText();
            String atime = tatime.getText();
            String price = tprice.getText();
        
            try{
                Conn c = new Conn();
                String query1 = "Select * from APP.Flight where flightNo = '" + no + "'";
                ResultSet rs = c.s.executeQuery(query1);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"Flight Details Already Exists");
                }
                else{
                    String query2 = "insert into APP.Flight values('" + no + "','" + src + "','" + dest + "','" + dtime + "','" + atime + "'," + price + ")";
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Flight Details Added Successfully");
                    setVisible(false);                
                }
            }   
            catch(Exception ex){
                ex.printStackTrace();
            }            
        }
        else if(e.getSource() == bclr){
            tno.setText("");
            tsrc.setText("");
            tdest.setText("");
            tdtime.setText("");
            tatime.setText("");
            tprice.setText("");
        }
    }
    
}