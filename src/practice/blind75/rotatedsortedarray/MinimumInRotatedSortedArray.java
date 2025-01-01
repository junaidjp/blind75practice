package practice.blind75.rotatedsortedarray;

import java.util.Arrays;

public class MinimumInRotatedSortedArray {

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

    private static int findMinInRotatedArray(int[] arr) {

        int left = 0;
        int right  = arr.length-1;
        if(arr.length ==1) {
            return arr[0];
        }
        while(right >= left) {

            int mid = left + ( right - left) /2;
            if(arr[mid] > arr[mid +1]) {
                return arr[mid+1];
            }

            if(arr[mid] < arr[mid -1]) {
                return arr[mid];
            }

            if(arr[mid] > arr[left]) {
                left = mid +1;
            }
             else {
                 right = mid -1;
            }




        }

        return -1;

    }

}
