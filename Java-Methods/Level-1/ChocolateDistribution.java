// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.util.Scanner;

public class ChocolateDistribution {
   public ChocolateDistribution() {
   }

   public static int[] findRemainderAndQuotient(int var0, int var1) {
      int var2 = var0 / var1;
      int var3 = var0 % var1;
      return new int[]{var2, var3};
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.print("Enter number of chocolates: ");
      int var2 = var1.nextInt();
      System.out.print("Enter number of children: ");
      int var3 = var1.nextInt();
      int[] var4 = findRemainderAndQuotient(var2, var3);
      System.out.println("Each child gets: " + var4[0] + " chocolates, Remaining: " + var4[1]);
      var1.close();
   }
}