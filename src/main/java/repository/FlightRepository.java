package repository;

import domain.Flight;
import domain.Pessanger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightRepository extends BaseConnection{

    public void AddFlight(Flight flight){
        try {
            if(con.isClosed()){
                openConnection();
            }
            PreparedStatement ps = con.prepareStatement(
                    "\n" +
                            "insert into flight(flight_number,flight_date,flight_source,flight_destination,fare,aeroplane_id) values (?,?,?,?,?,?)");
            ps.setString(1,flight.getFlightNumber());
            ps.setString(2,flight.getDate().toString());
            ps.setString(3,flight.getSource());
            ps.setString(4,(flight.getDestination()));
            ps.setString(5,(flight.getFare().toString()));
            ps.setString(6,(flight.getAeroplaneId().toString()));
            int i=ps.executeUpdate();
            System.out.println(i+" records inserted");

        }catch (Exception  e){
            System.out.println(e);
        }
    }

    public List<Flight> getAllFlights(String src,String des){
        List<Flight> flightList = new ArrayList<>();

        try{
         String query = generateQuery(src,des);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                Flight fl = new Flight();
                fl.populate(rs);
                flightList.add(fl);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return flightList;
    }

    public List<Flight> getAllFlightsadmin(){
        List<Flight> flightList = new ArrayList<>();

        try{
            String query = generatesQuery();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                Flight fl = new Flight();
                fl.populate(rs);
                flightList.add(fl);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return flightList;
    }

    private String generatesQuery(){
        String querya="select * from flight";
        return querya;
    }

    private String generateQuery(String src, String des) {
        String query = "select * from flight";
        if(!src.equalsIgnoreCase("src") && !des.equalsIgnoreCase("des")){
            query = query + " where flight_source = '"+src+"' and flight_destination='"+des+"'";
        }else if(!src.equalsIgnoreCase("src")){
            query=query + " where flight_source = '"+src+"'";
        }else if (!des.equalsIgnoreCase("des")){
            query = query +" where flight_destination = '"+des+"'";
        }

        return query;


    }

    public Flight getFlightsthroughName(String flightName){

        Flight flight = new Flight();
        try{
            if(con.isClosed()){
                openConnection();
            }
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from flight where flight_number = '"+flightName+"'");

            while (rs.next()){

                flight.populate(rs);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return flight;
    }
    public void UpdateFlight(Long id, String flight_number, String src, String des, LocalDate flight_date, Double fare, Long aeroId){

        try{
            if(con.isClosed()){
                openConnection();
            }
            Statement st = con.createStatement();

            st.executeUpdate("update flight set flight_number = '"+flight_number+"', flight_date = "+flight_date+", flight_source = '"+src+"'" +
                    ", flight_destination = '"+des+"', fare = '"+fare+"', aeroplane_id = '"+aeroId+"' where id = "+id+" ");


        }catch (Exception e){
            e.printStackTrace();}
    }

    public Boolean DeleteFlight(Long flightId) {
        try{
            if(con.isClosed()){
                openConnection();
            }
            Statement st = con.createStatement();

            st.executeUpdate("delete from flight where id ="+flightId+"" );

            return true;
        }catch (Exception e){
            e.printStackTrace();}
        return false; }

}
