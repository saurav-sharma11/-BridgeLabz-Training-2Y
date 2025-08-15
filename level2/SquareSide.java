import java.util.Scanner;

public class SquareSide {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking perimeter input
        System.out.print("Enter the perimeter of the square: ");
        double perimeter = input.nextDouble();

        // Calculating side
        double side = perimeter / 4;

        // Output
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);

        input.close();
    }
}