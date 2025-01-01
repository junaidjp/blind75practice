package practice.graphs;

import java.util.*;

public class ValidGraphTree {

    // Driver code
    public static void main(String[] args) {
        int[] n = {3, 4, 5, 5, 6};
        int[][][] edges = {
                {{0, 1}, {0, 2}, {1, 2}},
                {{0, 1}, {0, 2}, {0, 3}},
                {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {3, 4}},
                {{0, 1}, {0, 2}, {0, 3}, {3, 4}},
                {{0, 1}, {0, 2}, {1, 3}, {2, 4}, {0, 5}}
        };

        for (int i = 0; i < n.length; i++) {
            System.out.println((i + 1) + ". n = " + n[i]);
            System.out.println("   Edges = " + Arrays.deepToString(edges[i]));
            System.out.println("   Is the given graph a valid tree: " + validTree(n[i], edges[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


    }





    private static boolean validTree(int n, int[][] edges) {

        //What is template ?
        //

        if (edges.length != (n - 1)) {
            return false;
        }

        List<List<Integer>> adjacency = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacency.add(new ArrayList<>());

        }


        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            adjacency.get(x).add(y);
            adjacency.get(y).add(x);


        }

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        visited.add(0);
        stack.push(0);

        while (!stack.isEmpty()) {

            int node = stack.pop();
            //iteratate over the neigbours of the popped node
            for (int neigbour : adjacency.get(node)) {


                if (!visited.contains(neigbour)) {


                    stack.push(neigbour);
                    visited.add(neigbour);


                }


            }




        }
        return visited.size() == n;


        /**
         * Since each node is visited only once, the time complexity of the given solution is
         * O
         * (
         * n
         * )
         * O(n)
         * , where
         * n
         * n
         *  is the number of nodes.
         */
    }


}