import java.util.*;
public class RideAllocator{
    public static String initializeApp(){
        return null;
    }

    public static boolean addLocation(String name){
        return CityGraph.addLocation(name);
    }

    public static String addRoad(String from,String to,double distanceKm){
        return CityGraph.addRoad(from, to, distanceKm);
    }

    public static boolean removeLocation(String name){
        return CityGraph.removeLocation(name);
    }

    public static ArrayList<String> getAllLocations(){
        return CityGraph.getAllLocations();
    }

    public static ArrayList<String> getAllRoads(){
        return CityGraph.getAllRoadsAsStrings();
    }

    public static ArrayList<String> getNeighbours(String location){
        return CityGraph.getNeighbours(location);
    }

    public static boolean locationExists(String name){
        return CityGraph.locationExists(name);
    }

    public static String addDriver(String name, String location){
        return DriverFinder.addDriver(name, location);
    }

    public static boolean removeDriver(String name){
        return DriverFinder.removeDriver(name);
    }

    public static String updateDriverLocation(String driverName,String newLocation){
        return DriverFinder.updateDriverLocation(driverName, newLocation);
    }

    public static ArrayList<Driver> getAllDrivers(){
        return DriverFinder.getAllDrivers();
    }

    public static ArrayList<Driver> getAvailableDrivers(){
        return DriverFinder.getAvailableDrivers();
    }

    public static boolean setDriverAvailable(String driverName){
        for (Driver d : DriverFinder.allDrivers){
            if (d.name.equalsIgnoreCase(driverName)){
                d.available = true;
                return true;
            }
        }
        return false;
    }

}
