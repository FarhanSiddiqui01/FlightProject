package UI.user;

import Service.AeroplaneService;
import Service.FlightService;
import UI.admin.UpdatePlaneUi;
import domain.Aeroplane;
import domain.Passengerinquiry;

import javax.swing.*;
import java.awt.*;

public class PassengerInquiryUi {
    public PassengerInquiryUi() {
        JFrame frame = new JFrame("Passenger Inquiry");
        Container c = frame.getContentPane();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel1.setLayout(null);
        panel2.setLayout(null);

        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.setBounds(10,10,800,100);
        panel2.setBounds(10,150,800,800);

        JTextField contact=new JTextField(10);
        contact.setText("contact");
        contact.setBounds(20,10,150,30);

        JButton search =new JButton("SEARCH");
        search.setBounds(400,10,150,30);

        JButton back =new JButton("BACK");
        back.setBounds(600,10,150,30);

        back.addActionListener(btn->{
            frame.dispose();
            new UserUi();
        });

        panel1.add(contact);
        panel1.add(search);
        panel1.add(back);



        search.addActionListener(s->{
            String con=contact.getText();
            Passengerinquiry pass = FlightService.searchpassenger(con);
//            JLabel pas= new JLabel();
        });

        search.addActionListener(btn->{
            String con=contact.getText();
            Passengerinquiry pass = FlightService.searchpassenger(con);
            if (pass != null){
                CheckPassenger checkPassenger= new CheckPassenger(pass);
                frame.dispose();
            }else{

                JOptionPane.showMessageDialog(frame,"No Aeroplane Exists with this name");

            }
        });









//            String column[]={"Name","Contact","Address","Airline","Flight Name","Date","Source","Destination","Fare"};
//            JTable jt=new JTable(column);
//            JScrollPane sp=new JScrollPane(jt);
//            sp.setBounds(0,0,800,700);
//            panel2.add(sp);



        c.add(panel1);
        c.add(panel2);

        frame.setLayout(null);
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }
}
