import java.util.*;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int max = 0, minPrice = Integer.MAX_VALUE, greather = 0;
        for(int i = 0;i < prices.length; i++) {
            if(prices[i] < minPrice){
                minPrice = prices[i];
                greather = 0;
            }
            else if(greather < prices[i]) greather = prices[i];
            max = Math.max(max, (greather - minPrice))     ;      
        }
        return max;
    }
}
