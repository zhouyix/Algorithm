import java.util.HashMap;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] index=new int[256];
        for(int i=0;i<index.length;i++){
            index[i] = -1;
        }

        int res = 0;
        int left = 0;
        for(int i =0 ;i < s.length();i++){
           if(index[s.charAt(i)]!=-1 && index[s.charAt(i)] >= left){
                 left = index[s.charAt(i)]+1;
            }
              
           index[s.charAt(i)] = i;
           res = Math.max(i-left+1,res);
        }

        return res;
    }
}

