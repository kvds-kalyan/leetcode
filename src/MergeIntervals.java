import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Interval {
     int start;
     int end;

     Interval() {
         start = 0;
         end = 0;
     }

     Interval(int s, int e) {
         start = s;
         end = e;

     }
 }


public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.isEmpty()) {
            return new ArrayList<>();
        }
        intervals.sort((i1,i2)->i1.start-i2.start);
        LinkedList<Interval> stack = new LinkedList<>();
        List<Interval> res = new ArrayList<>();
        for(Interval i:intervals) {
            stack.addLast(i);
        }

        Interval top = null;

        while(!stack.isEmpty()) {
             top = stack.removeFirst();
            while(!stack.isEmpty()) {
                Interval next = stack.removeFirst();
                if(top.start<=next.start && next.start<=top.end) {
                    if(top.end < next.end) {
                        top.end = next.end;
                    }
                } else {
                    res.add(top);
                    stack.addFirst(next);
                    break;
                }
            }

        }
        res.add(top);
        return res;
    }
}


