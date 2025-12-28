public class coinchangequestion {
public static int coinChange(int coins[], int sum){
    int n = coins.length;
    int dp[][] = new int[n + 1][sum + 1];


    // sum = 0
    for (int i = 0; i <= n; i++){
        dp[i][0] = 1;
    }

    // coins = 0
    for (int i = 1; i <= n; i++){
        dp[0][i] = 0;
    }

    // O(n*sum)

    for (int i = 1; i < n + 1; i++){
        for (int j = 1; j < sum + 1; j++){
            if (coins[i - 1] <= j){ // include the coin
                dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j]; // include + exclude
            } else {
                dp[i][j] = dp[i - 1][j]; // exclude the coin
            }
        }
    }

    return dp[n][sum];
}

public static void main(String args[]) {
    int coins[] = {1, 2, 3};
    int sum = 4;
    System.out.println(coinChange(coins, sum));
    
}
}
