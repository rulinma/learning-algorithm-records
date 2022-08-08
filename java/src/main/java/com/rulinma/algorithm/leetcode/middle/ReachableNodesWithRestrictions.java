package com.rulinma.algorithm.leetcode.middle;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 6139. 受限条件下可到达节点的数目
 * <p>
 * 现有一棵由 n 个节点组成的无向树，节点编号从 0 到 n - 1 ，共有 n - 1 条边。
 * <p>
 * 给你一个二维整数数组 edges ，长度为 n - 1 ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。另给你一个整数数组 restricted 表示 受限 节点。
 * <p>
 * 在不访问受限节点的前提下，返回你可以从节点 0 到达的 最多 节点数目。
 * <p>
 * 注意，节点 0 不 会标记为受限节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
 * 输出：4
 * 解释：上图所示正是这棵树。
 * 在不访问受限节点的前提下，只有节点 [0,1,2,3] 可以从节点 0 到达。
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]
 * 输出：3
 * 解释：上图所示正是这棵树。
 * 在不访问受限节点的前提下，只有节点 [0,5,6] 可以从节点 0 到达。
 * <p>
 * https://leetcode.cn/problems/reachable-nodes-with-restrictions
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * edges 表示一棵有效的树
 * 1 <= restricted.length < n
 * 1 <= restricted[i] < n
 * restricted 中的所有值 互不相同
 *
 * @author 马如林
 * @Data 2022/8/8 07:50
 */
public class ReachableNodesWithRestrictions {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        // 广度遍历即可 BFS
        // 默认0节点存在
        int count = 1;
        // 1. 添加0节点
        // 2. bfs 访问节点，遇到restricted节点则skip，记录顶点个数
        // 双端队列
        Deque<Integer> deque = new LinkedList<>();
        // edges 从排序
        for (int[] e : edges) {
            // 0节点
            if (e[0] > e[1]) {
                int t = e[1];
                e[1] = e[0];
                e[0] = t;
            }
        }

        // 寻找节点为0的节点
        for (int[] e : edges) {
            // 0节点的下一个节点
            if (e[0] == 0 && !isRestricted(e[1], restricted)) {
                deque.add(e[1]);
                count++;
            }
        }

        // 从0开始添加节点
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int head = deque.poll();
                // 添加head相关的下一个节点，判断节点是否restricted，是则跳过
                // 获取head的所有下一个节点
                for (int[] e : edges) {
                    // 0节点的下一个节点
                    if (e[0] == head && !isRestricted(e[1], restricted)) {
                        deque.add(e[1]);
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean isRestricted(int x, int[] restricted) {

        for (int r : restricted) {
            if (r == x) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        ReachableNodesWithRestrictions reachableNodesWithRestrictions = new ReachableNodesWithRestrictions();
        int n = 7;
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}};
        int[] restricted = new int[]{4, 5};

//        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 5}, {0, 4}, {3, 2}, {6, 5}};
//        int[] restricted = new int[]{4, 2, 1};

//        int n = 4;
//        int[][] edges = new int[][]{{2, 1}, {1, 0}, {0, 3}};
//        int[] restricted = new int[]{3, 2};

        System.out.println(reachableNodesWithRestrictions.reachableNodes(n, edges, restricted));
    }
}
