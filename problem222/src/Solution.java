import static java.lang.Math.pow;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (isFull(root)) return (int) pow(2, depthOfFullTree(root)) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public int countNodesSol1(TreeNode root)
    {
        if (root == null) return 0;

        TreeNode left = root, right = root;
        int l = 1, r = 1;

        while ((left  = left.left)   != null) ++l;
        while ((right = right.right) != null) ++r;

        if (l == r) return (1 << l) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }


    public boolean isFull(TreeNode root) {
        int depth = depthOfFullTree(root);
        int h = 0;
        while (root != null) {
            h++;
            root = root.right;
        }
        return h == depth;
    }

    public int depthOfFullTree(TreeNode root) {
        int h = 0;
        while (root != null) {
            h++;
            root = root.left;
        }
        return h;
    }
}