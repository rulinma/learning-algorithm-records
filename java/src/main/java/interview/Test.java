package interview;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 马如林
 * @Data 2022/8/29 10:25
 */
public class Test {

    /**
     * 739. 每日温度
     */
    public int[] dailyTemperatures(int[] temperatures) {
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
        int[] t = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] rs = test.dailyTemperatures(t);
        System.out.println(Arrays.toString(rs));
    }

}
