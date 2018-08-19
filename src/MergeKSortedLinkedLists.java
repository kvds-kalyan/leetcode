import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==0)
            return null;
        if(lists.length==1)
            return lists[0];

        ListNode fin_head = null;
        ListNode iter = null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });

        for(ListNode node : lists) {
            if(node!=null) {
                queue.offer(node);
            }
        }

        fin_head = queue.poll();
        if(fin_head.next!=null)
            queue.offer(fin_head.next);
        iter = fin_head;

        while(!queue.isEmpty()) {
            ListNode top = queue.poll();
            iter.next = top;
            iter = iter.next;
            if(top.next!=null) {
                queue.offer(top.next);
            }
        }

        return fin_head;
    }
}
