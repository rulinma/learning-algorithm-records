package com.rulinma.algorithm.leetcode.middle;

import java.util.Arrays;

/**
 * 2359. 找到离给定两个节点最近的节点
 * <p>
 * 给你一个 n 个节点的 有向图 ，节点编号为 0 到 n - 1 ，每个节点 至多 有一条出边。
 * <p>
 * 有向图用大小为 n 下标从 0 开始的数组 edges 表示，表示节点 i 有一条有向边指向 edges[i] 。如果节点 i 没有出边，那么 edges[i] == -1 。
 * <p>
 * 同时给你两个节点 node1 和 node2 。
 * <p>
 * 请你返回一个从 node1 和 node2 都能到达节点的编号，使节点 node1 和节点 node2 到这个节点的距离 较大值最小化。如果有多个答案，请返回 最小 的节点编号。如果答案不存在，返回 -1 。
 * <p>
 * 注意 edges 可能包含环。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：edges = [2,2,3,-1], node1 = 0, node2 = 1
 * 输出：2
 * 解释：从节点 0 到节点 2 的距离为 1 ，从节点 1 到节点 2 的距离为 1 。
 * 两个距离的较大值为 1 。我们无法得到一个比 1 更小的较大值，所以我们返回节点 2 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：edges = [1,2,-1], node1 = 0, node2 = 2
 * 输出：2
 * 解释：节点 0 到节点 2 的距离为 2 ，节点 2 到它自己的距离为 0 。
 * 两个距离的较大值为 2 。我们无法得到一个比 2 更小的较大值，所以我们返回节点 2 。
 *  
 * <p>
 * 提示：
 * <p>
 * n == edges.length
 * 2 <= n <= 105
 * -1 <= edges[i] < n
 * edges[i] != i
 * 0 <= node1, node2 < n
 * <p>
 * <p>
 * https://leetcode.cn/problems/find-closest-node-to-given-two-nodes
 *
 * @author 马如林
 * @Data 2022/8/29 17:29
 */
public class FindClosestNodeToGivenTwoNodes {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        // 点 node1 和 node2 到其它所有点的最短路径
        int[] dist1 = getDist(edges, node1);
        int[] dist2 = getDist(edges, node2);
        int ans = -1, min = (int) 1e5 + 7;
        // 遍历可选择的「中间点」
        for (int i = 0; i < n; i++) {
            // 分别为 node1 和 node2 到 i 的最短路径
            int d1 = dist1[i], d2 = dist2[i];
            // 如果有一方到不了，则跳过
            if (d1 == -1 || d2 == -1) continue;
            int max = Math.max(d1, d2);
            if (max < min) {
                min = max;
                ans = i;
            }
        }
        return ans;
    }

    // 求点 s 到其它所有点的最短路径
    private int[] getDist(int[] edges, int s) {
        int d = 0;
        int[] dist = new int[edges.length];
        Arrays.fill(dist, -1);
        while (s != -1) {
            // 已经访问，考虑「环」的存在
            if (dist[s] != -1) {
                break;
            }
            dist[s] = d++;
            // 下一个点
            s = edges[s];
        }
        return dist;
    }

    public static void main(String[] args) {

        int[] edges = new int[]{2, 2, 3, -1};
        int node1 = 0;
        int node2 = 1;

        FindClosestNodeToGivenTwoNodes findClosestNodeToGivenTwoNodes = new FindClosestNodeToGivenTwoNodes();

        System.out.println(findClosestNodeToGivenTwoNodes.closestMeetingNode(edges, node1, node2));

    }
}
