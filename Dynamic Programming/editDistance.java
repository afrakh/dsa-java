public class editDistance {
    public static int editDist(String word1, String word2){
        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n+1][m+1];

        //initialize
        for (int i = 0; i<n+1; i++){
            dp[0][i] = i;
        }

        for (int i = 0; i<m+1; i++){
            dp[i][0] = i;
        }

        //bottom up
        for (int i = 1; i<n+1; i++){
            for (int j = 1; j<m+1; j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int insertOp = dp[i][j-1] + 1;
                    int deleteOp = dp[i-1][j] + 1;
                    int replaceOp = dp[i-1][j-1] + 1;

                    dp[i][j] = Math.min(insertOp, Math.min(deleteOp, replaceOp));
                }

    
    }
}        return dp[n][m];
    }
    public static void main(String args[]){
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(editDist(word1, word2));
    }
}
