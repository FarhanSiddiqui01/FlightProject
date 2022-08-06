package Service;

import domain.Aeroplane;
import domain.Flight;
import domain.Pessanger;
import repository.Aeroplanerepository;
import repository.FlightRepository;
import repository.PassengerRepository;

import java.util.List;

public class AeroplaneService {
    public static String[][] getAllAeroplanesForJTable(int length) {
        Aeroplanerepository aeroplanerepository = new Aeroplanerepository();
        List<Aeroplane> aeroplanes = aeroplanerepository.getAllaeroplanes();
        String[][] data  = new String[aeroplanes.size()][length];
        for(int row = 0 ; row < aeroplanes.size() ; row++){
            data[row][0] = aeroplanes.get(row).getAeroplaneName();
            data[row][1] = String.valueOf(aeroplanes.get(row).getCapacity());
            data[row][2] = aeroplanes.get(row).getAirline();

        }
        return data;
    }

    public static Boolean addaeroplane(String name, Integer capacity, String airline) {
            Aeroplane aeroplane = new Aeroplane(name,capacity,airline);
            Aeroplanerepository aeroplanerepository = new Aeroplanerepository();
        aeroplanerepository.AddAeroplane(aeroplane);

        return false;
    }


    public static Aeroplane searchAeroplane(String planeName) {
        Aeroplanerepository aeroplanerepository = new Aeroplanerepository();
        Aeroplane aero = aeroplanerepository.getPlanesthroughName(planeName);

        return aero;
    }

    public static Boolean PlaneEdit(String name, Integer capacity, String airline, Long id) {
        Aeroplanerepository aeroplanerepository = new Aeroplanerepository();
        aeroplanerepository.UpdatePlane(name,capacity,airline,id);
        return true;
    }

    public static Boolean DeletePlane(Long planeId) {
        Aeroplanerepository planeRepository = new Aeroplanerepository();
        Boolean pl = planeRepository.deletePlaneThroughID(planeId);

        if (pl){return  true;}
        return false;}

}
