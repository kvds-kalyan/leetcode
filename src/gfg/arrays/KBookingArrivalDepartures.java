package gfg.arrays;
//https://www.geeksforgeeks.org/find-k-bookings-possible-given-arrival-departure-times/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KBookingArrivalDepartures {

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

    static boolean  areBookingsPossible(int arrival[], int departure[], int n, int k) {
        List<Interval> intervals = new ArrayList<>();

        for(int i=0;i<n;i++) {
            intervals.add(new Interval(arrival[i],departure[i]));
        }

        Collections.sort(intervals,(Interval i1,Interval i2)->{
            return i1.start-i2.start;
        });

        int counter = k;

        Interval curr_long = intervals.remove(0);
        while(!intervals.isEmpty()) {
            Interval curr = intervals.remove(0);
            if(isOverlapping(curr,curr_long)) {
                counter--;
                if(counter == 0)
                    return false;
                if(curr.end > curr_long.end)
                    curr_long = curr;
            } else {
                curr_long = curr;
            }
        }

        return true;
    }

    public static boolean isOverlapping(Interval i1,Interval i2) {
        if(i1.start > i2.start) {
            return isOverlapping(i2,i1);
        }

        return i1.start<=i2.start && i2.start<=i1.end;
    }

    public static void main(String[] args) {
        int arr[] = {1,3,5};
        int dep[] = {2,6,8};

        int n=3;
        int k=1;

        System.out.println(areBookingsPossible(arr,dep,n,k));
    }
}
