package practice.graphs;

import java.util.HashMap;
import java.util.Map;

public class CloneGraphMain {

    public static void main(String[] args) {
        int[][][] data = {
                {{2, 3}, {1, 3}, {1, 2}},
                {{2, 4}, {1, 3}, {2, 4}, {1, 3}},
                {{2, 5}, {1, 3}, {2, 4}, {3, 5}, {1, 4}},
                {{2}, {1}},
                {{2, 6}, {1, 3}, {2, 4}, {3, 5}, {4, 6}, {1, 5}},
                {{}}
        };

        Node node1 = GraphUtility.createGraph(data[0]);
        System.out.println(".\t Original Graph: " + GraphUtility.create2DList(node1) + "\n");
        System.out.println();
        Node clonedRoot = clone(node1);


    }

    private static Node clone(Node root) {


        Map<Node,Node> nodesCompleted = new HashMap<Node,Node>();

        cloneHelper(root,nodesCompleted);

        return null;

    }

    private static Node cloneHelper(Node root, Map<Node, Node> nodesCompleted) {

        if(root == null) {
            return null;
        }
      Node clonedNode = new Node(root.data);
      nodesCompleted.put(root,clonedNode);
      for(Node p : root.neighbors) {
         Node x   = nodesCompleted.get(p);
         if(x == null) {
            clonedNode.neighbors.add(cloneHelper(p,nodesCompleted));
         }
         else {
             clonedNode.neighbors.add(x);
         }



      }

// O (n * m )

      return clonedNode;


    }
}
