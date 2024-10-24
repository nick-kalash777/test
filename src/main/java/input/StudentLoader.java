package input;

import models.Student;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StudentLoader implements Loader<Student> {
    @Override
    public List<Student> loadFile(String filePath) {
        List<Student> students = new ArrayList<>();
        try (FileReader reader = new FileReader(Path.of(filePath).toFile());
             CSVParser csvParser = new CSVParser(reader,
                     CSVFormat.Builder.create()
                             .setHeader("GROUP_NUMBER", "AVERAGE_SCORE", "RECORD_BOOK_NUMBER")
                             .setSkipHeaderRecord(true)
                             .build())) {
            for (CSVRecord record : csvParser) {
                int groupNumber = Integer.parseInt(record.get("GROUP_NUMBER"));
                double averageScore = Double.parseDouble(record.get("AVERAGE_SCORE"));
                String recordBookNumber = record.get("RECORD_BOOK_NUMBER");

                students.add(new Student.StudentBuilder()
                        .groupNumber(groupNumber)
                        .averageScore(averageScore)
                        .recordBookNumber(recordBookNumber)
                        .build());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("CSV file is corrupted.");
            return null;
        } catch (IOException e) {
            System.out.println("Error reading file.");
            return null;
        }
        return students;
    }
}