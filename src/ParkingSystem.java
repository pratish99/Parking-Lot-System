
public class ParkingSystem {
    public static void main(String[] args) throws ParkingNotAvailableException, InvalidVehicleNumberException {

        ParkingLot parkingLot = ParkingLot.getParkingLot();
        parkingLot.initializeParkingSlots(10, 10, 10);

        Motorcycle vehicle1 = new Motorcycle(3456, VehicleType.Motorcycle);
        Motorcycle vehicle2 = new Motorcycle(1234, VehicleType.Motorcycle);
        Car vehicle3 = new Car(3227, VehicleType.Car);
        Bus vehicle4 = new Bus(3127, VehicleType.Bus);
        Bus vehicle5 = new Bus(3117, VehicleType.Bus);
        Bus vehicle6 = new Bus(3437, VehicleType.Bus);
        parkingLot.showAvailableParking();

        parkingLot.park(vehicle1);
        parkingLot.park(vehicle2);
        parkingLot.park(vehicle3);
        parkingLot.park(vehicle4);
        parkingLot.showAvailableParking();

        parkingLot.park(vehicle5);
        parkingLot.park(vehicle6);
        parkingLot.unPark(vehicle1);
        parkingLot.unPark(vehicle6);
        parkingLot.showAvailableParking();



        }

}