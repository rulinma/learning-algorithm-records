package com.rulinma.algorithm.leetcode.easy;

/**
 * 1779. 找到最近的有相同 X 或 Y 坐标的点
 * <p>
 * 给你两个整数 x 和 y ，表示你在一个笛卡尔坐标系下的 (x, y) 处。同时，在同一个坐标系下给你一个数组 points ，其中 points[i] = [ai, bi] 表示在 (ai, bi) 处有一个点。当一个点与你所在的位置有相同的 x 坐标或者相同的 y 坐标时，我们称这个点是 有效的 。
 * <p>
 * 请返回距离你当前位置 曼哈顿距离 最近的 有效 点的下标（下标从 0 开始）。如果有多个最近的有效点，请返回下标 最小 的一个。如果没有有效点，请返回 -1 。
 * <p>
 * 两个点 (x1, y1) 和 (x2, y2) 之间的 曼哈顿距离 为 abs(x1 - x2) + abs(y1 - y2) 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]]
 * 输出：2
 * 解释：所有点中，[3,1]，[2,4] 和 [4,4] 是有效点。有效点中，[2,4] 和 [4,4] 距离你当前位置的曼哈顿距离最小，都为 1 。[2,4] 的下标最小，所以返回 2 。
 * <p>
 * https://leetcode.cn/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate
 *
 * @author 马如林
 * @Data 2022/7/4 14:12
 */
public class FindNearestPointThatHasTheSameXOrYCoordinate {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int a = point[0], b = point[1];
            if (a == x || b == y) {
                int dist = Math.abs(a - x) + Math.abs(b - y);
                if (dist < min) {
                    ans = i;
                    min = dist;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FindNearestPointThatHasTheSameXOrYCoordinate findNearestPointThatHasTheSameXOrYCoordinate = new FindNearestPointThatHasTheSameXOrYCoordinate();
        int[][] nums = {{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};
        int result = findNearestPointThatHasTheSameXOrYCoordinate.nearestValidPoint(3, 4, nums);
        System.out.println(result);
    }
}
