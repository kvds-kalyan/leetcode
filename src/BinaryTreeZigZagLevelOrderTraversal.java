import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Did it with Deque.Try with 2 stacks
public class BinaryTreeZigZagLevelOrderTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        if(root==null)
            return ans;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int counter = 1;

        boolean zigZag = false;

        while(!deque.isEmpty()) {
            if(zigZag) {
                List<Integer> currLevel = new ArrayList<>();
                while(counter>0) {
                    TreeNode curr = deque.removeLast();
                    //first right,then left
                    TreeNode left = curr.left;
                    TreeNode right = curr.right;

                    if(right!=null)
                        deque.addFirst(right);

                    if(left!=null)
                        deque.addFirst(left);

                    currLevel.add(curr.val);
                    counter--;
                }
                counter = deque.size();
                ans.add(currLevel);
                zigZag = false;

            } else {
                List<Integer> currLevel = new ArrayList<>();
                while(counter>0) {
                    TreeNode curr = deque.removeFirst();
                    //first left,then right
                    TreeNode left = curr.left;
                    TreeNode right = curr.right;

                    if(left!=null)
                        deque.addLast(left);

                    if(right!=null)
                        deque.addLast(right);
                    currLevel.add(curr.val);
                    counter--;
                }
                counter = deque.size();
                ans.add(currLevel);
                zigZag = true;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(9);
        TreeNode rootRight = new TreeNode(20);
        TreeNode rootRightLeft = new TreeNode(15);
        TreeNode rootRightRight = new TreeNode(7);

        root.left = rootLeft;
        root.right = rootRight;
        rootRight.left = rootRightLeft;
        rootRight.right = rootRightRight;

        System.out.println(zigzagLevelOrder(root));
    }
}


 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

