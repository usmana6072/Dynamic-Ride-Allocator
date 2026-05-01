package com.example.dynamic_ride_allocator.Models;

public class Trip {
    int tripID;
    int driverID;
    int riderID;
    int pickupLocation;       // ← store locations in trip too
    int dropOffLocation;
    float fare;
    float distance;           // calculated by BFS
    String status;            // "completed", "cancelled", "ongoing"
    String date;              // "2025-05-01" for history display
    String time;

    public Trip(){

    }

    public Trip(int tripID, int driverID, int riderID, int pickupLocation, int dropOffLocation, float fare) {
        this.tripID = tripID;
        this.driverID = driverID;
        this.riderID = riderID;
        this.pickupLocation = pickupLocation;
        this.dropOffLocation = dropOffLocation;
        this.fare = fare;
    }

    public int getTripID() {
        return tripID;
    }

    public void setTripID(int tripID) {
        this.tripID = tripID;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public int getRiderID() {
        return riderID;
    }

    public void setRiderID(int riderID) {
        this.riderID = riderID;
    }

    public int getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(int pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public int getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(int dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
