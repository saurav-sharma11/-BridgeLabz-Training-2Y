import java.util.Scanner;

public class TriangularParkRun {

    // Method to calculate required rounds
    public static double calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;   // Perimeter in meters
        double totalDistance = 5000;    // 5 km in meters
        return totalDistance / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input for sides of the triangle
        System.out.print("Enter side 1 of the triangle (in meters): ");
        double side1 = sc.nextDouble();

        System.out.print("Enter side 2 of the triangle (in meters): ");
        double side2 = sc.nextDouble();

        System.out.print("Enter side 3 of the triangle (in meters): ");
        double side3 = sc.nextDouble();

        // Calculate rounds
        double rounds = calculateRounds(side1, side2, side3);

        // Output result
        System.out.println("The athlete must complete " + Math.ceil(rounds) 
                           + " rounds to complete a 5 km run.");

        sc.close();
    }
}
