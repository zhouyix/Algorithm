/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()){
            return false;
        }
        
        int[] c1=new int[26];
        int[] c2=new int[26];

        for(int i=0;i<s1.length();i++){
            c1[s1.charAt(i)-'a']++;
            c2[s2.charAt(i)-'a']++;
        }

        if(Arrays.equals(c1,c2)){
            return true;
        }

        for(int i=s1.length();i<s2.length();i++){
            ++c2[s2.charAt(i)-'a'];
            --c2[s2.charAt(i-s1.length())-'a'];

            if(Arrays.equals(c1,c2)){
                return true;
            }
        }

        return false;
    }

    public boolean checkInclusion1(String s1, String s2) {
        for(int i=0;i+s1.length()<=s2.length();i++){
            String sub = s2.substring(i,i+s1.length()); 
            int[] arr = new int[26];
        for(int k=0;k<s1.length();k++){
            arr[s1.charAt(k)-'a']++;
        }
            if(check(sub,arr)){
                return true;
            }
        }

        return false;
    }

    public boolean check(String sub,int[] arr){
        for(int i=0;i<sub.length();i++){
            arr[sub.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++){
            if(arr[i]!=0){
                return false;
            }
        }

        return true;
    }
}

