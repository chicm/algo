package chicm;

import java.util.Scanner;

public class StockPrices {
  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int i = 0; i < t; i++) {
        int len = in.nextInt();
        int[] prices = new int[len];
        for(int j = 0; j < len; j++) {
            prices[j] = in.nextInt();
        }
        System.out.println(profit(prices));
    }
}
private static int profit(int[] prices) {
    int profit = 0;
    int max = Integer.MIN_VALUE;
    for(int i = prices.length-1; i>=0; i--) {
        max = Math.max(max, prices[i]);
        if(prices[i] < max) {
            profit += max - prices[i];
        }
    }
    return profit;
}
}
