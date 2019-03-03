   //dp method
   public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
		int len = arr.length;
		int count = 0;
		boolean[][]re = new boolean[len][len];
        for(int i=0;i<len;i++)
        {
        	re[i][i] = true;
            count++;
        	
        	if(i+1<len && arr[i]==arr[i+1])
        	{
        		re[i][i+1]=true;
        		count++;
        	}
        	
            //gap records the string len
        	for(int gap = 1;gap<=Math.min(len-i-1, i);gap++)
        	{
                //if len is even
        		if(arr[i-gap] == arr[i+gap] && re[i-gap+1][i+gap-1])
        		{
        			re[i-gap][i+gap]=true;
        		    count++;
        		   
        		}
        		
                //if len is odd
        		if(i+1+gap < len && arr[i-gap]==arr[i+1+gap] && re[i-gap+1][i+gap])
        		{
        			re[i-gap][i+1+gap]=true;
        			count++;
        		}
        	}
        	
        }
		return count;
    }

public int countSubstrings(String s) {
    int n = s.length(), res = 0;
        boolean[][] dp = new boolean[n][n];
        //why  i begins with n-1 ?
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) ++res;
            }
        }
        return res;
    }


     //recursive method
     public int countSubstrings2(String s) {
       int n =  s.length(), res = 0;
        for (int i = 0; i < n; ++i) {

            //if len is even
           res += helper(s, i, i);
           //if len is odd and use i as the middle 
            res += helper(s, i, i + 1);
        }
        return res;
    }
    
     public int helper(String s, int i, int j) {
         int res = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            --i; ++j; ++res;
        }
         return res;
    }