/*
 * @lc app=leetcode id=1156 lang=java
 *
 * [1156] Swap For Longest Repeated Character Substring
 */
class Solution {
    public int maxRepOpt1(String text) {
        int[] record = new int[26];
        int[] counts = new int[26];
        for(char c:text.toCharArray()) 
          counts[c-'a']++;

        int left = 0;
        int max = 0;
        int res = 0;
        for(int i=0;i<text.length();i++){
            int count = ++record[text.charAt(i)-'a'];
            max = Math.max(count,max);
            while(i-left+1-max >1){
                record[text.charAt(left)-'a']--;
                left++;
            }

        
            res = Math.max(res,Math.min(counts[text.charAt(i)-'a'],i-left+1));
        }

        return res;
    }

}

