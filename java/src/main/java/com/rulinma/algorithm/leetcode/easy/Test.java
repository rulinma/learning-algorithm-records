package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.ListNode;
import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.*;

/**
 * @author 马如林
 * @Data 2022/8/4 12:26
 */
public class Test {

    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        // 去重
        Set<Long> set = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        set.add(1L);
        heap.offer(1L);

        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (set.add(next)) {
                    heap.offer(next);
                }
            }
        }

        return ugly;
    }

    public int maxSubArray(int[] nums) {
        // 1 算出dp[i]的最大值
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 前面子串的子数组最大和的值>0，累加才有可能变大
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        for (int x : dp) {
            if (x > max) {
                max = x;
            }
        }

        return max;
    }

    public int singleNumber(int[] nums) {
        int rs = -1;

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            int s = map.getOrDefault(n, 0);
            if (s > 0) {
                map.put(n, s + 1);
            } else {
                map.put(n, 1);
            }
        }

        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        return rs;
    }

    public static ListNode reverseNode(ListNode listNode) {
        ListNode pre = null;
        ListNode head = listNode;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    private static void merge2List() {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(5);
        l1.next = l11;
        l11.next = l12;

        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        l2.next = l21;

        ListNode listNode = mergeOrderListNode(l1, l2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode mergeOrderListNode(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }

        while (l1 != null) {
            head.next = l1;
            l1 = l1.next;
            head = head.next;
        }

        while (l2 != null) {
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }

        return dummy.next;
    }

    private static void revertedListNode() {
        // 链表反转

        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(5);
        ListNode l13 = new ListNode(15);
        l1.next = l11;
        l11.next = l12;
        l12.next = l13;

        ListNode x = l1;
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }

        // reverse list
        System.out.println("-----");

//        merge2List();
        ListNode listNode = reverseNode(l1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    private static void treeHeight() {
        // Tree的深度和遍历
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        TreeNode left_l = new TreeNode(4);
        TreeNode left_r = new TreeNode(5);

        root.left = left;
        root.right = right;

        left.left = left_l;
        left.right = left_r;

        int rs = treeHeight(root);

        System.out.println(rs);
    }

    public static int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }

    public static int treeHeight2(TreeNode root) {
        int rs = 0;

        if (root == null) {
            return 0;
        }

        Deque<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            // 添加左右孩子
            List tmp = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                TreeNode node = list.poll();
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            list.addAll(tmp);

            rs++;
        }

        return rs;
    }

    private static void bfsTreeHeight() {
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        TreeNode left_l = new TreeNode(4);
        TreeNode left_r = new TreeNode(5);

        root.left = left;
        root.right = right;

        left.left = left_l;
        left.right = left_r;

        int rs = treeHeight2(root);
        System.out.println(rs);
    }

    private int climbStairs(int n) {
        int[] s = new int[n + 1];

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        s[1] = 1;
        s[2] = 2;

        int k = 3;
        while (k <= n) {
            s[k] = s[k - 1] + s[k - 2];
            k++;
        }

        return s[n];
    }

    public int coinChange(int[] coins, int amount) {
        // 自底向上的动态规划
        if (coins.length == 0) {
            return -1;
        }

        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo = new int[amount + 1];
        memo[0] = 0;
        // amout是金额
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            // j 金币的价值
            for (int v : coins) {
                if ((i - v >= 0) && (memo[i - v] < min)) {
                    min = memo[i - v] + 1;
                }
            }
            // memo[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min);
            memo[i] = min;
        }

        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }


    private static void arrTest() {
        //        String s = "011101";
//        String s = "00111";
//        arrTest();
        String s = "1111";

        char[] chars = s.toCharArray();

        int first = 0;
        int left = 0;
        int leftOne = 0;
        int last = 0;

        first = chars[0] == '0' ? 1 : 0;
        last = chars[s.length() - 1] == '1' ? 1 : 0;
        int totalOne = 0;

        for (int i = 1; i < s.length() - 1; i++) {
            if (chars[i] == '1') {
                totalOne++;
            }
        }

        int max = totalOne;

        for (int i = 1; i < s.length() - 1; i++) {
            // i 时的0的个数
            if (chars[i] == '0') {
                left++;
            } else {
                leftOne++;
                // i 时的右边1的个数
            }
            max = Math.max(left + totalOne - leftOne, max);
        }


        int result = first + max + last;
        System.out.println(result);

        // 回溯和递归
        // abc字符的全排列
//        List<String> rs = new ArrayList<>();
//        List<Character> list = new ArrayList<>();
//        backtrace(list, rs, "abc".toCharArray());
//
//        for (String s : rs) {
//            System.out.println(s);
//        }

//        List<List<Integer>> rs = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        int[] nums = new int[]{1, 2, 3};
//        backtrace1(list, rs, nums);
//
//        for (List<Integer> s : rs) {
//            System.out.println(s);
//        }
    }

    public static void backtrace(List<Character> list, List<String> rs, char[] s) {
        if (list.size() == s.length) {
            StringBuilder sb = new StringBuilder();
            for (Character character : list) {
                sb.append(character);
            }
            rs.add(sb.toString());
            return;
        }

        for (char ch : s) {
            if (!list.contains(ch)) {
                list.add(ch);
                backtrace(list, rs, s);
                list.remove(list.size() - 1);
            } else {
                //
            }
        }

    }

    public static void backtrace1(List<Integer> list, List<List<Integer>> rs, int[] arr) {
        if (list.size() == arr.length) {
            List<Integer> newList = new ArrayList<Integer>(list);
            rs.add(newList);
            return;
        }

        for (int ch : arr) {
            if (!list.contains(ch)) {
                list.add(ch);
                backtrace1(list, rs, arr);
                list.remove(list.size() - 1);
            } else {
                //
            }
        }

    }

    public int minimumRecolors(String blocks, int k) {
        // K区间范围的个数-B的个数就是就是需要翻转的个数，取最小值
        int min = k;

        char[] chars = blocks.toCharArray();

        int blackCount = 0;
        int left = 0;

        for (int i = 0; i < chars.length; i++) {
            // k个区间取值

            if (chars[i] == 'B') {
                blackCount++;
            }

            // K个长度了，进行判定
            if (i - left == k - 1) {
                min = Math.min(k - blackCount, min);
                // 左指针移动
                if (chars[left] == 'B') {
                    blackCount--;
                }
                left++;
            }
        }

        return min;
    }

    public int secondsToRemoveOccurrences(String s) {
        int count = 0;

        while (s.contains("01")) {
            s = s.replaceAll("01", "10");
            count++;
        }

        return count;
    }

    Map<String, Character> kv = new HashMap<>();

    public String shiftingLetters1(String s, int[][] shifts) {
        // 统计每个位置的移动次数，最后每个位置进行替换即可
        int len = s.length();
        char[] chars = new char[len];
        int[] changePos = new int[len];

        for (int i = 0; i < shifts.length; i++) {
            int pos = 1;
            if (shifts[i][2] == 0) {
                // 向前移位置
                pos = -1;
            }

            for (int m = shifts[i][0]; m <= shifts[i][1]; m++) {
                // 有移动
                // 移动最终数
                changePos[m] += pos;
            }
        }

        chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (changePos[i] != 0) {
                // 同样的参数可以直接获取记录
                char replaced = replace(chars[i], changePos[i] % 26);
                chars[i] = replaced;
            }
        }

        return String.valueOf(chars);
    }


    private char replace(char ch, int pos) {
        String key = ch + "_" + pos;
        if (kv.get(key) != null) {
            return kv.get(key);
        }
        char rs = ' ';
        int zIndex = (int) 'z';
        if (pos < 0) {
            rs = (char) (ch + 26 + pos > zIndex ? ch + pos : ch + 26 + pos);
        } else {
            rs = (char) (ch + pos > zIndex ? ch + pos - 26 : ch + pos);
        }

        kv.put(key, rs);

        return rs;
    }

    public String shiftingLetters(String s, int[][] shifts) {
        char[] chars = s.toCharArray();
        int[] cs = new int[chars.length];
        // 原始字符串的每个字符的ascii码
        for (int i = 0; i < chars.length; i++) {
            cs[i] = chars[i] - 'a';
        }

        // 建立差分数组
        int[] difference = new int[cs.length];
        difference[0] = cs[0];
        for (int i = 1; i < cs.length; i++) {
            difference[i] = cs[i] - cs[i - 1];
        }

        // 差分数组上区间操作
        for (int[] shift : shifts) {
            int start = shift[0], end = shift[1];
            int direction = shift[2];
            direction = (direction == 1) ? 1 : -1;
            difference[start] += direction;
            if (end + 1 < difference.length) {
                difference[end + 1] -= direction;
            }
        }

        // 差分数组反推出原数组
        int[] result = new int[cs.length];
        result[0] = (difference[0]) % 26;
        for (int i = 1; i < difference.length; i++) {
            result[i] = (result[i - 1] + difference[i]) % 26;
        }

        StringBuilder sb = new StringBuilder();
        for (int j : result) {
            // 有可能是负数(范围在[-25,0] )，所以要加上26
            if (j < 0) {
                j = 26 + j;
            }
            j = j % 26;
            sb.append((char) (j + 'a'));
        }
        return sb.toString();
    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        // 精力是所有精力的累加，不够则添加训练时间
        int sum = 0;
        // 精力是所有精力的累加，不够则添加训练时间
        int sumEnergy = 0;
        for (int e : energy) {
            sumEnergy += e;
        }
        if (sumEnergy >= initialEnergy) {
            sum = sumEnergy - initialEnergy + 1;
        }
        System.out.println(sum);

        // 遍历进行处理
        int current = initialExperience;
        int sumExperience = 0;
        for (int i = 0; i < experience.length; i++) {
            if (current <= experience[i]) {
                int addExp = experience[i] - current + 1;
                current += addExp;
                sumExperience += addExp;
            }
            current += experience[i];
        }

        sum += sumExperience;

        return sum;
    }

    public String largestPalindromic(String num) {
        StringBuilder sb = new StringBuilder();
        // 统计字符串每个ch的出现次数
        // 9-0 统计个数
        // 从9->0开始放字符串，偶数刚好添加一半，奇数则保存为中间值，继续添加后面的值
        int max = -1;
        char[] chars = num.toCharArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (char ch : chars) {
            int count = map.getOrDefault(Integer.parseInt(String.valueOf(ch)), 0);
            map.put(Integer.parseInt(String.valueOf(ch)), count + 1);
        }

        for (int i = 9; i >= 0; i--) {
            int c = map.getOrDefault(i, 0);
            if (c == 0) {
                continue;
            }

            // 偶数
            if (c % 2 == 0) {
            } else {
                // 奇数
                if (max == -1) {
                    max = i;
                }
            }
            int rc = c / 2;
            for (int j = 0; j < rc; j++) {
                sb.append(i);
            }
        }

        // 最后处理
        String t = sb.toString();
        StringBuilder rt = new StringBuilder(t).reverse();
        if (max != -1) {
            sb.append(max);
        }

        sb.append(rt);

        // 检查是否前导0的情况，如果是则去掉前面的所有0
        String result = sb.toString();
        int zeros = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                zeros++;
            } else {
                break;
            }
        }

        if (zeros == result.length()) {
            return "0";
        }

        if (zeros > 0) {
            return result.substring(zeros, result.length() - zeros);
        }

        return result;
    }


    public int amountOfTime(TreeNode root, int start) {

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        int c = -1;
        // 算法：BFS
        // 1. visitedSet记录所有已经访问的节点
        // 2. 从节点开始获取对应的parent和child，并进行扩散，需要记录节点的父节点map
        // 3. 每次迭代，队列里所有节点的父和子节点，直到队列为空
        Set<Integer> visitedSet = new HashSet<>();

        // 设置每个node的父节点
        traverTree(root, parentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        // 获取开始节点
        TreeNode startNode = traver(root, start);
        queue.add(startNode);
        while (!queue.isEmpty()) {
            System.out.println(queue.size());
            c++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                visitedSet.add(node.val);
                // get parent
                TreeNode p = parentMap.get(node);
                if (p != null && !visitedSet.contains(p.val)) {
                    queue.add(p);
                }

                // get child
                if (node.left != null) {
                    if (!visitedSet.contains(node.left.val)) {
                        queue.add(node.left);
                    }
                }

                if (node.right != null) {
                    if (!visitedSet.contains(node.right.val)) {
                        queue.add(node.right);

                    }
                }

            }
        }

        return c;
    }

    private TreeNode traver(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        TreeNode left = traver(root.left, val);
        if (left == null) {
            TreeNode right = traver(root.right, val);
            return right;
        }

        return left;
    }

    private void traverTree(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        // dfs
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parentMap.put(root.left, root);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
        }
        traverTree(root.left, parentMap);
        traverTree(root.right, parentMap);
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);

//        for (int i = 0; i < target.length; i++) {
//            if (target[i] != arr[i]) {
//                return false;
//            }
//        }

        Arrays.equals(target, arr);

        return true;
    }

    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }

        // 检查条件
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (set.contains(v + diff)) {
                if (set.contains(v + diff + diff)) {
                    count++;
                }
            }
        }

        return count;
    }

    public int reachableNodes1(int n, int[][] edges, int[] restricted) {
        int count = 0;
        // 访问0节点
        // 访问非受限的0节点对应的节点，并添加新节点
        // 继续循环上个步骤，直到节点为空
        Set<Integer> visited = new HashSet<>();

        Set<Integer> filter = new HashSet<>();
        for (int x : restricted) {
            filter.add(x);
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            List list = map.getOrDefault(v1, new ArrayList<>());
            list.add(v2);
            map.put(v1, list);

            // 反向
            List list1 = map.getOrDefault(v2, new ArrayList<>());
            list1.add(v1);
            map.put(v2, list1);
        }

        // bfs
        Deque<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            count += size;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                visited.add(node);
                // 获取node的相邻节点，
                List<Integer> list = map.getOrDefault(node, new ArrayList<>());
                for (Integer t : list) {
                    if (!filter.contains(t) && !visited.contains(t)) {
                        queue.add(t);
                    }
                }
            }
        }

        return count;
    }

    int count = 0;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        // DFS
        // 默认0节点存在
        Set<Integer> set = new HashSet<>();
        // 1. 添加0节点
        // 2. bfs 访问节点，遇到restricted节点则skip，记录顶点个数
        // 双端队列
        // 遍历edges，并过滤掉每个边的restricted
        // node的下一个边，能够立刻获取
        Set<Integer> restrictedSet = new HashSet<>();
        for (int r : restricted) {
            restrictedSet.add(r);
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            // 节点的下一个节点
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

        Set<Integer> visited = new HashSet<>();

        dfs(0, map, restrictedSet, visited);

        return count;
    }

    private void dfs(int i, Map<Integer, Set<Integer>> map, Set<Integer> restrictedSet, Set<Integer> visited) {
        count++;
        visited.add(i);
        // dfs 当前i节点的相邻有效节点
        Set<Integer> set = map.getOrDefault(i, new HashSet<>());
        for (Integer t : set) {
            if (!restrictedSet.contains(t) && !visited.contains(t)) {
                dfs(t, map, restrictedSet, visited);
            }
        }
    }

    public boolean validPartition(int[] nums) {
        // 算法：
        //        n个数的2, 3组合个数
        //
        //        dfs(n) 存储
        //        dfs(0) dfs(1) dfs(2) -> dfs(3) -> dfs(n)
        //        dfs(n): 2 && dfs(n-2) || 3-1 dfs(n-3) || 3-2 dfs(n-3)
        //        dfs(4) = 2 && dfs(4-2)
        //        dfs(5) = 2 && dfs(5-2) || 3-1 dfs(5-3) || 3-2 dfs(5-3)

        boolean[] dp = new boolean[nums.length];
        dp[0] = false;
        if (nums[1] == nums[0]) {
            dp[1] = true;
        }
        if (nums.length >= 3) {
            if (nums[0] == nums[1] - 1 && nums[1] == nums[2] - 1) {
                dp[2] = true;
            } else if (nums[0] == nums[1] && nums[1] == nums[2]) {
                dp[2] = true;
            }

            // 后续递进
            for (int i = 3; i < nums.length; i++) {
                //
                // 2 && dfs(i-2) || 3-1 && dfs(i-3) && 3-2 && dfs(i-3)
                dp[i] = false;

                if (dp[i - 2] && nums[i] == nums[i - 1]) {
                    dp[i] = true;
                    if (dp[i] == true) {
                        continue;
                    }
                }

                if (dp[i - 3] && nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1) {
                    dp[i] = true;
                    if (dp[i] == true) {
                        continue;
                    }
                }

                if (dp[i - 3] && nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2]) {
                    dp[i] = true;
                    if (dp[i] == true) {
                        continue;
                    }
                }

            }
        }

        return dp[nums.length - 1];
    }

    public int longestIdealString(String s, int k) {
        int count = 0;

        // 算法
        // 首先考虑暴力解法，在考虑优化
        // 1. n和n+1进行对比
        // 2. len(n+1) = len(n) + (n+1,n)是否在k的范围内?1:0

        return count;
    }

    public int maxProduct(int[] nums) {
        int max = nums[0] > nums[1] ? nums[0] : nums[1];
        int second = nums[0] < nums[1] ? nums[0] : nums[1];
        // 一次遍历获取最大的2个值，计算结果即可

        for (int i = 2; i < nums.length; i++) {
            // max second nums[i] 比较设置max和second
            if (nums[i] >= max) {
                second = max;
                max = nums[i];
            } else if (nums[i] > second) {
                second = nums[i];
            } else {
                // 不变化
            }
        }

        return (max - 1) * (second - 1);
    }

    /**
     * 1464. 数组中两元素的最大乘积
     */
    public int maxProduct1(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        // 最边上的2个 -1 后都是正值
        // 最边上的2个 -1 后都是负值
        // 最边上的2个 -1 后都是一个正一个负
        int ans = (nums[0] - 1) * (nums[1] - 1);
        int right = (nums[len - 1] - 1) * (nums[len - 2] - 1);

        ans = Math.max(ans, right);
        return ans;
    }

    /**
     * 2357. 使数组中所有元素都等于零
     */
    public int minimumOperations(int[] nums) {
        // 大于0的 不同元素个数
        int[] cnt = new int[101];

        for (int n : nums) {
            if (n != 0) {
                cnt[n]++;
            }
        }

        int count = 0;
        for (int i : cnt) {
            if (i != 0) {
                count++;
            }
        }

        return count;
    }

//    public int maximumGroups(int[] grades) {
//        int len = grades.length;
//        int count = 0;
//        int sum = 0;
//        for (int i = 0; i < len && sum <= len; i++) {
//            sum += i;
//            count++;
//        }
//        return count++;


//    }

    public int maximumGroups(int[] grades) {

        int ans = 0;
        int len = grades.length;
        int curlen = 1;
        int sum = 0;
        while (sum + curlen <= len) {
            sum += curlen++;
            ans++;
        }

        return ans;

//        int n = grades.length;
//        int i = 1;
//        int ans = 0;
//        while (n >= i) {
//            ans++;
//            n -= i;
//            i++;
//        }
//        return ans;
    }

    /**
     * 2351. 第一个出现两次的字母
     */
    public char repeatedCharacter(String s) {
        int[] cnt = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (cnt[ch - 'a'] == 1) {
                return ch;
            }
            cnt[ch - 'a']++;
        }

        return ' ';
    }

    /**
     * 2341. 数组能形成多少数对
     */
    public int[] numberOfPairs(int[] nums) {
        int[] ans = new int[101];

        int pairs = 0;
        int remain = 0;
        // 统计每个num出现的次数
        // ans遍历，非0的进行/2 和%2， /2是对数的累加 %2是剩余个数的累加
        for (int num : nums) {
            ans[num]++;
        }

        for (int i : ans) {
            if (i != 0) {
                pairs += i / 2;
                remain += i % 2;
            }
        }

        return new int[]{pairs, remain};
    }

    public static void main(String[] args) {
        Test test = new Test();
//        int rs = test.minimumRecolors("WBWBBBW", 2);
//        System.out.println(rs);

//        String s = "0110101";
//        int rs = test.secondsToRemoveOccurrences(s);
//        System.out.println(rs);
//
//        int[][] shifts = new int[][]{
//                {0, 0, 0},
//                {1, 1, 1}
//        };
//        String s = "dztz";
//        // catz
//        String rs = test.shiftingLetters(s, shifts);
//        System.out.println(rs);
//
//        int[][] shifts2 = new int[][]{
//                {0, 1, 0},
//                {1, 2, 1},
//                {0, 2, 1}
//        };
//        String s2 = "abc";
//        // ace
//        String rs2 = test.shiftingLetters(s2, shifts2);
//        System.out.println(rs2);
//
//
//        int[][] shifts3 = new int[][]{
//                {4, 8, 0}, {4, 4, 0}, {2, 4, 0}, {2, 4, 0},
//                {6, 7, 1}, {2, 2, 1}, {0, 2, 1}, {8, 8, 0},
//                {1, 3, 1}
//        };
//        String s3 = "xuwdbdqik";
//        // "ywxcxcqii"
//        String rs3 = test.shiftingLetters(s3, shifts3);
//        System.out.println(rs3);
//
//
//        int pos = 2;
//        int i = 'b' - 'a' + pos;
////        char ch = (char) ('a' + i);
//        char ch = test.replace('z', -27 % 26);
//        // 加入是负数，就是26-x
//        System.out.println(ch);

//        int initialEnergy = 1;
//        int initialExperience = 1;
//        int[] energy = new int[]{1, 1, 1, 1};
//        int[] experience = new int[]{1, 1, 1, 50};

//        int initialEnergy = 43;
//        int initialExperience = 76;
//        int[] energy = new int[]{11, 65, 22};
//        int[] experience = new int[]{85, 29, 22};
//
//        int rs = test.minNumberOfHours(initialEnergy, initialExperience, energy, experience);
//        System.out.println(rs);
//        System.out.println(test.largestPalindromic("444947137"));
//        System.out.println(test.largestPalindromic("00009"));
//        System.out.println(test.largestPalindromic("000099"));
//        System.out.println(test.largestPalindromic("0000991"));
//        System.out.println(test.largestPalindromic("00000"));

//
//        TreeNode root = new TreeNode(1);
//        TreeNode root2 = new TreeNode(2);
//        TreeNode root3 = new TreeNode(3);
//        TreeNode root4 = new TreeNode(4);
//        TreeNode root5 = new TreeNode(5);
//        TreeNode root6 = new TreeNode(6);
//        TreeNode root9 = new TreeNode(9);
//        TreeNode root10 = new TreeNode(10);
//        root.left = root5;
//        root.right = root3;
//
//        root5.right = root4;
//        root4.left = root9;
//        root4.right = root2;
//
//        root3.left = root10;
//        root3.right = root6;
//
//
//        System.out.println(test.amountOfTime(root, 3));
//        int n = 7;
//        int[][] edges = new int[][]{
//                {0, 1}, {0, 2}, {0, 5}, {0, 4}, {3, 2}, {6, 5}
//        };
//        int[] restricted = new int[]{4, 2, 1};
//        System.out.println(test.reachableNodes(n, edges, restricted));

//        int[] nums = new int[]{4, 4, 4, 5, 6};
//        System.out.println(test.validPartition(nums));
//
//        int[] nums1 = new int[]{1, 1, 1, 2};
//        System.out.println(test.validPartition(nums1));
//
//        int[] nums2 = new int[]{993335, 993336, 993337, 993338, 993339, 993340, 993341};
//        System.out.println(test.validPartition(nums2));

//        String s = "acfgbd";
//        int k = 2;
//        System.out.println(test.longestIdealString(s, k));

    }

}
