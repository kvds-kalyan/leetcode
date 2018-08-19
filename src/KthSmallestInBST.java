/*
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
How would you optimize the kthSmallest routine?

Store number of elements to the left and to the right
This will be like binary search
if left#>=k go left
else if left#==k-1 return root
else go right
 */
public class KthSmallestInBST {

    int counter = 0;
    int result = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return result;
    }

    private  void helper(TreeNode root, int k) {
        if(root==null)
            return;
        helper(root.left,k);
        if(counter>=k)
            return;
        if(counter+1==k) {
            counter++;
            result = root.val;
            return;
        }
        helper(root.right,k);

    }
}
