package practice.blind75.modifiedbinarysearch;

import java.util.Arrays;
import java.util.List;

public class SearchInRotatedSortedArray {

    // Driver code
    public static void main(String args[]) {
        List<List<Integer>> numList = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                Arrays.asList(10, 20, 30, 40, 50, 60),
                Arrays.asList(12, 24, 35, 47, 58, 69, 72, 83, 94),
                Arrays.asList(5, 13, 28, 41, 56, 63, 77, 82, 99, 105),
                Arrays.asList(5, 7, 12, 17, 21, 28, 33, 37, 41, 48, 52, 57, 62, 68, 72)
        );

        List<Integer> targetList = Arrays.asList(1, 50, 12, 56, 5);

        for (int i = 0; i < targetList.size(); i++) {
            System.out.println((i + 1) + ".\tSorted array: " + numList.get(i) +
                    "\n\ttarget " + targetList.get(i) +
                    " found at index " + binarySearch(numList.get(i), targetList.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    private static int binarySearch(List<Integer> nums, Integer target) {
        int start = 0;
        int end = nums.size() -1;

        while(start <=end) {
            int mid = start + (end -start) /2;

            if(nums.get(mid) == target){
                return mid;
            }
            if(nums.get(start) < nums.get(mid)) { //The first part of the array is sorted betwnee start and mid

                if(nums.get(start) <= target  && target <= nums.get(mid)) {
                    // target is within sorted first half of the array
                    end = mid -1;

                }
                else {
                    // target is not within sorted first half of the array , Lets examine the unsorted array
                    start = mid +1;
                }

            }
            else { //The second part of the array is sorted between Mid and end

                    if(nums.get(mid) < target && target <= nums.get(end)) {
                        start = mid + 1; //Target is withing second half of the array
                    }
                    else {
                        end = mid -1; //Target is not withing the second half of the array , So lets examine the unsorted second half
                    }
            }


        }

        return -1;


    }


}
