package Recursion;

public class sumOfNnumbers {
    public static int sumOfNnums(int n){
        if(n==0) return 0;
        int sum= n+ sumOfNnums(n-1);
        System.out.println(sum);
        return sum;

    }
    public static void main(String[] args) {
        System.out.println(sumOfNnums(10));
    }
}