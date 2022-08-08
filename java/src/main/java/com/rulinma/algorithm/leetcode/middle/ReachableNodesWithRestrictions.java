package com.rulinma.algorithm.leetcode.middle;

import java.util.*;

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
        Set<Integer> set = new HashSet<>();
        // 1. 添加0节点
        // 2. bfs 访问节点，遇到restricted节点则skip，记录顶点个数
        // 双端队列
        Deque<Integer> deque = new LinkedList<>();
        set.add(0);

        // 遍历edges，并过滤掉每个边的restricted
        // node的下一个边，能够立刻获取
        Set<Integer> restrictedSet = new HashSet<>();
        for (int r : restricted) {
            restrictedSet.add(r);
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            // 0节点的下一个节点
            if (!restrictedSet.contains(e[1])) {
                Set<Integer> set1 = map.get(e[0]);
                if (set1 == null || set1.isEmpty()) {
                    set1 = new HashSet<>();
                }
                set1.add(e[1]);
                map.put(e[0], set1);
            }

            if (!restrictedSet.contains(e[0])) {
                Set<Integer> set1 = map.get(e[1]);
                if (set1 == null || set1.isEmpty()) {
                    set1 = new HashSet<>();
                }
                set1.add(e[0]);
                map.put(e[1], set1);
            }
        }

        // 添加0节点开始并且有效的节点
        if (map.get(0) == null) {
            set.add(0);
            return set.size();
        } else {
            set.addAll(map.get(0));
            deque.addAll(map.get(0));
        }

        // 从0开始添加节点
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int head = deque.poll();
                // 获取head的所有下一个节点
                Set<Integer> t = map.get(head);
                if (t != null) {
                    for (Integer x : t) {
                        if (!set.contains(x)) {
                            set.add(x);
                            deque.add(x);
                        }
                    }
                }
            }
        }

        return set.size();
    }

    public static void main(String[] args) {

        ReachableNodesWithRestrictions reachableNodesWithRestrictions = new ReachableNodesWithRestrictions();
//        int n = 7;
//        int[][] edges = new int[][]{{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}};
//        int[] restricted = new int[]{4, 5};

//        int n = 7;
//        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 5}, {0, 4}, {3, 2}, {6, 5}};
//        int[] restricted = new int[]{4, 2, 1};

//        int n = 4;
//        int[][] edges = new int[][]{{2, 1}, {1, 0}, {0, 3}};
//        int[] restricted = new int[]{3, 2};


        int n = 10;
        int[][] edges = new int[][]{{4, 1}, {1, 3}, {1, 5}, {0, 5}, {3, 6}, {8, 4}, {5, 7}, {6, 9}, {3, 2}};
        int[] restricted = new int[]{2, 7};

//        int n = 4;
//        int[][] edges = new int[][]{{0, 1}, {1, 0}, {0, 3}};
//        int[] restricted = new int[]{3, 2};


        System.out.println(reachableNodesWithRestrictions.reachableNodes(n, edges, restricted));
    }
}
