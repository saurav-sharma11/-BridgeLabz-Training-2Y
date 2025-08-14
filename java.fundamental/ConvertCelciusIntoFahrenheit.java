import java.util.*;

public class ConvertCelciusIntoFahrenheit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature in celcius: ");
        int celcius = sc.nextInt();
        double fahrenheit = (celcius * 9.0/5.0)+ 32;
        System.out.println("temperature in fahrenheit: "+ fahrenheit);
    }


}