import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Map<String, Double> gradeToPoint = new HashMap<>();
        gradeToPoint.put("A+", 4.5);
        gradeToPoint.put("A0", 4.0);
        gradeToPoint.put("B+", 3.5);
        gradeToPoint.put("B0", 3.0);
        gradeToPoint.put("C+", 2.5);
        gradeToPoint.put("C0", 2.0);
        gradeToPoint.put("D+", 1.5);
        gradeToPoint.put("D0", 1.0);
        gradeToPoint.put("F", 0.0);

        double totalGradePoints = 0.0;
        double totalCredits = 0.0;

        for (int i = 0; i < 20; i++) {
            String subject = sc.next();
            double credits = sc.nextDouble();
            String grade = sc.next();
            
            if (grade.equals("P")) continue;
            
            totalGradePoints += credits * gradeToPoint.get(grade);
            totalCredits += credits;
        }
        
        double majorGPA = totalGradePoints / totalCredits;
        
        System.out.printf("%.6f\n", majorGPA);
    }
}
