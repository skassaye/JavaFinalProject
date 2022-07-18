import com.generation.model.Student;
import com.generation.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentServiceTest {
    Map<String, Student> students = new HashMap<>();
    DateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
    Student jim;
    Student matt;

    @BeforeEach
    void setUp() throws ParseException {

        jim = new Student("1", "Jim", "jim@gmail.com", formatter.parse("12/12/2012"));
        matt = new Student("2", "matt", "matt@gmail.com", formatter.parse("09/05/1998"));
        students.put(jim.getId(), jim);
        students.put(matt.getId(), matt);
        students.put(matt.getEmail(), matt);
    }

    @Test
    void findStudent() {
        assertEquals(matt, students.get("2"));
        assertEquals(jim, students.get("1"));
        assertEquals(matt, students.get("matt@gmail.com"));


    }




}

