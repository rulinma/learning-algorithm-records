package com.rulinma.algorithm.leetcode.middle;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author 马如林
 * @Data 2022/8/8 09:18
 */
public class ReachableNodesWithRestrictionsTest {

    @Test
    public void test1() {
        int n = 7;
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}};
        int[] restricted = new int[]{4, 5};

        ReachableNodesWithRestrictions reachableNodesWithRestrictions = new ReachableNodesWithRestrictions();
        int rs = reachableNodesWithRestrictions.reachableNodes(n, edges, restricted);
        Assert.assertEquals(4, rs);
    }


    @Test
    public void test2() {
        int n = 7;
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 5}, {0, 4}, {3, 2}, {6, 5}};
        int[] restricted = new int[]{4, 2, 1};

        ReachableNodesWithRestrictions reachableNodesWithRestrictions = new ReachableNodesWithRestrictions();
        int rs = reachableNodesWithRestrictions.reachableNodes(n, edges, restricted);
        Assert.assertEquals(3, rs);
    }


    @Test
    public void test3() {
        int n = 10;
        int[][] edges = new int[][]{{4, 1}, {1, 3}, {1, 5}, {0, 5}, {3, 6}, {8, 4}, {5, 7}, {6, 9}, {3, 2}};
        int[] restricted = new int[]{2, 7};

        ReachableNodesWithRestrictions reachableNodesWithRestrictions = new ReachableNodesWithRestrictions();
        int rs = reachableNodesWithRestrictions.reachableNodes(n, edges, restricted);
        Assert.assertEquals(8, rs);
    }

    @Test
    public void test5() {
        int n = 2;
        int[][] edges = new int[][]{{0, 1}};
        int[] restricted = new int[]{1};

        ReachableNodesWithRestrictions reachableNodesWithRestrictions = new ReachableNodesWithRestrictions();
        int rs = reachableNodesWithRestrictions.reachableNodes(n, edges, restricted);
        Assert.assertEquals(1, rs);
    }


}
