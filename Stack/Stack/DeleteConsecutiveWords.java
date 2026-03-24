package Stack;

import java.util.*;

public class DeleteConsecutiveWords {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of words:");
        int n = sc.nextInt();

        String arr[] = new String[n];

        System.out.println("Enter the words:");

        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.next();
        }

        System.out.println("Enter value of k:");
        int k = sc.nextInt();

        Stack<String> st = new Stack<>();

        int count = 1;

        for(int i = 0; i < n; i++)
        {
            if(!st.isEmpty() && st.peek().equals(arr[i]))
            {
                count++;

                if(count == k)
                {
                    for(int j = 0; j < k-1; j++)
                        st.pop();

                    count = 1;
                }
                else
                    st.push(arr[i]);
            }
            else
            {
                count = 1;
                st.push(arr[i]);
            }
        }

        System.out.println("Result:");

        for(String s : st)
            System.out.print(s + " ");
    }
}