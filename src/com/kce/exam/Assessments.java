package com.kce.exam;

public class Assessments {
private String name;
private double weightage;
private double marks;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getWeightage() {
	return weightage;
}
public void setWeightage(double weightage) {
	this.weightage = weightage;
}
public double getMarks() {
	return marks;
}
public void setMarks(double marks) {
	this.marks = marks;
}
public Assessments(String name, double weightage) {
	super();
	this.name = name;
	this.weightage = weightage;
}
public Assessments(String name, double weightage, int marks) {
	super();
	this.name = name;
	this.weightage = weightage;
	this.marks = marks;
}
}
