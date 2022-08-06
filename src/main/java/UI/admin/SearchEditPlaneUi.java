package UI.admin;


import Service.AeroplaneService;
import domain.Aeroplane;

import javax.swing.*;

public class SearchEditPlaneUi {
        SearchEditPlaneUi(){
            JFrame frame = new JFrame("Search Edit Airline Panel");

            JLabel planeNameLb = new JLabel("Please Enter Airline Name :");
            planeNameLb.setBounds(100,60,200,30);
            JTextField airlineNameTf = new JTextField();
            airlineNameTf.setBounds(270,60,150,30);

            JButton btnEnter = new JButton();
            btnEnter.setText("Enter");
            btnEnter.setBounds(100,150,150,30);

            JButton btnBack = new JButton();
            btnBack.setBounds(270,150,150,30);
            btnBack.setText("Back");

            frame.add(planeNameLb);
            frame.add(airlineNameTf);
            frame.add(btnEnter);
            frame.add(btnBack);


            btnEnter.addActionListener(btn->{
                String planeName = airlineNameTf.getText();

                Aeroplane aero = AeroplaneService.searchAeroplane(planeName);
                if (aero != null){
                    UpdatePlaneUi updatePlaneUi= new UpdatePlaneUi(aero);
                    frame.dispose();
                }else{

                    JOptionPane.showMessageDialog(frame,"No Aeroplane Exists with this name");

                }
            });



            btnBack.addActionListener(btn->{
                frame.dispose();
                new LookUpPlaneUi();
            });

            frame.setLayout(null);
            frame.setSize(600, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }
    }
