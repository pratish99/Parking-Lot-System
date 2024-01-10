import java.util.HashSet;

public class ParkingLot {
    HashSet<Level> level = new HashSet<>();
    ParkingLot(int maxLevels, int maxCarSpots, int maxMotorcycleSpots, int maxBusSpots){
        for(int i = 0; i<maxLevels; i++){
            level.add(new Level());
        }

    }


}
