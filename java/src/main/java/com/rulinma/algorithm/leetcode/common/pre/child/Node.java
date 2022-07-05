package com.rulinma.algorithm.leetcode.common.pre.child;

/**
 * @author 马如林
 * @Data 2022/7/5 18:25
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }
}
