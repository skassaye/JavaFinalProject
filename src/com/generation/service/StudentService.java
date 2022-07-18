package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();
//    DateFormat formatter = new SimpleDateFormat( "mm/dd/yyyy");
//    public StudentService() throws ParseException {
//        subscribeStudent(new Student("1", "Jim", "jim@gmail.com", formatter.parse("12/12/2012"))) ;
//        subscribeStudent(new Student("2", "matt", "jim@gmail.com", formatter.parse("12/12/2012")));
//        subscribeStudent(new Student("3", "dina", "jim@gmail.com", formatter.parse("12/12/2012")));
//        subscribeStudent(new Student("4", "ash", "jim@gmail.com", formatter.parse("12/12/2012")));
//    }

    public void subscribeStudent(Student student )
    {
        students.put( student.getId(), student );
    }

    public Student findStudent( String studentId )
    {
        if ( students.containsKey( studentId ) )
        {
            return students.get( studentId );
        }
        return null;
    }

    public void showSummary()
    {
        //TODO implement (we can get all details about a particular student, to structure the output we can write it as
//        follows, also we can loop through all approved courses of the student an output all line by line
        System.out.println("Current Student: ");
        for (String key : students.keySet()){
            Student student = students.get(key);
            System.out.println(student);
            System.out.println("Current courses this student is taking: ");
            student.getApprovedCourses().forEach(course -> System.out.println(course.toString()));
            System.out.println(" ");
        }
    }

    public void enrollToCourse( String studentId, Course course )
    {
        if ( students.containsKey( studentId ) )
        {
            students.get( studentId ).enrollToCourse( course );
        }
    }


}


