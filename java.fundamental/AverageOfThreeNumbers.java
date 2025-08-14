import java.util.*;


public class AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the first number: ");
        double first = sc.nextDouble();
        System.out.print("enter the second number: ");
        double second = sc.nextDouble();
        System.out.print("enter the third number: ");
        double third = sc.nextDouble();
        double average= (first + second + third)/3;
        System.out.println("average of the three numbers: " +average);
    }

}
