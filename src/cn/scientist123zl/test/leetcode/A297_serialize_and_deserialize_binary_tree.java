package cn.scientist123zl.test.leetcode;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 5.26 序列化和反序列化二叉树
 * 递归
 *
 */
public class A297_serialize_and_deserialize_binary_tree {

    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode nodeB=new TreeNode(2);
        TreeNode nodeC=new TreeNode(3);
        TreeNode nodeD=new TreeNode(4);
        TreeNode nodeE=new TreeNode(5);
        root.left=nodeB;
        root.right=nodeC;
        nodeC.left=nodeD;
        nodeC.right=nodeE;

        A297_serialize_and_deserialize_binary_tree a =new A297_serialize_and_deserialize_binary_tree();
        String s = a.serialize(root);//序列化为 1 2 X X 3 4 X X 5 X X
        a.deserialize(s);
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
