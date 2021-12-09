package owlcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class OwlCounter {

    private List<String> owls;

    public int getNumberOfOwls(String county) {
        for (String owl : owls) {
            if (owl.startsWith(county)) {
                return Integer.parseInt(owl.split("=")[1]);
            }
        }
        throw new IllegalArgumentException("No such county in Hungary!");
    }

    public int getNumberOfAllOwls() {
        int sum = 0;
        for (String owl : owls) {
            sum += Integer.parseInt(owl.split("=")[1]);
        }
        return sum;
    }

    public void readFromFile(Path path) {
        try {
            owls = Files.readAllLines(path);
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file.");
        }
    }

}
