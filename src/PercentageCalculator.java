package PercentageCal;

import java.util.Scanner;

public class PercentageCalculator {

    /*
     * 
     * 
     * Percentage calculator
     * Used to calculate:-
     * 1. Total marks
     * 2. Average Percentage
     * 3. Grade
     * 
     * ## Code is build dynamically considering the negative scenarios
     * 
     * 
     * 
     */

    public static void main(String[] args) {

        // Creating the object for scanner class
        Scanner sc = new Scanner(System.in);

        // Defining the code
        String code = "Pass";

        // Taking the input from user regarding his/her basic details
        System.out.println("Please fill the below details:-");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Class/Standard: ");
        String standard = sc.nextLine();

        // Taking the input from user for number of subjects
        System.out.println();
        System.out.println("For how many subjects do you want to calculate the total marks, percentage and grade?");
        int subjectCount = sc.nextInt();
        System.out.println("Please note marks are calculated out of 100!!");
        System.out.println();

        // Assuming initial total marks as 0
        double totalMarks = 0;

        // Creating a forloop to take marks for all the subjects from user
        for (int i = 0; i < subjectCount; i++) {

            System.out.print("Enter the marks for subject " + (i + 1) + " : ");
            double subjectMarks = sc.nextDouble();

            if (subjectMarks > 100) {

                System.out.println("Please make sure to enter the marks based on 100!!");
                System.out.print("Re-enter the marks for subject " + (i + 1) + " : ");
                double reEnterSubjectMarks = sc.nextDouble();

                if (reEnterSubjectMarks > 100) {
                    code = "Fail";
                    break;
                }

                totalMarks = totalMarks + reEnterSubjectMarks;

            } else {

                totalMarks = totalMarks + subjectMarks;

            }
        }

        // Calculating the required details
        if (code.equalsIgnoreCase("Pass")) {

            // Calculating the percentage
            double percentageObtained = percentageCal(totalMarks, subjectCount);

            // Displaying the grade, total marks and percentage obtained by user
            System.out.println();
            System.out.println("Please find the below details for " + name + " studying in " + standard + ":-");
            System.out.println("The total marks obtained in exam are: " + totalMarks);
            System.out.println("The total percentage obtained in exam is: " + percentageObtained);
            gradeCalculator(percentageObtained);

        } else {

            System.out.println();
            System.out.println("Please re-run the program to calculate grade.");
            System.out.println("And please make sure to enter the marks based on 100!!");

        }

        // Closing the scanner class
        sc.close();

    }

    // Method for calculating the percentage
    public static double percentageCal(double totalMarks, int subjectCount) {

        double percentageObtained = (totalMarks / (subjectCount * 100)) * 100;
        return ((double) Math.round(percentageObtained * 100) / 100);
    }

    // Method for calculating the grade
    public static void gradeCalculator(double percentageObtained) {

        if (percentageObtained >= 90) {
            System.out.println("Grade secured is A+");
        } else if (percentageObtained >= 80) {
            System.out.println("Grade secured is A");
        } else if (percentageObtained >= 70) {
            System.out.println("Grade secured is B");
        } else if (percentageObtained >= 60) {
            System.out.println("Grade secured is C");
        } else if (percentageObtained >= 50) {
            System.out.println("Grade secured is D");
        } else {
            System.out.println("You have failed in the examination!!");
        }

    }

}