import java.util.*;

public class unboundedKnapsack {
    public static int knapsackMemoization(int val[], int wt[], int n, int W, int dp[][]){
        if (W == 0 || n == 0){
            return 0;
        } 
        if (dp[n][W] != -1){
            return dp[n][W];
        } if (wt[n - 1] <= W){
            //valid so include
            int ans1 = val[n - 1] + knapsackMemoization(val, wt, n, W - wt[n - 1], dp);
            //exclude
            int ans2 = knapsackMemoization(val, wt, n - 1, W, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {
            //not valid
            dp[n][W] = knapsackMemoization(val, wt, n - 1, W, dp);
            return dp[n][W];
        }
    }

    public static int knapsackTabulation(int val[], int wt[], int n, int W){
        int dp[][]  = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {    // includes 0th row
            dp[i][0] = 0;
        }
        for (int j = 0; j <= W; j++) {    // includes 0th column
            dp[0][j] = 0;
}


        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= W; j++){
                int v = val[i - 1];   //ith item val
                int w = wt[i - 1];    //ith item weight

                if (w <= j){
                    //valid
                    int incProfit = v + dp[i][j - w];
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    // not valid
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String args[]){
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        int n = 5;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(knapsackMemoization(val, wt, n, W, dp));
        System.out.println(knapsackTabulation(val, wt, n, W));
    }
}
