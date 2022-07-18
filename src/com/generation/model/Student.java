package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student
    extends Person
    implements Evaluation
{
    private double average;

    private final List<Course> courses = new ArrayList<>();

    private final Map<String, Course> approvedCourses = new HashMap<>();

    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    public void enrollToCourse( Course course )
    {
        //TODO implement this method(check if the student is already enrolled in course, if not register the course using the registerApprovedCourse method below
        if(!isAttendingCourse(course.getCode())){
            registerApprovedCourse(course);
        }
    }

    public void registerApprovedCourse( Course course )
    {
        approvedCourses.put( course.getCode(), course );
    }


    public boolean isAttendingCourse( String courseCode )
    {
        //TODO implement this method (this is a method that checks whether a student is attending a course, input is
        // courseCode so, we can run a loop for each element in courses, it gets the course Module from course, gets the prerequisites and check if courseCode is in
        // present for all courses)
        for (Course course: courses){
            if (course.getModule().getPrerequisites().containsKey(courseCode)){
                return true;
            }
        }
        return false;
    }

    @Override
    public double getAverage()
    {
        return average;
    }
    @Override
    public List<Course> getApprovedCourses(){
        List<Course> ListOfApprovedCourses = new ArrayList<>(approvedCourses.values());
        return ListOfApprovedCourses;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }


}
