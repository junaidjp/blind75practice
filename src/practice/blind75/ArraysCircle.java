package practice.blind75;

public class ArraysCircle {


    public static void main(String args[]) {

        int[] array = {2,3,1,4,0,9,7};
        boolean  iscycle  = doesItcontainCycle(array);
        System.out.println(iscycle);


    }

    private static boolean doesItcontainCycle(int[] array) {


        int slow = 0;
        int fast = 0;

        do {

            slow = array[slow];
            fast = array[array[fast]];

           if(fast >= array.length) {
               return false;
           }

           return true;
        } while (slow != fast);
       // THIS IS NOT COMPLETE
    }


}
