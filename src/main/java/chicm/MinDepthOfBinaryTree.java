package chicm;

/**
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 
 * @author chicm
 *
 */
public class MinDepthOfBinaryTree {
  
  class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
  }
  
  public int minDepth(TreeNode root) {
    int minleft=Integer.MAX_VALUE, minright=Integer.MAX_VALUE;
    if(root == null)
        return 0;
    if(root.left == null && root.right == null)
        return 1;
    if(root.left != null)
        minleft = 1 + minDepth(root.left);
    if(root.right != null)
        minright = 1 + minDepth(root.right);
        
    return Math.min(minleft, minright);
  }
}
