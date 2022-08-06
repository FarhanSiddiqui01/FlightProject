package repository;

import domain.Aeroplane;
import domain.Passengerinquiry;
import domain.Pessanger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PassengerRepository extends BaseConnection{

    public void AddPassenger(Pessanger passanger){
        try {
            if(con.isClosed()){
                openConnection();
            }
            PreparedStatement ps = con.prepareStatement(
                    "insert into passenger (name,address,contact,flight_id) values(?, ?, ?, ?);");
            ps.setString(1,passanger.getName());
            ps.setString(2,passanger.getContact());
            ps.setString(3,passanger.getAddress());
            ps.setInt(4,(passanger.getFlightId()).intValue());;
            int i=ps.executeUpdate();
            System.out.println(i+" records inserted");

        }catch (Exception  e){
            System.out.println(e);
        }
    }


    public Passengerinquiry getPassengerForInquiry(String contact) {

        Passengerinquiry pass = new Passengerinquiry();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
  "select p.name,p.contact,p.address,a.airline,f.flight_number,f.flight_date,f.flight_source,f.flight_destination, f.fare from passenger p inner join flight f on p.flight_id = f.id inner join aeroplane a on f.aeroplane_id = a.id where p.contact ='"+contact+ "'; ");
            while (rs.next()){

                pass.populate(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

return pass;
    }



    public Passengerinquiry getpassengers(String contact){

        Passengerinquiry pi = new Passengerinquiry();
        try{
            if(con.isClosed()){
                openConnection();
            }
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select p.name,p.contact,p.address,a.airline,f.flight_number,f.flight_date,f.flight_source,f.flight_destination, f.fare from passenger p inner join flight f on p.flight_id = f.id inner join aeroplane a on f.aeroplane_id = a.id where p.contact ='"+contact+ "'; ");

            while (rs.next()){

                pi.populate(rs);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return pi;
    }
    }
