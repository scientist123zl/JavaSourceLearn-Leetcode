package cn.scientist123zl.test.leetcode;


import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.Stack;

/**
 * 5.26 验证二叉搜索树
 * 递归、栈
 *
 */
public class A98_validate_binary_search_tree {

//    public boolean isValidBST(TreeNode root) {
//        return  helper(root, null ,null);
//    }
//
//    private boolean helper(TreeNode root, Integer low, Integer high) {
//        if(root == null) return true;
//
//        if(low != null && root.val <= low) return false;
//        if(high != null && root.val >= high) return false;
//
//        return helper(root.left, low, root.val) && helper(root.right, root.val, high);
//    }

    public boolean isValidBST(TreeNode root) {
        Stack stack =new Stack();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = (TreeNode) stack.pop();
            if(pre != null && pre.val >= root.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        TreeNode nodeB=new TreeNode(1);
        TreeNode nodeC=new TreeNode(7);
        TreeNode nodeD=new TreeNode(6);
        TreeNode nodeE=new TreeNode(8);
        root.left=nodeB;
        root.right=nodeC;
        nodeC.left=nodeD;
        nodeC.right=nodeE;

        A98_validate_binary_search_tree a =new A98_validate_binary_search_tree();
        System.out.println(a.isValidBST(root));
 }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
