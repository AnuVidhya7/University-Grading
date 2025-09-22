package Grading;

public class Grade {
public static String getGrade(double total) {
	if(total>=90) {
		return "A";
	}
	else if(total>=80) {
		return "B";
	}
	else if(total>=70) {
		return "C";
	}
	else if(total>=60) {
		return "D";
	}
	else if(total>=50) {
		return "E";
	}
	else {
		return "F";
	}
}
public static double getGradePoints(String grade) {
	switch(grade) {
	case "A": return 10.0;
	case "B": return 9.0;
	case "C": return 8.0;
	case "D": return 7.0;
	case "E": return 6.0;
	default: return 0.0;
	}
}
public static boolean Resit(String grade) {
	return grade.equals("F");
}
public static boolean Improve(String grade) {
	return !grade.equals("A");
}
}
