import java.util.HashSet;

/*
 * @lc app=leetcode id=433 lang=java
 *
 * [433] Minimum Genetic Mutation
 */
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<String>();
        for(String s : bank){
            set.add(s);
        }

        if(!set.contains(end) || start.length() != end.length()){
            return -1;
        }

        int[] res = new int[1];

        return dfs(start,end,set,new char[]{'A','C','G','T'},res) ? res[0] : -1;
    }

    public boolean dfs(String start,String end,HashSet<String> set,char[] candidate,int[] res){
        if(start.equals(end)){
            return true;
        }

        for(int i=0;i<start.length();i++){
            for(int j=0;j<4;j++){
                if(start.charAt(i)!=candidate[j]){
                String newStart = start.substring(0,i)+candidate[j]+start.substring(i+1);
                if(set.contains(newStart)){
                    set.remove(newStart);
                    res[0]++;
                    if(dfs(newStart,end,set,candidate,res)){
                        return true;
                    }
                    res[0]--;
                    set.add(newStart);
                }
            }
            }
        }

        return false;
    }
}

// we can use BFS and queue way ,reference https://leetcode.com/problems/minimum-genetic-mutation/discuss/342941/C-Solution-BFS

