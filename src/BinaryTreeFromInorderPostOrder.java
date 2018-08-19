public class BinaryTreeFromInorderPostOrder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static TreeNode buildTree(int[] inorder,int[] postorder) {
        if(postorder.length==0||inorder.length==0)
            return null;
        int n = postorder.length;
        return helper(postorder,inorder,n-1,0,n-1);
    }

    private static TreeNode helper(int[] postorder, int[] inorder,int postorderIdx,int inorderFrom, int inorderTo) {

        int n = inorder.length;
        if(inorderFrom==inorderTo) {
            TreeNode root = new TreeNode(inorder[inorderFrom]);
            return root;
        }

        if(inorderTo<inorderFrom)
            return null;

        int currNode = postorder[postorderIdx];
        TreeNode root = new TreeNode(currNode);
        int iter = inorderFrom;
        while(iter<inorderTo && inorder[iter]!=currNode)
            iter++;

        root.right = helper(postorder,inorder,postorderIdx-1,iter+1,inorderTo);
        root.left = helper(postorder,inorder,postorderIdx-inorderTo+iter-1,inorderFrom,iter-1);

        return root;

    }
}
