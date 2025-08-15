import java.util.Scanner;

public class FeetToYardsMiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking distance in feet from user
        System.out.print("Enter the distance in feet: ");
        double feet = input.nextDouble();

        // Convert feet to yards
        double yards = feet / 3;

        // Convert yards to miles
        double miles = yards / 1760;

        // Output
        System.out.println("The distance in yards is " + yards +
                           " while the distance in miles is " + miles);

        input.close();
    }
}