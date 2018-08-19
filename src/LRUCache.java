import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer,Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            if(tail==node) {
                Node prev = node.prev;
                if(prev!=null) {
                    tail = prev;
                }
            }
            remove(node);
            makeHead(node);
            return node.value;
        }

    }

    public void put(int key, int value) {

        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            node.value = value;
            makeHead(node);
            map.put(key,node);
        } else {
            Node node = new Node(key,value);

            if(map.size()>=capacity) {
                Node next_last = tail.prev;
                remove(tail);
                tail = next_last;
            } else {
                if(tail==null) {
                    tail = node;
                }
            }
            makeHead(node);
            map.put(key,node);
        }


    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        if(prev != null) {
            prev.next = next;
        }
        if(next!=null) {
            next.prev = prev;
        }

    }

    public void makeHead(Node node) {
        if(head==null) {
            head = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void attach(Node prev,Node next) {
        prev.next = next;
        next.prev = prev;
    }
}

class Node {

    Node prev=null;
    Node next=null;
    int key;
    int value;

    public Node(int key,int val) {
        this.key = key;
        this.value = val;
    }

}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
