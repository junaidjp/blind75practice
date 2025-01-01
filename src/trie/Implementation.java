package trie;
import java.util.*;
public class Implementation {


    public static void main(String args[]) {


        String test = "cat calls caller and rat rattles ramblers";
        List<String> results = new ArrayList<String>();
         results.add("cat");
        results.add("calls");
        results.add("calls");
        results.add("and");
        results.add("rat");
        results.add("rattles");
        results.add("ramblers");



        Trie trie = new Trie();
       for(String str : results) {
           trie.insert(str);
       }





    }
}
