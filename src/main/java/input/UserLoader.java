package input;

import models.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class UserLoader implements Loader<User> {
    @Override
    public List<User> loadFile(String filePath) throws IllegalArgumentException, IOException {
        List<User> users = new ArrayList<>();
        List<String> data = Files.readAllLines(Path.of(filePath));
        for (String line : data) {
            String[] parsedLine = line.split(",");

            String name = parsedLine[0];
            String password = parsedLine[1];
            String email = parsedLine[2];

            users.add(new User.UserBuilder()
                    .name(name)
                    .password(password)
                    .email(email)
                    .build());

        }
        return users;
    }
}
