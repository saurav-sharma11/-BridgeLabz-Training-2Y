import java.util.*;

public class ConvertKilometersIntoMiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the kilometers: ");
        double kilometers = sc.nextDouble();
        double miles = kilometers * 0.621371;
        System.out.println("Miles: " + miles);
    }

}
