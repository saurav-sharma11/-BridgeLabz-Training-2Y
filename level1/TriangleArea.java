import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

     
        System.out.print("Enter the base of the triangle (in inches): ");
        double baseInches = input.nextDouble();

        System.out.print("Enter the height of the triangle (in inches): ");
        double heightInches = input.nextDouble();


        double areaInSqInches = 0.5 * baseInches * heightInches;

 
        double areaInSqCm = areaInSqInches * 6.4516;

        System.out.println("The area of the triangle is " + areaInSqInches + " square inches" +
                           " and " + areaInSqCm + " square centimeters");

        input.close();
    }
}