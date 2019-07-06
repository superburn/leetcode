package medium;

import java.util.Arrays;

public class BuildTree {
//    根据一棵树的前序遍历与中序遍历构造二叉树。
//
//    注意:
//    你可以假设树中没有重复的元素。
//
//    例如，给出
//
//    前序遍历 preorder = [3,9,20,15,7]
//    中序遍历 inorder = [9,3,15,20,7]
//    返回如下的二叉树：
//
//            3
//           / \
//          9  20
//            /  \
//           15   7

    public static void main(String[] args) {
        int[] in = {9,3,15,20,7};
        int[] post = {9,15,7,20,3};
        buildTree2(in,post);
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(int[] pre, int[] in) {
        if (pre.length == 0 && in.length == 0) {
            return null;
        }
        int rootVal = pre[0];
        int rootIndex = findRoot(in, rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(pre, 1, 1 + rootIndex),
                Arrays.copyOfRange(in, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(pre, rootIndex + 1, pre.length),
                Arrays.copyOfRange(in, rootIndex + 1, in.length));
        return root;
    }

    public static int findRoot(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }

//    根据一棵树的中序遍历与后序遍历构造二叉树。
//
//    注意:
//    你可以假设树中没有重复的元素。
//
//    例如，给出
//
//    中序遍历 inorder = [9,3,15,20,7]
//    后序遍历 postorder = [9,15,7,20,3]
//    返回如下的二叉树：
//
//             3
//            / \
//           9  20
//             /  \
//            15   7
    public static TreeNode buildTree2(int[] in, int[] post) {
        if (in.length == 0 && post.length == 0) {
            return null;
        }
        int rootVal = post[post.length - 1];
        int rootIndex = findRoot(in, rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree2(Arrays.copyOfRange(in, 0, rootIndex),
                Arrays.copyOfRange(post, 0, rootIndex));
        root.right = buildTree2(Arrays.copyOfRange(in, rootIndex + 1, in.length),
                Arrays.copyOfRange(post, rootIndex, in.length - 1));
        return root;
    }
}
