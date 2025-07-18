//package com.temperature;
//
//import com.sun.source.tree.Tree;
//import com.temperature.beans.*;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.*;
//
//public class TemperatureData {
//
////        TempSensor obj= new TempSensor(24);//like registration form
////        System.out.println(obj.getReading());
////        System.out.println(obj.getReading(ReadingUnit.C));
////        System.out.println(obj.getReading(ReadingUnit.F));
//
//    /// /        Sensor obj1= new HumiditySensor(50);
//    /// /        System.out.println(obj1.getReading());
//    /// /        System.out.println(obj.getReading(ReadingUnit.G));
//    /// /        System.out.println(obj.getReading(ReadingUnit.Kg));
////
////        System.out.println(obj.getClass());
////        System.out.println(obj.hashcode());
////        System.out.println(obj.toString());
////
////        TempSensor tempSensor=new TempSensor(24);  //exam form
////        System.out.println(tempSensor.getClass());
////        System.out.println(tempSensor.hashcode());
////        System.out.println(tempSensor.toString());
////        System.out.println(obj.equals(tempSensor));
//
////        try{
////            Commerical  commerical = new Commerical();
////            commerical.setNooffloors(200);
////        } catch (BuildingException e) {
////            throw new RuntimeException(e);
////        }
////        }
//    public static void main(String[] args) throws BuildingException {
//        Organization ourTechnology = new Organization();
//        ourTechnology.setName("ourTechnology");
//        ourTechnology.setdateofinitaial(LocalDate.of(2021, 04, 14));
//        ourTechnology.setEmail("operations@ourtech.com");
//        ourTechnology.setCeo("mdkfmdsk");
//        ourTechnology.setPhone(("+91 8778947245"));
//
//        Location chennai = createLocation("4/2", 2, "Thambaram", "Chennai", "Chennai", "India", "Tamilnadu", 9024.32, 7902.45, "623503");
//        Location coimbatore = createLocation("001", 3, "SARAVANAMPATI", "COIMBATORE", "Coimbatore", "India", "tamilnadu", 3849.98, 8902.78, "623504");
//
//        List<Location> location = new ArrayList<>();
//        location.add(chennai);
//        location.add(coimbatore);
//        Organization organization1 = new Organization();
//        organization1.setLocations(location);
//
//        Commerical Navigator = createBuilding(2, true, "white", "shape", "navigtor", 1, 20.10, 10.20);
//        Commerical creator = createBuilding(2, true, "white", "shape", "creator", 2, 20.10, 10.20);
//
//        Set<Building> buildings = new HashSet<>();
//        buildings.add(Navigator);
//        buildings.add(creator);
//        chennai.setBuilding(buildings);
//        System.out.println(chennai);
//        Commerical Inventor = createBuilding(2, true, "white", "shape", "inventer", 1, 20.10, 10.20);
//        Commerical Innovator = createBuilding(2, true, "white", "shape", "innovator", 2, 20.10, 10.20);
//
//        Set<Building> buildings1 = new HashSet<>();
//        buildings1.add(Inventor);
//        buildings1.add(Innovator);
//        coimbatore.setBuilding(buildings1);
//        System.out.println(coimbatore);
////floor
//        Floor firstfloor = createfloor(1, "floor1");
//        Floor secondfloor = createfloor(2, "floor2");
//        TreeSet<Floor> floorsForNavigator = new TreeSet<>(Comparator.comparingInt(Floor::getFloorNumber));
//        floorsForNavigator.add(firstfloor);
//        floorsForNavigator.add(secondfloor);
//        Navigator.setFloors(floorsForNavigator);
//
//        Floor firstFloorForCreator = createfloor(1, "floor1");
//        Floor secondFloorForCreator = createfloor(2, "floor2");
//        TreeSet<Floor> floorsForCreator = new TreeSet<>(Comparator.comparingInt(Floor::getFloorNumber));
//        floorsForCreator.add(firstFloorForCreator);
//        floorsForCreator.add(secondFloorForCreator);
//        creator.setFloors(floorsForCreator);
////zone
//        zone zoneForFirstFloor = createZone(1, "zone1", 2, "zonetype1");
//        zone zone2ForFirstFloor = createZone(2, "zone2", 3, "zonetype2");
//        Set<zone> zones = Set.of(zoneForFirstFloor, zone2ForFirstFloor);
//        firstfloor.setZones(zones);
//
//        zone zoneForSecondFloor = createZone(1, "zone1", 2, "zonetype1");
//        zone zone2ForSecondFloor = createZone(2, "zone2", 3, "zonetype2");
//        Set<zone> zonesForSecondFloor = Set.of(zoneForSecondFloor, zone2ForSecondFloor);
//        firstfloor.setZones(zonesForSecondFloor);
//
//
////        TempSensor tempdataForTempSensor = createTemperatureData()
//    }
//
//    public static Location createLocation(String doorno, int street, String areaname, String city, String district, String country, String state, double longtitude, double latitude, String pincode) {
//        Location ourlocation = new Location();
//        ourlocation.setDoorno(doorno);
//        ourlocation.setStreet(street);
//        ourlocation.setAreaname(areaname);
//        ourlocation.setCity(city);
//        ourlocation.setDistrict(district);
//        ourlocation.setCountry(country);
//        ourlocation.setState(state);
//        ourlocation.setLongtitude(longtitude);
//        ourlocation.setLatitude(latitude);
//        ourlocation.setPincode(pincode);
//        return ourlocation;
//    }
//
//    public static Commerical createBuilding(int nooffloors, boolean parkingAvailable, String color, String shape, String name, int bulidingNumber, double height,
//                                            double squareFeet) throws BuildingException {
//        Commerical ourbuilding = new Commerical();
//        ourbuilding.setNooffloors(nooffloors);
//        ourbuilding.isParkingAvailable(parkingAvailable);
//        ourbuilding.setColor(color);
//        ourbuilding.setShape(shape);
//        ourbuilding.setName(name);
//        ourbuilding.setBulidingNumber(bulidingNumber);
//        ourbuilding.setHeight(height);
//        ourbuilding.setSquareFeet(squareFeet);
//        return ourbuilding;
//    }
//
//    public static Floor createfloor(int floorNumber, String floorName) {
//        Floor ourfloor = new Floor();
//        ourfloor.setFloorNumber(floorNumber);
//        ourfloor.setFloorName(floorName);
//        return ourfloor;
//    }
//
//    public static zone createZone(int zoneNumber, String zoneName, int noOfRooms, String zoneType) {
//        zone ourzone = new zone();
//        ourzone.setZoneName(zoneName);
//        ourzone.setZoneNumber(zoneNumber);
//        ourzone.setNoOfRooms(noOfRooms);
//        ourzone.setZoneType(zoneType);
//        return ourzone;
//    }
//
//    public static TempSensor createTemperatureData(Map<LocalDateTime,Tempdata> temperatureDAtaMAp){
//        TempSensor ourTempSensor = new TempSensor();
//        ourTempSensor.setTemperatureDAtaMAp(temperatureDAtaMAp);
//        return ourTempSensor;
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////        FileOutputStream outputStream = null;
////        ObjectOutputStream objectOutputStream = null;
////        FileInputStream fileInputStream = null;
////        ObjectInputStream objectInputStream = null;
////
////        try {
////             outputStream = new FileOutputStream("ourTechnology.txt");
////             objectOutputStream = new ObjectOutputStream(outputStream);
////            objectOutputStream.writeObject(ourTechnology);
////            objectOutputStream.close();
////            outputStream.close();
////             fileInputStream = new FileInputStream("OurTechnology.txt");
////             objectInputStream = new ObjectInputStream(fileInputStream);
////            Organization myOrg = (Organization) objectInputStream.readObject();
////            System.out.println(myOrg);
////        } catch (FileNotFoundException e) {
////            throw new RuntimeException(e);
////        } catch (ClassNotFoundException e) {
////            throw new RuntimeException(e);
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        } finally {
////            try {
////
////
////                if (outputStream != null) {
////                    outputStream.close();
////                }
////                if (objectOutputStream != null) {
////                    objectOutputStream.close();
////                }
////                if (fileInputStream != null) {
////                    fileInputStream.close();
////                }
////                if (objectInputStream != null) {
////                    objectInputStream.close();
////                }
////            } catch (IOException e) {
////                throw new RuntimeException(e);
////            }
////        }
////    }
