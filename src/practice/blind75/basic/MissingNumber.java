package practice.blind75.basic;

import java.util.Arrays;
import java.util.HashSet;

public class MissingNumber {
    public static void main(String[] args) {
        // int[] arr = {1, 2, 3, 4, 5};
        int[] arr = {0,1};
        int missingNumber = findMissingNumberBetter(arr);
        System.out.println("The missing number is: " + missingNumber);
    }

    private static int findMissingNumber(int[] arr) {

        int n = arr.length + 1; //The array is supposed to have n numbers / in our case 4 numbers
        int expectedSum = n * (n + 1) / 2; // sum of the first n natural numbers
        int actualSum = 0;

        for (int num : arr) {
            actualSum = actualSum + num;

        }

        return expectedSum - actualSum;
    }


    private static int findMissingNumberBetter(int[] arr) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        for (int i = 0; i <=arr.length; i++) {

            if (!set.contains(i)) {
                return i;
            }
        }

        int n = 1000;
        int sum=0;
        for(int i=0; i< n; i++) {

            sum+= i/i*i;

        }
        int pisquare = sum/6;
        Math.sqrt(pisquare);
        return -1;


    }


}
