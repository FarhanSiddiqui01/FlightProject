package UI.user;

import Service.FlightService;
import UI.admin.LookUpFlight;
import domain.Passengerinquiry;

import javax.swing.*;
import java.time.LocalDate;

public class CheckPassenger {
    public CheckPassenger(Passengerinquiry passengerinquiry) {
        JFrame frame = new JFrame("SHOW PASSENGER");



        JLabel pname = new JLabel("Passenger name");
        pname.setBounds(150,50,150,100);
        JTextField pnametf = new JTextField();
        pnametf.setBounds(270,90,150,20);
        pnametf.setText(passengerinquiry.getName());



        JLabel pcontact = new JLabel("contact");
        pcontact.setBounds(150,100,150,100);
        JTextField pcontactTf = new JTextField();
        pcontactTf.setBounds(270,140,150,20);
        pcontactTf.setText(passengerinquiry.getContact());

        JLabel pad = new JLabel("address");
        pad.setBounds(150,150,150,100);
        JTextField padTf = new JTextField();
        padTf.setBounds(270,190,150,20);
        padTf.setText(passengerinquiry.getAddress());

        JLabel pal = new JLabel("airline");
        pal.setBounds(150,200,150,100);
        JTextField palTf = new JTextField();
        palTf.setBounds(270,240,150,20);
        palTf.setText(passengerinquiry.getAirline());

        JLabel pfn = new JLabel("flightname");
        pfn.setBounds(150,250,150,100);
        JTextField pfnTf = new JTextField();
        pfnTf.setBounds(270,290,150,20);
        pfnTf.setText(passengerinquiry.getFlightNumber());

        JLabel pfd = new JLabel("Date");
        pfd.setBounds(150,300,150,100);
        JTextField pfdtf = new JTextField();
        pfdtf.setBounds(270,340,150,20);
        pfdtf.setText(passengerinquiry.getFlightDate().toString());

        JLabel pfs = new JLabel("source");
        pfs.setBounds(150,350,150,60);
        JTextField pfsTf = new JTextField();
        pfsTf.setBounds(270,390,150,20);
        pfsTf.setText(passengerinquiry.getSource());

        JLabel pfde= new JLabel("destination");
        pfde.setBounds(150,400,150,60);
        JTextField pfdeTf = new JTextField();
        pfdeTf.setBounds(270,440,150,20);
        pfdeTf.setText(passengerinquiry.getDestination());

        JLabel pf= new JLabel("fare");
        pf.setBounds(150,450,150,60);
        JTextField pfTf = new JTextField();
        pfTf.setBounds(270,490,150,20);
        pfTf.setText(passengerinquiry.getFare().toString());




        frame.add(pname);
        frame.add(pnametf);
        frame.add(pcontact);
        frame.add(pcontactTf);
        frame.add(pad);
        frame.add(padTf);
        frame.add(pal);
        frame.add(palTf);
        frame.add(pfn);
        frame.add(pfnTf);
        frame.add(pfd);
        frame.add(pfdtf);
        frame.add(pfs);
        frame.add(pfsTf);
        frame.add(pfde);
        frame.add(pfdeTf);
        frame.add(pf);
        frame.add(pfTf);


//        String column[]={"Name","Contact","Address","Airline","Flight Name","Date","Source","Destination","Fare"};


//        {
//            String name = passengerinquiry.getFlightNumber();
//            LocalDate flight_date = LocalDate.parse(flightDateTf.getText());
//            String src = flightSourceTf.getText();
//            String des = flightDestinationTf.getText();
//            Double fare =  Double.parseDouble(flightFareTf.getText()) ;
//            Long aeroId = Long.parseLong(AeroplaneIdTf.getText());
//            Boolean edit =  FlightService.FlightEdit( flight.getId(),flight_number,src,des,flight_date,fare,aeroId);
//            if (edit){
//                JOptionPane.showMessageDialog(frame,"Flight Updated Succesfully");
//            }else {
//                JOptionPane.showMessageDialog(frame,"File Not Updated");
//            }
//        }





        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
