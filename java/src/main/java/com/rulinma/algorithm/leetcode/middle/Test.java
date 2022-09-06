package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.*;

/**
 * @author 马如林
 * @Data 2022/9/2 11:02
 */
public class Test {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 2个节点的父节点相同，或者其中1个是父节点
        // p节点的父节点列表 q节点的父节点列表 查看最后交叉的地方就是最近公共祖先（反转后第一个交叉的地方）
        Map<Integer, Integer> map = new HashMap<>();

        dfs(root, map, null);

        int anc = -1;
        // 获取parent列表
        List<Integer> p1 = getParent(p, map);
        List<Integer> p2 = getParent(q, map);

        Set<Integer> set = new HashSet<>();
        for (Integer x : p1) {
            set.add(x);
        }

        for (int i = 0; i < p2.size(); i++) {
            if (set.contains(p2.get(i))) {
                // 最近公共祖先
                anc = p2.get(i);
                break;
            }
        }

        // 根据val查找到TreeNode
        TreeNode rs = dfs(root, anc);

        return rs;
    }

    private TreeNode dfs(TreeNode root, int v) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                if (t.val == v) {
                    return t;
                }
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
        }

        return null;
    }

    private TreeNode dfs1(TreeNode root, int v) {
        if (root == null) {
            return null;
        }
        if (root.val == v) {
            return root;
        }

        TreeNode left = dfs1(root.left, v);
        TreeNode right = dfs1(root.right, v);
        if (left != null) {
            return left;
        }

        return right;
    }

    private List<Integer> getParent(TreeNode p, Map<Integer, Integer> map) {
        List<Integer> list = new ArrayList<>();
        Integer v = p.val;

        while (v != null) {
            list.add(v);
            v = map.get(v);
        }

        return list;
    }

    private void dfs(TreeNode root, Map<Integer, Integer> map, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (parent != null) {
            map.put(root.val, parent.val);
        }
        dfs(root.left, map, root);
        dfs(root.right, map, root);
    }

    public int numIslands(char[][] grid) {
        int c = 0;
        // bfs
        // dfs
        // left up right down 四个方向dfs
        int row = grid.length;
        int col = grid[0].length;
        int[][] visited = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    dfs(grid, i, j, visited);
                    c++;
                }
            }
        }

        return c;
    }

    private void dfs(char[][] grid, int i, int j, int[][] visited) {
        // i j 判断
        // 上下左右处理的越界处理
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }

        // 访问过位置
        if (grid[i][j] == '1' && visited[i][j] == 0) {
            visited[i][j] = 1;
            dfs(grid, i - 1, j, visited);
            dfs(grid, i + 1, j, visited);
            dfs(grid, i, j - 1, visited);
            dfs(grid, i, j + 1, visited);
        }
    }
    int max = 0;

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    /**
     * 652. 寻找重复的子树
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs1(root);
        return ans;
    }

    String dfs1(TreeNode root) {
        if (root == null) {
            return " ";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append("_");
        sb.append(dfs(root.left)).append(dfs(root.right));
        String key = sb.toString();
        map.put(key, map.getOrDefault(key, 0) + 1);
        if (map.get(key) == 2) {
            ans.add(root);
        }
        return key;
    }

    public int longestUnivaluePath(TreeNode root) {
        dfs((root));
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = dfs(root.left);
            if (root.val == root.left.val) {
                left++;
            } else {
                left = 0;
            }
        }
        if (root.right != null) {
            right = dfs(root.right);
            if (root.val == root.right.val) {
                right++;
            } else {
                right = 0;
            }
        }

        max = Math.max(max, left + right);

        return Math.max(left, right);
    }

    /**
     * 2133. 检查是否每一行每一列都包含全部整数
     */
    public boolean checkValid(int[][] matrix) {
        // 1. 获取每一行
        // 2. 遍历每一行，如果其值出现，则对应的数组位置设置为1，如果有非1的则该行数据不正确
        for (int[] x : matrix) {
            int[] arr = new int[matrix.length];
            for (int a : x) {
                arr[a - 1] = 1;
            }
            // check
            for (int i = 0; i < matrix.length; i++) {
                // 有一个没有被覆盖，就是错误
                if (arr[i] != 1) {
                    return false;
                }
            }
        }

        // 3. 遍历每一列
        for (int col = 0; col < matrix.length; col++) {
            int[] arr = new int[matrix.length];
            // 遍历每一行
            for (int row = 0; row < matrix.length; row++) {
                arr[matrix[row][col] - 1] = 1;
            }
            // check
            for (int i = 0; i < matrix.length; i++) {
                if (arr[i] != 1) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Test test = new Test();

        TreeNode root = new TreeNode(3);

        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(1);
        root.left = left;
        root.right = right;

        TreeNode left_l = new TreeNode(6);
        TreeNode left_r = new TreeNode(2);
        left.left = left_l;
        left.right = left_r;

        TreeNode right_l = new TreeNode(0);
        TreeNode right_r = new TreeNode(8);
        right.left = right_l;
        right.right = right_r;

        TreeNode left_r_l = new TreeNode(7);
        TreeNode left_r_r = new TreeNode(4);

        left_r.left = left_r_l;
        left_r.right = left_r_r;

//        char[][] grid = new char[][]{
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}
//        };
//
//        Test test = new Test();
//        System.out.println(test.numIslands(grid));

//        TreeNode treeNode = test.lowestCommonAncestor(root, left, right);
//        System.out.println(treeNode);

        TreeNode treeNode = test.dfs1(root, 7);
        System.out.println(treeNode);
    }

}