package practice.blind75.modifiedbinarysearch;

public class IntegerSquareRoot {

//Incomplete
    public static void main(String args[]) {

        int array[]= {2,3,4,5};
        int target = 10;

        int number = findIntegerSquare(array,target);
        System.out.println(number);



    }

    private static int findIntegerSquare(int[] array, int target) {

        int left = array[0];
        int right = (int) Math.floor(target/2);
        while(left <= right) {

            int mid = (int) Math.floor(left + right/2);
            int square = (int) Math.sqrt(mid);

            if(square == mid) {
                return mid;
            }
             if(square < target) {
                left = mid +1;
            }
             else {
                 right = mid -1;
             }

        }



        return right;

    }


}
