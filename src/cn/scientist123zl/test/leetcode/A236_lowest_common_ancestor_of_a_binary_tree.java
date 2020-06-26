package cn.scientist123zl.test.leetcode;


/**
 * 5.27 二叉树的最近公共祖先
 * 递归
 *
 *  1.终止条件：
 *  当越过叶节点，则直接返回 null ；
 *  当 root 等于 p, q ，则直接返回 root；
 *  2.递推工作：
 *  开启递归左子节点，返回值记为 left ；
 *  开启递归右子节点，返回值记为 right ；
 *
 *  返回值： 根据 left 和 right，可展开为四种情况；
 *  1.当 left 和 right 同时为空 ：说明 root的左 / 右子树中都不包含 p,q ，返回 null；
 *  2.当 left 和 right同时不为空 ：说明 p, q分列在 root 的异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root；
 *  3.当 left 为空 ，right不为空 ：p,q都不在 root 的左子树中，直接返回 right。具体可分为两种情况：
 *    1.p,q其中一个在 root 的右子树中，此时 right指向 p；
 *    2.p,q两节点都在 root的 右子树中，此时的right指向最近公共祖先节点 ；
 *  4.当left不为空 ,right 为空 ：与情况 3. 同理；
 *
 */


public class A236_lowest_common_ancestor_of_a_binary_tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) return null; //1
        if(left != null && right != null) return root; //2
        return left == null ? right : left; //3,4

    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode nodeB=new TreeNode(2);
        TreeNode nodeF=new TreeNode(6);
        TreeNode nodeC=new TreeNode(3);
        TreeNode nodeD=new TreeNode(4);
        TreeNode nodeE=new TreeNode(5);
        root.left=nodeB;
        root.right=nodeC;
        nodeB.left= nodeF;
        nodeC.left=nodeD;
        nodeC.right=nodeE;

       A236_lowest_common_ancestor_of_a_binary_tree a =new A236_lowest_common_ancestor_of_a_binary_tree();
        System.out.println(a.lowestCommonAncestor(root,nodeD,nodeE).val);


    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
