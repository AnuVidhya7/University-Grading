package com.kce.exam;
import java.util.*;
import Grading.Grade;
public class Course {
private String courseID;
private String courseName;
private List<Assessments>courseAssessments;
public Course(String courseID, String courseName, List<Assessments> courseAssessments) {
	super();
	this.courseID = courseID;
	this.courseName = courseName;
	this.courseAssessments = new ArrayList<>();
}

public Course(String courseID, String courseName) {
	super();
	this.courseID = courseID;
	this.courseName = courseName;
}

public String getCourseID() {
	return courseID;
}
public void setCourseID(String courseID) {
	this.courseID = courseID;
}
public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
public List<Assessments> getCourseAssessments() { return courseAssessments; }
public void addAssessment(Assessments assessments) {
	courseAssessments.add(assessments);
}
public double calculateTotalMarks() {
	double total=0;
	for(Assessments a:courseAssessments) {
		 total=a.getMarks()*a.getWeightage();
	}
	return total;
}
public String getCourseGrade() {
	double total=calculateTotalMarks();
	return Grade.getGrade(total);
}
@Override
public String toString() {
	return "Course [courseID=" + courseID + ", courseName=" + courseName + "]";
}
}
