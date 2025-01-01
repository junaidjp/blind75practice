package practice;

public class BinarySearch {

    public static void main(String args[]) {

        int array[] = {2,4,6,10,17,20,32};
        int index = findUsingBinarySearch(array,6);
        System.out.println(index);





    }

    private static int findUsingBinarySearch(int[] array, int key) {

            int left = 0;
            int right = array.length-1;

            while(left <= right) {

                int mid = left + (right -left )/ 2;

                if(array[mid] == key) {
                    return mid;
                }

               else  if(array[mid] < key) {
                    //then everything is on the right side of the Mid
                    //So change left
                    left = mid +1;

                }

               else {
                   right = mid-1;
                }


            }




        return -1;



    }


}
