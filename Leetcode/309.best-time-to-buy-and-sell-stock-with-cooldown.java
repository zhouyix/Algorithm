/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */
class Solution {
    //https://soulmachine.gitbooks.io/algorithm-essentials/java/dp/best-time-to-buy-and-sell-stock-with-cooldown.html
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int[] sellDay = new int[prices.length];
        int[] buyDay = new int[prices.length];

    
        sellDay[0] = 0;
        buyDay[0] = -prices[0];

        for(int i=1;i<prices.length;i++){
           sellDay[i]  = Math.max(sellDay[i-1],buyDay[i-1]+prices[i]);
           buyDay[i] = Math.max(buyDay[i-1], (i-2>=0 ?sellDay[i-2]:0)-prices[i]);
        }

       
        return sellDay[prices.length-1];
    }
}

