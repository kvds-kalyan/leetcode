import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int counter = 1;

        while (!deque.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            while (counter > 0) {
                TreeNode curr = deque.removeFirst();
                TreeNode left = curr.left;
                TreeNode right = curr.right;

                if (left != null)
                    deque.addLast(left);

                if (right != null)
                    deque.addLast(right);

                currLevel.add(curr.val);
                counter--;
            }
            counter = deque.size();
            ans.add(currLevel);
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

        System.out.println(levelOrder(root));
    }



}
