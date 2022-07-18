package com.generation.utils;

import com.generation.model.Student;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PrinterHelper
{

    public static void showMainMenu(){
        System.out.println( "|-------------------------------|" );
        System.out.println( "| Welcome to StudentGen         |" );
        System.out.println( "|-------------------------------|" );
        System.out.println( "| Select 1 option:              |" );
        System.out.println( "| . 1 Register Student          |" );
        System.out.println( "| . 2 Find Student              |" );
        System.out.println( "| . 3 Enroll Student to Course  |" );
        System.out.println( "| . 4 Show Students Summary     |" );
        System.out.println( "| . 5 Show Courses Summary      |" );
        System.out.println( "| . 6 Exit                      |" );
        System.out.println( "|-------------------------------|" );
    }

    public static Student createStudentMenu( Scanner scanner )
        throws ParseException
    {
        System.out.println( "|-------------------------------------|" );
        System.out.println( "| . 1 Register Student                |" );
        System.out.println( "|-------------------------------------|" );
        System.out.println( "| Enter student name:                 |" );
        String name = scanner.next();
        System.out.println( "| Enter student ID:                   |" );
        String id = scanner.next();
        System.out.println( "| Enter student email:                |" );
        String email = scanner.next();
        System.out.println( "| Enter student birth date(mm/dd/yyyy)|" );
        DateFormat formatter = new SimpleDateFormat( "mm/dd/yyyy");
        //TODO validate date format and catch exception to avoid crash
        String incomingDate = scanner.next();

        while (!incomingDate.matches("^(((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-/]?31|02[-/]" +
                "?(0[1-9]|1[0-9]|2[0-8]))[-/]?[0-9]{4}|02[-/]?29[-/]?([0-9]{2}(([2468][048]|[02468][48])|[13579][26])" +
                "|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$")){
            System.out.println("Please input a valid date");
            incomingDate = scanner.next();
        }

        System.out.println("Confirm date of birth");
        Date birthDate = formatter.parse(scanner.next());
        System.out.println( "|-------------------------------------|" );
        Student student = new Student( id, name, email, birthDate );
        System.out.println( "Student Successfully Registered! " );
        System.out.println(student);
        return student;
    }

}
