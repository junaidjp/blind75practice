package practice.blind75.modifiedbinarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickWithWeight {

    List<Integer> runningSums;
   private  int totalSum;

    public static void main(String[] args) {


        int[] weights = {1, 2, 3, 4, 5};
       // int pickIndex = pickIndex (weights);


    }
    
    
    
    public RandomPickWithWeight(int[] weights) {
        runningSums = new ArrayList<>();
        int runningSum = 0;
        for(int w : weights) {
            runningSum = runningSum + w;
            runningSums.add(runningSum);
        }

        totalSum = runningSum;


    }

    private  int pickIndex(int[] weights) {

      Random random = new Random();
      int target = random.nextInt(totalSum) + 1;
    int low = 0;
    int high = runningSums.size();
    while(low  < high) {


        int mid = low + (high - low) /2;

        if(target > runningSums.get(mid)) {
            low = mid +1;
        }
        else {
            high = mid;
        }
    }

        return low;

    }
}
