package com.rulinma.algorithm.leetcode.middle;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 912. 排序数组
 * <p>
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * https://leetcode.cn/problems/sort-an-array/
 *
 * @author 马如林
 * @Data 2022/6/18 18:19
 */
@Slf4j
public class SortAnArray {

    public void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        // 在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr, 0, arr.length - 1, temp);
    }

    private void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 左边归并排序，使得左子序列有序
            sort(arr, left, mid, temp);
            // 右边归并排序，使得右子序列有序
            sort(arr, mid + 1, right, temp);
            // 将两个有序子数组合并操作
            merge(arr, left, mid, right, temp);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 左序列指针
        int i = left;
        // 右序列指针
        int j = mid + 1;
        // 临时数组指针
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        // 将左边剩余元素填充进temp中
        while (i <= mid) {
            temp[t++] = arr[i++];
        }

        // 将右序列剩余元素填充进temp中
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        t = 0;
        // 将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    public void swaps(int[] nums, int index, int min) {
        int temp = nums[index];
        nums[index] = nums[min];
        nums[min] = temp;
    }

    /**
     * 保证顶点是最小值，其他不保证
     *
     * @param nums
     * @param index
     */
    public void heapify(int[] nums, int len, int index) {
        // 递归出口，可以不写，因为后面的条件都不会满足，但是这个更合理些，否则看不到递归出口。
        if (index > len) {
            return;
        }

        // 向下处理
        int min = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < len && nums[left] < nums[index]) {
            min = left;
        }
        if (right < len && nums[right] < nums[min]) {
            min = right;
        }

        if (min != index) {
            swaps(nums, index, min);
            // fix
            // 变化的地方，有可能破坏了堆的性质，需要重新调整，没有变化的地方则无需处理。
            heapify(nums, len, min);
        }

    }

    /**
     * 堆是一种数据结构，一种叫做完全二叉树的数据结构。
     * <p>
     * 大顶堆：每个节点的值都大于或者等于它的左右子节点的值。
     * 小顶堆：每个节点的值都小于或者等于它的左右子节点的值。
     *
     * @param nums
     * @return
     * @ref https://blog.csdn.net/qq_28063811/article/details/93034625/
     */
    public int[] sortArrayByHeap(int[] nums) {
        // 堆排序
        // 1. 完全二叉树，父节点都小于子节点（小根对）

        // 1. buildHeap
        buildHeap(nums);

        // 2. 输出堆数据
        // sortHeap
        sortHeap(nums);

        return nums;
    }

    private void buildHeap(int[] nums) {
        // 自底向上处理，会保证后面的数据是相对较好的，减少处理次数
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, nums.length, i);
        }
    }

    public void sortHeap(int[] nums) {
        buildHeap(nums);

        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, i, 0);
            // 将剩余的元素重新构建大顶堆，其实就是调整根节点以及其调整后影响的子节点，因为其他节点之前已经满足大顶堆性质。
            // 选择最后一个放到堆顶，也是技巧性选择，最优选择。
            heapify(nums, i, 0);
        }
    }


    /**
     * 冒泡排序原理：
     * 1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 2. 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 3. 针对所有的元素重复以上的步骤，除了最后一个。
     * 4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     */

    public int[] sortArrayByFlagBubbleOptimize(int[] nums) {
        // 1. 每次最近的2个进行判断，大的放到后面，最终此次排序的一个放到最后
        // 2. 添加标记位，如果本次排序没有进行过交换，则排序结束
        if (nums.length < 2) {
            return nums;
        }

        // 执行次数
        for (int round = 0; round < nums.length - 1; round++) {
            // 其中一次
            // 有交换记录则说明还需要继续，没有则可以退出。
            boolean hasSwap = false;
            // 重置
            // round 是已经确定了个数，无需继续排序，提高效率而已，最大位置必须是长度-2，所以是<len-1
            // i 是开始比较的下标，需要比较的次数是 nums.length - roud - 1
            for (int i = 0; i < nums.length - round - 1; i++) {
                // 选择大的放到最后，这里是不正确的，则进行交换
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i + 1, i);
                    hasSwap = true;
                }
            }

            if (!hasSwap) {
                return nums;
            }
        }

        return nums;
    }

    public int[] sortArrayByFlagBubble(int[] nums) {
        // 1. 每次最近的2个进行判断，大的放到后面，最终此次排序的一个放到最后
        // 2. 添加标记位，如果本次排序没有进行过交换，则排序结束
        if (nums.length < 2) {
            return nums;
        }

        // 执行次数
        for (int i = 0; i < nums.length - 1; i++) {
            // 其中一次
            // 有交换记录则说明还需要继续，没有则可以退出。
            boolean flag = false;
            {
                // 重置
                // i 是已经确定了个数，无需继续排序，提高效率而已，最大位置必须是长度-2，所以是<len-1
                for (int j = 0; j < nums.length - i - 1; j++) {
                    // 选择大的放到最后，这里是不正确的，则进行交换
                    if (nums[j] > nums[j + 1]) {
                        swap(nums, j + 1, j);
                        flag = true;
                    }
                }
            }

            if (!flag) {
                return nums;
            }
        }

        return nums;
    }

    public int[] sortArrayBySimpleBubble(int[] nums) {
        // 1. 每次最近的2个进行判断，大的放到后面，最终此次排序的一个放到最后
        // 2.

        if (nums.length < 2) {
            return nums;
        }

        // 执行次数
        for (int i = 0; i < nums.length - 1; i++) {
            // 其中一次
            // i 是已经确定了个数，无需继续排序，提高效率而已，最大位置必须是长度-2，所以是<len-1
            for (int j = 0; j < nums.length - i - 1; j++) {
                // 选择大的放到最后，这里是不正确的，则进行交换
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j + 1, j);
                }
            }
        }

        return nums;
    }

    /**
     * 第一次从待排序的数据元素中选出最小（或最大）的一个元素，
     * 存放在序列的起始位置，然后再从剩余的未排序元素中寻找到最小（大）元素，
     * 然后放到已排序的序列的末尾。
     * 以此类推，直到全部待排序的数据元素的个数为零
     */
    public int[] sortArrayBySelectOptimize(int[] nums) {
        // 1. 进行n-1次选择
        // 2. 每次选择最小的一个放入当前位置
        for (int round = 0; round < nums.length - 1; round++) {
            int minIndex = round;
            for (int j = round + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, round, minIndex);
        }

        return nums;
    }

    /**
     * 选择排序原理：
     * 1. 每次从数组中选择最小的那个放到当前位置
     * 2. 遍历currentIndex
     * 3. 遍历后面的数组，获取最小值，如果该值小于currentIndex，则交换2个数
     */
    public int[] sortArrayBySelect(int[] nums) {
        // 1. 进行n-1次选择
        // 2. 每次选择最小的一个放入当前位置
        for (int round = 0; round < nums.length - 1; round++) {
            int min = getMinIndex(nums, round);
            if (round != min) {
                // swap
                swap(nums, round, min);
            }
        }

        return nums;
    }

    private void swap(int[] nums, int round, int min) {
        int tmp = nums[min];
        nums[min] = nums[round];
        nums[round] = tmp;
    }

    public int getMinIndex(int[] nums, int cuurent) {
        int min = nums[cuurent];
        int minIndex = cuurent;

        for (int i = cuurent + 1; i <= nums.length - 1; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }

        return minIndex;
    }


    /**
     * 插入排序：
     * 1. 从第一个元素开始，该元素可以认为已经被排序
     * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 5. 将新元素插入到该位置后
     * 6. 重复步骤2~5
     * // TODO: DIA
     */
    public int[] sortArrayByInsert(int[] nums) {
        // 1. 进行n-1次选择
        // 2. 每次选择最小的一个放入当前位置
        for (int round = 1; round < nums.length; round++) {
            // 选择位置进行插入，
            int newNum = nums[round];
//            int j = round - 1;
//            while (j >= 0 && (nums[j] > newNum)) {
//                nums[j + 1] = nums[j];
//                j--;
//            }
//            nums[j + 1] = newNum;
            int j;
            for (j = round - 1; j >= 0; j--) {
                // 如果比newNum大把值往后移动一位
                System.out.println("j inner: " + j);
                if (nums[j] > newNum) {
                    nums[j + 1] = nums[j];
                } else {
                    System.out.println("break");
                    // 非常关键的break
                    break;
                }
            }
            System.out.println("j: " + j);
            nums[j + 1] = newNum;
        }

        return nums;
    }

    /**
     * 快速排序
     *
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quicksort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = partition(nums, l, r);
            quicksort(nums, l, pos - 1);
            quicksort(nums, pos + 1, r);
        }
    }

    public int partition(int[] s, int l, int r) {
        int i = l, j = r;
        // s[l]即s[i]就是第一个坑
        int x = s[l];
        while (i < j) {
            // 从右向左找小于x的数来填s[i]
            while (i < j && s[j] >= x) {
                j--;
            }
            if (i < j) {
                // 将s[j]填到s[i]中，s[j]就形成了一个新的坑
                s[i] = s[j];
                i++;
            }
            // 从左向右找大于或等于x的数来填s[j]
            while (i < j && s[i] < x) {
                i++;
            }
            if (i < j) {
                // 将s[i]填到s[j]中，s[i]就形成了一个新的坑
                s[j] = s[i];
                j--;
            }
        }
        // 退出时，i等于j。将x填到这个坑中。
        s[i] = x;
        return i;
    }

    public int partition2(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap2(nums, i, j);
            }
        }
        swap2(nums, i + 1, r);
        return i + 1;
    }

    private void swap2(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // mergeSort


    public void mergeSortMy(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void merges(int[] nums, int left, int mid, int right) {
        // tmp 数组
        int[] tmp = new int[right - left + 1];

        // 合并从left -> mid 和 mid + 1 -> right的有序数组，并复制到nums[left] -> nums[right]位置
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = nums[i++];
        }

        while (j <= right) {
            tmp[k++] = nums[j++];
        }

        // 复制
        k = 0;
        while (left <= right) {
            nums[left++] = tmp[k++];
        }
    }

    public void mergeSort(int[] nums, int left, int right) {
        // left = right 就是一个当前数，需要退出递归
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            // 合并当前的left和right数据
            merges(nums, left, mid, right);
        } else {
            // 这里会退出， 一般else没必要写，写这里可以明确递归的退出条件
            return;
        }
    }

    public void shellSort(int[] nums) {
        int len = nums.length;
        // 增量置初值
        int d = len / 2;
        while (d >= 1) {
            for (int i = d; i < len; i++) {
                // 对所有组采用直接插入排序
                int current = nums[i];
                // 对相隔d个位置的一组采用直接插入排序
                int j = i - d;
                while (j >= 0 && current < nums[j]) {
                    nums[j + d] = nums[j];
                    j = j - d;
                }
                nums[j + d] = current;
            }
            // 减小增量
            d = d / 2;
        }
    }

    public static void main(String[] args) {
        SortAnArray sortAnArray = new SortAnArray();
//        int[] nums = new int[]{11, 30, 2, 4, 15, 60, 1, 3, 5, 8};
////        int[] nums = new int[]{11, 30, 2, 4, 15, 60, 1};
//        int[] rs = sortAnArray.sortArrayByHeap(nums);
//        System.out.println(Arrays.toString(rs));

        int[] arr = {9, 8, 17, 6, 5, 4, 13, 2, 1};
//        sortAnArray.shellSort(arr);
//        System.out.println(Arrays.toString(arr));

        insertSort(arr);
        System.out.println(Arrays.toString(arr));

        int rs = binarySearch(arr, 13);
        System.out.println(rs);
    }

    public static int binarySearch(int[] arr, int num) {
        int rs = -1;
        // 双向指针收缩即可，无需递归
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return rs;
    }

    public static void insertSort(int[] nums) {
        // 插入排序
        if (nums.length <= 1) {
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            // 每次插入的数
            int current = nums[i];
            // 从此开始继续比较的第一个数
            int j = i - 1;
//            while (j >= 0 && nums[j] > current) {
//                // 后移
//                nums[j + 1] = nums[j];
//                j--;
//            }

            // 首先保证下标有效
            while (j >= 0) {
                // 后移
                if (nums[j] > current) {
                    nums[j + 1] = nums[j];
                    j--;
                } else {
                    break;
                }
            }

            nums[j + 1] = current;
        }

    }


}
