import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinTreeRightSideView {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {

            int counter = queue.size();
            TreeNode first = queue.peek();
            list.add(first.val);

            while (counter != 0) {
                TreeNode curr = queue.poll();
                if (curr.right != null)
                    queue.offer(curr.right);
                if (curr.left != null)
                    queue.offer(curr.left);
                counter--;
            }

        }

        return list;

    }
}
