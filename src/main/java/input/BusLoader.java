package input;


import models.Bus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BusLoader implements Loader<Bus> {
    @Override
    public List<Bus> loadFile(String filePath) throws IllegalArgumentException, IOException {
        List<Bus> buses = new ArrayList<>();
        List<String> data = Files.readAllLines(Path.of(filePath));
        for (String line : data) {
            String[] parsedLine = line.split(",");

            String number = parsedLine[0];
            String model = parsedLine[1];
            int mileage = Integer.parseInt(parsedLine[2]);

            buses.add(new Bus.BusBuilder()
                    .number(number)
                    .model(model)
                    .mileage(mileage)
                    .build());
        }
        return buses;
    }
}