package com.InterviewCake;

/**
 * @author: pgajjar
 * @since: 8/24/17
 * @see: https://www.interviewcake.com/question/java/stock-price
 */
public class Sol1_StockTradingMaximizer {
    public static int getMaxProfit(int[] stockPricesYesterday) {
        if (stockPricesYesterday.length < 2) {
            throw new IllegalArgumentException("At lease two price points are required to evaluate max profit.");
        }

        int purchasePivot = 0;
        for (int i = 0; i < stockPricesYesterday.length; i++) {
            if (stockPricesYesterday[i] < stockPricesYesterday[purchasePivot]) {
                purchasePivot = i;
            }
        }

        int sellPivot = purchasePivot;
        for (int i = sellPivot; i < stockPricesYesterday.length; i++) {
            if (stockPricesYesterday[i] > stockPricesYesterday[sellPivot]) {
                sellPivot = i;
            }
        }

        if (sellPivot > purchasePivot) {
            return stockPricesYesterday[sellPivot] - stockPricesYesterday[purchasePivot];
        }
        return 0;
    }

    public static int getMaxProfitV2(int[] stockPricesYesterday) {
        if (stockPricesYesterday.length < 2) {
            throw new IllegalArgumentException("At lease two price points are required to evaluate max profit.");
        }

        int purchasePivot = 0;
        int sellPivot = purchasePivot;
        for (int i = 0; i < stockPricesYesterday.length; i++) {
            if (stockPricesYesterday[i] < 0) {
                throw new IllegalArgumentException("Negative price point is not possible in real world scenario.");
            }

            if (stockPricesYesterday[i] < stockPricesYesterday[purchasePivot]) {
                purchasePivot = i;
                sellPivot = purchasePivot;
            } else if (stockPricesYesterday[i] > stockPricesYesterday[sellPivot]) {
                sellPivot = i;
            }
        }

        if (sellPivot > purchasePivot) {
            return stockPricesYesterday[sellPivot] - stockPricesYesterday[purchasePivot];
        }
        return 0;
    }

    public static int getMaxProfitV3(int[] stockPricesYesterday) {

        // make sure we have at least 2 prices
        if (stockPricesYesterday.length < 2) {
            throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
        }

        // we'll greedily update minPrice and maxProfit, so we initialize
        // them to the first price and the first possible profit
        int minPrice = stockPricesYesterday[0];
        int maxProfit = stockPricesYesterday[1] - stockPricesYesterday[0];

        // start at the second (index 1) time
        // we can't sell at the first time, since we must buy first,
        // and we can't buy and sell at the same time!
        // if we started at index 0, we'd try to buy *and* sell at time 0.
        // this would give a profit of 0, which is a problem if our
        // maxProfit is supposed to be *negative*--we'd return 0.
        for (int i = 1; i < stockPricesYesterday.length; i++) {
            int currentPrice = stockPricesYesterday[i];

            // see what our profit would be if we bought at the
            // min price and sold at the current price
            int potentialProfit = currentPrice - minPrice;

            // update maxProfit if we can do better
            maxProfit = Math.max(maxProfit, potentialProfit);

            // update minPrice so it's always
            // the lowest price we've seen so far
            minPrice = Math.min(minPrice, currentPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] stockPricesYesterday = new int[] {10, 7, 5, 8, 11, 9};
//        System.out.println(StockTradingMaximizer.getMaxProfit(stockPricesYesterday));
//        System.out.println(StockTradingMaximizer.getMaxProfitV2(stockPricesYesterday));
//        System.out.println(StockTradingMaximizer.getMaxProfitV3(stockPricesYesterday));

        stockPricesYesterday = new int[] {10, 8, 6, 4, 2};
        System.out.println(Sol1_StockTradingMaximizer.getMaxProfit(stockPricesYesterday));
        System.out.println(Sol1_StockTradingMaximizer.getMaxProfitV2(stockPricesYesterday));
        System.out.println(Sol1_StockTradingMaximizer.getMaxProfitV3(stockPricesYesterday));

//        stockPricesYesterday = new int[] {10, 11, 12 ,13, 14, 15};
//        System.out.println(StockTradingMaximizer.getMaxProfit(stockPricesYesterday));
//        System.out.println(StockTradingMaximizer.getMaxProfitV2(stockPricesYesterday));
//        System.out.println(StockTradingMaximizer.getMaxProfitV3(stockPricesYesterday));
    }
}
