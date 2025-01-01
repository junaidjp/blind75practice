package practice.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Graph {
    private int V;
    private List<List<Integer>> adj;

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }

    private void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    private void BFS(int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while(queue.size() != 0) {

            s= queue.poll();
            System.out.print(s +  " ");
            Iterator<Integer> i = adj.get(s).listIterator();
            while(i.hasNext()) {
                int n = i.next();

                if(!visited[n]) {
                    queue.add(n);
                    visited[n] = true;
                }
            }



        }


    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.BFS(2);
    }

}
