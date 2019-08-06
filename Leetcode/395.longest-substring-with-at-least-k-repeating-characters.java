/*
 * @lc app=leetcode id=395 lang=java
 *
 * [395] Longest Substring with At Least K Repeating Characters
 */
class Solution {
    public int longestSubstring(String s, int k){
        int[] record = new int[26];
        int max = 0;
        for(char c: s.toCharArray()){
            record[c-'a']++;
        }

        for(int i=0;i<s.length();i++){
            if(record[s.charAt(i)-'a'] < k){
                int leftMax = longestSubstring(s.substring(0, i), k);

                // improvement: find the first available char as the left of the rightStr part
                while (i < s.length() && record[s.charAt(i)-'a'] < k) {
                    i++;
                }

                int rightMax = i >= s.length() ? 0: longestSubstring(s.substring(i), k);
                return Math.max(leftMax,rightMax);
            }else{
                max = Math.max(max,i+1);
            }
        }

       return max;
    }

    public int longestSubstring1(String s, int k) {
        int max = 0;
        int i=0;

        while(i+k <= s.length()){
            int[] record = new int[26];
            int mask = 0;
            int nextIndex = i;
            for(int j=i;j<s.length();j++){
                int t = s.charAt(j)-'a';
                ++record[t];
                if(record[t] < k){
                    mask = mask | (1<<t);
                }else{
                    mask = mask & (~(1<<t));
                }

                if(mask == 0){
                    max = Math.max(j-i+1,max);
                    nextIndex = j;
                }
            }

            i = nextIndex+1;
        }

        return max;
    }
}

