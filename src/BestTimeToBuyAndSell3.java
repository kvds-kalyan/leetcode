public class BestTimeToBuyAndSell3 {

    public static int maxProfit(int[] prices) {
        int buy1 =-1, buy2 = -1, sell1 = -1, sell2 = -1, max = 0;
        int n = prices.length;

        for (int i = 0; i < prices.length; i++) {

            int curr = prices[i];
            int prev = prices[i - 1];

            if(curr < prev) {
                //if buy2 is not set
                if(buy2==-1) {
                    sell1 = prev;
                    while(i+1<n && prices[i+1]<=curr)
                        i++;
                    if(i==n-1)
                        return max;
                    buy2 = i;
                } else {
                    sell2 = prev;
                    max = Math.max(max,((sell1-buy1)+(sell2-buy2)));
                    //reset
                    buy1 = buy2;
                    sell1 = sell2;
                    buy2 = -1;
                    sell2 = -1;
                }
            }
        }
        return max;
    }
}
