package com.rulinma.algorithm.leetcode.middle;

/**
 * @author 马如林
 * @Data 2022/9/19 21:21
 */
public class Trie2 {

    private Trie2[] children;
    private boolean isEnd;

    public Trie2() {
        children = new Trie2[26];
        isEnd = false;
    }

    public void insert(String word) {
        // 1.
        Trie2 node = this;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie2();
            }
            node = node.children[index];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie2 node = this;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }

        return node.isEnd ;
    }

    public boolean startsWith(String prefix) {
        Trie2 node = this;
        char[] chars = prefix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }

        return true;
    }

    public static void main(String[] args) {
        Trie2 trie = new Trie2();
        trie.insert("apple");
        boolean rs = trie.search("apple");
        // 返回 True
        System.out.println(rs);
        rs = trie.search("app");
        // 返回 False
        System.out.println(rs);
        rs = trie.startsWith("app");
        // 返回 True
        System.out.println(rs);
        trie.insert("app");

        rs = trie.search("app");
        // 返回 True
        System.out.println(rs);
    }
}
