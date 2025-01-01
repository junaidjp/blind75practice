package practice.blind75.fastandslowpointers;

import java.util.Arrays;

public class CircularArrayloop {

    // Driver code
    public static void main(String[] args) {
        int[][] input = {
                {-2, -3, -9},
                {-5, -4, -3, -2, -1},
                {-1, -2, -3, -4, -5},
                {2, 1, -1, -2},
                {-1, -2, -3, -4, -5, 6},
                {1, 2, -3, 3, 4, 7, 1},
                {2, 2, 2, 7, 2, -1, 2, -1, -1}
        };

        for (int i = 0; i < input.length; i++) {
            System.out.println((i + 1) + ".\tCircular array = " + Arrays.toString(input[i]) + "\n");
            boolean result = circularArrayLoop(input[i]);
            System.out.println("\tFound Loop = " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    private static boolean circularArrayLoop(int[] nums) {
        // Let takes example 2 -1 -3
        //First iterate over the index array
        int size = nums.length;
        for(int i=0;i<nums.length;i++) {
            int slow =i , fast = i;

           boolean forward = nums[i] > 0;



           while(true) {

              slow = nextStep(slow,nums[slow],size);

                if(isNotCycle(nums,forward,slow)){
                    break;
                }

                fast = nextStep(fast,nums[fast],size);

               if(isNotCycle(nums,forward,slow)){
                  break;
               }

               fast = nextStep(fast,nums[fast],size);

               if(fast == slow) {
                   return true;
               }
           }


        }
    return false;

    }


    private static boolean isNotCycle(int[] nums, boolean previousDirection, int pointer) {

        boolean currentDirection = nums[pointer] > 0;

        int nextPosition = nextStep(pointer,nums[pointer],nums.length);

        boolean isSelfLoop = nextPosition == pointer;

        return currentDirection != previousDirection || isSelfLoop;



    }


    private static int nextStep(int pointer, int value, int size) {
            //First iteration is pointer 0 , value as 2 , size as 2

                int result = (pointer + value) % size; // 0 + 2 = 2 % 2 = 0
                if(result < 0) {
                    result = result + size;  // Then we move in the first of backward

                }
                return result;
    }

}
