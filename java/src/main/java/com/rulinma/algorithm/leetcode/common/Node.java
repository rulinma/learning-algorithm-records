package com.rulinma.algorithm.leetcode.common;

/**
 * @author 马如林
 * @Data 2022/6/29 10:59
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
