package com.rulinma.algorithm.leetcode.middle;

/**
 * @author 马如林
 * @Data 2022/9/19 21:21
 */
public class Trie {
    private Ttree root;

    public Trie() {
        root = new Ttree();
    }

    public void insert(String word) {
        Ttree node = root;
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            int index = ch - 'a';
            if (node.getNodes()[index] == null) {
                Ttree t = new Ttree();
                node.getNodes()[index] = t;
            }
            node = node.getNodes()[index];
        }

        node.setEnd(true);
    }

    public boolean search(String word) {
        Ttree node = root;
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            int index = ch - 'a';
            if (node.getNodes()[index] == null) {
                return false;
            }
            node = node.getNodes()[index];
        }

        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        Ttree node = root;
        char[] chars = prefix.toCharArray();
        for (char ch : chars) {
            int index = ch - 'a';
            if (node.getNodes()[index] == null) {
                return false;
            }
            node = node.getNodes()[index];
        }

        return true;
    }

//    public static void main(String[] args) {
//        TrieTree trie = new TrieTree();
//        trie.insert("apple");
//        boolean rs = trie.search("apple");
//        // 返回 True
//        System.out.println(rs);
//        rs = trie.search("app");
//        // 返回 False
//        System.out.println(rs);
//        rs = trie.startsWith("app");
//        // 返回 True
//        System.out.println(rs);
//        trie.insert("app");
//
//        rs = trie.search("app");
//        // 返回 True
//        System.out.println(rs);
//    }
}


class Ttree {
    private Ttree[] nodes = new Ttree[26];
    private boolean isEnd;

    public Ttree[] getNodes() {
        return nodes;
    }

    public void setNodes(Ttree[] nodes) {
        this.nodes = nodes;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}