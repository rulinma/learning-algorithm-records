package interview;

/**
 * @author 马如林
 * @Data 2022/8/29 10:25
 */
public class Test1 {

    /**
     * O(n^2)
     */
    public int transfer(int n, int k) {
        int ans = -1;

        for (int i = 1; i <= k; i++) {
            if (days(n, k, i) > 0) {
                return i;
            }
        }

        return ans;
    }


    /**
     * O(n)的复杂度，模拟枚举一遍即可。
     */
    public int days(int n, int k, int p) {
        // 数据检验
        if (k > n || n < 0 || k < 0 || p < 0) {
            return -1;
        }

        int ans = 0;
        // 感染者总数
        int sum = 0;
        // 累计天数
        int day = 0;
        // 剩余感染人数
        int remain = k;
        while (true) {
            // 如果remain>0 并且p-day=0 则无法继续转运
            if (remain > 0 && p - day <= 0) {
                return -1;
            }
            // day是每天转运能力-
            remain = remain - (p - day);
            sum += p - day;
            if (sum >= n || remain <= 0) {
                day++;
                break;
            }
            if (remain > 0) {
                // 感染一个人
                remain = remain * 2;
            }
            day++;
        }

        ans = day;
        return ans;
    }

    public static void main(String[] args) {
        Test1 test = new Test1();
        int rs = test.days(500, 30, 16);
        System.out.println(rs);

        int transfer = test.transfer(500, 30);
        System.out.println(transfer);
    }

}
