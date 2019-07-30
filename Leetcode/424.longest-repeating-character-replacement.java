/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int[] record = new int[26];
        int left = 0;
        int max = 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            int count = ++record[s.charAt(i)-'A'];
            max = Math.max(count,max);
            while(i-left+1-max >k){
                record[s.charAt(left)-'A']--;
                left++;
            }

            res = Math.max(res,i-left+1);
        }

        return res;
    }
}

