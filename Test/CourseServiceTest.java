import com.generation.model.Course;
import com.generation.model.Module;
import com.generation.model.Student;
import com.generation.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseServiceTest {

    private final Map<String, Course> courses = new HashMap<>();

    private final Map<String, List<Student>> enrolledStudents = new HashMap<>();

    Course course;
    Course course1;
    Module module;
    @BeforeEach
    void  setUp(){
        module = new Module( "INTRO-CS", "Introduction to Computer Science",
                "Introductory module for the generation technical programs" );
        course = new Course( "INTRO-CS-1", "Introduction to Computer Science", 9, module );
        course1 = new Course( "INTRO-CS-2", "Introduction to Algorithms", 9, module );

        courses.put( course.getCode(), course );
        courses.put( course1.getCode(), course1 );

    }
    @Test
    void getCourse(){
        assertEquals(course, courses.get("INTRO-CS-1"));
        assertEquals(course1, courses.get("INTRO-CS-2"));

    }


}
