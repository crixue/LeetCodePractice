package leetcode.arr;

public class BestTimeToBuyAndSellStock3 {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[1], sell2 = 0;
        for (int i = 1; i < len; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        BestTimeToBuyAndSellStock3 test = new BestTimeToBuyAndSellStock3();
        int i = test.maxProfit(nums);
        System.out.println(i);
    }
}
