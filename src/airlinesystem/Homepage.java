package airlinesystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage extends JFrame implements ActionListener {
    
    JFrame f = new JFrame("Airlines Management System");
    JLabel title;
    JButton badd, baddf, bsearch, bticket, bbook, bcancel;
    
    Homepage(){
        
        title = new JLabel("Airlines Management System");
        badd = new JButton("Add Customer");
        baddf = new JButton("Add Flight");
        bsearch = new JButton("Search Flight");
        bticket = new JButton("See Ticket");
        bbook = new JButton("Book Ticket");
        bcancel = new JButton("Cancel Ticket");
        title.setFont(new Font("algerian",Font.BOLD, 55));
        title.setBounds(40,15,800,80);
        badd.setBounds(50,150,120,50);
        baddf.setBounds(225,150,120,50);
        bsearch.setBounds(50,245,120,50);
        bticket.setBounds(225,245,120,50);
        bbook.setBounds(50,340,120,50);
        bcancel.setBounds(225,340,120,50);
        f.add(title);
        f.add(badd);
        f.add(baddf);
        f.add(bsearch);
        f.add(bticket);
        f.add(bbook);
        f.add(bcancel);
        badd.addActionListener(this);
        baddf.addActionListener(this);
        bsearch.addActionListener(this);
        bticket.addActionListener(this);
        bbook.addActionListener(this);
        bcancel.addActionListener(this);
        f.getContentPane().setBackground(Color.LIGHT_GRAY);
        f.setLayout(null);
        f.setSize(860,520);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == badd){
            new AddCustomer();
        }
        else if(e.getSource() == baddf){
            new AddFlight();
        }
        else if(e.getSource() == bsearch){
            new SearchFlight();
        }
        else if(e.getSource() == bticket){
            new Ticket();
        }
        else if(e.getSource() == bbook){
            new BookTicket();
        }
        else if(e.getSource() == bcancel){
            new CancelTicket();
        }
    }    
}
