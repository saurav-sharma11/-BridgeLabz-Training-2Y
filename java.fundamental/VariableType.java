public class VariableType {
    public static void main(String[] args) {
        // Declare variables
        int num = 10;
        double price = 99.99;
        String name = "Java";

        System.out.println("Data type of num: " + ((Object)num).getClass().getSimpleName());
        System.out.println("Data type of price: " + ((Object)price).getClass().getSimpleName());
        System.out.println("Data type of name: " + name.getClass().getSimpleName());
    }
}
