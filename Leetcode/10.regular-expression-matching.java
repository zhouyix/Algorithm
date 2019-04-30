import javax.lang.model.util.ElementScanner6;

/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 *
 * https://leetcode.com/problems/regular-expression-matching/description/
 *
 * algorithms
 * Hard (24.93%)
 * Total Accepted:    287.9K
 * Total Submissions: 1.1M
 * Testcase Example:  '"aa"\n"a"'
 *
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*'.
 * 
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * Note:
 * 
 * 
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters
 * like . or *.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'.
 * Therefore, by repeating 'a' once, it becomes "aa".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * 
 * 
 * Example 4:
 * 
 * 
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore
 * it matches "aab".
 * 
 * 
 * Example 5:
 * 
 * 
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean isMatch(String s, String p) { 
         //return isMatch(s,p,0,0);
        if(s== null || p == null){
            return false;
        }
      
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        // for case "",""
        dp[0][0] = true;

        // for case "","?*?*"
        for(int j = 2; j < p.length()+ 1; j +=2){
            if(p.charAt(j - 1) == '*' && dp[0][j - 2]){
                dp[0][j] = true;
            }
        }

        for(int i=1;i<=s.length();i++)
        for(int j=1;j<=p.length();j++){
            char curs = s.charAt(i - 1);
            char curp = p.charAt(j - 1);

            if(curs == curp)
            {
                dp[i][j] = dp[i-1][j-1];
            }else if(curp == '.'){
               dp[i][j] = dp[i-1][j-1];
            }else if(curp=='*'){
                char preCurP = p.charAt(j - 2);
               if(preCurP == curs || preCurP == '.'){
                    // match empty ,match single,match multiple
                dp[i][j] = dp[i][j-2] || dp[i-1][j-1] || dp[i-1][j];
               }else{
                   dp[i][j] = dp[i][j-2];
               }
               
            }
        }

        return dp[s.length()][p.length()];
    }
    public boolean isMatch1(String s, String p,int i,int j) {
        while(i<s.length() && j < p.length()){
            if(p.charAt(j)!=s.charAt(i)) {
                if (p.charAt(j) == '.') {
                    if (j + 1 < p.length() && p.charAt(j + 1) != '*') {
                        i++;
                        j++;
                    } else if(j+1 == p.length()){
                        // for case: a,.
                        return (i+1) >= s.length();
                    }else {
                        // for case:abcdab,a.*b
                        for (int k = i; k <= s.length(); k++)
                            if (isMatch1(s, p, k, j + 2)) {
                                return true;
                            }

                             return false;
                        }
                    }
             else if (p.charAt(j) == '*') {
                    if (j - 1 < 0) {
                        return false;
                    }

                    char c = p.charAt(j - 1);
                    while (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                        j++;
                    }

                    // set * equals 0
                    if (c != s.charAt(i)) {
                        return isMatch1(s, p, i, j + 1);
                    } else {
                        int begin = i;
                        while (begin - 1 >= 0 && s.charAt(begin) == s.charAt(begin - 1)) {
                            begin--;
                        }

                        int end = i;
                        while (end + 1 < s.length() && s.charAt(end) == s.charAt(end + 1)) {
                            end++;
                        }

                        for (int t = begin; t <= end + 1; t++) {
                            if (isMatch1(s, p, t, j + 1)) {
                                return true;
                            }
                        }
                        return false;
                    }
                } else if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    // for case: a,b*a
                    return isMatch1(s, p, i, j + 2);
                }else{
                    // for case:a,b
                    return false;
                }
            }else{

                // for case:aab,a*b 
                if(j+1 < p.length() && p.charAt(j+1) == '*'){
                    int end = i;
                    while (end + 1 < s.length() && s.charAt(end) == s.charAt(end + 1)) {
                        end++;
                    }

                    for (int t = i; t <= end+1; t++)
                        if (isMatch1(s, p, t, j + 2)) {
                            return true;
                        }
                    
                    return false;
                }else{
                    i++;
                    j++;
                }

            }
        }

        if(i >= s.length() && j >= p.length()){
            return true;
        }else if(i >= s.length()){
            // for case : ab,.*c, so check the rest must be ?*?* pattern for p
            if((p.length() - j)%2 ==1){
                return false;
            }

            for(int t = j+1;t<p.length();t=t+2){
                if(p.charAt(t) != '*'){
                    return false;
                }
            }

            return true;
        }

        return false;
    }
          
}
