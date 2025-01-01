package practice.blind75;

public class ContainerWithWater {


    public static void main(String args[]) {

           int[] heights = {1,8,6,2,5,4,8,3,7};
           int maxArea  = containerWithMostWater(heights);
           System.out.println(maxArea);


    }

    private static int containerWithMostWater(int[] heights) {

        int start = 0;
        int end = heights.length -1;
        int maxArea= 0 ;


        while(start < end) {
            int width = end -start;
             maxArea =  Math.max(maxArea,Math.min(heights[start],heights[end]) * width);
             if(heights[start] <= heights[end]){
                start++;
            }
            else {
                end--;
            }


        }


        return maxArea ;

    }


}
