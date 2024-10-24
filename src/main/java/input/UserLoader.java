package input;

import models.User;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class UserLoader implements Loader<User> {
    @Override
    public List<User> loadFile(String filePath) throws IllegalArgumentException, IOException {
        List<User> users = new ArrayList<>();
        try (FileReader reader = new FileReader(Path.of(filePath).toFile());
             CSVParser csvParser = new CSVParser(reader,
                     CSVFormat.Builder.create()
                             .setHeader("NAME", "PASSWORD", "EMAIL")
                             .setSkipHeaderRecord(true)
                             .build())) {
            for (CSVRecord record : csvParser) {
                String name = record.get("NAME");
                String password = record.get("PASSWORD");
                String email = record.get("EMAIL");

                users.add(new User.UserBuilder()
                        .name(name)
                        .password(password)
                        .email(email)
                        .build());
            }

        }
        return users;
    }
}
