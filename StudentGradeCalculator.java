import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeCalculator {
    
    private char grade; // Declare class variables
    private ArrayList<Byte> marks = new ArrayList<>(); // ArrayList to store subject marks
    private int sum = 0; // Total marks sum
    private double averagePercentage; // Average percentage of marks
    public Scanner sc = new Scanner(System.in); // Scanner object to read input

    // Method to calculate total marks sum
    void calculateSum() { 
        byte value = 0, total = 0;

        System.out.print("\nEnter the number of subjects: ");  
        total = sc.nextByte(); // Read total number of subjects from user input

        // Loop to input marks for each subject
        for(int i = 0; i < total; i++)
        {
            System.out.print("\nEnter the marks: ");
            value = sc.nextByte(); // Read marks for a subject from user input
            marks.add(value); // Add marks to ArrayList
            sum = sum + value; // Update total marks sum
        }
    }

    // Method to calculate average percentage
    void calculateAveragePercentage(){

        double average = (double) sum / (marks.size() * 100); // Calculate average as a fraction
        averagePercentage = average * 100; // Convert average to percentage
    }

    // Method to assign grades based on average percentage
    void assignGrades()
    {
        byte value = (byte) (averagePercentage / 10); // Convert average percentage to byte

        // Use a switch-case to determine the grade based on the average percentage value
        switch(value)
        {

            case 9:
            case 10:
            this.grade = 'A';
            break;

            case 8:
            this.grade = 'B';
            break;
            
            case 7:
            this.grade = 'C';
            break;
            
            default :
            this.grade = 'F';
            break;
        }

    }

    // Method to print the final result
    void printResult(){
        System.out.println("\n\t\t\tStudent Grade Calculator ");
        System.out.println("\n\t\tTotal marks        : " + sum);
        System.out.println("\t\tAverage Percentage : " + averagePercentage);
        System.out.println("\t\tGrade              : " + grade);
    }
    
    public static void main(String[] args){
        // Create an instance of the StudentGradeCalculator class
        StudentGradeCalculator student = new StudentGradeCalculator();
        
        // Print introductory messages
        System.out.println("\n\n\t\t\tStudent Grade Calculator");
        System.out.println("\t\t1. Enter the marks obtained in each subject");
        System.out.println("\t\t2. The marks should be out of 100");
        System.out.println("\t\t3. This code will output total marks, average, percentage, and corresponding grade");

        // Call methods to perform calculations and display results
        student.calculateSum();
        student.calculateAveragePercentage();
        student.assignGrades();
        student.printResult();

        // Print closing message
        System.out.println("\n\t\t\tThanks for visiting.");
    }
    
}
