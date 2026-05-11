package  com.example.dynamic_ride_allocator.graphs;
import java.util.*;

public class RideAllocator {

    public static String initializeApp() {
        return FileHandler.loadAll();
    }

    public static boolean addLocation(String name) { return CityGraph.addLocation(name); }
    public static String addRoad(String from, String to, double distanceKm) { return CityGraph.addRoad(from, to, distanceKm); }
    public static boolean removeLocation(String name) { return CityGraph.removeLocation(name); }
    public static ArrayList<String> getAllLocations() { return CityGraph.getAllLocations(); }
    public static ArrayList<String> getAllRoads() { return CityGraph.getAllRoadsAsStrings(); }
    public static ArrayList<String> getNeighbours(String location) { return CityGraph.getNeighbours(location); }
    public static boolean locationExists(String name) { return CityGraph.locationExists(name); }

    public static ArrayList<Driver> getAllDrivers() { return DriverFinder.getAllDrivers(); }
    public static ArrayList<Driver> getAvailableDrivers() { return DriverFinder.getAvailableDrivers(); }

    public static boolean setDriverAvailable(String driverName) {
        for (Driver d : DriverFinder.allDrivers) {
            if (d.getName().equalsIgnoreCase(driverName)) {
                d.setAvailable(true);
                FileHandler.saveAll();
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Driver> findNearbyDrivers(String riderLocation, int maxHops) {
        return DriverFinder.findNearbyDrivers(riderLocation, maxHops);
    }

    public static Driver assignClosestDriver(ArrayList<Driver> nearbyDrivers) {
        if (nearbyDrivers == null || nearbyDrivers.isEmpty()) return null;
        DriverMinHeap.clear();
        DriverMinHeap.insertAll(nearbyDrivers);
        Driver assigned = DriverMinHeap.extractMin();
        if (assigned != null) {
            assigned.setAvailable(false);
            FileHandler.saveAll();
        }
        return assigned;
    }

    public static Driver requestRide(String riderLocation, int maxHops) {
        ArrayList<Driver> nearby = findNearbyDrivers(riderLocation, maxHops);
        return assignClosestDriver(nearby);
    }

    public static ArrayList<Driver> getHeapSnapshot(ArrayList<Driver> nearbyDrivers) {
        DriverMinHeap.clear();
        DriverMinHeap.insertAll(new ArrayList<>(nearbyDrivers));
        return DriverMinHeap.getAllInHeap();
    }

    public static int getLocationIndex(String locationName) {
        return DriverFinder.getLocationIndex(locationName);
    }

    public static String getLocationName(int index) {
        return DriverFinder.getLocationName(index);
    }

    public static String getDataFolderPath() {
        return FileHandler.getSaveFolderPath();
    }
    public static void saveNow() {
        FileHandler.saveAll();
    }
}