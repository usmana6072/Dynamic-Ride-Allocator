import java.util.*;
public class DriverFinder {
    static ArrayList<Driver> allDrivers=new ArrayList<>();

    public static String addDriver(String name, String location){
        name=name.trim();
        location=location.trim();
        if (!CityGraph.locationExists(location))
            return "LOCATION NOT FOUND";
        for (Driver d:allDrivers)
            if (d.name.equalsIgnoreCase(name))
                return "DUPLICATE NAME";
        allDrivers.add(new Driver(name, location));
        return "OK";
    }

    public static boolean removeDriver(String name){
        boolean removed=allDrivers.removeIf(d -> d.name.equalsIgnoreCase(name));
        return removed;
    }

    public static String updateDriverLocation(String name,String newLocation){
        if (!CityGraph.locationExists(newLocation))
            return "LOCATION NOT FOUND";
        for (Driver d : allDrivers) {
            if (d.name.equalsIgnoreCase(name)){
                d.location = newLocation;
                return "OK";
            }
        }
        return "DRIVER NOT FOUND";
    }

    public static ArrayList<Driver> getAllDrivers(){
        return allDrivers;
    }

    public static ArrayList<Driver> getAvailableDrivers(){
        ArrayList<Driver> available=new ArrayList<>();
        for (Driver d:allDrivers)
            if (d.available)
                available.add(d);
        return available;
    }
    public static ArrayList<Driver> findNearbyDrivers(String riderLocation, int maxHops){
        ArrayList<Driver> nearbyDrivers = new ArrayList<>();
        if (!CityGraph.locationExists(riderLocation)) return nearbyDrivers;
        Queue<String> queue=new LinkedList<>();
        Map<String, Integer> hops=new HashMap<>();
        Map<String, Double> dist=new HashMap<>();

        queue.add(riderLocation);
        hops.put(riderLocation,0);
        dist.put(riderLocation,0.00);

        while (!queue.isEmpty()){
            String current=queue.poll();
            int currentHop=hops.get(current);

            if (currentHop>= maxHops)
                continue;

            for (Road road : CityGraph.adjacencyList.get(current)){
                String neighbor = road.destination;
                if (hops.containsKey(neighbor)) continue;

                int newHop=currentHop + 1;
                double newDist=dist.get(current)+road.distance;

                hops.put(neighbor,newHop);
                dist.put(neighbor,newDist);
                queue.add(neighbor);
                addAvailableDriversAt(neighbor, newDist, nearbyDrivers);
            }
        }
        nearbyDrivers.sort(Comparator.comparingDouble(d -> d.distance));
        return nearbyDrivers;
    }

    public static void addAvailableDriversAt(String location,double distance,ArrayList<Driver> nearbyDrivers){
        for (Driver driver : allDrivers) {
            if (driver.available && driver.location.equals(location)) {
                driver.distance = distance;
                nearbyDrivers.add(driver);
            }
        }
    }
}

