package com.kce.exam;
import java.util.*;

import Grading.Grade;
public class Transcript {
private Student student;
private Map<Course,String> courseGrades;
public Transcript(Student student) {
	this.student=student;
	this.courseGrades=new HashMap<>();
}
public void addCourseGrade(Course course) {
	String grade=course.getCourseGrade();
	courseGrades.put(course, grade);
}
public double calculateGPA() {
	double totalpoints=0;
	int count=0;
	for(String grade:courseGrades.values()) {
		totalpoints+=Grade.getGradePoints(grade);
		count++;
	}
	return (count==0)?0:totalpoints/count;
}
public void applyResit(Course course) {
	if(Grade.Resit(courseGrades.get(course))) {
		System.out.println("Resit appiled for "+course.getCourseName());
	}
	else {
		System.out.println("Resit not allowed for "+course.getCourseName());
	}
}
public void applyImprovement(Course course) {
	if(Grade.Improve(courseGrades.get(course))) {
		System.out.println("Improvement allowed for "+course.getCourseName());
	}else {
		System.out.println("Improvement not allowed for "+ course.getCourseName());
	}
}
public void printTranscript() {
	System.out.println("Transcript for Student: "+student.getStudentName());
	courseGrades.forEach((course,grade)->
	System.out.println(course.getCourseName()+" : "+grade)
	);
	System.out.println("GPA = " + calculateGPA());
}
}
