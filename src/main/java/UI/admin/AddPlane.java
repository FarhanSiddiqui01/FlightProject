package UI.admin;

import Service.AeroplaneService;
import Service.FlightService;
import domain.Aeroplane;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddPlane {
    public AddPlane(){
        JFrame frame = new JFrame("ADMIN PANEL");
        Container container = frame.getContentPane();

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        topPanel.setLayout(null);
        bottomPanel.setLayout(null);

        topPanel.setBackground(Color.GRAY);
        topPanel.setBounds(0, 0, 1000, 100);
        bottomPanel.setBackground(Color.lightGray);
        bottomPanel.setBounds(0, 100, 1000, 800);

        JLabel title = new JLabel("ADD FLIGHT");
        JLabel airplaneName = new JLabel("Airplane Name");
        JTextField airplaneNameTf = new JTextField(10);
        JLabel capacity = new JLabel("Capacity");
        JTextField capacityTf = new JTextField(10);
        JLabel airlineName = new JLabel("Airline Name");
        JTextField airlineNameTf = new JTextField(10);


        JButton addPlane = new JButton("ADD PLANE");

        JButton backButton = new JButton(">");

        airplaneName.setBounds(250, 50, 150, 35);
        airplaneNameTf.setBounds(400, 50, 150, 35);

        capacity.setBounds(250,100,150,35);
        capacityTf.setBounds(400,100,150,35);

        airlineName.setBounds(250, 150, 150, 35);
        airlineNameTf.setBounds(400, 150, 150, 35);


        backButton.setBounds(900,5,50,50);
        addPlane.setBounds(400, 350, 150, 35);

        addPlane.addActionListener(btn->{
            System.out.println(airplaneNameTf.getText());
            System.out.println(capacityTf.getText());
            System.out.println(airlineNameTf.getText());
            Boolean addingPlane= AeroplaneService.addaeroplane(airplaneNameTf.getText(), Integer.valueOf(capacityTf.getText()), airlineNameTf.getText());
            if (addingPlane){
                JOptionPane.showMessageDialog(frame,"Booking Confirmed");
            }else {
                JOptionPane.showMessageDialog(frame,"Booking Failed");
            }
        });
//
//        book.addActionListener(bk->{
//            System.out.println(passengerName.getText());
//            System.out.println(passengerContact.getText());
//            System.out.println(passengerAddresstf.getText());
//            System.out.println(flightIdTf.getText());
//            Boolean flightBooking = FlightService.booking(passengerName.getText(),passengerContact.getText(),
//                    passengerAddresstf.getText(),flightIdTf.getText());
//
//            if(flightBooking){
//                JOptionPane.showMessageDialog(frame,"Booking confirmed");
//            }else {
//                JOptionPane.showMessageDialog(frame,"Booking failed");
//            }
//        });
        backButton.addActionListener(btn->{
            frame.dispose();
            new LookUpPlaneUi();
        });

        topPanel.add(title);
        bottomPanel.add(airplaneName);
        bottomPanel.add(airplaneNameTf);
        bottomPanel.add(capacity);
        bottomPanel.add(capacityTf);
        bottomPanel.add(airlineName);
        bottomPanel.add(airlineNameTf);

        bottomPanel.add(addPlane);
        bottomPanel.add(backButton);

        container.add(topPanel);
        container.add(bottomPanel);

        frame.setLayout(null);
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


}
