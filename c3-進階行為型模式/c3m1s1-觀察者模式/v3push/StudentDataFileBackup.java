package v3push;

import common.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import static java.util.stream.Collectors.joining;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
@SuppressWarnings("ALL")
public class StudentDataFileBackup implements StudentDataObserver {
    @Override
    public void update(Collection<Student> students) throws IOException {
        String fileName = new SimpleDateFormat("yyyyMMdd-HH:mm:ss'.backup.data'", Locale.getDefault()).format(new Date());
        Files.writeString(Paths.get(fileName), students.stream()
                .map(Student::toString)
                .collect(joining("\n")));
    }
}
