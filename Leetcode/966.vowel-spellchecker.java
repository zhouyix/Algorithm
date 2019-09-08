/*
 * @lc app=leetcode id=966 lang=java
 *
 * [966] Vowel Spellchecker
 */
class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < wordlist.length; i++) {
            String w = wordlist[i];
            set.add(w);
            map1.putIfAbsent(w.toLowerCase(), i);
            map2.putIfAbsent(maskVowels(w.toLowerCase()), i);
        }

        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String w = queries[i];
            if (set.contains(w)) {
                ans[i] = w;
                continue;
            }

            w = w.toLowerCase();
            if (map1.containsKey(w)) {
                ans[i] = wordlist[map1.get(w)];
                continue;
            } 

            w = maskVowels(w);
            if (map2.containsKey(w)) {
                ans[i] = wordlist[map2.get(w)];
            } else {
                ans[i] = "";
            }
        }
        return ans;
        }

        private String maskVowels(String s) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (isVowel(chars[i])) {
                    chars[i] = '*';
                }
            }
            return String.valueOf(chars);
        }
    
        private boolean isVowel(char c) {
            c = Character.toLowerCase(c);
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }

    
}

