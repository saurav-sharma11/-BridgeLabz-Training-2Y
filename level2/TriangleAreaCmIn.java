import java.util.Scanner;

public class TriangleAreaCmIn {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking base and height in cm
        System.out.print("Enter the base of the triangle (in cm): ");
        double baseCm = input.nextDouble();

        System.out.print("Enter the height of the triangle (in cm): ");
        double heightCm = input.nextDouble();

        // Area in square centimeters
        double areaSqCm = 0.5 * baseCm * heightCm;

        // Convert cm² to inches² (1 inch = 2.54 cm → 1 sq inch = 2.54² cm²)
        double areaSqInches = areaSqCm / (2.54 * 2.54);

        // Output
        System.out.println("The Area of the triangle in sq in is " + areaSqInches +
                           " and sq cm is " + areaSqCm);

        input.close();
    }
}