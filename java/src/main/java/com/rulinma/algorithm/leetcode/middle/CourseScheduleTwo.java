package com.rulinma.algorithm.leetcode.middle;

import java.util.*;

/**
 * 210. 课程表 II
 * <p>
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 * <p>
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2：
 * <p>
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 示例 3：
 * <p>
 * 输入：numCourses = 1, prerequisites = []
 * 输出：[0]
 *  
 * <p>
 * 提示：
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * 所有[ai, bi] 互不相同
 * <p>
 * <p>
 * https://leetcode.cn/problems/course-schedule-ii
 *
 * @author 马如林
 * @Data 2022/9/3 20:37
 */
public class CourseScheduleTwo {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        List<Integer> result = new ArrayList<>();

        int count = 0;
        // 算法
        // bfs（用一个List记录访问顺序即可）
        // 0. 统计每个点的入度和出度
        // 1. 寻找入度为0的点，作为起始点，放入队列
        // 2. 遍历队列，把相邻节点的入度-1，如果入度为0则添加到队列中（visited节点标记，如果重复应该是有环，则退出）
        // 3. count个数==课程数 退出

        // 0 ~ n-1课程
        // map: key, value 是邻接节点
        // inDegree[i] = num; 记录当前节点入度个数
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] v = prerequisites[i];
            // 有向图
            inDegree[v[1]] += 1;
            // 添加邻接点
            List<Integer> list = map.getOrDefault(v[0], new ArrayList<>());
            list.add(v[1]);
            map.put(v[0], list);
        }

        // 寻找入度为0的
        boolean[] visited = new boolean[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                visited[i] = true;
                result.add(i);
            }
        }

        // 遍历queue
        while (!queue.isEmpty()) {
            int size = queue.size();
            count += size;
            if (count == numCourses) {
                int j = 0;
                for (Integer i : result) {
                    ans[j++] = i;
                }
                return ans;
            }
            for (int i = 0; i < size; i++) {
                // 获取邻接数据，减去节点的入度，如果入度为0，则可以添加到queue
                int node = queue.poll();
                List<Integer> adjacent = map.getOrDefault(node, new ArrayList<>());
                for (Integer x : adjacent) {
                    // 有环
                    if (visited[x] == true) {
                        return new int[]{0};
                    }
                    inDegree[x]--;
                    if (inDegree[x] == 0) {
                        queue.add(x);
                        visited[x] = true;
                        result.add(x);
                    }
                }
            }
        }

        if (count < numCourses) {
            return new int[]{0};
        }

        return ans;
    }

    public static void main(String[] args) {
        CourseScheduleTwo courseScheduleTwo = new CourseScheduleTwo();
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] rs = courseScheduleTwo.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(rs));

//        int numCourses = 2;
//        int[][] prerequisites = new int[][]{{1, 0}};
//        int[] rs = courseScheduleTwo.findOrder(numCourses, prerequisites);
//        System.out.println(rs);
    }

}
