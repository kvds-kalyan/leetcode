import java.util.Stack;

public class BestTimeToBuyAndSellStock {
    //O(n)
    public static int maxProfit(int[] prices) {
        if(prices.length<=1)
            return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<prices.length;i++) {
            int curr = prices[i];
            if(stack.isEmpty())
                stack.push(curr);
            else {
                int top = stack.peek();
                if(curr<=top) {
                    while(!stack.isEmpty()) {
                        stack.pop();
                    }
                    stack.push(curr);
                } else {
                    max = Math.max(max,curr-top);
                }
            }
        }
        return max;
    }

    public static int maxProfitConstantSpacePrice(int[] prices) {
        if(prices.length<=1)
            return 0;
        int max = 0;
        int buy = -1;
        for(int i=0;i<prices.length;i++) {
            int curr = prices[i];
            if(buy==-1)
                buy = curr;
            else {
                if(curr<=buy) {
                    buy = curr;
                } else {
                    max = Math.max(max,curr-buy);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        System.out.println(maxProfitConstantSpacePrice(arr));
    }
}
