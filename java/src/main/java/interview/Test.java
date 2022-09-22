package interview;

import javafx.util.Pair;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @author 马如林
 * @Data 2022/8/29 10:25
 */
public class Test {

    /**
     * 49. 字母异位词分组
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        // 每个字符串进行再排序，如果相同放入到同一组中
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            List<String> list = map.getOrDefault(String.valueOf(chars), new ArrayList<>());
            list.add(s);
            map.put(String.valueOf(chars), list);
        }

        Iterator<String> iterable = map.keySet().iterator();
        while (iterable.hasNext()) {
            String key = iterable.next();
            ans.add(map.get(key));
        }

        return ans;
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int count = map.getOrDefault(n, 0);
            map.put(n, count + 1);
        }

        PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = (Integer) iterator.next();
            Integer value = (Integer) map.get(key);
            Pair<Integer, Integer> pair = new Pair<>(key, value);
            priorityQueue.add(pair);
        }

        int j = 0;
        for (int i = 0; i < k; i++) {
            ans[j++] = priorityQueue.poll().getKey();
        }

        return ans;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        // 单调栈
        int[] ans = new int[temperatures.length];

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peek()]) {
                // 弹出deque
                int index = deque.pop();
                ans[index] = i - index;
            }
            // 插入当前值
            deque.push(i);
        }

        // 栈的剩余元素补0
        while (!deque.isEmpty()) {
            ans[deque.pop()] = 0;
        }

        return ans;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        // 单调栈
        int[] ans = new int[temperatures.length];

        Stack<Integer> deque = new Stack<>();
        // 后续一旦>stack顶元素，则弹出栈内元素<val, index>
        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peek()]) {
                // 弹出deque
                int index = deque.pop();
                ans[index] = i - index;
            }
            // 插入当前值
            deque.add(i);
        }

        // 栈的剩余元素补0
        while (!deque.isEmpty()) {
            ans[deque.pop()] = 0;
        }

        return ans;
    }

    /**
     * 739. 每日温度
     */
    public int[] dailyTemperatures1(int[] temperatures) {
        // 单调栈
        int[] ans = new int[temperatures.length];

        Stack<Pair<Integer, Integer>> deque = new Stack<>();
        // 后续一旦>stack顶元素，则弹出栈内元素<val, index>
        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty() && temperatures[i] > deque.peek().getKey()) {
                // 弹出deque
                Pair p = deque.pop();
                int index = (int) p.getValue();
                ans[index] = i - index;
            }
            // 插入当前值
            deque.add(new Pair<>(temperatures[i], i));
        }

        // 栈的剩余元素补0
        while (!deque.isEmpty()) {
            Pair p = deque.pop();
            ans[(int) p.getValue()] = 0;
        }

        return ans;
    }

    public static void main(String[] args) {
        Test test = new Test();
//        int[] t = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
//        int[] rs = test.dailyTemperatures(t);
//        System.out.println(Arrays.toString(rs));

        int[] t = new int[]{1, 1, 1, 2, 2, 3};
        int[] rs = test.topKFrequent(t, 2);
        System.out.println(Arrays.toString(rs));

        int[] t1 = new int[]{1};
        int[] rs1 = test.topKFrequent(t1, 1);
        System.out.println(Arrays.toString(rs1));
    }

}
