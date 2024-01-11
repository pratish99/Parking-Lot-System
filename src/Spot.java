public class Spot {
    private int spotNumber;
    private boolean isEmpty;
    private Vehicle parkVehicle;

    Spot(int spotNumber){
        this.spotNumber = spotNumber;
        isEmpty = true;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Vehicle getParkVehicle() {
        return parkVehicle;
    }

    public void setParkVehicle(Vehicle parkVehicle) {
        this.parkVehicle = parkVehicle;
    }
    public void vacateSlot() {
        parkVehicle = null;
        this.isEmpty = true;
    }

    public void occupySlot(Vehicle parkVehicle) {
        this.parkVehicle = parkVehicle;
        this.isEmpty = false;
    }
}
