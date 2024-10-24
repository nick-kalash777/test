package input;


import models.Bus;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BusLoader implements Loader<Bus> {
    @Override
    public List<Bus> loadFile(String filePath) throws IllegalArgumentException, IOException {
        List<Bus> buses = new ArrayList<>();
        try (FileReader reader = new FileReader(Path.of(filePath).toFile());
             CSVParser csvParser = new CSVParser(reader,
                     CSVFormat.Builder.create()
                             .setHeader("NUMBER", "MODEL", "MILEAGE")
                             .setSkipHeaderRecord(true)
                             .build())) {
            for (CSVRecord record : csvParser) {
                String number = record.get("NUMBER");
                String model = record.get("MODEL");
                int mileage = Integer.parseInt(record.get("MILEAGE"));

                buses.add(new Bus.BusBuilder()
                        .number(number)
                        .model(model)
                        .mileage(mileage)
                        .build());
            }
        }
        return buses;
    }
}