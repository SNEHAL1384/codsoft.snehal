import java.util.Scanner;

public class GradeCalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many subjects did you take?");
        int subjectCount = input.nextInt();
        
        int[] scores = new int[subjectCount];
        int sum = 0;
        
        for (int i = 0; i < subjectCount; i++) {
            System.out.printf("Enter score for subject %d (max 100): ", i + 1);
            scores[i] = input.nextInt();
            sum += scores[i];
        }
        
        double avg = (double) sum / subjectCount;
        String letterGrade = calculateGrade(avg);
        
        System.out.println("\nResults:");
        System.out.println("Total score: " + sum);
        System.out.printf("Average: %.2f%%\n", avg);
        System.out.println("Final grade: " + letterGrade);
    }
    
    private static String calculateGrade(double average) {
        if (average >= 90) return "A+";
        if (average >= 80) return "A";
        if (average >= 70) return "B+";
        if (average >= 60) return "B";
        if (average >= 50) return "C";
        return "F";
    }
}
