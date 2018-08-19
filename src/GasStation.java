import java.util.LinkedList;
import java.util.Queue;

public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0,end=1,runningFuel;
        int n = gas.length;

        runningFuel = gas[0]-cost[0];

        if(n==1)
            return runningFuel<0?-1:0;

        while(start!=end && start<n) {
            while(runningFuel<0 && start<n) {
                runningFuel = runningFuel+cost[start]-gas[start];
                start++;
            }
            runningFuel = runningFuel+gas[end]-cost[end];
            end = (end+1)%n;
        }

        return (start>=n||runningFuel<0)?-1:start;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }
}
