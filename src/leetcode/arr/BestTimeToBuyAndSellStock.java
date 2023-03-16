package leetcode.arr;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0, len = prices.length;
        int minimumPrice = prices[0];

        for (int i = 1; i < len; i++) {
            if (prices[i] >= minimumPrice) {
                maxProfit = Math.max(prices[i]-minimumPrice, maxProfit);
            } else {
                minimumPrice = prices[i];
            }
        }

        return maxProfit;
    }
}
