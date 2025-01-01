package practice.graphs;

import java.util.*;

public class NetworkDelay {


    public static void main(String[] args) {
        int[][][] times = {
                {{2, 1, 1}, {3, 2, 1}, {3, 4, 2}},
                {{2, 1, 1}, {1, 3, 1}, {3, 4, 2}, {5, 4, 2}},
                {{1, 2, 1}, {2, 3, 1}, {3, 4, 1}},
                {{1, 2, 1}, {2, 3, 1}, {3, 5, 2}},
                {{1, 2, 2}}
        };

        int[] n = {4, 5, 4, 5, 2};
        int[] k = {3, 1, 1, 1, 2};

        for (int i = 0; i < times.length; i++) {
            System.out.println((i + 1) + ".\t times = " + Arrays.deepToString(times[i]));
            System.out.println("\t number of nodes 'n' = " + n[i]);
            System.out.println("\t starting node 'k' = " + k[i] + "\n");
            System.out.println("\t Minimum amount of time required = " + networkDelayTime(times[i], n[i], k[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }



    public static int networkDelayTime(int[][] times, int n, int startNode) {

        //First create a adjancencyList

        Map<Integer,List<int[]>> adjacencyList = new HashMap<>();
        for(int[] time : times) {
            int sourceNode = time[0];
            int destinationNode = time[1];
            int travelTime = time[2];

            adjacencyList.computeIfAbsent(sourceNode, key -> new ArrayList<>()).add(new int[]{destinationNode,travelTime});



        }



        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0,startNode});

        Set<Integer> visited = new HashSet<>();
        int delays = 0;
        while(!pq.isEmpty()) {

            int[] current = pq.poll();
            int time = current[0];
            int node = current[1];

            if(visited.contains(node)) {
                continue;
            }

            visited.add(node);




            delays = Math.max(delays,time);

            //Not get the adjacency
            List<int[]> neighbours = adjacencyList.getOrDefault(node,new ArrayList<>());
            for(int[] neighbour : neighbours)
            {
                int neighbourNode = neighbour[0];
                int neighbourTime = neighbour[1];


                if(!visited.contains(neighbourNode)) {

                    int newTime = neighbourTime + time;
                    pq.offer(new int[] {newTime,neighbourNode});

                }





            }
        }


        if(visited.size() == n ) {
            return delays;
        }

        return -1;





    }






     public static int networkDelayTime1(int[][] times,int n,int k) {
        //What is the template ?

        //First create a Adjacency list
        // example 2,1,1 -> 2 is the source and key is the tuples that have the destination node and the time for the signal
        //to travel from source to destination node.

        Map<Integer, List<int[]>> adjacency = new HashMap<>();

        for(int[] time : times) {

            int source = time[0];
            int destination = time[1];
            int travelTime = time[2];
           adjacency.computeIfAbsent(source,key -> new ArrayList<>()).add(new int[]{destination,travelTime});


        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // stores the delay time of each nodes as te fist element for each tuple and
         // the node as the second element (time,node)
         pq.offer(new int[]{0,k}); //This adds a source node with a delay time of 0

         Set<Integer> visited = new HashSet<>();

         int delays = 0;

         while(!pq.isEmpty()) {

             int[] current = pq.poll();

             int time = current[0];
             int node = current[1];


             if(visited.contains(node)) {
                 continue;
             }

             visited.add(node);
             delays = Math.max(delays, time);
             List<int[]> neighbours  = adjacency.getOrDefault(node,new ArrayList<>());

             for(int [] neighbour: neighbours) {

                 int neighbourNode = neighbour[0];
                 int neighbourTime = neighbour[1];

                 if(!visited.contains(neighbourNode)) {

                     int newTime = time + neighbourTime;
                     pq.offer(new int[]{newTime,neighbourNode});
                 }
             }


         }
if(visited.size() == n) {
      return delays;
  }



        return -1;


     }

}
