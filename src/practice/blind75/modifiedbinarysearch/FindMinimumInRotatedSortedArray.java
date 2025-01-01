package practice.blind75.modifiedbinarysearch;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {

    // Driver code
    public static void main(String[] args) {
        int[][] arr = {
                {5, 7, 11, 2, 3},
                {-17, -2, -1, 0, 12, 15, 100, 121, 289},
                {34, 45, 72, 85, -98, -74, -2, -1},
                {4, 8, 12, 15, 19, 28, 55, 67, 88},
                {-33, -23, -11, -7, -100, -70, -50, -45},
                {1, 2, 3, 4, 5, 6, 0},
                {6, 7, 8, 1, 2, 3, 4}
        };

        for (int i = 0; i < arr.length; ++i) {
            System.out.println(i + 1 + ".\tInput array: " + Arrays.toString(arr[i]));
            System.out.println("\tMinimum element in the rotated array is: " + findMinInRotatedArray(arr[i]));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }

    private static int findMinInRotatedArray(int[] ints) {

        return -1;

    }
}
