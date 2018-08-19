public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        //check to see if this is a full tree
        int hl=0,hr=0;
        for(TreeNode left = root.left;left!=null;left=left.left,hl++);
        for(TreeNode right = root.right;right!=null;right=right.right,hr++);
        if(hl==hr)
            return (int)Math.pow(2,hl+1)-1;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
