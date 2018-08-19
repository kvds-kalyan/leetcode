package gfg.arrays;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class PigeonHoleSorting {

    public static void pigeonhole_sort(int arr[], int n) {
         OptionalInt min_opt = IntStream.of(arr).min();
         OptionalInt max_opt = IntStream.of(arr).max();

         int min = min_opt.getAsInt();
         int max = max_opt.getAsInt();

         int range = max-min+1;

         int[] p_hole = new int[range];

         for(int i=0;i<arr.length;i++) {
             p_hole[arr[i]-min]++;
         }

         int counter=0;
         for(int i=0;i<p_hole.length;i++) {
             int j = p_hole[i];
             while(j>0) {
                 arr[counter++] = i+min;
                 j--;
             }
         }
    }
}
