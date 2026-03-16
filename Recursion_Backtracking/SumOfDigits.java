package Recursion_Backtracking;

public class SumOfDigits {

    public static int sumOfDigits(int n) {

        if (n < 10)
            return n;

        return n % 10 + sumOfDigits(n / 10);
    }

    public static void main(String[] args) {

        int a = 47652;
        System.out.println(sumOfDigits(a));

    }
}