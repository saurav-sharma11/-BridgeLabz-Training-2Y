import java.util.Scanner;

public class HandshakeCalculator {

    // Method to calculate maximum handshakes
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();

        // Calculate max handshakes
        int maxHandshakes = calculateHandshakes(numberOfStudents);

        // Output
        System.out.println("The maximum number of possible handshakes among " 
                           + numberOfStudents + " students is: " + maxHandshakes);

        sc.close();
    }
}
