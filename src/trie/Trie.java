package trie;

import java.util.List;

public class Trie {

    TrieNode root;

    public Trie() {


        this.root = new TrieNode();
    }

    public void insert(String test) {

    TrieNode trieNode = this.root;
        for(int j=0; j<test.length();j++) {
            char ch = test.charAt(j);
            if(!trieNode.children.containsKey(ch)) {
                trieNode.children.put(ch,new TrieNode());
            }
            trieNode = trieNode.children.get(ch);
        }

        trieNode.isWord = true;



    }

    }

