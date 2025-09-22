package com.kce.exam;
import java.util.*;
public class Student {
private int studentID;
private String studentName;
private List<Course>registeredCourse;
private Map<Course, List<Assessments>> courseAssessment; 
private Map<Course,Integer>CourseMarks;
public Student(int studentID, String studentName, List<Course> registeredCourse) {
	super();
	this.studentID = studentID;
	this.studentName = studentName;
	this.registeredCourse = new ArrayList<>();
	this.courseAssessment = new HashMap<>();
}

public Student(int studentID, String studentName) {
	super();
	this.studentID = studentID;
	this.studentName = studentName;
	this.registeredCourse = new ArrayList<>();     // initialize the list
    this.courseAssessment = new HashMap<>();  
}

public int getStudentID() {
	return studentID;
}
public void setStudentID(int studentID) {
	this.studentID = studentID;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public List<Course> getRegisteredCourses() { 
	return registeredCourse; 
	}
public void registerCourse(Course course) {
	registeredCourse.add(course);
	System.out.println(studentName +"registered for this"+course.getCourseName());
}
public Map<Course, List<Assessments>> getCourseAssessments() { 
	return courseAssessment; 
	}
public void evaluateStudent(Course course,int marks) {
	if(registeredCourse.contains(course)) {
		CourseMarks.put(course, marks);
	}
	else {
		System.out.println(course.getCourseName()+" is not registered for"+studentName);
	}
}

public void recordMarks(Course course, String assessmentName, double marks) {
	// TODO Auto-generated method stub
	if (!courseAssessment.containsKey(course)) {
        System.out.println("No assessments found for course " + course.getCourseName());
        return;
    }
    for (Assessments a : courseAssessment.get(course)) {
        if (a.getName().equalsIgnoreCase(assessmentName)) {
            a.setMarks(marks);
            System.out.println("Marks " + marks + " recorded for " + assessmentName + " in " + course.getCourseName());
            return;
        }
    }
    System.out.println("Assessment '" + assessmentName + "' not found for course " + course.getCourseName());
}

public void addAssessment(Course course, Assessments assessment) {
	// TODO Auto-generated method stub
	if (!registeredCourse.contains(course)) {
        System.out.println("Cannot add assessment. Student is not registered for " + course.getCourseName());
        return;
    }
    courseAssessment.putIfAbsent(course, new ArrayList<>());
    courseAssessment.get(course).add(assessment);
    System.out.println("Assessment '" + assessment.getName() + "' added for course " + course.getCourseName());
}
public void printTranscript() {
    System.out.println("\nTranscript for " + studentName + ":");
    for (Course c : courseAssessment.keySet()) {
        System.out.println("Course: " + c.getCourseName());
        for (Assessments a : courseAssessment.get(c)) {
            System.out.println("   " + a.getName() + " | Marks: " + a.getMarks() + " | Weightage: " + a.getWeightage());
        }
    }
}
}
