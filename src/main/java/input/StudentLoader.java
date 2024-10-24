package input;

import models.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StudentLoader implements Loader<Student> {
    @Override
    public List<Student> loadFile(String filePath) throws IllegalArgumentException, IOException {
        List<Student> students = new ArrayList<>();
        List<String> data = Files.readAllLines(Path.of(filePath));
        for (String line : data) {
            String[] parsedLine = line.split(",");

            int groupNumber = Integer.parseInt(parsedLine[0]);
            double averageScore = Double.parseDouble(parsedLine[1]);
            String recordBookNumber = parsedLine[2];

            students.add(new Student.StudentBuilder()
                    .groupNumber(groupNumber)
                    .averageScore(averageScore)
                    .recordBookNumber(recordBookNumber)
                    .build());
        }
        return students;
    }
}