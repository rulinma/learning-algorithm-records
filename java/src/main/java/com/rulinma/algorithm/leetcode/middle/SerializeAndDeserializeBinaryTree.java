package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 297. 二叉树的序列化与反序列化
 * <p>
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * <p>
 * 输入：root = [1,2]
 * 输出：[1,2]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中结点数在范围 [0, 104] 内
 * -1000 <= Node.val <= 1000
 * <p>
 * https://leetcode.cn/problems/serialize-and-deserialize-binary-tree
 *
 * @author 马如林
 * @Data 2022/9/8 18:55
 */
public class SerializeAndDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        String[] req = data.split(",");
        ArrayList<String> r = new ArrayList<>(Arrays.asList(req));
        return dfsdeserialize(r);
    }

    public TreeNode dfsdeserialize(ArrayList<String> r) {
        if ("null".equals(r.get(0))) {
            r.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(r.get(0)));
        r.remove(0);
        node.left = dfsdeserialize(r);
        node.right = dfsdeserialize(r);
        return node;
    }

}
