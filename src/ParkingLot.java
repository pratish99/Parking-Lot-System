import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ParkingLot {
    private static ParkingLot parkingLot;
    private final List<Spot> motorcycleSpots;
    private final List<Spot> carSpots;
    private final List<Spot> busSpots;
    int motorcycle = 0, bus = 0, car = 0;
    HashMap<Integer, Vehicle> vehicles = new HashMap<>();
    private ParkingLot() {
        this.motorcycleSpots = new ArrayList<>();
        this.carSpots = new ArrayList<>();
        this.busSpots = new ArrayList<>();
    }
    public static ParkingLot getParkingLot() {
        if (parkingLot == null){
            parkingLot = new ParkingLot();
        }

        return parkingLot;
    }

    public boolean initializeParkingSlots(int motorcycleSpotNumber, int carSpotNumber, int busSpotNumber) {

        for (int i = 1; i <= motorcycleSpotNumber; i++) {
            motorcycleSpots.add(new Spot(i));
        }
        for (int i = 1; i <= carSpotNumber; i++) {
            carSpots.add(new Spot(i));
        }
        for (int i = 1; i <= busSpotNumber; i++) {
            busSpots.add(new Spot(i));
        }
        return true;
    }

    public void park(Vehicle vehicle) throws ParkingNotAvailableException {
        Spot availableSpot;
        if (vehicle.getVehicleType().equals(VehicleType.Car)) {
            availableSpot = getAvailableCarSpot();
            car++;
        }
        else if(vehicle.getVehicleType().equals(VehicleType.Motorcycle)){
            availableSpot = getAvailableMotorcycleSpot();
            motorcycle++;

        }
        else {
            availableSpot = getAvailableBusSpot();
            bus++;
        }
        availableSpot.occupySlot(vehicle);
        vehicles.put(vehicle.getVehicleNumber(), vehicle);


    }
    private Spot getAvailableCarSpot() throws ParkingNotAvailableException {
        for (Spot slot : carSpots) {
            if (slot.isEmpty()) {
                return slot;
            }
        }
        throw new ParkingNotAvailableException("No Empty Slot available");
    }

    private Spot getAvailableMotorcycleSpot() throws ParkingNotAvailableException {
        for (Spot slot : motorcycleSpots) {
            if (slot.isEmpty()) {
                return slot;
            }
        }
        throw new ParkingNotAvailableException("No Empty Slot available");
    }
    private Spot getAvailableBusSpot() throws ParkingNotAvailableException {
        for (Spot slot : busSpots) {
            if (slot.isEmpty()) {
                return slot;
            }
        }
        throw new ParkingNotAvailableException("No Empty Slot available");
    }

    public void unPark(Vehicle vehicle) throws InvalidVehicleNumberException {

        try{
            Spot slot;
            if (vehicle.getVehicleType().equals(VehicleType.Motorcycle)) {
                slot = getMotocycleSpot(vehicle.getVehicleNumber());
                System.out.println("Unparked vehicle with registration " + vehicle.getVehicleNumber() + " from slot number " + slot.getSpotNumber());
                slot.vacateSlot();
                motorcycle--;
            }
            else if (vehicle.getVehicleType().equals(VehicleType.Car)) {
                slot = getCarSpot(vehicle.getVehicleNumber());
                System.out.println("Unparked vehicle with registration " + vehicle.getVehicleNumber() + " from slot number " + slot.getSpotNumber());
                slot.vacateSlot();
                car--;
            }
            else if (vehicle.getVehicleType().equals(VehicleType.Bus)) {
                slot = getBusSpot(vehicle.getVehicleNumber());
                System.out.println("Unparked vehicle with registration " + vehicle.getVehicleNumber() + " from slot number " + slot.getSpotNumber());
                slot.vacateSlot();
                bus--;
            }

        }catch (InvalidVehicleNumberException invalidVehicleNumber) {
            System.out.println(invalidVehicleNumber.getMessage());
            throw invalidVehicleNumber;
        }
    }

    private Spot getMotocycleSpot(int vehicleNumber) throws InvalidVehicleNumberException {
        for (Spot slot : motorcycleSpots) {
            Vehicle vehicle = slot.getParkVehicle();
            if (vehicle != null && vehicle.getVehicleNumber() == vehicleNumber) {
                return slot;
            }
        }
        throw new InvalidVehicleNumberException("Two wheeler with registration number " + vehicleNumber + " not found");
    }
    private Spot getCarSpot(int vehicleNumber) throws InvalidVehicleNumberException {
        for (Spot slot : carSpots) {
            Vehicle vehicle = slot.getParkVehicle();
            if (vehicle != null && vehicle.getVehicleNumber() == vehicleNumber) {
                return slot;
            }
        }
        throw new InvalidVehicleNumberException("Car with registration number " + vehicleNumber + " not found");
    }
    private Spot getBusSpot(int vehicleNumber) throws InvalidVehicleNumberException {
        for (Spot slot : busSpots) {
            Vehicle vehicle = slot.getParkVehicle();
            if (vehicle != null && vehicle.getVehicleNumber() == vehicleNumber) {
                return slot;
            }
        }
        throw new InvalidVehicleNumberException("Bus wheeler with registration number " + vehicleNumber + " not found");
    }
    public void showAvailableParking(){
        System.out.println("Motorcycle Spots Available: " + (motorcycleSpots.size()-motorcycle) + "\tCar Spots Available: " + (carSpots.size() - car)  + "\tBus Spots Available: " + (busSpots.size()-bus));
    }
}
