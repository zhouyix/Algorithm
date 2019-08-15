/*
 * @lc app=leetcode id=318 lang=java
 *
 * [318] Maximum Product of Word Lengths
 */
class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        int[] bits = new int[words.length];
        for(int i=0;i<words.length;i++){
            int bit = 0;
            for(int j=0;j<words[i].length();j++){
                bit = bit | (1 << (words[i].charAt(j)-'a'));
            }

            bits[i] = bit;
        }

        for(int i=0;i<words.length;i++){
            for( int j=i+1;j<words.length;j++){
                if((bits[i] & bits[j]) == 0){
                    max = Math.max(max,words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }
}

