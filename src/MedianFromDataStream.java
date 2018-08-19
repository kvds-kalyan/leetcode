import java.util.ArrayList;
import java.util.List;

public class MedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(-1);
        //mf.addNum(0);
        System.out.println(mf.findMedian());
        mf.addNum(-2);
        System.out.println(mf.findMedian());
        mf.addNum(-3);
        System.out.println(mf.findMedian());

    }
}

class MedianFinder {

    List<Integer> list = new ArrayList<>();
    int left_index,right_index;

    /** initialize your data structure here. */
    public MedianFinder() {
        left_index = -1;
        right_index= -1;
    }

    public void addNum(int num) {

        insertDataIntoList(num);
        if(list.size()==1) {
            left_index = 0;
        } else {
            //right==-1 => odd currently.New one will be even
            if(right_index==-1) {
                if(num <= list.get(left_index)) {
                    right_index = left_index;
                    if(left_index==0) {
                        left_index=0;
                    } else {
                        left_index=-1;
                    }
                } else {
                    right_index = left_index+1;
                }
            } else {
                if(num <= list.get(right_index)) {
                    left_index = right_index-1;
                    right_index = -1;
                } else {
                    left_index = right_index;
                    right_index=-1;
                }
            }

        }
    }

    public void insertDataIntoList(int num) {
        int i=0;
        for(i=0;i<list.size();i++) {
            if(num <= list.get(i)) {
                break;
            }
        }

        if(i==list.size())
            list.add(num);
        else if(i==0) {
            list.add(0,num);
        } else {
            list.add(i-1,num);
        }
    }

    public double findMedian() {
        if(right_index==-1)
            return list.get(left_index);
        else
            return (double)(list.get(right_index)+list.get(left_index))/2;
    }
}

/*
Beautifully done
class MedianFinder {
    PriorityQueue<Integer> maxHeap;//lower half
    PriorityQueue<Integer> minHeap;//higher half

    public MedianFinder(){
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (double)(maxHeap.peek()+(minHeap.peek()))/2;
        }else{
            return maxHeap.peek();
        }
    }
}
 */
