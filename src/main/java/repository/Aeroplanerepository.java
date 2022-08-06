package repository;


import domain.Aeroplane;
import domain.Flight;
import domain.Pessanger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aeroplanerepository extends BaseConnection{

    public List<Aeroplane> getAllaeroplanes(){
        List<Aeroplane> Aeroplanelist = new ArrayList<>();

        try{
            String query = generatesQuery();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                Aeroplane al = new Aeroplane();
                al.populate(rs);
                Aeroplanelist.add(al);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Aeroplanelist;
    }

    private String generatesQuery(){
        String querya="select * from aeroplane";
        return querya;
    }

    public void AddAeroplane(Aeroplane aeroplane){
        try {
            if(con.isClosed()){
                openConnection();
            }
            PreparedStatement ps = con.prepareStatement(
                    "insert into aeroplane (aeroplane_name,capacity,airline) values(?, ?, ?);");
            ps.setString(1,aeroplane.getAeroplaneName());
            ps.setInt(2,(aeroplane.getCapacity()));
            ps.setString(3,aeroplane.getAirline());
            int i=ps.executeUpdate();
            System.out.println(i+" records inserted");

        }catch (Exception  e){
            System.out.println(e);
        }
    }

    public Aeroplane getPlanesthroughName(String aeroplaneName){

        Aeroplane aero = new Aeroplane();
        try{
            if(con.isClosed()){
                openConnection();
            }
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from aeroplane where aeroplane_name = '"+aeroplaneName+"'");

            while (rs.next()){

                aero.populate(rs);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return aero;
    }

    public void UpdatePlane(String name,Integer capacity, String airline, Long id){

        try{
            if(con.isClosed()){
                openConnection();
            }
            Statement st = con.createStatement();

            st.executeUpdate("update aeroplane set aeroplane_name = '"+name+"', capacity = "+capacity+", airline = '"+airline+"' where id = "+id+" ");


        }catch (Exception e){
            e.printStackTrace();}
    }

    public Boolean deletePlaneThroughID(Long planeId) {
        try{
            if(con.isClosed()){
                openConnection();
            }
            Statement st = con.createStatement();

            st.executeUpdate("delete from aeroplane where id ="+planeId+"" );

            return true;
        }catch (Exception e){
            e.printStackTrace();}
        return false; }


}
