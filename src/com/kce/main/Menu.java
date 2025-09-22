package com.kce.main;

import com.kce.exam.*;
import java.util.*;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static List<ExamSchedule> schedules = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("====University Exam Grading===");
            System.out.println("1.Add Course");
            System.out.println("2.Add Student");
            System.out.println("3.Create Assessment");
            System.out.println("4.Schedule Exam");
            System.out.println("5.Record Marks");
            System.out.println("6.Publish Grades");
            System.out.println("7.Generate Transcript");
            System.out.println("8.Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: // Add Course
                    System.out.print("Enter Course ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Course Name: ");
                    String name = sc.nextLine();
                    courses.add(new Course(id, name));
                    System.out.println("Course added.");
                    break;

                case 2: // Add Student
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    String sname = sc.nextLine();
                    students.add(new Student(sid, sname));
                    System.out.println("Student added.");
                    break;

                case 3: // Create Assessment
                    if (students.isEmpty() || courses.isEmpty()) {
                        System.out.println("Add students and courses first!");
                        break;
                    }
                    System.out.print("Enter student ID: ");
                    int stid = sc.nextInt();
                    sc.nextLine();
                    Student st = null;
                    for (Student s : students) {
                        if (s.getStudentID() == stid) st = s;
                    }
                    if (st == null) { System.out.println("Student not found."); break; }

                    System.out.print("Enter course code: ");
                    String ccode2 = sc.nextLine();
                    Course csel = null;
                    for (Course c : courses) {
                        if (c.getCourseID().equals(ccode2)) csel = c;
                    }
                    if (csel == null) { System.out.println("Course not found."); break; }
                    if (!st.getRegisteredCourses().contains(csel)) {
                        st.registerCourse(csel);
                    }
                    System.out.print("Enter assessment name: ");
                    String aname = sc.nextLine();
                    System.out.print("Enter weightage: ");
                    double weight = sc.nextDouble();
                    sc.nextLine();

                    st.addAssessment(csel, new Assessments(aname, weight));
                    System.out.println("Assessment added.");
                    break;

                case 4: // Schedule Exam
                    if (courses.isEmpty()) { System.out.println("No courses available."); break; }
                    System.out.print("Enter course code: ");
                    String code = sc.nextLine();
                    Course course = null;
                    for (Course c : courses) {
                        if (c.getCourseID().equals(code)) course = c;
                    }
                    if (course == null) { System.out.println("Invalid course."); break; }

                    System.out.print("Enter exam date (YYYY-MM-DD): ");
                    sc.nextLine();
                    String date = sc.next();
                    System.out.print("Enter location: ");
                    String loc = sc.nextLine();
                    schedules.add(new ExamSchedule(course, date, loc));
                    System.out.println("Exam scheduled.");
                    break;

                case 5: // Record Marks
                    if (students.isEmpty()) { System.out.println("No students."); break; }
                    System.out.print("Enter student ID: ");
                    int sid2 = sc.nextInt();
                    sc.nextLine();
                    Student st2 = null;
                    for (Student s : students) {
                        if (s.getStudentID() == sid2) st2 = s;
                    }
                    if (st2 == null) { System.out.println("Student not found."); break; }

                    System.out.print("Enter course code: ");
                    String cc = sc.nextLine();
                    Course course2 = null;
                    for (Course c : courses) {
                        if (c.getCourseID().equals(cc)) course2 = c;
                    }
                    if (course2 == null) { System.out.println("Course not found."); break; }

                    System.out.print("Enter assessment name: ");
                    String an = sc.nextLine();
                    System.out.print("Enter marks: ");
                    double m = sc.nextDouble();
                    sc.nextLine();
                    st2.recordMarks(course2, an, m);
                    break;

                case 6: // Publish Grades
                    System.out.println("\nGrades Published:");
                    for (Student s : students) {
                        System.out.println("Student: " + s.getStudentName());
                        for (Course c : s.getCourseAssessments().keySet()) {
                            System.out.println("Course: " + c.getCourseName());
                            for (Assessments a : s.getCourseAssessments().get(c)) {
                                System.out.println("   " + a.getName() + " | Marks: " + a.getMarks());
                            }
                        }
                    }
                    break;

                case 7: // Generate Transcript
                    for (Student s : students) {
                        s.printTranscript();
                    }
                    break;

                case 8: // Exit
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
