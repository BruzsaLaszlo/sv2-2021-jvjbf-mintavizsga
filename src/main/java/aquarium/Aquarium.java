package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    public static final int CAPACITY = 20;
    private static final int LIVING_SPACE = 5;
    private final List<Fish> fish = new ArrayList<>();


    public void addFish(Fish fish) {
        if (CAPACITY / LIVING_SPACE == this.fish.size())
            throw new IllegalStateException("Can not add fish because there is no more space.");
        this.fish.add(fish);
    }

    public void feed() {
        for (Fish f : fish) {
            f.feed();
        }
    }

    public void removeFish(int maxWeight) {
        List<Fish> removeList = new ArrayList<>();
        for (Fish f: fish) {
            if (f.getWeight() > maxWeight) {
                removeList.add(f);
            }
        }
        fish.removeAll(removeList);
    }

    public List<String> getStatus() {
        List<String> result = new ArrayList<>();
        for (Fish f : fish) {
            result.add(f.getStatus());
        }
        return result;
    }

    public int getNumberOfFishWithMemoryLoss() {
        int count = 0;
        for (Fish f : fish) {
            if (f.hasMemoryLoss()) {
                count++;
            }
        }
        return count;
    }

    public boolean isThereFishWithGivenColor(String color) {
        for (Fish f : fish) {
            if (f.getColor().equals(color)) {
                return true;
            }
        }
        return false;
    }

    public Fish getSmallestFish() {
        Fish smallest = fish.get(0);
        for (Fish f : fish) {
            if (smallest.getWeight() > f.getWeight()) {
                smallest = f;
            }
        }
        return smallest;
    }

}
