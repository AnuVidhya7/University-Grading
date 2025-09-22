package com.kce.exam;

public class ExamSchedule {
private Course course;
private String ExamDate;
private String ExamLocation;

public ExamSchedule(Course course, String examDate, String examLocation) {
	super();
	this.course = course;
	ExamDate = examDate;
	ExamLocation = examLocation;
}
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
public String getExamDate() {
	return ExamDate;
}
public void setExamDate(String examDate) {
	ExamDate = examDate;
}
public String getExamLocation() {
	return ExamLocation;
}
public void setExamLocation(String examLocation) {
	ExamLocation = examLocation;
}
@Override
public String toString() {
	return "ExamSchedule [course=" + course + ", ExamDate=" + ExamDate + ", ExamLocation=" + ExamLocation + "]";
}

}
