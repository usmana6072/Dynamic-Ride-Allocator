package com.example.dynamic_ride_allocator.DataLayer;

import com.example.dynamic_ride_allocator.Models.Admin;
import com.example.dynamic_ride_allocator.Models.Driver;
import com.example.dynamic_ride_allocator.Models.Rider;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UsersData {
    public static Map<String, Admin> adminData=new HashMap<>();
    public static Map<String, Rider> riderData=new HashMap<>();
    public static Map<String, Driver> driverData=new HashMap<>();
    public static String adminPath="C:\\DRA\\admin.txt";
    public static String riderPath="C:\\DRA\\rider.txt";
    public static String driverPath="C:\\DRA\\driver.txt";

    public static void loadData(){
        loadAdmin();
        loadRider();
        loadDriver();
    }

    private static void loadDriver() {
        File file=new File(driverPath);
        try(ObjectInputStream input=new ObjectInputStream(new FileInputStream(file))){
            Driver driver=(Driver) input.readObject();
            if(driver!=null)
                driverData.put(driver.getEmail(),driver);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private static void loadRider() {
        File file=new File(riderPath);
        try(ObjectInputStream input=new ObjectInputStream(new FileInputStream(file))){
            Rider rider=(Rider) input.readObject();
            if(rider!=null)
                riderData.put(rider.getEmail(),rider);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private static void loadAdmin() {
        File file=new File(adminPath);
        try(ObjectInputStream input=new ObjectInputStream(new FileInputStream(file))){
            Admin admin=(Admin) input.readObject();
            if(admin!=null)
                adminData.put(admin.getEmail(),admin);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void writeAdmin(){
        File file=new File(adminPath);
        try(ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream(file))){
            for(String s:adminData.keySet()){
                Admin admin=adminData.get(s);
                if(admin!=null){
                    output.writeObject(admin);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void writeRider(){
        File file=new File(riderPath);
        try(ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream(file))){
            for(String s:riderData.keySet()){
                Rider rider=riderData.get(s);
                if(rider!=null){
                    output.writeObject(rider);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void writeDriver(){
        File file=new File(driverPath);
        try(ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream(file))){
            for(String s:driverData.keySet()){
                Driver driver=driverData.get(s);
                if(driver!=null){
                    output.writeObject(driver);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
