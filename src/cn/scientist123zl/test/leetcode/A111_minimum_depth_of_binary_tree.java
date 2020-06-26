package cn.scientist123zl.test.leetcode;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 5.27 二叉树的最小深度
 * 递归
 *
 */
public class A111_minimum_depth_of_binary_tree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        //这道题递归条件里分为三种情况
        //1.左孩子和右孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if(root.left == null && root.right == null) return 1;
        //2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
        if(root.left == null || root.right == null) return m1 + m2 + 1;

        //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
        return Math.min(m1,m2) + 1;

    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode nodeB=new TreeNode(2);
        TreeNode nodeF=new TreeNode(2);
        TreeNode nodeC=new TreeNode(3);
        TreeNode nodeD=new TreeNode(4);
        TreeNode nodeE=new TreeNode(5);
        root.left=nodeB;
        root.right=nodeC;
        nodeB.left= nodeF;
        nodeC.left=nodeD;
        nodeC.right=nodeE;

        A111_minimum_depth_of_binary_tree a = new A111_minimum_depth_of_binary_tree();
        System.out.println(a.minDepth(root));


    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
