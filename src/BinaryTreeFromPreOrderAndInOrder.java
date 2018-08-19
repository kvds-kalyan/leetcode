public class BinaryTreeFromPreOrderAndInOrder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0)
            return null;
        int n = inorder.length;
        return helper(preorder,inorder,0,0,n-1);
    }

    private static TreeNode helper(int[] preorder, int[] inorder,int preorderIdx,int inorderFrom, int inorderTo) {

        int n = inorder.length;
        if(inorderFrom==inorderTo) {
            TreeNode root = new TreeNode(inorder[inorderFrom]);
            return root;
        }

        if(inorderTo<inorderFrom)
            return null;

        int currNode = preorder[preorderIdx];
        TreeNode root = new TreeNode(currNode);
        int iter = inorderFrom;
        while(iter<inorderTo && inorder[iter]!=currNode)
            iter++;

        root.left = helper(preorder,inorder,preorderIdx+1,inorderFrom,iter-1);
        //all left are now done vic.
        root.right = helper(preorder,inorder,preorderIdx+iter-inorderFrom+1,iter+1,inorderTo);

        return root;

    }

    public static void main(String[] args) {
        int[] preorder = {5,4,1,2,3};
        int[] inorder = {1,2,3,4,5};

        buildTree(preorder,inorder);
    }

}
