package practice.blind75.basic;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void reverseArray(int[] arr) {

        int start = 0;
        int end = arr.length -1;
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

    }
}
