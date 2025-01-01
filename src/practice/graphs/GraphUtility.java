package practice.graphs;

import java.util.*;

public class GraphUtility {

    public static Node createGraph(int[][] data) {

        if(data.length == 0){
            return new Node(1);
        }
        Node[] nodes = new Node[data.length];
        for (int i = 0; i < data.length; i++) {
            nodes[i] = new Node(i + 1);
        }

        for (int i = 0; i < data.length; i++) {
            for (int neighbor : data[i]) {
                nodes[i].neighbors.add(nodes[neighbor - 1]);
            }
        }
        return nodes[0];



    }

    public List<List<Integer>> create2DListPr2(Node root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue  = new LinkedList<>();
        queue.add(root);
        HashMap<Node,Node> visited = new HashMap<>();

        List<List<Integer>> graph = new ArrayList<>();

        HashMap<Node,Integer> nodeIndex = new HashMap<>();

        while(!queue.isEmpty()) {

            Node node = queue.remove();
            List<Integer> neighbours = new ArrayList<>();

            for(Node neighbour : node.neighbors) {

                neighbours.add(visited.getOrDefault(neighbour,neighbour).data);
                if(!visited.containsKey(neighbour) && !queue.contains(neighbour)) {
                    visited.put(neighbour,neighbour);
                    queue.add(neighbour);
                }


            }
            Collections.sort(neighbours);

            if(!nodeIndex.containsKey(node)) {

                int index = graph.size();

                nodeIndex.put(node,index);
                List<Integer> subList = new ArrayList<>();

                subList.add(node.data);
                subList.addAll(neighbours);
                graph.add(subList);

            }
        } // End queue

        //Sort the graph by Node Value
        Collections.sort(graph, new Comparator<List<Integer>>() {
           public int compare(List<Integer> a , List<Integer> b) {
               return a.get(0) - b.get(0);
           }
        });



        for(List<Integer> subList: graph) {

            List<Integer> sub = subList.subList(1,subList.size());
            result.add(sub);


        }
        return result;


    }



public List<List<Integer>> create2DListPractice(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        HashMap<Node,Node> visited = new HashMap<>();
        List<List<Integer>> graph = new ArrayList<>();
        HashMap<Node,Integer> nodeIndex = new HashMap<>();
        while(!queue.isEmpty()) {

            Node node = queue.remove();
            List<Integer> neighbours = new ArrayList<>();
            for(Node neighbour : node.neighbors) {


                neighbours.add(visited.getOrDefault(neighbour, neighbour).data);
                if (!visited.containsKey(neighbour) && !queue.contains(neighbour)) {


                    visited.put(neighbour, neighbour);
                    queue.add(neighbour);


                }
            }

                Collections.sort(neighbours);
                //Append the value of the Node and its \

                if (!nodeIndex.containsKey(node)) {


                    int index = graph.size();
                    nodeIndex.put(node, index);


                    List<Integer> subList = new ArrayList<>();

                    subList.add(node.data);
                    subList.addAll(neighbours);
                    graph.add(subList);


                }
            }

                Collections.sort(graph,new Comparator<List<Integer>>() {
                    public int compare(List<Integer> a , List<Integer> b) {
                        return a.get(0) - b.get(0);
                    }
                });



                for(List<Integer> subList : graph) {

                    List<Integer> sub = subList.subList(1,subList.size());
                    result.add(sub);


                }

       return result;

}


    public static List<List<Integer>> create2DList(Node root) {

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        //Initialize a HashMap to keep track of visited Nodes
        HashMap<Node,Node> visited = new HashMap<Node,Node>();


        //Initialie a 2D List to store the graph
        List<List<Integer>> graph = new ArrayList<List<Integer>>();

        //Initialze a HashMap to store the index of each Node

        HashMap<Node,Integer> nodeIndex = new HashMap<Node,Integer>();
        while(!queue.isEmpty()) {
            Node node = queue.remove();
            List<Integer> neighbours  = new ArrayList<>();

            for(Node neighbour : node.neighbors) {

                neighbours.add(visited.getOrDefault(neighbour,neighbour).data);

                if(!visited.containsKey(neighbour) && !queue.contains(neighbour)) {
                    visited.put(neighbour,neighbour);
                    queue.add(neighbour);
                }


            }

            Collections.sort(neighbours);

            // Append the current node's value and its neighbors to the 2D List
            if(!nodeIndex.containsKey(node)) {

            int index = graph.size(); // First time this will be zero

            nodeIndex.put(node,index);

            List<Integer> subList = new ArrayList<Integer>();
            subList.add(node.data);
            subList.addAll(neighbours);
            graph.add(subList);




            }



        }

//Sort the Graph by Node value
Collections.sort(graph,new Comparator<List<Integer>>() {
    public int compare(List<Integer> a, List<Integer> b) {
        return a.get(0)  - b.get(0);
    }
});

List<List<Integer>> result = new ArrayList<List<Integer>>();

for(List<Integer> subList : graph) {
List<Integer> sub = new ArrayList<>(subList.subList(1,subList.size()));
result.add(sub);

    
}
    return result;
    }

}
