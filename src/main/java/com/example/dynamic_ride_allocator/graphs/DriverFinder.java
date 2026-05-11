package  com.example.dynamic_ride_allocator.graphs;
import java.util.*;

public class DriverFinder {

    static ArrayList<Driver> allDrivers = new ArrayList<>();

    public static ArrayList<Driver> getAllDrivers() {
        return allDrivers;
    }

    public static ArrayList<Driver> getAvailableDrivers() {
        ArrayList<Driver> available = new ArrayList<>();
        for (Driver d : allDrivers)
            if (d.isAvailable()) available.add(d);
        return available;
    }

    public static ArrayList<Driver> findNearbyDrivers(String riderLocation, int maxHops) {
        ArrayList<Driver> nearbyDrivers = new ArrayList<>();
        if (!CityGraph.locationExists(riderLocation)) return nearbyDrivers;

        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> hops = new HashMap<>();
        Map<String, Double> dist = new HashMap<>();

        queue.add(riderLocation);
        hops.put(riderLocation, 0);
        dist.put(riderLocation, 0.0);

        while (!queue.isEmpty()) {
            String current    = queue.poll();
            int    currentHop = hops.get(current);
            if (currentHop >= maxHops) continue;

            for (Road road : CityGraph.adjacencyList.get(current)) {
                String neighbour = road.destination;
                if (!hops.containsKey(neighbour)) {
                    int    newHop  = currentHop + 1;
                    double newDist = dist.get(current) + road.distance;
                    hops.put(neighbour, newHop);
                    dist.put(neighbour, newDist);
                    queue.add(neighbour);

                    for (Driver driver : allDrivers) {
                        // int location → String: allLocations list se nikalo
                        int locIndex = driver.getLocation();
                        String driverLocationName = "";
                        if (locIndex >= 0 && locIndex < CityGraph.allLocations.size())
                            driverLocationName = CityGraph.allLocations.get(locIndex);

                        if (driver.isAvailable() && driverLocationName.equals(neighbour)) {
                            driver.distance = newDist;
                            nearbyDrivers.add(driver);
                        }
                    }
                }
            }
        }

        nearbyDrivers.sort((a, b) -> Double.compare(a.distance, b.distance));
        return nearbyDrivers;
    }

    public static int getLocationIndex(String locationName) {
        return CityGraph.allLocations.indexOf(locationName);
    }

    public static String getLocationName(int index) {
        if (index >= 0 && index < CityGraph.allLocations.size())
            return CityGraph.allLocations.get(index);
        return "";
    }
}