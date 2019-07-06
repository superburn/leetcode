package medium;

//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
//
//        例如:
//        给定二叉树: [3,9,20,null,null,15,7],
//
//         3
//        / \
//       9  20
//         /  \
//        15   7
//        返回其层次遍历结果：
//
//        [
//        [3],
//        [9,20],
//        [15,7]
//        ]

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();

        if (root == null) {
            return list;
        }

        List<TreeNode> rootList = new ArrayList();
        rootList.add(root);
        while (rootList.size() > 0) {
            List<Integer> values = new ArrayList();
            for (TreeNode node : rootList) {
                values.add(node.val);
            }
            list.add(values);
            rootList = iterateLevelNode(rootList);
        }
        return list;
    }

    public List<TreeNode> iterateLevelNode(List<TreeNode> lastLevel) {
        List<TreeNode> currentLevel = new ArrayList();
        for (TreeNode node : lastLevel) {
            if (node.left != null) {
                currentLevel.add(node.left);
            }
            if (node.right != null) {
                currentLevel.add(node.right);
            }
        }
        return currentLevel;
    }

/////////////////////////////////////////////////////////////////////////////

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        if (root == null) {
            return list;
        }

        int level = 0;

        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList();
            int cur_queue_size = queue.size();
            for (int i = 0; i < cur_queue_size; i++) {
                TreeNode node = queue.remove();
                currentLevel.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(currentLevel);
            level++;
        }
        return list;
    }

////////////////////////////////////////////////////////////////////////////////
    List<List<Integer>> list = new ArrayList();

    public List<List<Integer>> levelOrder3(TreeNode root) {
        if(root == null){
            return list;
        }
        helper(root,0);
        return list;
    }

    public void helper(TreeNode node, int level) {

        if (list.size() == level) {
            list.add(new ArrayList());
        }

        list.get(level).add(node.val);

        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }

    }
}
