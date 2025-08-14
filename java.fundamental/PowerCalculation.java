import java.util.*;
public class PowerCalculation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the power of the number: ");
        int power = sc.nextInt();
        System.out.print("Enter the base of the number: ");
        int base = sc.nextInt();
        double result = Math.pow(base, power);
        System.out.println("Result: " + result);
    }
}
