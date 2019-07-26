/*
 * @lc app=leetcode id=467 lang=java
 *
 * [467] Unique Substrings in Wraparound String
 */
class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] record = new int[26];
        int count = 0;
        int i = 0;
        while(i < p.length()){
            int end = i;
            while(end<p.length()){
                if(end+1 ==  p.length() || (p.charAt(end) == 'z' &&  p.charAt(end+1) == 'a')
                        ||(p.charAt(end+1) == p.charAt(end)+1)){
                    end++;
                }else{
                    break;
                }
            }

            for(int k = i;k<p.length() && k <=end ; k++) {
                record[p.charAt(k)-'a'] = Math.max(record[p.charAt(k)-'a'],end - k+ (end == p.length() ? 0 :1));
            }

            i = end + 1;
        }

        for(int v : record){
            count = count + v;
        }

        return count;
    }
}

