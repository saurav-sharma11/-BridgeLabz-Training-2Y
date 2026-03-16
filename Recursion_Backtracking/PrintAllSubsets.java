package Recursion_Backtracking;

import java.util.ArrayList;

public class PrintAllSubsets {

    public static void printSubset(int[] arr, int i, ArrayList<Integer> ans) {

        if (i == arr.length) {
            System.out.println(ans);
            return;
        }

        // include element
        ans.add(arr[i]);
        printSubset(arr, i + 1, ans);

        // backtrack
        ans.remove(ans.size() - 1);

        // exclude element
        printSubset(arr, i + 1, ans);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        printSubset(arr, 0, new ArrayList<>());
    }
}