
 public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        dp[0][0] = grid[0][0];
        for(int i=1;i<=grid.length;i++){
            dp[i][0] = dp[i-1][0]+grid[i-1][0];
        }

        for(int i=1;i<=grid[0].length;i++){
            dp[0][i] = dp[0][i-1]+grid[0][i-1];
        }

        for(int i=1;i<=grid.length;i++)
        for(int j=1;j<=grid[0].length;j++){
            dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
        }

        return dp[grid.length][grid[0].length];
    }

 public int minPathSum2(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
        return 0;

        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
      
        for(int i=1;i<grid[0].length;i++){
            dp[i] = dp[i-1]+grid[0][i];
        }

        for(int i=1;i<grid.length;i++)
        for(int j=0;j<grid[0].length;j++){
            dp[j] = j-1 >= 0 ? Math.min(dp[j],dp[j-1])+grid[i][j] : dp[j] + grid[i][j];
        }

        return dp[grid[0].length-1];
    }

public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount < 0)
            return -1;

        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++)
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = (j >= coins[i] && j % coins[i] == 0) ? j / coins[i] : Integer.MAX_VALUE;
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                    int k = j / coins[i];
                    for (int t = 1; t <= k && j - coins[i] * t > 0; t++) {
                        int previous = dp[i - 1][j - coins[i] * t];
                        if (previous != Integer.MAX_VALUE)
                            dp[i][j] = Math.min(dp[i][j], previous + t);
                    }
                }
            }

        return dp[coins.length - 1][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length - 1][amount];
    }
    
    
   public int coinChange2(int[] coins, int amount) {
        if (coins.length == 0 || amount < 0)
            return -1;

        int[][] dp = new int[coins.length][amount + 1];
        for(int a = 1;a<=amount;a++){
            dp[0][a] = Integer.MAX_VALUE;
            if(a-coins[0] >=0 && dp[0][a-coins[0]] != Integer.MAX_VALUE)
              dp[0][a] = dp[0][a-coins[0]]+1;
        }

        for (int i = 1; i < coins.length; i++)
            for (int j = 1; j <= amount; j++) {
              
                dp[i][j] = dp[i - 1][j];
                if (j - coins[i] >= 0 && dp[i][j - coins[i]] != Integer.MAX_VALUE)
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i]] + 1);

            }

        return dp[coins.length - 1][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length - 1][amount];
    }
    
    public int coinChange3(int[] coins, int amount) {
        if (coins.length == 0 || amount < 0)
            return -1;

        int[] dp = new int[amount + 1];
        for(int a = 1;a<=amount;a++){
            dp[a] = Integer.MAX_VALUE;
            if(a-coins[0] >=0 && dp[a-coins[0]] != Integer.MAX_VALUE)
            //attension!
              dp[a] = dp[a-coins[0]]+1;
        }

        for (int i = 1; i < coins.length; i++)
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0 && dp[j - coins[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);

            }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
    
    
      public int minDistance(String word1, String word2) {
        if(word1.length() == 0){
            return word2.length();
        }else if(word2.length() == 0){
            return word1.length();
        }

        int[][] dp = new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++){
            if(word1.charAt(i) == word2.charAt(0)){
                dp[i][0] = i;
            }else{
                //delete arr[i] ,because insert will only add 1 
                dp[i][0] = i-1 >= 0 ? dp[i-1][0]+1 : i+1;
            }
        }

        for(int i=0;i<word2.length();i++){
            if(word1.charAt(0) == word2.charAt(i)){
                dp[0][i] = i;
            }else{
                dp[0][i] = i-1 >= 0 ? dp[0][i-1]+1 :i+1;
            }
        }

        for(int i=1;i<word1.length();i++){
            for(int j=1;j<word2.length();j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                   //replace,delete,add
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }

        return dp[word1.length()-1][word2.length()-1];
    }
    
    
      public int minDistance2(String word1, String word2) {
        if(word1.length() == 0){
            return word2.length();
        }else if(word2.length() == 0){
            return word1.length();
        }

        int[] dp = new int[word2.length()+1];
       
        for(int i=1;i<=word2.length();i++){
           dp[i] = i;
        }

        for(int i=1;i<=word1.length();i++){
            int pre = dp[0];
            //attention!
            dp[0] = i;
            for(int j=1;j<=word2.length();j++){
                int tmp = dp[j]; //tmp represents dp[i-1][j]
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[j] = pre;
                }else{
                    dp[j] = Math.min(pre,Math.min(tmp,dp[j-1]))+1;
                }

                pre = tmp; // for the next dp[i][j+1] ,pre represents dp[i-1][j+1 - 1] which is left upper value
            }
        }

        return dp[word2.length()];
    }
