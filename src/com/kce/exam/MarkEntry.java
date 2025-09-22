package com.kce.exam;

public class MarkEntry {
private Student student;
private Course course;
double marks;

public MarkEntry(Student student, Course course, double marks) {
	super();
	this.student = student;
	this.course = course;
	this.marks = marks;
}
public Student getStudent() {
	return student;
}
public void setStudent(Student student) {
	this.student = student;
}
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
public double getMarks() {
	return marks;
}
public void setMarks(double marks) {
	this.marks = marks;
}
@Override
public String toString() {
	return "MarkEntry [student=" + student + ", course=" + course + ", marks=" + marks + "]";
}

}
