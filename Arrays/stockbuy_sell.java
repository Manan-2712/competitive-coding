package Arrays;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class stockbuy_sell {
    public int maxProfit(int[] prices) {
        // // BRUTE FORCE
        // int n = prices.length;
        // int diff =0;
        // for(int i=0;i<n-1;i++){
        // int temp = prices[i];
        // for(int j=i+1;j<n;j++)
        // diff = Math.max(diff,prices[j]- temp);
        // }

        // return diff;

        // OPTIMISED SOLN.
        int maxprofit = 0;
        int minprice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;

    }
}
