package leetcode.arr;

public class BestTimeToBuyAndSellStock2 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0, len = prices.length;

        for (int i = 1; i < len; i++) {
            if(prices[i] - prices[i-1] > 0) {
                maxProfit += prices[i] - prices[i-1];
            }
        }

        return maxProfit;
    }
}
