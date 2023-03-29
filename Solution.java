import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        if (root.left == null && root.right == null){
            result.add(Integer.toString(root.val));
            return result;
        }

        List<String> leftRoots = binaryTreePaths(root.left);
        List<String> rightRoots = binaryTreePaths(root.right);

        for (String leftRoot : leftRoots) {
            result.add(root.val + "->" + leftRoot);
        }

        for (String rightRoot : rightRoots) {
            result.add(root.val + "->" + rightRoot);
        }



        return result;
    }
}