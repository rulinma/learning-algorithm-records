package com.rulinma.algorithm.leetcode.common.ntree;

import java.util.List;

/**
 * @author 马如林
 * @Data 2022/7/3 19:43
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

}
