public class SortLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode sortList(ListNode head) {

        if(head==null)
            return null;

        ListNode low = null;

        //pivot = head
        int pivot = head.val;

        ListNode iter = head;
        ListNode prev = head;

        while(iter!=null) {
            ListNode next = iter.next;
            if(iter.val < pivot) {
                prev.next = next;
                iter.next = low;
                low = iter;
                iter = next;
            } else {
                prev = iter;
                iter = next;
            }
        }

        ListNode lowHead = sortList(low);
        if(lowHead!=null) {
            ListNode lowIter = lowHead;
            while (lowIter.next != null)
                lowIter = lowIter.next;
            lowIter.next = head;
        }
        head.next = sortList(head.next);
        return lowHead==null?head:lowHead;

    }

    public static void main(String[] args) {
        ListNode i1 = new ListNode(-1);
        ListNode i2 = new ListNode(5);
        ListNode i3 = new ListNode(3);
        ListNode i4 = new ListNode(4);

        i1.next = i2;
        i2.next = i3;
        i3.next = i4;

        ListNode sorted = sortList(i1);
        ListNode curr = sorted;
        while(curr!=null) {
            System.out.print(curr.val+"->");
            curr = curr.next;
        }

    }

}

/*
Why MergeSort is preferred over QuickSort for Linked Lists?
In case of linked lists the case is different mainly due to difference in memory allocation of arrays and linked lists. Unlike arrays, linked list nodes may not be adjacent in memory. Unlike array, in linked list, we can insert items in the middle in O(1) extra space and O(1) time. Therefore merge operation of merge sort can be implemented without extra space for linked lists.

In arrays, we can do random access as elements are continuous in memory. Let us say we have an integer (4-byte) array A and let the address of A[0] be x then to access A[i], we can directly access the memory at (x + i*4). Unlike arrays, we can not do random access in linked list. Quick Sort requires a lot of this kind of access. In linked list to access i’th index, we have to travel each and every node from the head to i’th node as we don’t have continuous block of memory. Therefore, the overhead increases for quick sort. Merge sort accesses data sequentially and the need of random access is low.
 */


/*
public class Solution {

  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;

    // step 1. cut the list to two halves
    ListNode prev = null, slow = head, fast = head;

    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    prev.next = null;

    // step 2. sort each half
    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);

    // step 3. merge l1 and l2
    return merge(l1, l2);
  }

  ListNode merge(ListNode l1, ListNode l2) {
    ListNode l = new ListNode(0), p = l;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }

    if (l1 != null)
      p.next = l1;

    if (l2 != null)
      p.next = l2;

    return l.next;
  }

}
 */