public class stringConversion {
    public static int lcs(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }

        for (int j = 0; j <= m; j++){
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++){
            for (int j = 1; j < m + 1; j++){
                if (str1.charAt(i - 1) == str2.charAt(j - 1)){   // same
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {   // diff
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }
    public static int stringConversionCost(String str1, String str2){
        int lcsLength = lcs(str1, str2);
        int deletions = str1.length() - lcsLength;
        int insertions = str2.length() - lcsLength;
        return deletions + insertions;
    }
    public static void main(String args[]){
        String str1 = "abcdef";
        String str2 = "aceg";
        System.out.println("Minimum operations required to convert " + str1 + " to " + str2 + " is: " + stringConversionCost(str1, str2));
    }
}
