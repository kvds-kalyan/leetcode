import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

    static class Interval {
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

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();

        if(intervals.isEmpty()) {
             res.add(newInterval);
             return res;
        }

        intervals.sort((i1,i2)->i1.start-i2.start);
        LinkedList<Interval> stack = new LinkedList<>();

        for(Interval i:intervals) {
            stack.addLast(i);
        }

        boolean intervalToBeAdded = false;

        while(!stack.isEmpty()) {
            Interval curr = stack.removeFirst();
            if(isOverlapping(curr,newInterval)) {
                Interval merged = mergeInterval(curr,newInterval);
                newInterval = merged;
            } else {
                res.add(curr);
            }
        }

        res.add(newInterval);
        res.sort((i1,i2)->i1.start-i2.start);

        return res;


    }

    public static boolean isOverlapping(Interval i1,Interval i2) {
        if(i1.start > i2.start) {
            return isOverlapping(i2,i1);
        }

        return i1.start<=i2.start && i2.start<=i1.end;
    }

    public static Interval mergeInterval(Interval i1,Interval i2) {
        if(i1.start > i2.start) {
            return  mergeInterval(i2,i1);
        }
        if(i1.end < i2.end) {
            return new Interval(i1.start,i2.end);
        } else {
            return i1;
        }
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(6,9);
        Interval newI = new Interval(2,5);

        List<Interval> a = new ArrayList<>();
        a.add(i1);
        a.add(i2);

        System.out.println(insert(a,newI));
    }



}
