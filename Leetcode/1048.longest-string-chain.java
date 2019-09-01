/*
 * @lc app=leetcode id=1048 lang=java
 *
 * [1048] Longest String Chain
 */
class Solution {
        public int longestStrChain(String[] words) {
            if (words == null || words.length == 0) return 0;
            int res = 0;
            Arrays.sort(words, new Comparator<String>() {
                public int compare(String str1, String str2) {
                    return str1.length() - str2.length();
                }
            });
            HashMap<String, Integer> map = new HashMap();
            for (String word : words) {
                if (map.containsKey(word)) continue;
                map.put(word, 1);
                for (int i = 0; i < word.length(); i++) {
                    StringBuilder sb = new StringBuilder(word);
                    sb.deleteCharAt(i);
                    String pre = sb.toString();
                    if (map.containsKey(pre) && map.get(pre) + 1 > map.get(word)) {
                        map.put(word, map.get(pre) + 1);
                    }
                }
                if (map.get(word) > res) res = map.get(word);
            }
            return res;
        }   
}

