/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s,new int[4],0,res,0);
        return res;
    }

    public void helper(String s,int[] path,int index,List<String> res,int count){
        if(index==s.length()&&count==4){
            String v = path[0]+"."+path[1]+"."+path[2]+"."+path[3];
            res.add(v);
            return;
        }else if(count==4 || index==s.length()){
            return;
        }

        
        for (int k = 1; k <= 3 && index + k <= s.length(); k++) {
            int seg = Integer.valueOf(s.substring(index, index + k));
            // no leading '0'
            if (seg > 255 || (s.charAt(index) == '0' && k >= 2)) {
                break;
            }
            path[count] = seg;
            helper(s, path, index + k, res, count + 1);
        }
    }
}

